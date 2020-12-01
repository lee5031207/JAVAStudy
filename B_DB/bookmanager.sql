SELECT * FROM USER_SOURCE;  
DROP PROCEDURE SP_RENT_INSERT;
DROP PROCEDURE SP_RENT_RETURN;
DROP PROCEDURE SP_RENT_EXTEND;

DROP SEQUENCE SC_B_IDX;
DROP SEQUENCE SC_RM_IDX;
DROP SEQUENCE SC_RB_IDX;
DROP SEQUENCE SC_RH_IDX;
DROP SEQUENCE SC_BOARD_IDX;
DROP SEQUENCE SC_FILE_IDX;
DROP SEQUENCE SC_BC_IDX;
DROP SEQUENCE SC_BRES_IDX;


CREATE SEQUENCE SC_B_IDX
START WITH 10000;

CREATE SEQUENCE SC_RM_IDX
START WITH 10000;

CREATE SEQUENCE SC_RB_IDX
START WITH 10000;

CREATE SEQUENCE SC_RH_IDX
START WITH 10000;

CREATE SEQUENCE SC_BOARD_IDX
START WITH 10000;

CREATE SEQUENCE SC_FILE_IDX
START WITH 10000;

CREATE SEQUENCE SC_BC_IDX
START WITH 10000;

CREATE SEQUENCE SC_BRES_IDX
START WITH 10000;

INSERT INTO TB_MEMBER (USER_ID, PASSWORD, EMAIL, TELL)
VALUES ('PCLASS', '123ABC!@3', 'AAA@AAA.COM', '010-0000-0000');

INSERT INTO TB_BOOK (B_IDX, TITLE, AUTHOR, CATEGORY) 
VALUES (SC_B_IDX.NEXTVAL, '비행운', '김애한' ,'문학');

INSERT INTO TB_BOOK (B_IDX, TITLE, AUTHOR, CATEGORY) 
VALUES (SC_B_IDX.NEXTVAL, '남한산성', '김훈' ,'문학');

INSERT INTO TB_BOOK (B_IDX, TITLE, AUTHOR, CATEGORY) 
VALUES (SC_B_IDX.NEXTVAL, '사랑의 기술', '에리히 프롬' ,'사회과학');

INSERT INTO TB_RENT_MASTER (RM_IDX, USER_ID, TITLE, RENT_BOOK_CNT)
VALUES (SC_RM_IDX.NEXTVAL, 'PCLASS', '비행운 외 0권', 1);

SELECT * FROM TB_BOOK;
--------------------------------------------------------------------------------

 --대출 프로시저 생성 ( SP_RENT_INSERT )
 --대출할 도서의 도서번호와 대출번호를 매개변수로 받아 대출 처리를 하는 프로시저를 생성하세요
 
 --1.회원 테이블의 대출 가능일자를 오늘로 수정하세요
 --2.TB_RENT_BOOK 테이블에 대출한 도서의 정보가 입력 되어야 합니다.
 --3.TB_RENT_HISTORY 테이블에 대출한 도서의 정보가 기록 되어야 합니다.
 --4.대출이 완료되면 도서 테이블에서 해당 도서의 수량이 1 감소해야합니다.
 --5.대출이 완료되면 도서 테이블에서 해당 도서의 대출 횟수가 1 증가 해야 합니다.
 --6. 대출이 완료되면 대출 히스토리 테이블에 '대출'내역이 기록 되어야 합니다.
 
 CREATE OR REPLACE PROCEDURE 
 SP_RENT_INSERT (V_B_IDX TB_BOOK.B_IDX%TYPE, V_RM_IDX  TB_RENT_MASTER.RM_IDX%TYPE)
 IS
    V_USER_ID TB_RENT_MASTER.USER_ID%TYPE;
    V_RB_IDX TB_RENT_BOOK.RB_IDX%TYPE;
 BEGIN
     --1.회원 테이블의 대출 가능일자를 오늘로 수정하세요
     SELECT USER_ID INTO V_USER_ID FROM TB_RENT_MASTER WHERE RM_IDX = V_RM_IDX; --RENT_MASTER 테이블의 
     UPDATE TB_MEMBER SET RENTABLE_DATE = SYSDATE WHERE USER_ID = V_USER_ID;
     
    --2.TB_RENT_BOOK 테이블에 대출한 도서의 정보가 입력 되어야 합니다.
    SELECT SC_RB_IDX.NEXTVAL INTO V_RB_IDX FROM DUAL;
    INSERT INTO TB_RENT_BOOK (RB_IDX, RM_IDX, B_IDX)
    VALUES (V_RB_IDX, V_RM_IDX, V_B_IDX);
    
    --3.TB_RENT_HISTORY 테이블에 대출한 도서의 정보가 기록 되어야 합니다.
    INSERT INTO TB_RENT_HISTORY(RH_IDX, RM_IDX, RB_IDX, B_IDX, REG_DATE, STATE)
    VALUES(SC_RH_IDX.NEXTVAL, V_RM_IDX, V_RB_IDX, V_B_IDX, SYSDATE, 'RE00');

    --4.대출이 완료되면 도서 테이블에서 해당 도서의 수량이 1 감소해야합니다.
    UPDATE TB_BOOK SET BOOK_AMT = BOOK_AMT-1 WHERE B_IDX = V_B_IDX;
    --5.대출이 완료되면 도서 테이블에서 해당 도서의 대출 횟수가 1 증가 해야 합니다.
    UPDATE TB_BOOK SET RENT_CNT = RENT_CNT+1 WHERE B_IDX = V_B_IDX;
