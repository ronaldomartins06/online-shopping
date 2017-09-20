CREATE TABLE category(
	
	id int AUTO_INCREMENT,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active boolean,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

CREATE TABLE user_detail (
	id int AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id),
);


INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ronaldo', 'Martins', 'ADMIN', true, 'admin', 'ronaldomartins06@gmail.com', '8888888888');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Regis', 'Martins', 'SUPPLIER', true, '12345', 'regis@gmail.com', '9999999999');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Maria', 'McAnoy', 'SUPPLIER', true, '12345', 'maria@gmail.com', '7777777777');


CREATE TABLE product (
	id int auto_increment,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	

CREATE TABLE address (
	id int auto_increment,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);

CREATE TABLE cart (
	id int auto_increment,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);

INSERT INTO category (name, description,image_url,is_active) VALUES ('Laptop', 'This is description for Laptop category!', 'CAT_1.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Television', 'This is description for Television category!', 'CAT_2.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Mobile', 'This is description for Mobile category!', 'CAT_3.png', true);


INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 880, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 750, 2, true, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 700, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 1300, 3, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 720, 5, true, 1, 3 );


INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('ronaldo', 'martins', 'ADMIN', true, '$2y$10$Ba38N8jkeEsgr7YF5bKr5uqRt1Q3Kwm84rgkLtJLEmi67UgmJnLbe', 'ronaldomartins06@gmail.com', '8888888888');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('regis', 'martins', 'SUPPLIER', true, '$2y$10$61JKrLP177RMZQ8/c4LUnuud7qgHzXhi6v7fZFVl.KvePf5VzdR7q', 'regis@gmail.com', '9999999999');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('maria', 'mcanoy', 'SUPPLIER', true, '$2y$10$VvLu5cQBR/CvKtbgzccWpuOG1pVbgmR2NPA9RroxwAU7l4gmIu54e', 'maria@gmail.com', '7777777777');
