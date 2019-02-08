insert into user (username,password,firstname,lastname,email,city,active,first_log,type, bonus_points) values ('dovla96', '$2a$04$nRJALierFkUMWbUfQBzvy.DhKLc6UTMSX4vI4.HfPF0THn.VjTIYm', 'Vladimir', 'Cvetanovic', 'cvetanovic9696@gmail.com', 'Novi Sad',true, false,'RENT_ADMIN', 0);

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

INSERT INTO `avio` (`id`, `address`, `description`, `name`, `map`, `city_id`) VALUES (101,'Beogradski aeroport 2','Srpska nacionalna avio kompanija. Letite sa nama i platite mnogo. Za prakticno nista.', 'Air Serbia', '', 52);
INSERT INTO `avio` (`id`,`address`,`description`,`map`,`name`,`city_id`) VALUES (102,'Charles de Gaulle AP','Discover the Air France universe: purchase a ticket, visit our corporate website, and gain access to all AIR FRANCE KLM Group sites.','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1868.4337081545928!2d2.5463864466060167!3d49.00966842920348!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e63e038e4ccf5b%3A0x42be0982f5ba62c!2sCharles+de+Gaulle+Airport!5e0!3m2!1sen!2srs!4v1549496938750','Air France',19);
INSERT INTO `avio` (`id`,`address`,`description`,`map`,`name`,`city_id`) VALUES (103,'El Prat de Llobregat 4','Vueling, Low Fares & Friendly Service. Book Now & Save Money! Get points to fly. Premium Card. Premium Service. Fares suiting your needs. ','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d20756.587114479924!2d2.075364640851538!3d41.29478491674772!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x2b461f76ea4689be!2sVueling+Airlines!5e0!3m2!1sen!2srs!4v1549497215832','Vueling Airlines',61);
INSERT INTO `avio` (`id`,`address`,`description`,`map`,`name`,`city_id`) VALUES (104,'Khalifa City 453','Etihad Airways is the national airline of the United Arab Emirates. We aim to provide you with choice, comfort and warm service.','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3632.1353813324126!2d54.612090715140276!3d24.446087884251064!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3e5e4f543beb57c7%3A0xba4f5f628fc42dae!2sEtihad+Airways+Head+Office!5e0!3m2!1sen!2srs!4v1549497380977','Etihad Airways',69);


INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (1,101,52);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (2,101,53);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (3,101,62);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (4,101,61);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (5,101,37);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (6,101,24);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (7,101,19);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (8,101,76);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (9,101,48);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (10,101,77);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (592,102,19);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (593,102,44);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (594,102,21);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (595,102,60);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (596,102,61);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (597,102,55);
INSERT INTO `destination` (`id`,`avio_id`,`city_id`) VALUES (598,102,52);

INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (11,90,'2019-02-18 15:25:00','2019-02-18 17:50:00',189,145,101,1,4);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (102,80,'2019-02-18 14:25:00','2019-02-19 18:50:00',220,1705,101,1,3);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (184,70,'2019-02-19 19:40:00','2019-02-19 21:50:00',160,130,101,4,1);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (255,110,'2019-02-20 07:25:00','2019-02-20 21:50:00',580,865,101,1,10);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (368,110,'2019-02-22 18:25:00','2019-02-23 04:22:00',630,597,101,10,1);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (480,110,'2019-02-21 12:00:00','2019-02-21 14:40:00',239,160,101,1,7);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (599,60,'2019-02-25 12:40:00','2019-02-25 15:20:00',230,160,102,592,598);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (660,70,'2019-02-26 16:40:00','2019-02-26 18:15:00',160,95,102,592,597);


INSERT INTO `interception` (`id`,`duration`,`destination_id`,`flight_id`) VALUES (103,55,4,102);
INSERT INTO `interception` (`id`,`duration`,`destination_id`,`flight_id`) VALUES (256,85,8,255);
INSERT INTO `interception` (`id`,`duration`,`destination_id`,`flight_id`) VALUES (257,60,6,255);
INSERT INTO `interception` (`id`,`duration`,`destination_id`,`flight_id`) VALUES (369,130,8,368);



