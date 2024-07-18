drop table board;

create table board(
bno number(5) primary key,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date not null
);

drop sequence board_seq;

create sequence board_seq
   increment by 1
   start with 1
   nocycle
   nocache;
   
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '비오내요~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '안녕하세요~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '감사합니다.~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '수고하셨내요~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '화이팅하세요~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '방갑습니다.~', '비오는데 등교하시는냐고 고생 하셨습니다.', '김기원', sysdate);


select * from board;

-- memeber 테이블 용

drop table member; -- 테이블명에 TBL 쓰면좋다고 함

create table member(
   mno number(5) primary key,
   mid varchar2(10) not null,
   mpw varchar2(10)not null,
   mdate date not null
);

-- 더미데이터
insert into member(mno, mid,mpw,mdate) values(board_seq.nextval, '김기원','1234',sysdate);
insert into member(mno, mid,mpw,mdate) values(board_seq.nextval, '용상엽','1234',sysdate);
insert into member(mno, mid,mpw,mdate) values(board_seq.nextval, '조건재','1234',sysdate);
insert into member(mno, mid,mpw,mdate) values(board_seq.nextval, '양승환','1234',sysdate);
insert into member(mno, mid,mpw,mdate) values(board_seq.nextval, '안희준','1234',sysdate);

select * from member;