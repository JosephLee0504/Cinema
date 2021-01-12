/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  zhch
 * Created: 2021年1月10日
 */


create table accounts (id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
    username varchar(20),
    password varchar(20),
    balance double
);
insert into accounts (username, password,balance)values('a','a',10000);

create table cinemas(id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
    name varchar(30),
    address varchar(90)
);
insert into cinemas(name, address) values('Good Cinema','bell street no 3');
insert into cinemas(name, address) values('Cala Cinema','bell street no 4');
insert into cinemas(name, address) values('Hollywood Cinema','newyork street no 4');

create table movies(id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
    name varchar(30),
    mtype varchar(30),
    mtime int,
    mdesc varchar(300),
    image varchar(300),
    publishtime varchar(30)
);
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie01','fight',120,'a good movie','movie01.jpg','2020-01-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie02','fight',120,'two good movie','movie02.jpg','2020-03-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie03','fight',120,'a very good movie','movie03.jpg','2020-04-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie04','fight',120,'a very good movie','movie04.jpg','2020-04-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie05','fight',120,'a very good movie','movie05.jpg','2020-04-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie06','fight',120,'a very good movie','movie06.jpg','2020-04-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie07','fight',120,'a very good movie','movie07.jpg','2020-04-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie08','fight',120,'a very good movie','movie08.jpg','2020-04-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie09','fight',120,'a very good movie','movie09.jpg','2020-04-12');
insert into movies (name, mtype, mtime, mdesc, image, publishtime)values('movie10','fight',120,'a very good movie','movie10.jpg','2020-04-12');

create table schedules(id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
    movieid int,
    cinemaid int,
    roomid int,
    price double,
    showtime varchar(19)
);
insert into schedules(movieid, cinemaid, roomid,price,showtime)values(1,1,1, 30.0,'2021-01-12 13:20'  );
insert into schedules(movieid, cinemaid, roomid,price,showtime)values(1,2,1, 30.0,'2021-02-03');
insert into schedules(movieid, cinemaid, roomid,price,showtime)values(1,3,1, 30.0,'2021-02-04');
insert into schedules(movieid, cinemaid, roomid,price,showtime)values(4,3,1, 30.0,'2021-02-04');
insert into schedules(movieid, cinemaid, roomid,price,showtime)values(4,3,1, 30.0,'2021-02-04');
insert into schedules(movieid, cinemaid, roomid,price,showtime)values(4,3,1, 30.0,'2021-02-04');

create table rooms(id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
    name varchar(30),
    cinemaid int,
    seatcount int
);
insert into rooms(name, cinemaid, seatcount)values('ScreeningRoom01',1,120);
insert into rooms(name, cinemaid, seatcount)values('ScreeningRoom02',1,120);
insert into rooms(name, cinemaid, seatcount)values('ScreeningRoom03',2,120);
insert into rooms(name, cinemaid, seatcount)values('ScreeningRoom04',3,120);

create table scores(id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
    movieid int,
    accountid int,
    score int
);
create table comments(id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
    movieid int,
    accountid int,
    comment varchar(300),
    publishtime varchar(19)
);
create table orders(id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
    scheduleid int,
    accountid int,
    seat int,
    status int
);

