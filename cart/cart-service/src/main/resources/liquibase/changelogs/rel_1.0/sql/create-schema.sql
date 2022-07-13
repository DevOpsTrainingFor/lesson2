create table cart
(
    id          bigint auto_increment,
    cart_external_id varchar(36) not null,
    product_external_id varchar(36) not null,
    constraint cart_pk
        primary key (id)
);

create unique index cart_external_id_product_external_id_uindex
    on cart (cart_external_id, product_external_id);

create table product
(
    id          bigint auto_increment,
    external_id varchar(36) not null,
    name       varchar(80) not null,
    price    decimal(10,2) not null,
    constraint product_pk
        primary key (id)
);

create unique index product_external_id_uindex
    on product (external_id);