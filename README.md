# Эмулятор кофемашины

## Описание
Этот проект представляет собой эмулятор кофемашины, реализованный как REST API с использованием Spring Boot. Он позволяет управлять рецептами кофе, пользователями и отслеживать использование кофемашины.

## Технологии
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Swagger/OpenAPI для документации API

## Функциональность
- Возможность заказать кофе!
- Управление рецептами кофе (создание, чтение, обновление, удаление)
- Управление пользователями
- Логирование использования кофемашины
- Отслеживание ошибок

## Начало работы

### Предварительные требования
- JDK 17
- Maven
- PostgreSQL

### Установка и запуск
1. Клонируйте репозиторий:

git clone https://github.com/your-username/coffee-machine-emulator.git

2. Перейдите в директорию проекта:

cd coffee-machine-emulator

3. Настройте подключение к базе данных в `application.properties`.

4. Соберите проект:

mvn clean install

5. Запустите приложение:

java -jar target/coffee-machine-emulator-0.0.1-SNAPSHOT.jar

## API документация
После запуска приложения, документация API доступна по адресу:

http://localhost:8080/swagger-ui.html


## Структура проекта
- `src/main/java/com/exe/coffeemachine/emulator/` - исходный код
    - `controller/` - REST контроллеры
    - `service/` - бизнес-логика
    - `repository/` - интерфейсы для работы с базой данных
    - `entity/` - сущности JPA
    - `dto/` - объекты передачи данных
    - `mapper/` - маппинг между DTO и сущностями
    - `exception/` - пользовательские исключения
    - `audit/` - классы для аудита

## Тестирование
Для запуска тестов выполните:

mvn test

## Лицензия
Этот проект лицензирован под Apache License 2.0.

## Контакты
[Олег](mailto:mirpribili@ya.ru)

Ссылка на проект: [https://github.com/mirpribili/coffee-machine-emulator](https://github.com/mirpribili/coffee-machine-emulator)
