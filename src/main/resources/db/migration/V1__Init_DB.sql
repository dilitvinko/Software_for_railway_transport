create table log_task (
    id bigint not null auto_increment,
    comment varchar(255),
    time integer not null,
    task_id bigint,
    primary key (id)
);

create table people (
    id bigint not null auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    login varchar(255),
    password varchar(255),
    patronymic varchar(255),
    primary key (id)
);

create table task (
    id bigint not null auto_increment,
    name_task varchar(255),
    state bit not null,
    people_id bigint,
    primary key (id)
);

create table user_role (
    user_id bigint not null,
    roles varchar(255)
);

create table usr (
    id bigint not null auto_increment,
    active bit not null,
    password varchar(255),
    username varchar(255),
    primary key (id)
);

alter table log_task
    add constraint FKl5uh48sqy232wyt4vb1w70mkq
    foreign key (task_id) references task (id);

alter table task
    add constraint FKcb374tq1gqxy9qjh77h9ctww8
    foreign key (people_id) references people (id);

alter table user_role
    add constraint FKfpm8swft53ulq2hl11yplpr5
    foreign key (user_id) references usr (id);