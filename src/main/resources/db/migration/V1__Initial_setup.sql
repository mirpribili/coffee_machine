-- Создание таблиц
CREATE TABLE CoffeeRecipes (
                               recipe_id SERIAL PRIMARY KEY,
                               name VARCHAR(100) NOT NULL,
                               description TEXT,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Ingredients (
                             ingredient_id SERIAL PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             current_quantity DECIMAL(10, 2) NOT NULL,
                             min_quantity DECIMAL(10, 2) NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE RecipeIngredients (
                                   recipe_id INTEGER REFERENCES CoffeeRecipes(recipe_id) ON DELETE CASCADE,
                                   ingredient_id INTEGER REFERENCES Ingredients(ingredient_id) ON DELETE CASCADE,
                                   amount DECIMAL(10, 2) NOT NULL,
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   PRIMARY KEY (recipe_id, ingredient_id)
);

CREATE TABLE UsageLogs (
                           log_id SERIAL PRIMARY KEY,
                           user_id INTEGER REFERENCES Users(user_id) ON DELETE SET NULL,
                           recipe_id INTEGER REFERENCES CoffeeRecipes(recipe_id) ON DELETE SET NULL,
                           status VARCHAR(20),
                           amount DECIMAL(10, 2),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ErrorLogs (
                           error_id SERIAL PRIMARY KEY,
                           user_id INTEGER REFERENCES Users(user_id) ON DELETE SET NULL,
                           error_message TEXT NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

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
-- CREATE OR REPLACE FUNCTION check_ingredient_quantity()
-- RETURNS TRIGGER
-- AS $$
-- BEGIN
--     IF NEW.current_quantity < NEW.min_quantity THEN
--         PERFORM pg_notify('ingredient_low', NEW.name || ' is running low.');
-- END IF;
-- RETURN NEW;
-- END;
-- $$
-- LANGUAGE plpgsql;

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

-- Наполнение таблиц тестовыми данными
INSERT INTO Ingredients (name, current_quantity, min_quantity)
VALUES
    ('Сахар', 5000, 500),
    ('Вода', 10000, 1000),
    ('Кофе', 2000, 200),
    ('Молоко', 3000, 300),
    ('Какао', 1000, 100);

INSERT INTO CoffeeRecipes (name, description)
VALUES
    ('Эспрессо', 'Классический крепкий кофе'),
    ('Капучино', 'Эспрессо с молочной пеной'),
    ('Латте', 'Эспрессо с молоком'),
    ('Горячий шоколад', 'Какао с молоком и сахаром'),
    ('Американо', 'Эспрессо с добавлением горячей воды');

INSERT INTO RecipeIngredients (recipe_id, ingredient_id, amount)
VALUES
    (1, 3, 10),
    (2, 3, 10),
    (2, 4, 100),
    (3, 3, 10),
    (3, 4, 150),
    (4, 1, 20),
    (4, 2, 200),
    (4, 5, 30),
    (5, 2, 150),
    (5, 3, 10);

INSERT INTO Users (username, email)
VALUES
    ('user1', 'user1@example.com'),
    ('user2', 'user2@example.com'),
    ('user3', 'user3@example.com');

INSERT INTO UsageLogs (user_id, recipe_id, status, amount, created_at)
VALUES
    (1, 1, 'успешно', 0, '2024-06-01 10:00:00'),
    (2, 2, 'успешно', 1, '2024-06-01 11:30:00'),
    (3, 3, 'успешно', 2, '2024-06-02 09:45:00'),
    (1, 4, 'успешно', 0, '2024-06-02 14:20:00'),
    (3, 1, 'успешно', 1, '2024-06-03 18:30:00'),
    (1, 2, 'успешно', 0, '2024-06-04 13:55:00'),
    (2, 3, 'успешно', 2, '2024-06-04 15:00:00'),
    (3, 4, 'успешно', 0, '2024-06-05 11:25:00');

INSERT INTO ErrorLogs (user_id, error_message, created_at)
VALUES
    (1, 'Нехватка молока', '2024-05-01 10:05:00'),
    (2, 'Засор трубки', '2024-05-01 11:35:00'),
    (3, 'Ошибка дозирования', '2024-05-02 14:25:00'),
    (2, 'Нехватка сахара', '2024-05-03 16:15:00'),
    (1, 'Перегрев', '2024-05-05 17:45:00');
