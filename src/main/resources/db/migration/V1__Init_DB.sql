drop table if exists carriage;
     drop table if exists city;
     drop table if exists person;
     drop table if exists person_role;
     drop table if exists schedule;
     drop table if exists teste;
     drop table if exists test_entity;
     drop table if exists ticket;
     drop table if exists train;
     drop table if exists type_carriage;
     create table carriage (id bigint not null auto_increment, number integer not null, train_id bigint, type_carriage_id bigint, primary key (id)) ;
     create table city (id bigint not null auto_increment, name varchar(255), primary key (id)) ;
     create table person (id bigint not null auto_increment, experience integer not null, login varchar(255), name varchar(255), password varchar(255), surname varchar(255), primary key (id)) ;
     create table person_role (person_id bigint not null, roles varchar(255)) ;
     create table schedule (id bigint not null auto_increment, driving_order integer not null, time time, city_id bigint, train_id bigint, primary key (id)) ;
     create table teste (id bigint not null auto_increment, age integer not null, heal integer not null, primary key (id)) ;
     create table test_entity (id bigint not null auto_increment, age integer not null, name varchar(255), primary key (id)) ;
     create table ticket (id bigint not null auto_increment, date date, number_seat integer not null, price double precision not null, carriage_id bigint, in_schedule_id bigint, out_schedule_id bigint, person_id bigint, train_id bigint, primary key (id)) ;
     create table train (id bigint not null auto_increment, name varchar(255), primary key (id)) ;
     create table type_carriage (id bigint not null auto_increment, amount_seats integer not null, cooff_prise double precision not null, type varchar(255), primary key (id)) ;
     alter table carriage add constraint FK52ja5382do6dr5dt6nec768hc foreign key (train_id) references train (id);
     alter table carriage add constraint FKf91vrg0dsowf22h91p8lu8cky foreign key (type_carriage_id) references type_carriage (id);
     alter table person_role add constraint FKhyx1efsls0f00lxs6xd4w2b3j foreign key (person_id) references person (id);
     alter table schedule add constraint FKb0195u9p6jsyo9in423b8fdrc foreign key (city_id) references city (id);
     alter table schedule add constraint FK8x7cqx078595e7vsua30ekjl7 foreign key (train_id) references train (id);
     alter table ticket add constraint FKq27w98dav6xec1uh16r4fdcd9 foreign key (carriage_id) references carriage (id);
     alter table ticket add constraint FKgaldsuki6vof5cmnjxqsx7c4a foreign key (in_schedule_id) references schedule (id);
     alter table ticket add constraint FKfrrjhxr4lv05yk41yw7ikoglb foreign key (out_schedule_id) references schedule (id);
     alter table ticket add constraint FKova7mpgrn7uwci6ixwhdmblnv foreign key (person_id) references person (id);
     alter table ticket add constraint FK86c20t7sdlfvrwskmig4xqd4u foreign key (train_id) references train (id);

     ALTER TABLE ticket ADD UNIQUE (date, number_seat, carriage_id, train_id, in_schedule_id, out_schedule_id);
    ALTER TABLE schedule ADD UNIQUE (train_id, city_id, time);
    ALTER TABLE carriage ADD UNIQUE (train_id, number);

ALTER TABLE `train`
    ADD UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE;
;
ALTER TABLE `person`
    ADD UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE;
;
ALTER TABLE `test_jpa_railway`.`city`
    ADD UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE;
;
