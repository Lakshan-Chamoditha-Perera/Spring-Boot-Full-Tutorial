use
    custom_db;

drop table members;
drop table roles;

create table members
(
    user_id varchar(50) primary key,
    pw      varchar(100) not NULL,
    active  boolean      not NULL
);

create table roles
(
    user_id varchar(50) references members (user_id),
    role    varchar(50) not null,
    constraint foreign key roles (user_id) references members (user_id)
);


--  user_id : shan, password: 123
insert into members
values ('shan', '{bcrypt}$2a$12$9iFrALDz46SrXX/vvxSSZOY.TzZgJ4zHkfKdiajQBFCr7slMYxX9a', true);

insert into roles
values ('shan', 'ROLE_EMPLOYEE');
