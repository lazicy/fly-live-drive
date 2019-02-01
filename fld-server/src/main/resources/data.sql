insert into user (username,password,firstname,lastname,email,city,active,type) values ('dovla96', '$2a$04$nRJALierFkUMWbUfQBzvy.DhKLc6UTMSX4vI4.HfPF0THn.VjTIYm', 'Vladimir', 'Cvetanovic', 'cvetanovic9696@gmail.com', 'Novi Sad',true,'RENT_ADMIN');

insert into authority (id,name) values (1,'ROLE_RENT_ADMIN');

insert into user_authority (user_id, authority_id) values ('dovla96',1);

insert into rentacar (id,name,address,city,country,description) values (556,'Drive a lot','Bulevar Evrope','Novi Sad','Srbija','Najbolji servis ikada');
insert into rentacar (id,name,address,city,country,description) values (412,'Teraj bona','Bosanskog cevapa 10','Han Pijesak','Bosna i Hercegovina','Bolji servis bona od ovog drugog');

insert into filijala (id,name,address,city,country,description,servis_id) values (123,'Drive a lot','Bulevar Kralja Petra','Novi Sad','Srbija','Najbolji servis ikada',556);

insert into vozilo (id,model,brand,production_year,number_of_seats,type,filijala_id) values (12, 'Q7','Audi','2016',5,'SUV',123);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,filijala_id) values (132, 'X5','BMW','2016',5,'SUV',123);