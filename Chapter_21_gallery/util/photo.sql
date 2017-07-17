create table photo(
	idx int(5) primary key auto_increment,
    title varchar(100),
    filename varchar(200),
    pwd varchar(20),
    ip varchar(20)
);
select * from photo;