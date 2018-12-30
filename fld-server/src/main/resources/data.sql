insert into user (username,password,firstname,lastname,email,city,active,type) values ('dovla96', '$2a$04$nRJALierFkUMWbUfQBzvy.DhKLc6UTMSX4vI4.HfPF0THn.VjTIYm', 'Vladimir', 'Cvetanovic', 'cvetanovic9696@gmail.com', 'Novi Sad',false,'RENT_ADMIN');

insert into authority (id,name) values (1,'ROLE_RENT_ADMIN');

insert into user_authority (user_id, authority_id) values ('dovla96',1);

insert into rentacar (id,name,address,city,country,description) values (556,'Drive a lot','Bulevar Evrope','Novi Sad','Srbija','Najbolji servis ikada');

insert into filijala (id,name,address,city,country,description,servis_id) values (123,'Drive a lot','Bulevar Kralja Petra','Novi Sad','Srbija','Najbolji servis ikada',556);