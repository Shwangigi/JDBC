select * from MEMBER;
select* from SHOP;
select* from review;
select * from book;
select * from cut;
select * from timetable;

SELECT * FROM all_sequences where sequence_owner='ANN';

-- 리뷰 더미데이터
insert into review(rno ,rwriter, rcontents,rdesignernum ) values(rno_seq.nextval, '양승환', '최고의 실력 여기로 오새요', 10);
insert into review(rno ,rwriter, rcontents,rdesignernum ) values(rno_seq.nextval, '안희준', '섹시 헤어 최고의나로 만들어줬어요', 10);
insert into review(rno ,rwriter, rcontents,rdesignernum ) values(rno_seq.nextval, '조건재', '최고의 섹시미남이 되었어요', 10);
insert into review(rno ,rwriter, rcontents,rdesignernum ) values(rno_seq.nextval, '김기원', '투블럭 장인이시네요', 10);
insert into review(rno ,rwriter, rcontents,rdesignernum ) values(rno_seq.nextval, '용상엽', '빠글빠글 뒷머리 다운펌도 했는데 최고네요', 10);

--샵 더미데이터
insert into SHOP(sname,slocation,sno,sdesigner,sopen ,sclose)
values('차홍 아르더','서울특별시 강남구 언주로152길 10' ,sno_seq.nextval, '디자이너', '10:00','19:00');

-- 북(예약) 더미데이터
insert into BOOK(bno,bsname, bdate,btime,bdesignernum,bcut,bname, busernum )
values (book_seq.nextval,'차홍 아르더', '2024/07/20','10:30',10,'디자인 커트','test1',12 );

-- 컷 더미데터
insert into cut(csname,csno,ccode,ccutname,cprice,ccontents )
values ('차홍 아르더', 3, 1, '앞머리커트', 30000,  '퍼스널하고 심미적인 앞머리 커트' );
insert into cut(csname,csno,ccode,ccutname,cprice,ccontents )
values ('차홍 아르더', 3, 2, '커트', 66000,  '퍼스널하고 심미적인 커트' );
insert into cut(csname,csno,ccode,ccutname,cprice,ccontents )
values ('차홍 아르더', 3, 3, '디자인커트', 77000,  '예술적 영감으로 퍼스널하고 심미적인 커트' );

ALTER TABLE timetable ADD( status VARCHAR(20) DEFAULT '예약 가능');

