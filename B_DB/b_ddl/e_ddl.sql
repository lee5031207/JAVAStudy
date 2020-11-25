-- CREATE TABLE 테이블명 (컬럼명  타입  제약조건 ...);

CREATE TABLE MY_EMPLOYEE(
    -- 제약조건 없이 컬럼을 추가
    PHONE VARCHAR2(13),
    
    --DEFAULT : 기본 값 지정, 데이터가 테이블에 입력될 때 해당 컬럼에 넣을 값이 없다면
    --               기본 값으로 지정한 값이 입력
    HIRE_DATE DATE DEFAULT SYSDATE,
    
    --고유무결성(UNIQUE) : 테이블의 특정 컬럼 값에 대해서 각 ROW가 
    --                               가지는 값들이 서로 달라야 한다는 규정
    ENO CHAR(14) UNIQUE,
    
    --NULL 무결성(NOT NULL) : 테이블의 특정 컬럼 값이 NULL 이 될 수 없도록 하는 규정
    ENAME VARCHAR2(20) NOT NULL,
    
    
    --DOMAIN무결성(CHECK) : 특정 컬럼값이 그 컬럼에 정의된 
    --                                   도메인(영역)에 속한 값이어야 한다는 규정
    MARRIAGE CHAR(1) DEFAULT 'N' CHECK(MARRIAGE IN('Y','N')),
    AGE NUMBER CHECK(AGE>20),
    
    --기본키(PRIMARY KEY) 지정
    --기본키는 테이블의 각 행을 고유하게 식별하는 역할을 담당한다.
    --테이블 당 하나만 정의 가능
    --기본키는 후보키중 테이블을 대표하는 키이다. 
    --따라서 후보키의 여건인 최소성과 유일성을 만족해야 한다.
    --기본키를 제외한 후보키들을 대체키라고 이야기한다.
    --기본키를 지정하면 고유 인덱스가 자동으로 생성이 된다.
    --인덱스 : 데이터베이스에서 검색 연산을 최적화 하기 위해 사용하는 컬럼 정보로 구성된 데이터 구조
    -- 인덱스를 사용하면 원하는 정보를 빠르게 검색할 수 있다.
    EID CHAR(10) PRIMARY KEY
    
    
    --제약조건 걸어주기
    -- CONSTRAINT 제약 조건명 제약조건 종류(컬럼명)
    
    
    --참조 뮤결성 : 기본키와 참조키 간의 관계가 항상 유지
    --부모 테이블은 자신을 참조 하고 있는 자식 테이블이 삭제되지 않는 한, 삭제 될 수 없다
    --자식 테이블은 부모테이블의 컬럼에 존재하지 않는 값을 컬럼 값으로 넣을 수 없다.
    --CONSTRAINT 제약조건명 FOREIGN KEY(컬럼명) REFERENCES 부모테이블명(컬럼명)
    --ON UPDATE CASCADE : 부모테이블의 컬럼이 수정되면 자식 테이블도 같이 수정
    --ON DELETE CASCADE : 부모테이블의 ROW가 삭제되면 자식테이블의 행도 같이 삭제
    --ON DELETE SET NULL : 부모테이블의 ROW가 삭제되면 자식테이블의 컬럼 값을 NULL로 변경
);  

--1. AGE에 20보다 작은 값을 넣고 MARRIAGE에 Z를 넣어 
--   도메인 무결성을 어겨보자!
INSERT INTO MY_EMPLOYEE (ENAME, AGE, MARRIAGE, EID) VALUES ('이성욱',19,'Z','AAA');

--2. NOT NULL이 지정된 컬럼에 NULL을 넣어 NULL무결성을 어겨보자
--INSERT 문에서 값을 지정하지 않은 컬럼은 자동으로 NULL이 들어가게 된다
--INSERT INTO MY_EMPLOYEE (AGE, MARRIAGE) VALUES (19,'Z');

--3. PRIMARY KEY로 지정된 E_ID에 NULL값을 넣어서 기본키의 최소성을 확인하고
--   중복된 값도 넣어서 기본키의 유일성을 확인
INSERT INTO MY_EMPLOYEE (ENAME, AGE, MARRIAGE, EID) VALUES ('이성욱',21,'N','AAA');

