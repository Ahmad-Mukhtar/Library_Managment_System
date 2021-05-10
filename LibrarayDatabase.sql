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
ActualStock int,
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
Select *from Bookissue
Select * from bookinfo
Select * from History
Select * from Favourites
Select * from Penalty
Select * from Bookreservation

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