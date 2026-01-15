-- Drop table if it exists (to avoid conflicts)
DROP TABLE IF EXISTS task;

create table task
(
    id          varchar(32) primary key,
    title       varchar(50),
    description varchar(100),
    status      varchar(10)
);