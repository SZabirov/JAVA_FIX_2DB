1. [Создание таблиц](https://postgrespro.ru/docs/postgrespro/9.5/tutorial-table).
    Пример создания трех таблиц:
    ```sql
    CREATE TABLE "user"
    (
      id        INTEGER,
      username  VARCHAR(255),
      password  VARCHAR(255)
    );
    
    CREATE TABLE "product"
    (
      id INTEGER,
      name VARCHAR(255),
      cost INTEGER
    );
    
    CREATE TABLE "order"
    (
      user_id INTEGER,
      product_id INTEGER
    );
    ```

2. [Ограничения - constraints](https://postgrespro.ru/docs/postgresql/9.5/ddl-constraints).
    Та же схема, только с некоторыми необходимыми ограничениями:
    ```sql
    CREATE TABLE "user"
    (
      id        INTEGER PRIMARY KEY, --первичный ключ
      username  VARCHAR(255) UNIQUE, --ограничение уникальности
      password  VARCHAR(255)
    );
    
    CREATE TABLE "product"
    (
      id INTEGER PRIMARY KEY,
      name VARCHAR(255),
      cost INTEGER NOT NULL CHECK ( cost > 0 ) --проверка на NULL и проверка на неотрицательность
    );
    
    CREATE TABLE "order"
    (
      user_id INTEGER REFERENCES "user"(id), --внешний ключ на id из таблицы "user"
      product_id INTEGER REFERENCES "product"(id)
    );
    ```
    
3. `CREATE TABLE` относится к DDL-командам. `ALTER TABLE`
    и `DROP TABLE` также относятся к DDL.
4.  Для вставки данных в таблицу используется `INSERT`:
```sql
INSERT INTO "user"(id, username, password)
VALUES (1, 'Salavat', 'qwerty123');
INSERT INTO "user"(id, username, password)
VALUES (2, 'Marsel', 'asdfadsf');

INSERT INTO "product"(id, name, cost)
VALUES (1, 'TV', 20000);
INSERT INTO "product"(id, name, cost)
VALUES (2, 'Laptop', 45000);
```
5. Выбрать данные из таблицы - `SELECT`:
```sql
SELECT * FROM "user"; --получение всех записей из "user"
SELECT * FROM "user" WHERE id = 1; --получение всех пользователей с id равным 1
```
6. Обновление данных в таблице - `UPDATE`:
```sql
UPDATE "user" SET password = 'qwerty_01' WHERE id = 1;
```
7. Удаление - `DELETE`:
```sql
DELETE FROM product WHERE id = 1;
```