use web_programing;

create table bbs(
	idx int primary key auto_increment,
    name varchar(50) not null,
    title varchar(100) not null,
    content text not null,
    ip varchar(50) not null,
    regdate date,
    hit int(10),
    ref int(10),
    step int(10),
    depth int(10)
);

select * from bbs;

create table comment(
	idx int primary key auto_increment,
    b_idx int,
    name varchar(50) not null,
    content text not null,
    regdate date,
    constraint fk_idx foreign key(b_idx) references bbs(idx) on delete cascade
);
