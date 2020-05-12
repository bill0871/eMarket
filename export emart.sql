-- we don't know how to generate root <with-no-name> (class Root) :(
create table buyer
(
	id int(4) auto_increment
		primary key,
	username varchar(32) not null,
	password varchar(32) not null,
	email varchar(128) null,
	mobile varchar(16) null,
	create_time datetime null
);

create table category
(
	id int(2) auto_increment
		primary key,
	name varchar(32) default '' not null,
	brief_details varchar(256) null
);

create table discount
(
	id int(2) auto_increment
		primary key,
	code char(4) null comment '4-alphabetic code',
	percentage decimal(8,2) null,
	start_date datetime not null,
	end_date datetime not null,
	description varchar(256) null,
	create_date datetime null
);

create table item
(
	id int(2) auto_increment
		primary key,
	category_id int(2) not null,
	subcategory_id int(2) not null,
	price decimal(8,2) not null,
	name varchar(128) not null,
	description varchar(256) null,
	stock_number int(2) not null,
	remarks varchar(256) null
);

create table `order`
(
	id int(2) auto_increment
		primary key,
	buyer_id int(2) not null,
	seller_id int(2) not null,
	transaction_id int(2) not null,
	item_id int(2) not null comment 'one item_id to one order_id',
	number_of_items int(2) not null,
	remarks varchar(256) null,
	create_date datetime null
);

create table seller
(
	id int(4) auto_increment
		primary key,
	username varchar(32) not null,
	password varchar(32) not null,
	company_name varchar(64) null,
	GSTIN varchar(16) null,
	brief_company varchar(64) null,
	postal_address varchar(64) null,
	website varchar(128) null,
	email varchar(128) null,
	create_time datetime null
);

create table subcategory
(
	id int(2) auto_increment
		primary key,
	name varchar(32) default '' not null,
	category_id int(2) not null,
	brief_details varchar(256) null,
	GST decimal(8,2) null,
	constraint subcategory_ibfk_1
		foreign key (category_id) references category (id)
)
comment 'foreign key of category';

create index category_id
	on subcategory (category_id);

create table transaction
(
	id int(2) auto_increment
		primary key,
	buyer_id int(2) not null,
	seller_id int(2) not null,
	transaction_type enum('debit', 'credit') null,
	remarks varchar(256) null,
	create_date datetime null
);

