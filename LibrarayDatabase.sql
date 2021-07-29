create database LibraryManagmentSystem

use LibraryManagmentSystem



create table admininfo
(

 username varchar(20) not null,
 adminpassword varchar(20),
  primary key(username)
)
create table Member
(
memberid int IDEntity(1,1) not null,
email varchar(20),
memberpassword varchar(20),
Firstname varchar(20),
Lastname varchar(20),
Dob Date,
gender varchar(6),
username varchar(20) Unique,
NoofBooksIssued int,
NoofBooksReserved int
primary key(memberid)
)
create table Penalty
(
penaltyprice int,
username varchar(20),
primary key(username),
Foreign key (username) References Member(username) on Update cascade on Delete cascade
)
create table History
(
Bookid int not null,
username varchar(20),
primary key(Bookid,username),
Foreign key (Bookid) References Bookinfo(Bookid) on Update cascade on Delete cascade,
Foreign key (username) References Member(username) on Update cascade on Delete cascade
)


create table bookinfo
(
Genre varchar(10),
Bookid int not null,
Bookname varchar(20),
BookDescription varchar(100),
CurrentStock int,
Bookimagelink varchar(100),
Authorname varchar(20),
Publishername varchar(20),
Primary key(Bookid),
)
create table Bookissue
(
username varchar(20) not null,
Issuedate varchar(50),
Bookid int not null,
duedate varchar(50),
primary key(username,Bookid),
Foreign key (username) References Member(username) on Update cascade on Delete cascade,
Foreign key (Bookid) References Bookinfo(Bookid) on Update cascade on Delete cascade
)
create table Favourites
(
username varchar(20) not null,
Bookid  int not null,
primary key(username,Bookid),
Foreign key (username) References Member(username) on Update cascade on Delete cascade,
Foreign key (Bookid) References Bookinfo(Bookid) on Update cascade on Delete cascade
)
create table Bookreservation
(
 Bookid int  not null,
 username varchar(20) not null,
 Reservationdate varchar(50),
 DueDate varchar(50),
 primary key(username,Bookid),
 Foreign key (username) References Member(username) on Update cascade on Delete cascade,
 Foreign key (Bookid) References Bookinfo(Bookid) on Update cascade on Delete cascade
 )


select * from admininfo
Select * from Member
Select * from Bookissue
Select * from bookinfo
Select * from History
Select * from Favourites
Select * from Penalty
Select * from Bookreservation

insert into bookinfo(Genre,Bookid,Bookname,BookDescription,CurrentStock,Bookimagelink,Authorname,Publishername)
values('Fantasy',1,'The Hobbit','Nice Book',10,'src\Images\1.jpg','Auditore','C2C'),
('Action',2,'War','Nice Book',12,'src\Images\2.jpg','meditore','Bones'),
('Adventure',3,'Mobi','Nice Book',11,'src\Images\3.jpg','laditore','Aniplex'),
('Action',4,'George 1984','Nice Book',14,'src\Images\4.jpg','Vaditore','Mappa'),
('Horror',5,'Dracula','Nice Book',17,'src\Images\5.jpg','Ichigo','Wit'),
('Drama',6,'The Hunger Games','Nice Book',5,'src\Images\6.jpg','Kurosaki','Mad House'),
('Fiction',7,'Narnia','Nice Book',13,'src\Images\7.jpg','Rias','Kyoto Animation'),
('Comedy',8,'Diary of a Wimpy Kid','Nice Book',8,'src\Images\8.jpg','Gremory','Flourite'),
('Fiction',9,'OOAD','Nice Book',7,'src\Images\9.jpg','lelouch','ViVi')



create procedure signup
@mempass varchar(20),
@memdob varchar(20),
@mememail varchar(20),
@memfname varchar(20),
@memlname varchar(20),
@memusername varchar(20),
@memgender varchar(6)
As
Begin
Insert into Member (username,memberpassword,email,Firstname,Lastname,Dob,gender,Noofbooksissued,NoofBooksReserved)
values(@memusername,@mempass,@mememail,@memfname,@memlname,@memdob,@memgender,0,0)
End


create procedure signin
@usrname Varchar(20),
@passw varchar(20),
@flag int output
As
Begin
if Exists(Select Member.username from Member where Member.username=@usrname and Member.memberpassword=@passw)
begin
set @flag=1
end
else
begin
 set @flag=0
end
End

create procedure adminsignin
@usrname Varchar(20),
@passw varchar(20),
@flag int output
As
Begin
if Exists(Select admininfo.username from admininfo where admininfo.username=@usrname and admininfo.adminpassword=@passw)
begin
set @flag=1
end
else
begin
 set @flag=0
end
End









