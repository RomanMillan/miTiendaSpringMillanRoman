CREATE USER 'millanRoman'@'%' IDENTIFIED by 'millanRoman';
CREATE DATABASE IF NOT EXISTS `miTiendaSpringMillanRoman`;
GRANT ALL PRIVILEGES ON `miTiendaSpringMillanRoman`.* TO 'millanRoman'@'%';


CREATE TABLE miTiendaSpringMillanRoman.userdb( 
	username VARCHAR(32), 
	password VARCHAR(100), 
	realusername VARCHAR(32), 
	email VARCHAR(32),   
	administrator BOOLEAN, 
	CONSTRAINT PK_userdb PRIMARY KEY(username) 
);


CREATE TABLE miTiendaSpringMillanRoman.category(
	categoryname VARCHAR(32),
	description VARCHAR(100),
	CONSTRAINT PK_category PRIMARY KEY(categoryname)
);

CREATE TABLE miTiendaSpringMillanRoman.elementdb(
	elementname VARCHAR(32),
	description VARCHAR(100),
	stock int(10),
	price int(10),
	key_category VARCHAR(32),
	CONSTRAINT PK_elementdb PRIMARY KEY(elementname),
	CONSTRAINT FK_elementdb FOREIGN KEY(key_category) REFERENCES category(categoryname) ON DELETE CASCADE
);


CREATE TABLE miTiendaSpringMillanRoman.orderdb(
	numberOrder int(4) AUTO_INCREMENT,
	dateOrder datetime,
	vat int(2),
	key_user VARCHAR(32),
	CONSTRAINT PK_orderdb PRIMARY KEY(numberOrder),
	CONSTRAINT FK_orderdb FOREIGN KEY(key_user) REFERENCES userdb(username)
);

CREATE TABLE miTiendaSpringMillanRoman.receipt(
	key_element VARCHAR(32),
	key_order int(4),
	CONSTRAINT PK_receipt PRIMARY KEY (key_element, key_order),
	CONSTRAINT FK_receipt_element FOREIGN KEY(key_element) REFERENCES elementdb(elementname),
	CONSTRAINT FK_receipt_orderBD FOREIGN KEY(key_order) REFERENCES orderdb(numberOrder)
);



/*contraseña para admin : admin // los demás: 1234 = 45337ab528ab456381fd0fe311633a6b */
insert into miTiendaSpringMillanRoman.userdb (username, password, realusername, email, administrator) values ('admin', 'admin', 'admin', 'admin@gmail.com', true);
insert into miTiendaSpringMillanRoman.userdb (username, password, realusername, email, administrator) values ('Eli', '1234', 'Elisa', 'eli@gmail.com', false);
insert into miTiendaSpringMillanRoman.userdb (username, password, realusername, email, administrator) values ('Manu23', '1234', 'Manuel','manu@gmail.com', false);

insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Subaru', 'penatibus et magnis dis parturient montes');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Mazda', 'massa id lobortis convallis tortor risus');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('BMW', 'justo lacinia eget tincidunt eget tempus vel pede morbi');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Honda', 'orci luctus et ultrices posuere cubilia curae nulla');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Seat', 'vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Suzuki', 'est donec odio justo sollicitudin ut suscipit a feugiat et');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Ds', 'vel pede morbi porttitor lorem id ligula suspendisse ornare consequat');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Kia', 'phasellus id sapien in sapien iaculis congue vivamus metus');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Volkswagen', 'quis justo maecenas rhoncus aliquam lacus morbi quis');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Ssangyong', 'mauris viverra diam vitae quam suspendisse potenti');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Renault', 'nonummy integer non velit donec diam neque vestibulum eget');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Audi', 'erat nulla tempus vivamus in felis eu sapien cursus');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Ford', 'sapien arcu sed augue aliquam erat');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Jeep', 'parturient montes nascetur ridiculus mus vivamus');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Mercedes', 'lobortis sapien sapien non mi integer');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Peugeot', 'id turpis integer aliquet massa');
insert into miTiendaSpringMillanRoman.category (categoryname, description) values ('Toyota', 'amet sapien dignissim vestibulum vestibulum ante ipsum');



insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Cougar', 'rhoncus mauris enim leo rhoncus sed vestibulum',20, 172998, 'Mazda');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Corolla', 'augue vestibulum ante ipsum primis',20, 144029, 'Subaru');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('GranTurismo', 'cras pellentesque volutpat dui maecenas tristique est et',20, 97759, 'Ford');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('M-Class', 'lectus in quam fringilla rhoncus',20, 48967, 'Volkswagen');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('VUE', 'morbi odio odio elementum eu interdum',20, 20821, 'Kia');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('745', 'in hac habitasse platea dictumst',20, 91511, 'Ford');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Fiesta', 'cras mi pede malesuada in imperdiet et commodo',20, 193665, 'Subaru');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Sierra 2500', 'ligula nec sem duis aliquam',20, 40668, 'Subaru');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Forester', 'orci luctus et ultrices posuere',20, 198959, 'Subaru');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('CL-Class', 'ultrices posuere cubilia curae duis faucibus accumsan odio',20, 92928, 'Ssangyong');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Town Car', 'neque vestibulum eget vulputate ut ultrices vel',20, 147186, 'Mercedes');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Monte Carlo', 'mus etiam vel augue vestibulum rutrum rutrum',20, 183689, 'Seat');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('TrailBlazer', 'ac diam cras pellentesque volutpat dui maecenas',20, 28751, 'Subaru');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Tacoma Xtra', 'massa volutpat convallis morbi odio odio',20, 21150,'Audi');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('SVX', 'vivamus in felis eu sapien cursus vestibulum',20, 100045, 'Honda');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Cabriolet', 'nullam porttitor lacus at turpis donec',20, 43123, 'Ds');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Sky', 'dictumst etiam faucibus cursus urna ut tellus nulla',20, 115044, 'Jeep');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Cobalt', 'eget eleifend luctus ultricies eu nibh quisque id',20, 59841, 'Ssangyong');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Reliant', 'in hac habitasse platea dictumst etiam faucibus',20, 103208, 'Honda');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Camry', 'sem mauris laoreet ut rhoncus aliquet pulvinar',20, 84092, 'Kia');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Econoline E250', 'nam nulla integer pede justo lacinia eget',20, 81353, 'Peugeot');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Escalade', 'justo in hac habitasse platea dictumst',20, 51804, 'BMW');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('F250', 'luctus rutrum nulla tellus in sagittis dui',20, 84114, 'Honda');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Esprit', 'interdum in ante vestibulum ante ipsum',20, 181967, 'Kia');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('STS', 'pellentesque volutpat dui maecenas tristique',20, 33194, 'BMW');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Arnagert', 'habitasse platea dictumst morbi vestibulum velit id',20, 51648, 'Renault');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('PT Cruiser', 'vulputate ut ultrices vel augue',20, 122548, 'Audi');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Aztek', 'mi in porttitor pede justo eu massa donec',20, 16423, 'Mercedes');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Veracruz', 'sollicitudin mi sit amet lobortis sapien sapien',20, 96411, 'Audi');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('LR3', 'justo sollicitudin ut suscipit a',20, 175688, 'Ds');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Galaxie', 'et ultrices posuere cubilia curae nulla dapibus',20, 56735, 'Honda');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Challenger', 'mi nulla ac enim in tempor turpis',20, 132350, 'Jeep');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('FJ Cruiser', 'massa id lobortis convallis tortor risus dapibus augue',20, 188627, 'Toyota');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('430', 'eu orci mauris lacinia sapien quis libero nullam',20, 70319, 'Honda');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Dyy', 'tellus semper interdum mauris ullamcorper',20, 191405, 'Peugeot');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Eldorado', 'ipsum primis in faucibus orci luctus et ultrices',20, 61608, 'Honda');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('RX-7', 'nulla neque libero convallis eget eleifend luctus ultricies',20, 108258, 'Peugeot');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Bonneville', 'magna vulputate luctus cum sociis natoque penatibus',20, 49440, 'Toyota');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('C30', 'odio elementum eu interdum eu tincidunt',20, 130973, 'Volkswagen');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('IS-F', 'volutpat sapien arcu sed augue aliquam',20, 42293, 'Volkswagen');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Fortesque', 'pharetra magna ac consequat metus sapien',20, 97601, 'Peugeot');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Montana', 'at lorem integer tincidunt ante',20, 97430, 'Renault');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Elise', 'dui proin leo odio porttitor',20, 187070, 'Volkswagen');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Savana 1500', 'donec ut mauris eget massa',20, 29954, 'Peugeot');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Tana 100', 'quam a odio in hac habitasse',20, 82251, 'Suzuki');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('GS', 'ante nulla justo aliquam quis turpis',20, 29308, 'Ssangyong');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Regal', 'quis libero nullam sit amet turpis elementum',20, 146911, 'Audi');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Navajo', 'arcu sed augue aliquam erat volutpat in',20, 120682, 'Ds');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Avalon', 'lectus aliquam sit amet diam in magna',20, 166951, 'BMW');
insert into miTiendaSpringMillanRoman.elementdb (elementname, description,stock, price, key_category) values ('Cooper', 'eros viverra eget congue eget semper rutrum',20, 48721, 'Honda');