--4. HIRE_DATE에 NULL을 넣어서 DEFAULT로 지정한 값이 잘 입력되는지 확인

--SELECT문을 활용해서 테이블 복제
--CREATE TABLE COPY_EMPLOYEE
--AS SELECT * FROM EMPLOYEE;
--SELECT * FROM COPY_EMPLOYEE;
--DROP TABLE COPY_EMPLOYEE;

--테이블 컬럼만 복제해오기, 데이터 (X)
--CREATE TABLE COPY_EMPLOYEE
--AS SELECT * FROM EMPLOYEE WHERE 1=0;
--SELECT * FROM COPY_EMPLOYEE;
--DROP TABLE COPY_EMPLOYEE;


-----------------------------------------------------------------------------------------------------
--테이블 수정
--1. 컬럼
-- ALTER TABLE 테이블명 ADD|MODIFY|DROP (컬럼명 타입 DEFAULT 제약조건)

-- 1-1. 컬럼 추가(ADD)
ALTER TABLE MY_EMPLOYEE ADD(JOB_CODE CHAR(2));
SELECT * FROM MY_EMPLOYEE;
-- 1-2. 컬럼 수정(MODIFY)
-- 컬럼의 타입은 변경 불가, 단 테이블에  데이터가 하나도 없으면 타입변경 가능
-- 컬럼의 크기는 지금보다 큰 크기로만 변경 가능
-- NOT NULL 제약조건을 지정할 수 있다. 단 이미 NULL인 행이 존재하면 변경 불가
-- UNIQUE 제약조건을 지정할 수 있다. 단, 이미 중복된 데이터가 있으면 변경 불가
ALTER TABLE MY_EMPLOYEE MODIFY(JOB_CODE CHAR(10));
ALTER TABLE MY_EMPLOYEE MODIFY(JOB_CODE NOT NULL);
INSERT INTO MY_EMPLOYEE (ENAME, AGE, MARRIAGE, EID, JOB_CODE) VALUES ('사보현',21,'N','BBB','J7');
INSERT INTO MY_EMPLOYEE (ENAME, AGE, MARRIAGE, EID, JOB_CODE) VALUES ('사보현',21,'N','CCC','J7');
ALTER TABLE MY_EMPLOYEE MODIFY(JOB_CODE UNIQUE);
-- 1-3. 컬럼 삭제(DROP)
ALTER TABLE MY_EMPLOYEE DROP COLUMN JOB_CODE;


-- 기본키 추가하기, 기본키 삭제하기
ALTER TABLE MY_EMPLOYEE ADD PRIMARY KEY(ENAME);

--기존 기본키 삭제
ALTER TABLE MY_EMPLOYEE DROP PRIMARY KEY;

--제약조건 추가하기, 제약조건 삭제하기
--MY_EMPLOYEE 테이블의 ENO컬럼에 NOT NULL 제약조건 추가
--ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약 조건 종류 (컬럼명)
ALTER TABLE MY_EMPLOYEE ADD CONSTRAINT ENO_NULL CHECK (ENO IS NOT NULL);
SELECT * FROM MY EMPLOYEE;

--제약조건 삭제하기
--ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명

--테이블 삭제
--DROP TABLE 테이블명
DROP TABLE MY_EMPLOYEE;
--DROP TABLE 테이블명 CASCADE CONSTRAINT;
--테이블과 참조관계인 테이블의 참조 제약조건도 함께 삭제

--외래키 추가
--ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 FOREIGN KEY(컬럼명) REFERNCES 부모테이블명(컬럼명)
ALTER TABLE TB_BOARD ADD CONSTRAINT FK_BOARD_MEMBER
FOREIGN KEY(USER_ID) REFERENCES TB_MEMBER(USER_ID);
--외래키 삭제
--ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;
ALTER TABLE TB_BOARD DROP CONSTRAINT FK_BOARD_MEMBER;


--[참고]
-- DATA DICTIONARY : 데이터 사전
--읽기 전용으로 제공되는 테이블 또는 VIEW의 집합, 데이터베이스 전반에 대한 정보를 제공
--사용자 정보, 권한 정보, 제약 조건, 객체정보 등등
-- 제약조건에 대한 정보를 담고 있는 DICTIONARY 조회
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TB_BOARD';

