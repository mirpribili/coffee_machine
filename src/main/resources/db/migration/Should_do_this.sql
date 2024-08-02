
-- Индексация полей
CREATE INDEX ON CoffeeRecipes (name);

-- Функции для генерации отчетов
CREATE OR REPLACE FUNCTION generate_recipe_popularity_report(start_date DATE, end_date DATE)
    RETURNS TABLE (
                      recipe_id INTEGER,
                      name VARCHAR(100),
                      total_usage INTEGER
                  )
AS $$
BEGIN
    RETURN QUERY
        SELECT
            cr.recipe_id,
            cr.name,
            COUNT(*) AS total_usage
        FROM
            CoffeeRecipes cr
                JOIN UsageLogs ul ON cr.recipe_id = ul.recipe_id
        WHERE
            ul.created_at BETWEEN start_date AND end_date
        GROUP BY
            cr.recipe_id, cr.name
        ORDER BY
            total_usage DESC;
END;
$$
    LANGUAGE plpgsql;

-- Триггер для уведомлений о нехватке ингредиентов
CREATE OR REPLACE FUNCTION check_ingredient_quantity()
    RETURNS TRIGGER
AS $$
BEGIN
    IF NEW.current_quantity < NEW.min_quantity THEN
        PERFORM pg_notify('ingredient_low', NEW.name || ' is running low.');
    END IF;
    RETURN NEW;
END;
$$
    LANGUAGE plpgsql;

CREATE TRIGGER ingredient_quantity_check
    AFTER UPDATE ON Ingredients
    FOR EACH ROW
EXECUTE PROCEDURE check_ingredient_quantity();

-- Представления (Views) для отчетов
CREATE VIEW low_ingredient_report AS
SELECT
    i.name,
    i.current_quantity,
    i.min_quantity
FROM
    Ingredients i
WHERE
    i.current_quantity < i.min_quantity;
