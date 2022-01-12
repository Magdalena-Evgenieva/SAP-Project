create database Project;
USE Project;


create table Size(
id INT NOT NULL auto_increment,
size varchar(255) NOT NULL,
primary key (id)
);

create table Type_brands(
id INT NOT NULL auto_increment,
brand varchar(255) NOT NULL,
descriptions varchar(300),
primary key (id)
);
create table Type_senses(
id INT NOT NULL auto_increment,
senses varchar(255) NOT NULL,
primary key (id)
);
create table Type_gender(
id INT NOT NULL auto_increment,
gender varchar(255) NOT NULL,
primary key (id)
);

insert into Type_senses(senses)
values ('Sport'),('Floral'),('Oriental'),('Fresh');

insert into Type_gender(gender)
values ('male'),('fimale');

insert into Size(size)
values ('100mL'),('50mL'),('30mL');

    
    create table Company(
id INT NOT NULL auto_increment,
Company_name varchar(255) NOT NULL,
FB varchar(255) NOT NULL,
Instagram varchar(255) NOT NULL,
Twitter varchar(255) NOT NULL,
password_to varchar(255) NOT NULL,
username varchar(255) NOT NULL,
primary key (id)
);
create table Clients(
id INT NOT NULL auto_increment,
name_client varchar(255) NOT NULL,
address varchar(255) NOT NULL,
telephone int NOT NULL,
primary key (id)
);


    create table Type_brands(
id INT NOT NULL auto_increment,
brand varchar(255) NOT NULL,
descriptions varchar(300),
primary key (id)
);

insert into Type_brands(brand, descriptions)
values ('Armani','Inspired by the elements of nature, the Giorgio Armani fragrances are an example of invisible sophistication. 
        A symbol of perfection and harmony'),('Chanel','From the legendary fragrance N°5, to the uncompromising freedom embodied by BLEU DE CHANEL. 
        CHANEL continues to set the standard for luxury and distinction.'),('DIOR','Fragrances which make you fell spacial'),('Lancome','Discover luxury perfumes from 
        one of the best perfume brands in the word Lancôme.');
    select * from Type_brands;
    
create table Perfumes(
id INT NOT NULL auto_increment,
Perfume_name varchar(255) NOT NULL,
Type_gender_id int not null,
Type_brands_id int not null,
Size_id int not null,
Type_senses_id int not null,
descriptions varchar(255) not null,
Price int not null,
Quantity int not null,
primary key (id),
Foreign key (Type_gender_id) references Type_gender(id),
Foreign key (Type_brands_id) references Type_brands(id),
Foreign key (Size_id) references Size(id),
Foreign key (Type_senses_id) references Type_senses(id)
);
 INSERT INTO perfumes (Perfume_name,Type_gender_id ,Type_brands_id ,Size_id , Type_senses_id, descriptions,Price,quantity)
VALUES ('Si', 2, 1, 2, 4, 'Si by Giorgio Armani is a Chypre Fruity fragrance for women.',152,200),
       ('Acqua di Gio', 1, 1, 2, 3, 'Acqua di Gio Profumo by Giorgio Armani is a Aromatic Aquatic fragrance for men.',125,245),
       ('Chanel №5', 2, 2, 1, 2, 'Since its creation in 1921, N°5 has exuded the very essence of femininity',200,400),
	   ('Bleu', 1, 2, 1, 4, 'Explore the Bleu de CHANEL fragrance collection for Men at CHANEL.',200,312),
       ('Savage', 1, 3, 2, 4, 'A new, highly concentrated interpretation of Sauvage, melding extreme freshness for men.',130,122),
       ('Savage', 2, 3, 2, 3, 'A new, highly concentrated interpretation of Sauvage, melding extreme freshness with warm oriental tones for her.',130,412),
       ('Miss Dior', 2, 3, 2, 2, ' Miss Dior is a hymn to love, emblematic of Dior’s femininity and Couture spirit.  A tailor-made trail with a modern, rebellious and elegant character.',150,365),
	   ('La Vie est Belle', 2, 4, 3, 2, 'La Vie Est Belle was created by Olivier Polge, Dominique Ropion and Anne Flipo and become one of the most favourite fragrance on the market',90,215);
       
     select * from perfumes;
     
     create table Salesman(
id INT NOT NULL auto_increment,
salesman_name varchar(255) NOT NULL,
Client_id int not null,
Username varchar(255) not null,
Selesman_password varchar(255) not null,
Selesman_email varchar(255) not null,
primary key (id),
Foreign key (Client_id) references clients(id)
);
create table Salescompanyclients(
id INT NOT NULL auto_increment,
Selesman_id int not null,
Client_id int not null,
Item_id int not null,
quantity int not null,
New_price int not null,
Date_ int not null,
primary key (id),
Foreign key (Selesman_id) references Salesman(id),
Foreign key (Client_id) references Clients(id),
Foreign key (Item_id) references Perfumes(id)
);

select * from Perfumes;


insert into Company(Company_name,FB,Instagram,Twitter,password_to,username)
values ('ORD'),('ORD'),('ORD'),('ORD'),('Gabi123@'),('Gabi');

       