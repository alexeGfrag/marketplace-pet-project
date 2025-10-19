create table auth.users
(
    id          uuid         not null,
    constraint pk_users_id primary key (id),
    email       varchar(255) not null,
    password    varchar(255),
    roles       text         not null,
    date_create timestamp    not null default now()
);