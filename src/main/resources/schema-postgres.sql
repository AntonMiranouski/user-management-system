drop table if exists USERS cascade;
create table USERS (
    ID serial not null,
    CREATED_AT timestamp,
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    PASSWORD varchar(255),
    USERNAME varchar(255) unique,
    ACTIVE boolean,
    primary key (ID)
);

SELECT setval('public.users_id_seq', 2, true);

drop table if exists ROLES cascade;
create table ROLES (
    USER_ID int4 not null,
    ROLES varchar(255)
);

alter table if exists ROLES
    add constraint roles_users_fk
    foreign key (USER_ID) references USERS;
