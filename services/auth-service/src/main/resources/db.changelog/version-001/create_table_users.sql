create table market.users (
    id uuid not null,
    email varchar(255) not null,
    password varchar(255),
    roles text not null,
    date_create timestamp not null default now()
)