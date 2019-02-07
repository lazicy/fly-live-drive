insert into user (username,password,firstname,lastname,email,city,active,type) values ('dovla96', '$2a$04$nRJALierFkUMWbUfQBzvy.DhKLc6UTMSX4vI4.HfPF0THn.VjTIYm', 'Vladimir', 'Cvetanovic', 'cvetanovic9696@gmail.com', 'Novi Sad',true,'RENT_ADMIN');

insert into authority (id,name) values (1,'RENT_ADMIN');
insert into authority (id,name) values (2,'HOTEL_ADMIN');
insert into authority (id,name) values (3,'AVIO_ADMIN');
insert into authority (id,name) values (4,'SYSTEM_ADMIN');
insert into authority (id,name) values (5,'USER');

insert into user_authority (user_id, authority_id) values ('dovla96',1);


INSERT INTO country (id, name) values
(1, 'Argentina'),
(2, 'Bahamas'),
(3, 'Belgium'),
(4, 'Brazil'),
(5, 'China'),
(6, 'Croatia'),
(7, 'Denmark'),
(8, 'France'),
(9, 'Germany'),
(10, 'Italy'),
(11, 'Mexico'),
(12, 'Montenegro'),
(13, 'Netherlands'),
(14, 'Norway'),
(15, 'Poland'),
(16, 'Portugal'),
(17, 'Romania'),
(18, 'Russia'),
(19, 'Serbia'),
(20, 'Slovenia'),
(21, 'South Africa'),
(22, 'Spain'),
(23, 'Tanzania'),
(24, 'Turkey'),
(25, 'United Arab Emirates'),
(26, 'United Kingdom'),
(27, 'United States of America'),
(28, 'Venezuela'),
(29, 'Vietnam'),
(30, 'Zimbabwe');




INSERT INTO city (id, name, country_id) values
(1, 'Buenos Aires', 1),
(2, 'La Plata', 1),
(3, 'Córdoba', 1),
(4, 'Nassau', 2),
(5, 'Antwerp', 3),
(6, 'Brussels', 3),
(7, 'Liège', 3),
(8, 'Brasília', 4),
(9, 'Rio de Janeiro', 4),
(10, 'São Paulo', 4),
(11, 'Beijing', 5),
(12, 'Shanghai', 5),
(13, 'Guangzhou', 5),
(14, 'Shenzhen', 5),
(15, 'Zagreb', 6),
(16, 'Split', 6),
(17, 'Aalborg', 7),
(18, 'Copenhagen', 7),
(19, 'Paris', 8),
(20, 'Roubaix', 8),
(21, 'Toulouse', 8),
(22, 'Aachen', 9),
(23, 'Berlin', 9),
(24, 'Frankfurt', 9),
(25, 'Munich', 9),
(27, 'Dortmund', 9),
(28, 'Bologna', 10),
(29, 'Firenze', 10),
(30, 'Milan', 10),
(31, 'Rome', 10),
(32, 'Mexico City', 11),
(33, 'Monterrey', 11),
(34, 'Tijuana', 11),
(35, 'Podgorica', 12),
(36, 'Tivat', 12),
(37, 'Amsterdam', 13),
(38, 'Rotterdam', 13),
(39, 'Oslo', 14),
(40, 'Bergen', 14),
(41, 'Kraków', 15),
(42, 'Warsaw', 15),
(43, 'Porto', 16),
(44, 'Lisabon', 16),
(45, 'Bucharest', 17),
(46, 'Timișoara', 17),
(47, 'Saint Petersburg', 18),
(48, 'Moscow', 18),
(49, 'Kazan', 18),
(50, 'Vladivostok', 18),
(51, 'Novi Sad', 19),
(52, 'Belgrade', 19),
(53, 'Niš', 19),
(54, 'Novi Kneževac', 19),
(55, 'Ljubljana', 20),
(56, 'Maribor', 20),
(57, 'Johannesburg', 21),
(58, 'Cape Town', 21),
(59, 'Port Elizabeth', 21),
(60, 'Madrid', 22),
(61, 'Barcelona', 22),
(62, 'Valencia', 22),
(63, 'Bilbao', 22),
(64, 'Dodoma', 23),
(65, 'Istanbul', 24),
(66, 'Ankara', 24),
(67, 'Izmir', 24),
(68, 'Bursa', 24),
(69, 'Abu Dhabi', 25),
(70, 'Dubai', 25),
(71, 'London', 26),
(72, 'Liverpool', 26),
(73, 'Manchester', 26),
(74, 'Glasgow', 26),
(75, 'Cardiff', 26),
(76, 'New York', 27),
(77, 'Chicago', 27),
(78, 'Los Angeles', 27),
(79, 'Denver', 27),
(80, 'Miami', 27),
(81, 'Portland', 27),
(82, 'Caracas', 28),
(83, 'Maracaibo', 28),
(84, 'Hanoi', 29),
(85, 'Harare', 30);

