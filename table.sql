create table schedule
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  null,
    updated_at datetime(6)  null,
    content    longtext     null,
    title      varchar(255) not null,
    user_id    bigint       null,
        foreign key (user_id) references user (id)
);

create table user
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  null,
    updated_at datetime(6)  null,
    email      varchar(255) not null,
    name       varchar(255) not null,
    password   varchar(255) not null
);

