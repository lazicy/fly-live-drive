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

INSERT INTO `avio` (`id`, `address`, `description`, `map`, `name`, `city_id`) VALUES (1,'Beogradski aeroport 2','3tersdfasdasd','asdasd','Air Serbia',52);
INSERT INTO `destination` (`id`, `avio_id`, `city_id`) VALUES (2,1,52);

insert into rentacar (id,name,address,city_id,description) values (1,'Drive a lot','Bulevar Evrope',51,'Najbolji servis ikada');
insert into rentacar (id,name,address,city_id,description) values (2,'Teraj bona','Bosanskog cevapa 10',54,'Bolji servis bona od ovog drugog');

insert into filijala (id,name,address,city,country,description,servis_id) values (1,'Drive a lot','Bulevar Kralja Petra','Novi Sad','Srbija','Najbolji servis ikada',1);

insert into vozilo (id,model,brand,production_year,number_of_seats,type,filijala_id) values (1, 'Q7','Audi','2016',5,'SUV',1);
insert into vozilo (id,model,brand,production_year,number_of_seats,type,filijala_id) values (2, 'X5','BMW','2016',5,'SUV',1);

insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (1, 'Hotel Moscow', 'Terazije 20', 52, 'Uz duboko poštovanje prema svojoj tradiciji, vrednosti koja traja više od veka – renovirani hotel zadovoljava najsavremenije visoke hotelske standarde.', 'http://www.serbia.com/wp-content/uploads/2016/03/abroadabroadtravel111.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2830.4188282049304!2d20.458241815265584!3d44.813031484676664!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475a7ab209cff051%3A0x52504f6400d4b777!2z0KXQvtGC0LXQuyDQnNC-0YHQutCy0LA!5e0!3m2!1ssr!2srs!4v1549149868770', 4);
insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (2, 'Hyatt Regency Belgrade', 'Milentija Popovica 5', 52, 'Hyatt Regency Belgrade is a is a modern hotel located in New Belgrade, Belgrade, Serbia. It is part of international hotel group Hyatt Regency. Located across the street from Ušće Tower and Ušće Shopping Center, it is close to both the city centre and Sava Center, and fifteen minutes from Belgrade Nikola Tesla Airport.', 'http://www.ekapija.com/thumbs/hyatt_exterior_051018_tw630.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2830.4668467333004!2d20.430136115535667!3d44.81205307909863!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475a65593956f76b%3A0x4a870b8916a9f8ce!2sHyatt+Regency+Belgrade!5e0!3m2!1ssr!2srs!4v1549150263295', 5);
insert into hotel (id, name, address, city_id, description, hotel_imageurl, map, stars) values (3, 'The Plaza', '768 5th Ave', 76, 'The Plaza Hotel is a landmark 20-story luxury hotel and condominium apartment building in the Midtown Manhattan neighborhood in the borough of Manhattan, New York City. It opened in 1907 and is now owned by Katara Hospitality.', 'https://images.datahubus.com/5739f864b5dc6545f27c3164/the-plaza-residences/1-central-park-s_.jpg', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3021.888861850124!2d-73.97667638459352!3d40.76446907932614!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c258f07d5da561%3A0x61f6aa300ba8339d!2sThe+Plaza!5e0!3m2!1ssr!2srs!4v1549150623903', 5);