insert into rentacar (id,name,address,city_id,description) values (1,'Drive a lot','Bulevar Evrope',51,'Najbolji servis ikada');
insert into rentacar (id,name,address,city_id,description) values (2,'Teraj bona','Bosanskog cevapa 10',54,'Bolji servis bona od ovog drugog');

insert into filijala (id,name,address,city_id,description,servis_id) values (12,'Drive a lot','Bulevar Kralja Petra',51,'Najbolji servis ikada',1);
insert into filijala (id,name,address,city_id,description,servis_id) values (13, 'Drive a lot', 'Bulevar Vojvode Stepe', 52, 'Naj', 1);
insert into filijala (id,name,address,city_id,description,servis_id) values (14, 'Drive a lot', 'Mihajla Pupina 1', 53, 'Naj', 1);
insert into filijala (id,name,address,city_id,description,servis_id) values (15, 'Drive a lot', 'Ksong Ksung', 12, 'Ma ja sam naj', 1);

insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (54, 'Q7','Audi','2016',5,'SUV',10,12);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (68, 'X5','BMW','2016',5,'SUV',15,12);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (12, 'X4','BMW','2016',5,'SUV',30,12);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (66, 'X3','BMW','2016',5,'SUV',30,12);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (13, 'X2','Audi','2016',5,'SUV',10,13);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (22, 'Focus','Ford','2016',5,'SUV',15,13);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,price_per_day,filijala_id) values (35, 'Astra','Opel','2016',5,'SUV',30,13);


INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (12,'A',false,1,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (13,'B',false,1,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (14,'C',false,1,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (15,'D',false,1,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (16,'E',false,1,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (17,'F',false,1,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (18,'A',false,2,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (19,'B',false,2,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (20,'C',false,2,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (21,'D',false,2,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (22,'E',false,2,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (23,'F',false,2,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (24,'A',false,3,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (25,'B',false,3,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (26,'C',false,3,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (27,'D',false,3,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (28,'E',false,3,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (29,'F',false,3,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (30,'A',false,4,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (31,'B',false,4,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (32,'C',false,4,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (33,'D',false,4,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (34,'E',false,4,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (35,'F',false,4,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (36,'A',false,5,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (37,'B',false,5,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (38,'C',false,5,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (39,'D',false,5,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (40,'E',false,5,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (41,'F',false,5,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (42,'A',false,6,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (43,'B',false,6,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (44,'C',false,6,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (45,'D',false,6,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (46,'E',false,6,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (47,'F',false,6,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (48,'A',false,7,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (49,'B',false,7,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (50,'C',false,7,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (51,'D',false,7,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (52,'E',false,7,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (53,'F',false,7,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (54,'A',false,8,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (55,'B',false,8,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (56,'C',false,8,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (57,'D',false,8,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (58,'E',false,8,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (59,'F',false,8,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (60,'A',false,9,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (61,'B',false,9,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (62,'C',false,9,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (63,'D',false,9,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (64,'E',false,9,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (65,'F',false,9,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (66,'A',false,10,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (67,'B',false,10,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (68,'C',false,10,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (69,'D',false,10,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (70,'E',false,10,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (71,'F',false,10,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (72,'A',false,11,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (73,'B',false,11,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (74,'C',false,11,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (75,'D',false,11,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (76,'E',false,11,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (77,'F',false,11,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (78,'A',false,12,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (79,'B',false,12,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (80,'C',false,12,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (81,'D',false,12,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (82,'E',false,12,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (83,'F',false,12,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (84,'A',false,13,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (85,'B',false,13,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (86,'C',false,13,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (87,'D',false,13,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (88,'E',false,13,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (89,'F',false,13,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (90,'A',false,14,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (91,'B',false,14,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (92,'C',false,14,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (93,'D',false,14,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (94,'E',false,14,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (95,'F',false,14,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (96,'A',false,15,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (97,'B',false,15,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (98,'C',false,15,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (99,'D',false,15,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (100,'E',false,15,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (101,'F',false,15,11);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (104,'A',false,1,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (105,'B',false,1,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (106,'C',false,1,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (107,'D',false,1,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (108,'E',false,1,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (109,'F',false,1,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (110,'A',false,2,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (111,'B',false,2,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (112,'C',false,2,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (113,'D',false,2,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (114,'E',false,2,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (115,'F',false,2,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (116,'A',false,3,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (117,'B',false,3,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (118,'C',false,3,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (119,'D',false,3,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (120,'E',false,3,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (121,'F',false,3,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (122,'A',false,4,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (123,'B',false,4,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (124,'C',false,4,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (125,'D',false,4,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (126,'E',false,4,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (127,'F',false,4,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (128,'A',false,5,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (129,'B',false,5,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (130,'C',false,5,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (131,'D',false,5,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (132,'E',false,5,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (133,'F',false,5,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (134,'A',false,6,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (135,'B',false,6,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (136,'C',false,6,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (137,'D',false,6,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (138,'E',false,6,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (139,'F',false,6,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (140,'A',false,7,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (141,'B',false,7,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (142,'C',false,7,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (143,'D',false,7,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (144,'E',false,7,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (145,'F',false,7,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (146,'A',false,8,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (147,'B',false,8,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (148,'C',false,8,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (149,'D',false,8,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (150,'E',false,8,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (151,'F',false,8,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (152,'A',false,9,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (153,'B',false,9,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (154,'C',false,9,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (155,'D',false,9,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (156,'E',false,9,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (157,'F',false,9,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (158,'A',false,10,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (159,'B',false,10,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (160,'C',false,10,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (161,'D',false,10,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (162,'E',false,10,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (163,'F',false,10,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (164,'A',false,11,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (165,'B',false,11,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (166,'C',false,11,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (167,'D',false,11,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (168,'E',false,11,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (169,'F',false,11,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (170,'A',false,12,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (171,'B',false,12,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (172,'C',false,12,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (173,'D',false,12,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (174,'E',false,12,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (175,'F',false,12,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (176,'A',false,13,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (177,'B',false,13,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (178,'C',false,13,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (179,'D',false,13,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (180,'E',false,13,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (181,'F',false,13,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (182,'A',false,14,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (183,'B',false,14,102);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (185,'A',false,1,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (186,'B',false,1,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (187,'C',false,1,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (188,'D',false,1,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (189,'E',false,1,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (190,'F',false,1,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (191,'A',false,2,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (192,'B',false,2,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (193,'C',false,2,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (194,'D',false,2,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (195,'E',false,2,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (196,'F',false,2,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (197,'A',false,3,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (198,'B',false,3,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (199,'C',false,3,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (200,'D',false,3,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (201,'E',false,3,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (202,'F',false,3,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (203,'A',false,4,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (204,'B',false,4,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (205,'C',false,4,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (206,'D',false,4,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (207,'E',false,4,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (208,'F',false,4,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (209,'A',false,5,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (210,'B',false,5,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (211,'C',false,5,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (212,'D',false,5,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (213,'E',false,5,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (214,'F',false,5,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (215,'A',false,6,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (216,'B',false,6,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (217,'C',false,6,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (218,'D',false,6,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (219,'E',false,6,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (220,'F',false,6,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (221,'A',false,7,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (222,'B',false,7,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (223,'C',false,7,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (224,'D',false,7,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (225,'E',false,7,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (226,'F',false,7,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (227,'A',false,8,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (228,'B',false,8,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (229,'C',false,8,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (230,'D',false,8,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (231,'E',false,8,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (232,'F',false,8,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (233,'A',false,9,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (234,'B',false,9,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (235,'C',false,9,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (236,'D',false,9,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (237,'E',false,9,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (238,'F',false,9,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (239,'A',false,10,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (240,'B',false,10,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (241,'C',false,10,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (242,'D',false,10,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (243,'E',false,10,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (244,'F',false,10,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (245,'A',false,11,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (246,'B',false,11,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (247,'C',false,11,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (248,'D',false,11,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (249,'E',false,11,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (250,'F',false,11,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (251,'A',false,12,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (252,'B',false,12,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (253,'C',false,12,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (254,'D',false,12,184);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (258,'A',false,1,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (259,'B',false,1,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (260,'C',false,1,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (261,'D',false,1,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (262,'E',false,1,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (263,'F',false,1,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (264,'A',false,2,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (265,'B',false,2,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (266,'C',false,2,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (267,'D',false,2,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (268,'E',false,2,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (269,'F',false,2,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (270,'A',false,3,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (271,'B',false,3,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (272,'C',false,3,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (273,'D',false,3,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (274,'E',false,3,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (275,'F',false,3,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (276,'A',false,4,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (277,'B',false,4,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (278,'C',false,4,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (279,'D',false,4,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (280,'E',false,4,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (281,'F',false,4,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (282,'A',false,5,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (283,'B',false,5,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (284,'C',false,5,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (285,'D',false,5,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (286,'E',false,5,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (287,'F',false,5,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (288,'A',false,6,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (289,'B',false,6,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (290,'C',false,6,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (291,'D',false,6,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (292,'E',false,6,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (293,'F',false,6,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (294,'A',false,7,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (295,'B',false,7,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (296,'C',false,7,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (297,'D',false,7,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (298,'E',false,7,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (299,'F',false,7,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (300,'A',false,8,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (301,'B',false,8,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (302,'C',false,8,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (303,'D',false,8,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (304,'E',false,8,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (305,'F',false,8,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (306,'A',false,9,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (307,'B',false,9,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (308,'C',false,9,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (309,'D',false,9,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (310,'E',false,9,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (311,'F',false,9,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (312,'A',false,10,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (313,'B',false,10,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (314,'C',false,10,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (315,'D',false,10,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (316,'E',false,10,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (317,'F',false,10,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (318,'A',false,11,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (319,'B',false,11,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (320,'C',false,11,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (321,'D',false,11,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (322,'E',false,11,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (323,'F',false,11,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (324,'A',false,12,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (325,'B',false,12,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (326,'C',false,12,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (327,'D',false,12,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (328,'E',false,12,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (329,'F',false,12,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (330,'A',false,13,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (331,'B',false,13,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (332,'C',false,13,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (333,'D',false,13,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (334,'E',false,13,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (335,'F',false,13,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (336,'A',false,14,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (337,'B',false,14,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (338,'C',false,14,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (339,'D',false,14,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (340,'E',false,14,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (341,'F',false,14,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (342,'A',false,15,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (343,'B',false,15,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (344,'C',false,15,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (345,'D',false,15,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (346,'E',false,15,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (347,'F',false,15,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (348,'A',false,16,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (349,'B',false,16,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (350,'C',false,16,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (351,'D',false,16,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (352,'E',false,16,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (353,'F',false,16,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (354,'A',false,17,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (355,'B',false,17,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (356,'C',false,17,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (357,'D',false,17,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (358,'E',false,17,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (359,'F',false,17,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (360,'A',false,18,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (361,'B',false,18,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (362,'C',false,18,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (363,'D',false,18,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (364,'E',false,18,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (365,'F',false,18,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (366,'A',false,19,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (367,'B',false,19,255);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (370,'A',false,1,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (371,'B',false,1,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (372,'C',false,1,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (373,'D',false,1,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (374,'E',false,1,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (375,'F',false,1,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (376,'A',false,2,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (377,'B',false,2,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (378,'C',false,2,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (379,'D',false,2,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (380,'E',false,2,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (381,'F',false,2,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (382,'A',false,3,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (383,'B',false,3,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (384,'C',false,3,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (385,'D',false,3,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (386,'E',false,3,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (387,'F',false,3,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (388,'A',false,4,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (389,'B',false,4,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (390,'C',false,4,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (391,'D',false,4,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (392,'E',false,4,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (393,'F',false,4,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (394,'A',false,5,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (395,'B',false,5,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (396,'C',false,5,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (397,'D',false,5,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (398,'E',false,5,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (399,'F',false,5,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (400,'A',false,6,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (401,'B',false,6,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (402,'C',false,6,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (403,'D',false,6,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (404,'E',false,6,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (405,'F',false,6,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (406,'A',false,7,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (407,'B',false,7,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (408,'C',false,7,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (409,'D',false,7,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (410,'E',false,7,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (411,'F',false,7,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (412,'A',false,8,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (413,'B',false,8,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (414,'C',false,8,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (415,'D',false,8,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (416,'E',false,8,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (417,'F',false,8,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (418,'A',false,9,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (419,'B',false,9,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (420,'C',false,9,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (421,'D',false,9,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (422,'E',false,9,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (423,'F',false,9,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (424,'A',false,10,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (425,'B',false,10,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (426,'C',false,10,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (427,'D',false,10,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (428,'E',false,10,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (429,'F',false,10,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (430,'A',false,11,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (431,'B',false,11,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (432,'C',false,11,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (433,'D',false,11,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (434,'E',false,11,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (435,'F',false,11,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (436,'A',false,12,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (437,'B',false,12,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (438,'C',false,12,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (439,'D',false,12,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (440,'E',false,12,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (441,'F',false,12,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (442,'A',false,13,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (443,'B',false,13,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (444,'C',false,13,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (445,'D',false,13,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (446,'E',false,13,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (447,'F',false,13,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (448,'A',false,14,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (449,'B',false,14,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (450,'C',false,14,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (451,'D',false,14,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (452,'E',false,14,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (453,'F',false,14,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (454,'A',false,15,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (455,'B',false,15,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (456,'C',false,15,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (457,'D',false,15,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (458,'E',false,15,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (459,'F',false,15,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (460,'A',false,16,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (461,'B',false,16,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (462,'C',false,16,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (463,'D',false,16,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (464,'E',false,16,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (465,'F',false,16,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (466,'A',false,17,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (467,'B',false,17,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (468,'C',false,17,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (469,'D',false,17,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (470,'E',false,17,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (471,'F',false,17,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (472,'A',false,18,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (473,'B',false,18,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (474,'C',false,18,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (475,'D',false,18,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (476,'E',false,18,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (477,'F',false,18,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (478,'A',false,19,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (479,'B',false,19,368);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (482,'A',false,1,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (483,'B',false,1,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (484,'C',false,1,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (485,'D',false,1,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (486,'E',false,1,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (487,'F',false,1,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (488,'A',false,2,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (489,'B',false,2,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (490,'C',false,2,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (491,'D',false,2,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (492,'E',false,2,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (493,'F',false,2,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (494,'A',false,3,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (495,'B',false,3,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (496,'C',false,3,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (497,'D',false,3,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (498,'E',false,3,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (499,'F',false,3,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (500,'A',false,4,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (501,'B',false,4,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (502,'C',false,4,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (503,'D',false,4,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (504,'E',false,4,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (505,'F',false,4,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (506,'A',false,5,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (507,'B',false,5,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (508,'C',false,5,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (509,'D',false,5,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (510,'E',false,5,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (511,'F',false,5,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (512,'A',false,6,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (513,'B',false,6,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (514,'C',false,6,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (515,'D',false,6,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (516,'E',false,6,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (517,'F',false,6,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (518,'A',false,7,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (519,'B',false,7,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (520,'C',false,7,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (521,'D',false,7,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (522,'E',false,7,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (523,'F',false,7,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (524,'A',false,8,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (525,'B',false,8,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (526,'C',false,8,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (527,'D',false,8,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (528,'E',false,8,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (529,'F',false,8,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (530,'A',false,9,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (531,'B',false,9,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (532,'C',false,9,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (533,'D',false,9,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (534,'E',false,9,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (535,'F',false,9,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (536,'A',false,10,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (537,'B',false,10,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (538,'C',false,10,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (539,'D',false,10,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (540,'E',false,10,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (541,'F',false,10,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (542,'A',false,11,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (543,'B',false,11,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (544,'C',false,11,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (545,'D',false,11,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (546,'E',false,11,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (547,'F',false,11,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (548,'A',false,12,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (549,'B',false,12,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (550,'C',false,12,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (551,'D',false,12,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (552,'E',false,12,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (553,'F',false,12,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (554,'A',false,13,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (555,'B',false,13,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (556,'C',false,13,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (557,'D',false,13,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (558,'E',false,13,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (559,'F',false,13,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (560,'A',false,14,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (561,'B',false,14,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (562,'C',false,14,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (563,'D',false,14,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (564,'E',false,14,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (565,'F',false,14,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (566,'A',false,15,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (567,'B',false,15,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (568,'C',false,15,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (569,'D',false,15,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (570,'E',false,15,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (571,'F',false,15,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (572,'A',false,16,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (573,'B',false,16,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (574,'C',false,16,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (575,'D',false,16,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (576,'E',false,16,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (577,'F',false,16,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (578,'A',false,17,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (579,'B',false,17,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (580,'C',false,17,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (581,'D',false,17,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (582,'E',false,17,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (583,'F',false,17,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (584,'A',false,18,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (585,'B',false,18,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (586,'C',false,18,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (587,'D',false,18,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (588,'E',false,18,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (589,'F',false,18,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (590,'A',false,19,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (591,'B',false,19,480);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (600,'A',false,1,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (601,'B',false,1,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (602,'C',false,1,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (603,'D',false,1,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (604,'E',false,1,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (605,'F',false,1,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (606,'A',false,2,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (607,'B',false,2,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (608,'C',false,2,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (609,'D',false,2,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (610,'E',false,2,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (611,'F',false,2,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (612,'A',false,3,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (613,'B',false,3,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (614,'C',false,3,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (615,'D',false,3,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (616,'E',false,3,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (617,'F',false,3,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (618,'A',false,4,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (619,'B',false,4,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (620,'C',false,4,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (621,'D',false,4,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (622,'E',false,4,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (623,'F',false,4,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (624,'A',false,5,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (625,'B',false,5,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (626,'C',false,5,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (627,'D',false,5,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (628,'E',false,5,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (629,'F',false,5,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (630,'A',false,6,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (631,'B',false,6,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (632,'C',false,6,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (633,'D',false,6,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (634,'E',false,6,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (635,'F',false,6,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (636,'A',false,7,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (637,'B',false,7,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (638,'C',false,7,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (639,'D',false,7,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (640,'E',false,7,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (641,'F',false,7,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (642,'A',false,8,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (643,'B',false,8,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (644,'C',false,8,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (645,'D',false,8,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (646,'E',false,8,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (647,'F',false,8,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (648,'A',false,9,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (649,'B',false,9,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (650,'C',false,9,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (651,'D',false,9,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (652,'E',false,9,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (653,'F',false,9,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (654,'A',false,10,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (655,'B',false,10,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (656,'C',false,10,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (657,'D',false,10,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (658,'E',false,10,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (659,'F',false,10,599);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (661,'A',false,1,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (662,'B',false,1,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (663,'C',false,1,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (664,'D',false,1,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (665,'E',false,1,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (666,'F',false,1,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (667,'A',false,2,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (668,'B',false,2,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (669,'C',false,2,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (670,'D',false,2,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (671,'E',false,2,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (672,'F',false,2,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (673,'A',false,3,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (674,'B',false,3,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (675,'C',false,3,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (676,'D',false,3,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (677,'E',false,3,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (678,'F',false,3,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (679,'A',false,4,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (680,'B',false,4,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (681,'C',false,4,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (682,'D',false,4,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (683,'E',false,4,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (684,'F',false,4,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (685,'A',false,5,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (686,'B',false,5,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (687,'C',false,5,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (688,'D',false,5,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (689,'E',false,5,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (690,'F',false,5,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (691,'A',false,6,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (692,'B',false,6,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (693,'C',false,6,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (694,'D',false,6,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (695,'E',false,6,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (696,'F',false,6,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (697,'A',false,7,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (698,'B',false,7,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (699,'C',false,7,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (700,'D',false,7,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (701,'E',false,7,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (702,'F',false,7,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (703,'A',false,8,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (704,'B',false,8,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (705,'C',false,8,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (706,'D',false,8,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (707,'E',false,8,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (708,'F',false,8,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (709,'A',false,9,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (710,'B',false,9,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (711,'C',false,9,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (712,'D',false,9,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (713,'E',false,9,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (714,'F',false,9,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (715,'A',false,10,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (716,'B',false,10,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (717,'C',false,10,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (718,'D',false,10,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (719,'E',false,10,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (720,'F',false,10,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (721,'A',false,11,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (722,'B',false,11,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (723,'C',false,11,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (724,'D',false,11,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (725,'E',false,11,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (726,'F',false,11,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (727,'A',false,12,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (728,'B',false,12,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (729,'C',false,12,660);
INSERT INTO `seat` (`id`,`place`,`reserved`,`row`,`flight_id`) VALUES (730,'D',false,12,660);



insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (1, 'Hotel Moscow', 'Terazije 20', 52, 'Uz duboko poštovanje prema svojoj tradiciji, vrednosti koja traja više od veka – renovirani hotel zadovoljava najsavremenije visoke hotelske standarde.', 'http://www.serbia.com/wp-content/uploads/2016/03/abroadabroadtravel111.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2830.4188282049304!2d20.458241815265584!3d44.813031484676664!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475a7ab209cff051%3A0x52504f6400d4b777!2z0KXQvtGC0LXQuyDQnNC-0YHQutCy0LA!5e0!3m2!1ssr!2srs!4v1549149868770', 4);
insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (2, 'Hyatt Regency Belgrade', 'Milentija Popovica 5', 52, 'Hyatt Regency Belgrade is a is a modern hotel located in New Belgrade, Belgrade, Serbia. It is part of international hotel group Hyatt Regency. Located across the street from Ušće Tower and Ušće Shopping Center, it is close to both the city centre and Sava Center, and fifteen minutes from Belgrade Nikola Tesla Airport.', 'http://www.ekapija.com/thumbs/hyatt_exterior_051018_tw630.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2830.4668467333004!2d20.430136115535667!3d44.81205307909863!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475a65593956f76b%3A0x4a870b8916a9f8ce!2sHyatt+Regency+Belgrade!5e0!3m2!1ssr!2srs!4v1549150263295', 5);
insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (3, 'The Plaza', '768 5th Ave', 76, 'The Plaza Hotel is a landmark 20-story luxury hotel and condominium apartment building in the Midtown Manhattan neighborhood in the borough of Manhattan, New York City. It opened in 1907 and is now owned by Katara Hospitality.', 'https://images.datahubus.com/5739f864b5dc6545f27c3164/the-plaza-residences/1-central-park-s_.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3021.888861850124!2d-73.97667638459352!3d40.76446907932614!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c258f07d5da561%3A0x61f6aa300ba8339d!2sThe+Plaza!5e0!3m2!1ssr!2srs!4v1549150623903', 5);