END;
/

--SELECT * FROM USER_SOURCE;
--DROP SEQUENCE SP_RENT_INSERT;

------------------------------------------------------------------------------

 --반납 프로시저 생성 (SP_RENT_RETURN)
 --대출번호, 대출도서번호, 회원아이디를 매개변수로 받아 반납처리를 진행하는 프로시저를 생성하세요
 --1. 반납이 진행되면 도서 테이블에서 해당 도서의 수량이 1 증가해야 합니다.
 --2. 만약 반납일자 이후에 반납을 해 연체 처리가 된다면 연체한 일자의 4배 만큼의 기간동안 대출이 불가능합니다.
   -- 회원테이블의 대출 가능일자에 반납한 일자 * 4만큼의 일자를 더해줘야 합니다.
--3. 반납이 진행되면 대출도서테이블의 대출 상태는 반납으로, 반납일은 오늘로 업데이트 되어야 합니다.
--4. 반납된 도서가 속한 대출건에 더 이상 반납할 도서가 없다면 TB_RENT_MASTER 테이블의 IS_RETURN 값을 TRUE로 지정해 완납된 대출건으로 UPDATE 해줘야 합니다.
--5. 반납이 진행되었다면 대출 히스토리 테이블에 '반납' 내역이 기록되어야 합니다

CREATE OR REPLACE PROCEDURE 
SP_RENT_RETURN (V_RM_IDX TB_RENT_MASTER.RM_IDX%TYPE, V_RB_IDX  TB_RENT_BOOK.RB_IDX%TYPE, V_USER_ID TB_MEMBER.USER_ID%TYPE)
-- 매개변수 : 대출번호, 대출도서번호, 회원아이디
IS
    V_B_IDX TB_BOOK.B_IDX%TYPE;  --도서번호 변수
    V_RETURN_DATE TB_RENT_BOOK.RETURN_DATE%TYPE; --반납일자 변수
    V_LATE_DATE NUMBER; --연체일 변수
    V_RENT_BOOK_CNT NUMBER; --빌린 책 개수 변수
