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
NoofBooksIssued int
primary key(memberid)
)
create table Penalty
(
penaltyprice int,
memid int not null,
primary key(memid),
Foreign key (memid) References Member(memberid) on Update cascade on Delete cascade
)
create table History
(
Bookid int not null,
memberid int not null,
primary key(Bookid,memberid),
Foreign key (Bookid) References Bookinfo(Bookid) on Update cascade on Delete cascade,
Foreign key (memberid) References Member(memberid) on Update cascade on Delete cascade
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
Memberid int not null,
Issuedate date,
Bookid int not null,
duedate date,
primary key(Memberid,Bookid),
Foreign key (Memberid) References Member(memberid) on Update cascade on Delete cascade,
Foreign key (Bookid) References Bookinfo(Bookid) on Update cascade on Delete cascade
)
create table Favourites
(
Memberid  int not null,
Bookid  int not null,
primary key(Memberid,Bookid),
Foreign key (Memberid) References Member(memberid) on Update cascade on Delete cascade,
Foreign key (Bookid) References Bookinfo(Bookid) on Update cascade on Delete cascade
)
create table Bookreservation
(
 Bookid int  not null,
 Memberid  int not null,
 Reservationcount int,
 Reservationdate date,
 DueDate date,
 primary key(Memberid,Bookid),
 Foreign key (Memberid) References Member(memberid) on Update cascade on Delete cascade,
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

select * from bookinfo


Insert into bookinfo(bookid,Genre,Bookname,BookDescription,CurrentStock,Bookimagelink,Authorname,Publishername)
	values(1,'Fantasy','The Hobbit','Imaginery'	,9,'src/Images/1.jpg','Tolkien','George Allen'),
			(2,'Action','War and Peace','Find Peace in it.'	,3,'src/Images/2.jpg','Tolstoy','C2C'),
			(3,'Drama','Mobi','Unknown'	,4,'src/Images/3.jpg','Marley','NAZ'),
			(4,'Drama','George 1984 ','Very Nice Book'	,6,'src/Images/4.jpg','Hitler','VIZ'),
			(5,'Horror','Dracula','Origin of Dracula',7,'src/Images/5.jpg','baghoor','Funima'),
			(6,'Adventure','The Hunger Games','Deadly games',8,'src/Images/6.jpg','Smith','Aniplex'),
			(7,'Adventure','Narnia','A new World',2,'src/Images/7.jpg','Walker','Netflix'),
			(8,'Drama','Wimpy Kid','Hilarious'	,6,'src/Images/8.jpg','Jeff','Bones'),
			(9,'Fiction','Naruto','The story of a young ninja',5,'src/Images/9.jpg','Kishimoto','Damai')
	
	


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
Insert into Member (username,memberpassword,email,Firstname,Lastname,Dob,gender,Noofbooksissued)
values(@memusername,@mempass,@mememail,@memfname,@memlname,@memdob,@memgender,0)
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

insert into admininfo  values('admin','pass1')