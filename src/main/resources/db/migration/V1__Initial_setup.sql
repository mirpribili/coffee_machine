CREATE TABLE coffee_recipe (
                               recipe_id BIGSERIAL PRIMARY KEY,
                               name VARCHAR(100) NOT NULL,
                               description TEXT,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users (
                       user_id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ingredient (
                            ingredient_id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            current_quantity DECIMAL(10, 2) NOT NULL,
                            min_quantity DECIMAL(10, 2) NOT NULL,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE recipe_ingredient (
                                   recipe_id BIGINT REFERENCES coffee_recipe(recipe_id) ON DELETE CASCADE,
                                   ingredient_id BIGINT REFERENCES ingredient(ingredient_id) ON DELETE CASCADE,
                                   amount DECIMAL(10, 2) NOT NULL,
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   PRIMARY KEY (recipe_id, ingredient_id)
);

CREATE TABLE usage_log (
                           log_id BIGSERIAL PRIMARY KEY,
                           user_id BIGINT REFERENCES users(user_id) ON DELETE SET NULL,
                           recipe_id BIGINT REFERENCES coffee_recipe(recipe_id) ON DELETE SET NULL,
                           status VARCHAR(20),
                           amount DECIMAL(10, 2),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE error_log (
                           error_id BIGSERIAL PRIMARY KEY,
                           user_id BIGINT REFERENCES users(user_id) ON DELETE SET NULL,
                           error_message TEXT NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
