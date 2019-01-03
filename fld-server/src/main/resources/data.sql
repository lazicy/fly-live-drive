insert into user (username,password,firstname,lastname,email,city,active,type) values ('dovla96', '$2a$04$nRJALierFkUMWbUfQBzvy.DhKLc6UTMSX4vI4.HfPF0THn.VjTIYm', 'Vladimir', 'Cvetanovic', 'cvetanovic9696@gmail.com', 'Novi Sad',true,'RENT_ADMIN');

insert into authority (id,name) values (1,'RENT_ADMIN');
insert into authority (id,name) values (2,'HOTEL_ADMIN');
insert into authority (id,name) values (3,'AVIO_ADMIN');
insert into authority (id,name) values (4,'SYSTEM_ADMIN');
insert into authority (id,name) values (5,'USER');

insert into user_authority (user_id, authority_id) values ('dovla96',1);