BEGIN

    SELECT B_IDX INTO V_B_IDX FROM TB_RENT_BOOK WHERE RB_IDX = V_RB_IDX; --도서번호 변수 INTO해줌
    SELECT RETURN_DATE INTO V_RETURN_DATE  FROM TB_RENT_BOOK WHERE RB_IDX = V_RB_IDX; -- 반납일자 변수 INTO 해줌
    V_LATE_DATE := SYSDATE - V_RETURN_DATE; --연체일 변수 값 초기화
    SELECT RENT_BOOK_CNT INTO V_RENT_BOOK_CNT FROM TB_RENT_MASTER WHERE RM_IDX = V_RM_IDX;  --그 대출건의 빌린책 개수
    
    --1. 반납이 진행되면 도서 테이블에서 해당 도서의 수량이 1 증가해야 합니다.
    UPDATE TB_BOOK SET BOOK_AMT = BOOK_AMT+1 WHERE B_IDX = V_B_IDX;
    --2. 만약 반납일자(RETURN_DATE) 이후에 반납을 해 연체 처리가 된다면 연체한 일자의 4배 만큼의 기간동안 대출이 불가능합니다.
   -- 회원테이블의 대출 가능일자(RENTABLE_DATE)에 반납한 일자 * 4만큼의 일자를 더해줘야 합니다.
   IF TRUNC(V_RETURN_DATE) < TRUNC(SYSDATE) 
   THEN 
        --연체임
        UPDATE TB_MEMBER SET RENTABLE_DATE  = SYSDATE+(V_LATE_DATE*4) WHERE USER_ID = V_USER_ID;
   END IF;
   --3. 반납이 진행되면 대출도서테이블의 대출 상태는 반납으로, 반납일은 오늘로 업데이트 되어야 합니다.
   UPDATE TB_RENT_BOOK SET STATE = 'RE03' WHERE RM_IDX = V_RM_IDX;
   UPDATE TB_RENT_BOOK SET RETURN_DATE = SYSDATE WHERE RM_IDX = V_RM_IDX;
   --4. 반납된 도서가 속한 대출건에 더 이상 반납할 도서가 없다면 TB_RENT_MASTER 테이블의 
   --   IS_RETURN 값을 TRUE로 지정해 완납된 대출건으로 UPDATE 해줘야 합니다.
   IF V_RENT_BOOK_CNT = 1
   THEN 
        UPDATE TB_RENT_MASTER SET IS_RETURN = 1 WHERE RM_IDX = V_RM_IDX;
   END IF;
    --5. 반납이 진행되었다면 대출 히스토리 테이블에 '반납' 내역이 기록되어야 합니다   
    UPDATE TB_RENT_HISTORY SET STATE = 'RE03' WHERE RM_IDX = V_RM_IDX;
END;
/

---------------------------------------------------------------------------------------------------------------    
--연장 프로시저 생성  (SP_RENT_EXTEND)
--대출번호, 대출도서번호를 매개변수로 받아 연장처리를 진행하는 프로시저를 생성하세요
--1. 연장 처리가 진행되면 반납일자가 7일 증가하게 됩니다.
--2. 연장 처리가 진행되면 연장횟수가 1 증가하게 됩니다.
--3. 연장 처리가 진행되면 대출도서의 상태가 '연장'으로 변경되게 됩니다.
--4. 연장 처리가 진행되면 대출 히스토리 테이블에 '연장' 내역이 기록되어야 합니다.

CREATE OR REPLACE PROCEDURE 
SP_RENT_EXTEND (V_RM_IDX TB_RENT_MASTER.RM_IDX%TYPE, V_RB_IDX TB_RENT_BOOK.RB_IDX%TYPE)
IS

BEGIN
    --1. 연장 처리가 진행되면 반납일자가 7일 증가하게 됩니다.
    UPDATE TB_RENT_BOOK SET RETURN_DATE  = RETURN_DATE+7 WHERE RB_IDX = V_RB_IDX;
    --2. 연장 처리가 진행되면 연장횟수가 1 증가하게 됩니다.
    UPDATE TB_RENT_BOOK SET EXTENTION_CNT = EXTENTION_CNT+1 WHERE RB_IDX = V_RB_IDX;
    --3. 연장 처리가 진행되면 대출도서의 상태가 '연장'으로 변경되게 됩니다.
    UPDATE TB_RENT_BOOK SET STATE = 'RE01' WHERE RB_IDX = V_RB_IDX;
    --4. 연장 처리가 진행되면 대출 히스토리 테이블에 '연장' 내역이 기록되어야 합니다.
    UPDATE TB_RENT_HISTORY SET STATE = 'RE01' WHERE RB_IDX = V_RB_IDX;
END;
/
    
    
    


    
    





     
    
    

    

    
    
    
 


