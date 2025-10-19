create table auth.user_roles
(
    user_id uuid         not null,
    roles    varchar(255) not null,
    constraint fk_user_roles_user_id
        foreign key (user_id)
        references auth.users(id)
        on delete cascade,
    constraint pk_user_roles
        primary key (user_id, roles)
);