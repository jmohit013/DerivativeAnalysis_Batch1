create database test;
use test;

create table futures(company_name varchar(100),futures_category varchar(100),underlying_asset varchar(100),lot_size int, spot_price double, primary key(company_name,futures_category,underlying_asset));
create table options(company_name varchar(100),options_category varchar(100),options_type varchar(100),underlying_asset varchar(100),lot_size int, spot_price double, primary key(company_name,options_category,options_type,underlying_asset));
create table user(user_id int,name varchar(255),password varchar(255), primary key (user_id));

insert into Futures values('Amazon','Long','Bond',100,3000);
insert into Futures values('Google','Long','Bond',150,1400);
insert into Futures values('Walmart','Long','Bond',200,150);
insert into Futures values('Amazon','Short','Bond',100,3000);
insert into Futures values('Google','Short','Bond',150,1400);
insert into Futures values('Walmart','Short','Bond',200,150);
insert into Futures values('Amazon','Long','Share',100,3000);
insert into Futures values('Google','Long','Share',150,1400);
insert into Futures values('Walmart','Long','Share',200,150);
insert into Futures values('Amazon','Short','Share',100,3000);
insert into Futures values('Google','Short','Share',150,1400);
insert into Futures values('Walmart','Short','Share',200,150);

Insert into options values('Amazon','Long','Call','Bond',100,3000);
Insert into options values('Google','Long','Call','Bond',150,1400);
Insert into options values('Walmart','Long','Call','Bond',200,150);
Insert into options values('Amazon','Short','Call','Bond',100,3000);
Insert into options values('Google','Short','Call','Bond',150,1400);
Insert into options values('Walmart','Short','Call','Bond',200,150);
Insert into options values('Amazon','Long','Call','Share',100,3000);
Insert into options values('Google','Long','Call','Share',150,1400);
Insert into options values('Walmart','Long','Call','Share',200,150);
Insert into options values('Amazon','Short','Call','Share',100,3000);
Insert into options values('Google','Short','Call','Share',150,1400);
Insert into options values('Walmart','Short','Call','Share',200,150);
Insert into options values('Amazon','Long','Put','Bond',100,3000);
Insert into options values('Google','Long','Put','Bond',150,1400);
Insert into options values('Walmart','Long','Put','Bond',200,150);
Insert into options values('Amazon','Short','Put','Bond',100,3000);
Insert into options values('Google','Short','Put','Bond',150,1400);
Insert into options values('Walmart','Short','Put','Bond',200,150);
Insert into options values('Amazon','Long','Put','Share',100,3000);
Insert into options values('Google','Long','Put','Share',150,1400);
Insert into options values('Walmart','Long','Put','Share',200,150);
Insert into options values('Amazon','Short','Put','Share',100,3000);
Insert into options values('Google','Short','Put','Share',150,1400);
Insert into options values('Walmart','Short','Put','Share',200,150);

Insert into user values(1,'admin','admin');
Insert into user values(2,'Tanisha','12345678');
Insert into user values(3,'Sanket','12345678');