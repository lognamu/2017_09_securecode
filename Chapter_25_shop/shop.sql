use web_programing;

create table product(
	idx int(10) primary key auto_increment,
    category varchar(100) not null,
    model varchar(100) unique key,
    manufacturer varchar(100) not null,
    price_ori int(10) not null,
    price_sale int(10) not null,
    sale_rate int(10) not null,
    image_s varchar(100) not null,
    image_l varchar(100) not null,
    content text not null,
    regdate date not null
);

select * from product;

create table cart(
	idx int(10) primary key auto_increment,
    p_idx int(10),
    u_idx int(10),
    count int(10),
    foreign key(p_idx) references product(idx)
);

select * from cart;
