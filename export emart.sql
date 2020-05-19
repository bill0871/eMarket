-- we don't know how to generate root <with-no-name> (class Root) :(
create table buyer
(
    id int auto_increment
        primary key,
    create_time datetime(6) null,
    email varchar(255) null,
    mobile varchar(255) null,
    password varchar(255) null,
    username varchar(255) null,
    constraint UK_df2jf9246bkb964rg04cmucc2
        unique (username)
);

create table category
(
    id int auto_increment
        primary key,
    brief_details varchar(255) null,
    name varchar(255) null
);

create table discount
(
    id int(11) auto_increment
        primary key,
    code char(4) null comment '4-alphabetic code',
    create_date datetime(6) null,
    description varchar(255) null,
    end_date datetime(6) null,
    percentage decimal(8,2) null,
    start_date datetime(6) null
);

create table item
(
    id int auto_increment
        primary key,
    category_id int null,
    description varchar(255) null,
    name varchar(255) null,
    price decimal(8,2) null,
    remarks varchar(255) null,
    stock_number int null,
    subcategory_id int null
);

create table cart_item
(
    id int auto_increment
        primary key,
    quantity int not null,
    item_id int not null,
    user_id int not null,
    constraint UK_l5j5nns4rldk9e37ns442xqhx
        unique (item_id),
    constraint FKdljf497fwm1f8eb1h8t6n50u9
        foreign key (item_id) references item (id),
    constraint user_id
        foreign key (user_id) references buyer (id)
);

create table purchase_history
(
    id int auto_increment
        primary key,
    buyer_id int null,
    create_date datetime(6) null,
    item_id int null,
    number_of_items int null,
    remarks varchar(255) null,
    seller_id int null,
    transaction_id int null
);

create table seller
(
    id int auto_increment
        primary key,
    brief_company varchar(255) null,
    company_name varchar(255) null,
    create_time datetime(6) null,
    email varchar(255) null,
    gstin varchar(255) null,
    password varchar(255) null,
    postal_address varchar(255) null,
    username varchar(255) null,
    website varchar(255) null,
    constraint UK_3gnjncn8l4no25wl7pyjqrx3p
        unique (username)
);

create table subcategory
(
    id int auto_increment
        primary key,
    brief_details varchar(255) null,
    gst double null,
    name varchar(255) null,
    category_id int null,
    constraint FKe4hdbsmrx9bs9gpj1fh4mg0ku
        foreign key (category_id) references category (id)
);

create table transaction
(
    id int auto_increment
        primary key,
    buyer_id int null,
    create_date datetime(6) null,
    remarks varchar(255) null,
    seller_id int null,
    transaction_type int null
);

