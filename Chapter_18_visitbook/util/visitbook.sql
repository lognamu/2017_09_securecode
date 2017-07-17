use web_programing;

create table visit(
	idx int(5) primary key auto_increment,
    name varchar(20),
    content text,
    ip varchar(20),
    pwd varchar(100),
    regdate date
);

select * from visit;
delete from visit where idx = 2;
insert into visit(name, content, ip, pwd, regdate)
values('홍길동', '내가 일빠다!! 신난다!!', '192.168.0.100', '1234', curdate());

insert into visit(name, content, ip, pwd, regdate)
values('장동혁', '윗사람 유치하군ㅋㅋㅋ', '192.168.0.100', '1234', curdate());