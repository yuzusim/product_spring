-- 관리자 모드
insert into user_tb(username, admin_name, password, email, role, created_at)
values('최고 관리자', 'admin','1234','admin@nate.com', 1, now());

-- 개인 회원가입
insert into user_tb(username, password, phone, email, address, role, created_at)
values('심유주','1234', '010-111-1111', 'ssar@nate.com', '부산광역시', 2, now());

-- 판매자 상품 테이블
insert into product_tb(name, price, qty, created_at)
values ('바나나', 5000, 98, now());
insert into product_tb(name, price, qty, created_at)
values ('딸기', 10000, 99, now());
insert into product_tb(name, price, qty, created_at)
values ('수박', 10000, 100, now());