INSERT INTO `avio` (`id`, `address`, `description`, `name`, `map`, `city_id`) VALUES (1,'Beogradski aeroport 2','Srpska nacionalna avio kompanija. Letite sa nama i platite mnogo. Za prakticno nista.', 'Air Serbia', '', 52);
INSERT INTO `avio` (`id`,`address`,`description`,`map`,`name`,`city_id`) VALUES (9,'Charles de Gaulle AP','Discover the Air France universe: purchase a ticket, visit our corporate website, and gain access to all AIR FRANCE KLM Group sites.','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1868.4337081545928!2d2.5463864466060167!3d49.00966842920348!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e63e038e4ccf5b%3A0x42be0982f5ba62c!2sCharles+de+Gaulle+Airport!5e0!3m2!1sen!2srs!4v1549496938750','Air France',19);
INSERT INTO `avio` (`id`,`address`,`description`,`map`,`name`,`city_id`) VALUES (11,'El Prat de Llobregat 4','Vueling, Low Fares & Friendly Service. Book Now & Save Money! Get points to fly. Premium Card. Premium Service. Fares suiting your needs. ','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d20756.587114479924!2d2.075364640851538!3d41.29478491674772!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x2b461f76ea4689be!2sVueling+Airlines!5e0!3m2!1sen!2srs!4v1549497215832','Vueling Airlines',61);
INSERT INTO `avio` (`id`,`address`,`description`,`map`,`name`,`city_id`) VALUES (13,'Khalifa City 453','Etihad Airways is the national airline of the United Arab Emirates. We aim to provide you with choice, comfort and warm service.','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3632.1353813324126!2d54.612090715140276!3d24.446087884251064!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3e5e4f543beb57c7%3A0xba4f5f628fc42dae!2sEtihad+Airways+Head+Office!5e0!3m2!1sen!2srs!4v1549497380977','Etihad Airways',69);


insert into rentacar (id,name,address,city_id,description) values (1,'Drive a lot','Bulevar Evrope',51,'Najbolji servis ikada');
insert into rentacar (id,name,address,city_id,description) values (2,'Teraj bona','Bosanskog cevapa 10',54,'Bolji servis bona od ovog drugog');

insert into filijala (id,name,address,city_id,description,servis_id) values (12,'Drive a lot','Bulevar Kralja Petra',51,'Najbolji servis ikada',1);
insert into filijala (id,name,address,city_id,description,servis_id) values (13, 'Drive a lot', 'Bulevar Vojvode Stepe', 52, 'Naj', 1);
insert into filijala (id,name,address,city_id,description,servis_id) values (14, 'Drive a lot', 'Mihajla Pupina 1', 53, 'Naj', 1);
insert into filijala (id,name,address,city_id,description,servis_id) values (15, 'Drive a lot', 'Ksong Ksung', 12, 'Ma ja sam naj', 1);

insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (54, 'Q7','Audi','2016',5,'SUV',10,12);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (68, 'X5','BMW','2016',5,'SUV',15,12);


INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (2,1,52);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (1,1,30);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (3,1,28);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (4,1,29);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (5,1,76);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (6,1,53);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (7,1,62);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (8,1,36);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (9,1,43);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (10,11,61);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (11,11,62);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (12,11,60);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (13,11,52);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (14,11,71);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (15,11,76);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (130,9,19);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (131,9,1);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (132,9,32);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (133,9,80);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (134,9,52);


INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (10,80,'2019-02-12 13:45:00','2019-02-12 18:20:00',175,275,1,2,7);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (92,69,'2019-02-11 09:25:00','2019-02-11 22:45:00',105,800,1,2,8);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (162,110,'2019-02-14 10:30:00','2019-02-14 17:00:00',540,390,1,2,5);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (1,78,'2019-02-15 15:06:00','2019-02-15 22:50:00',180,464,1,7,2);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (16,30,'2019-02-20 06:45:00','2019-02-20 17:30:00',450,645,11,12,15);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (48,80,'2019-02-19 17:45:00','2019-02-20 23:30:00',130,1785,11,11,13);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (135,70,'2019-02-19 15:33:00','2019-02-19 17:50:00',200,137,9,130,134);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (206,70,'2019-02-19 18:20:00','2019-02-19 20:45:00',189,145,9,134,130);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (277,90,'2019-02-23 06:01:00','2019-02-23 22:45:00',570,1004,9,130,131);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (369,90,'2019-02-26 20:30:00','2019-02-27 10:45:00',590,855,9,131,130);


INSERT INTO `interception` (`id`,`duration`,`destination_id`,`flight_id`) VALUES (17,50,14,16);
INSERT INTO `interception` (`id`,`duration`,`destination_id`,`flight_id`) VALUES (49,30,10,48);
INSERT INTO `interception` (`id`,`duration`,`destination_id`,`flight_id`) VALUES (278,100,132,277);
INSERT INTO `interception` (`id`,`duration`,`destination_id`,`flight_id`) VALUES (370,130,133,369);

