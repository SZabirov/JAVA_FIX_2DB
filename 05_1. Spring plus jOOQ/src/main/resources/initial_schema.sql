create table if not exists shop_user
(
    id serial not null
        constraint shop_user_pkey
            primary key,
    username varchar(255),
    password varchar(255)
);

alter table shop_user owner to postgres;

create table if not exists product
(
    id integer not null
        constraint product_pkey
            primary key,
    cost integer,
    name varchar(255)
);

alter table product owner to postgres;

create table if not exists shop_user_products
(
    user_id integer not null
        constraint fkpcf9ucoumyaahtcxebqm7xtkx
            references shop_user,
    products_id integer not null
        constraint fk68m9614kbmmxu1cef6e84qvs5
            references product,
    constraint shop_user_products_pkey
        primary key (user_id, products_id)
);

alter table shop_user_products owner to postgres;

