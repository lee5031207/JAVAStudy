--DCL
--권한관리 
-- *** 관리자 계정 : 데이터베이스의 생성과 관리를  담당하는 슈퍼 유저
--                        데이터베이스에 대한 모든 권한과 책임을 가지고 있다. (DBA)
-- *** 사용자 계정  : 데이터베이스에서 본인이 맡은 작업을 수행하는 계정
--                         시스템 계정은 보안을 위해 업무에 필요한 최소한의 권한만을 가진다

-- 1. 계정생성
-- CREATE USER 아이디 IDENTIFIED BY PASSWORD;
CREATE USER bookmanager IDENTIFIED BY user11;


--2. 권한부여
-- BM계정에게 CREATE SESSION권한을 부여하자!
-- GRANT 권한 이름, 권한 이름 ... TO 사용자ID
GRANT CREATE SESSION TO bookmanager;

--3. 권한회수
-- REVOKE  권한 이흠,  권한 이름... FROM 사용자ID
REVOKE CREATE SESSION FROM bookmanager;

--4. ROLE : 다양한 권한을 하나의 이름으로 묶어놓는 것
-- RESOURCE, CONNECT
-- RESOURCE : 사용자가 객체를 생성할 수 있도록 객체생성과 관련된 권한들의 묶음
--                  CREATE TABLE, CREATE VIEW, CREATE SEQUENCE, CREATE TRIGGER
-- CONNECT : 사용자의 접근과 관련된 권한들의 묶음
--                  CREATE SESSION


--BM계정에 ROLE을 활용해 권한을 부여
GRANT CONNECT, RESOURCE TO bookmanager;


--ROLE을 생성
--표현 방식
--CREATE ROLE ROLE이름;
--GRANT 권한이름, 권한이름 .. TO ROLE이름

CREATE ROLE BOOKMANAGER_ROLE;

GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW, CREATE SEQUENCE
TO BOOKMANAGER_ROLE;


