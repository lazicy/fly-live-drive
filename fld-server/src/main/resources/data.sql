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



insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (1, 'Hotel Moscow', 'Terazije 20', 52, 'Uz duboko poštovanje prema svojoj tradiciji, vrednosti koja traja više od veka – renovirani hotel zadovoljava najsavremenije visoke hotelske standarde.', 'http://www.serbia.com/wp-content/uploads/2016/03/abroadabroadtravel111.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2830.4188282049304!2d20.458241815265584!3d44.813031484676664!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475a7ab209cff051%3A0x52504f6400d4b777!2z0KXQvtGC0LXQuyDQnNC-0YHQutCy0LA!5e0!3m2!1ssr!2srs!4v1549149868770', 4);
insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (2, 'Hyatt Regency Belgrade', 'Milentija Popovica 5', 52, 'Hyatt Regency Belgrade is a is a modern hotel located in New Belgrade, Belgrade, Serbia. It is part of international hotel group Hyatt Regency. Located across the street from Ušće Tower and Ušće Shopping Center, it is close to both the city centre and Sava Center, and fifteen minutes from Belgrade Nikola Tesla Airport.', 'http://www.ekapija.com/thumbs/hyatt_exterior_051018_tw630.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2830.4668467333004!2d20.430136115535667!3d44.81205307909863!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475a65593956f76b%3A0x4a870b8916a9f8ce!2sHyatt+Regency+Belgrade!5e0!3m2!1ssr!2srs!4v1549150263295', 5);
insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (3, 'The Plaza', '768 5th Ave', 76, 'The Plaza Hotel is a landmark 20-story luxury hotel and condominium apartment building in the Midtown Manhattan neighborhood in the borough of Manhattan, New York City. It opened in 1907 and is now owned by Katara Hospitality.', 'https://images.datahubus.com/5739f864b5dc6545f27c3164/the-plaza-residences/1-central-park-s_.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3021.888861850124!2d-73.97667638459352!3d40.76446907932614!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c258f07d5da561%3A0x61f6aa300ba8339d!2sThe+Plaza!5e0!3m2!1ssr!2srs!4v1549150623903', 5);



INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`discount_seats`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (1,80,'2019-02-12 10:50:00',0,'2019-02-12 12:30:00',189,100,101,1,4);
INSERT INTO `flight` (`id`,`available_seats`,`departure_date`,`discount_seats`,`landing_date`,`price`,`total_duration`,`avio_id`,`departure_destination_id`,`landing_destination_id`) VALUES (82,70,'2019-02-19 13:40:00',0,'2019-02-19 15:15:00',199,95,101,4,1);



INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (2,false,0,'A',false,1,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (3,false,0,'B',false,1,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (4,false,0,'C',false,1,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (5,false,0,'D',false,1,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (6,false,0,'E',false,1,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (7,false,0,'F',false,1,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (8,false,0,'A',false,2,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (9,false,0,'B',false,2,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (10,false,0,'C',false,2,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (11,false,0,'D',false,2,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (12,false,0,'E',false,2,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (13,false,0,'F',false,2,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (14,false,0,'A',false,3,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (15,false,0,'B',false,3,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (16,false,0,'C',false,3,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (17,false,0,'D',false,3,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (18,false,0,'E',false,3,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (19,false,0,'F',false,3,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (20,false,0,'A',false,4,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (21,false,0,'B',false,4,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (22,false,0,'C',false,4,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (23,false,0,'D',false,4,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (24,false,0,'E',false,4,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (25,false,0,'F',false,4,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (26,false,0,'A',false,5,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (27,false,0,'B',false,5,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (28,false,0,'C',false,5,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (29,false,0,'D',false,5,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (30,false,0,'E',false,5,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (31,false,0,'F',false,5,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (32,false,0,'A',false,6,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (33,false,0,'B',false,6,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (34,false,0,'C',false,6,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (35,false,0,'D',false,6,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (36,false,0,'E',false,6,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (37,false,0,'F',false,6,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (38,false,0,'A',false,7,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (39,false,0,'B',false,7,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (40,false,0,'C',false,7,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (41,false,0,'D',false,7,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (42,false,0,'E',false,7,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (43,false,0,'F',false,7,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (44,false,0,'A',false,8,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (45,false,0,'B',false,8,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (46,false,0,'C',false,8,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (47,false,0,'D',false,8,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (48,false,0,'E',false,8,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (49,false,0,'F',false,8,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (50,false,0,'A',false,9,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (51,false,0,'B',false,9,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (52,false,0,'C',false,9,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (53,false,0,'D',false,9,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (54,false,0,'E',false,9,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (55,false,0,'F',false,9,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (56,false,0,'A',false,10,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (57,false,0,'B',false,10,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (58,false,0,'C',false,10,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (59,false,0,'D',false,10,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (60,false,0,'E',false,10,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (61,false,0,'F',false,10,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (62,false,0,'A',false,11,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (63,false,0,'B',false,11,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (64,false,0,'C',false,11,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (65,false,0,'D',false,11,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (66,false,0,'E',false,11,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (67,false,0,'F',false,11,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (68,false,0,'A',false,12,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (69,false,0,'B',false,12,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (70,false,0,'C',false,12,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (71,false,0,'D',false,12,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (72,false,0,'E',false,12,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (73,false,0,'F',false,12,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (74,false,0,'A',false,13,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (75,false,0,'B',false,13,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (76,false,0,'C',false,13,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (77,false,0,'D',false,13,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (78,false,0,'E',false,13,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (79,false,0,'F',false,13,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (80,false,0,'A',false,14,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (81,false,0,'B',false,14,1,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (83,false,0,'A',false,1,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (84,false,0,'B',false,1,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (85,false,0,'C',false,1,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (86,false,0,'D',false,1,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (87,false,0,'E',false,1,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (88,false,0,'F',false,1,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (89,false,0,'A',false,2,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (90,false,0,'B',false,2,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (91,false,0,'C',false,2,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (92,false,0,'D',false,2,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (93,false,0,'E',false,2,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (94,false,0,'F',false,2,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (95,false,0,'A',false,3,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (96,false,0,'B',false,3,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (97,false,0,'C',false,3,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (98,false,0,'D',false,3,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (99,false,0,'E',false,3,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (100,false,0,'F',false,3,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (101,false,0,'A',false,4,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (102,false,0,'B',false,4,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (103,false,0,'C',false,4,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (104,false,0,'D',false,4,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (105,false,0,'E',false,4,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (106,false,0,'F',false,4,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (107,false,0,'A',false,5,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (108,false,0,'B',false,5,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (109,false,0,'C',false,5,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (110,false,0,'D',false,5,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (111,false,0,'E',false,5,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (112,false,0,'F',false,5,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (113,false,0,'A',false,6,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (114,false,0,'B',false,6,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (115,false,0,'C',false,6,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (116,false,0,'D',false,6,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (117,false,0,'E',false,6,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (118,false,0,'F',false,6,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (119,false,0,'A',false,7,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (120,false,0,'B',false,7,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (121,false,0,'C',false,7,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (122,false,0,'D',false,7,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (123,false,0,'E',false,7,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (124,false,0,'F',false,7,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (125,false,0,'A',false,8,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (126,false,0,'B',false,8,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (127,false,0,'C',false,8,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (128,false,0,'D',false,8,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (129,false,0,'E',false,8,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (130,false,0,'F',false,8,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (131,false,0,'A',false,9,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (132,false,0,'B',false,9,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (133,false,0,'C',false,9,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (134,false,0,'D',false,9,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (135,false,0,'E',false,9,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (136,false,0,'F',false,9,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (137,false,0,'A',false,10,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (138,false,0,'B',false,10,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (139,false,0,'C',false,10,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (140,false,0,'D',false,10,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (141,false,0,'E',false,10,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (142,false,0,'F',false,10,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (143,false,0,'A',false,11,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (144,false,0,'B',false,11,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (145,false,0,'C',false,11,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (146,false,0,'D',false,11,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (147,false,0,'E',false,11,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (148,false,0,'F',false,11,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (149,false,0,'A',false,12,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (150,false,0,'B',false,12,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (151,false,0,'C',false,12,82,NULL,NULL);
INSERT INTO `seat` (`id`,`deleted`,`discount`,`place`,`reserved`,`row`,`flight_id`,`reservation_departure_id`,`reservation_return_id`) VALUES (152,false,0,'D',false,12,82,NULL,NULL);
