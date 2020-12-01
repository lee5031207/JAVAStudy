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
VALUES (SC_B_IDX.NEXTVAL, '�����', '�����' ,'����');

INSERT INTO TB_BOOK (B_IDX, TITLE, AUTHOR, CATEGORY) 
VALUES (SC_B_IDX.NEXTVAL, '���ѻ꼺', '����' ,'����');

INSERT INTO TB_BOOK (B_IDX, TITLE, AUTHOR, CATEGORY) 
VALUES (SC_B_IDX.NEXTVAL, '����� ���', '������ ����' ,'��ȸ����');

INSERT INTO TB_RENT_MASTER (RM_IDX, USER_ID, TITLE, RENT_BOOK_CNT)
VALUES (SC_RM_IDX.NEXTVAL, 'PCLASS', '����� �� 0��', 1);

SELECT * FROM TB_BOOK;
--------------------------------------------------------------------------------

 --���� ���ν��� ���� ( SP_RENT_INSERT )
 --������ ������ ������ȣ�� �����ȣ�� �Ű������� �޾� ���� ó���� �ϴ� ���ν����� �����ϼ���
 
 --1.ȸ�� ���̺��� ���� �������ڸ� ���÷� �����ϼ���
 --2.TB_RENT_BOOK ���̺� ������ ������ ������ �Է� �Ǿ�� �մϴ�.
 --3.TB_RENT_HISTORY ���̺� ������ ������ ������ ��� �Ǿ�� �մϴ�.
 --4.������ �Ϸ�Ǹ� ���� ���̺��� �ش� ������ ������ 1 �����ؾ��մϴ�.
 --5.������ �Ϸ�Ǹ� ���� ���̺��� �ش� ������ ���� Ƚ���� 1 ���� �ؾ� �մϴ�.
 --6. ������ �Ϸ�Ǹ� ���� �����丮 ���̺� '����'������ ��� �Ǿ�� �մϴ�.
 
 CREATE OR REPLACE PROCEDURE 
 SP_RENT_INSERT (V_B_IDX TB_BOOK.B_IDX%TYPE, V_RM_IDX  TB_RENT_MASTER.RM_IDX%TYPE)
 IS
    V_USER_ID TB_RENT_MASTER.USER_ID%TYPE;
    V_RB_IDX TB_RENT_BOOK.RB_IDX%TYPE;
 BEGIN
     --1.ȸ�� ���̺��� ���� �������ڸ� ���÷� �����ϼ���
     SELECT USER_ID INTO V_USER_ID FROM TB_RENT_MASTER WHERE RM_IDX = V_RM_IDX; --RENT_MASTER ���̺��� 
     UPDATE TB_MEMBER SET RENTABLE_DATE = SYSDATE WHERE USER_ID = V_USER_ID;
     
    --2.TB_RENT_BOOK ���̺� ������ ������ ������ �Է� �Ǿ�� �մϴ�.
    SELECT SC_RB_IDX.NEXTVAL INTO V_RB_IDX FROM DUAL;
    INSERT INTO TB_RENT_BOOK (RB_IDX, RM_IDX, B_IDX)
    VALUES (V_RB_IDX, V_RM_IDX, V_B_IDX);
    
    --3.TB_RENT_HISTORY ���̺� ������ ������ ������ ��� �Ǿ�� �մϴ�.
    INSERT INTO TB_RENT_HISTORY(RH_IDX, RM_IDX, RB_IDX, B_IDX, REG_DATE, STATE)
    VALUES(SC_RH_IDX.NEXTVAL, V_RM_IDX, V_RB_IDX, V_B_IDX, SYSDATE, 'RE00');

    --4.������ �Ϸ�Ǹ� ���� ���̺��� �ش� ������ ������ 1 �����ؾ��մϴ�.
    UPDATE TB_BOOK SET BOOK_AMT = BOOK_AMT-1 WHERE B_IDX = V_B_IDX;
    --5.������ �Ϸ�Ǹ� ���� ���̺��� �ش� ������ ���� Ƚ���� 1 ���� �ؾ� �մϴ�.
    UPDATE TB_BOOK SET RENT_CNT = RENT_CNT+1 WHERE B_IDX = V_B_IDX;
END;
/

--SELECT * FROM USER_SOURCE;
--DROP SEQUENCE SP_RENT_INSERT;

------------------------------------------------------------------------------

 --�ݳ� ���ν��� ���� (SP_RENT_RETURN)
 --�����ȣ, ���⵵����ȣ, ȸ�����̵� �Ű������� �޾� �ݳ�ó���� �����ϴ� ���ν����� �����ϼ���
 --1. �ݳ��� ����Ǹ� ���� ���̺��� �ش� ������ ������ 1 �����ؾ� �մϴ�.
 --2. ���� �ݳ����� ���Ŀ� �ݳ��� �� ��ü ó���� �ȴٸ� ��ü�� ������ 4�� ��ŭ�� �Ⱓ���� ������ �Ұ����մϴ�.
   -- ȸ�����̺��� ���� �������ڿ� �ݳ��� ���� * 4��ŭ�� ���ڸ� ������� �մϴ�.
--3. �ݳ��� ����Ǹ� ���⵵�����̺��� ���� ���´� �ݳ�����, �ݳ����� ���÷� ������Ʈ �Ǿ�� �մϴ�.
--4. �ݳ��� ������ ���� ����ǿ� �� �̻� �ݳ��� ������ ���ٸ� TB_RENT_MASTER ���̺��� IS_RETURN ���� TRUE�� ������ �ϳ��� ��������� UPDATE ����� �մϴ�.
--5. �ݳ��� ����Ǿ��ٸ� ���� �����丮 ���̺� '�ݳ�' ������ ��ϵǾ�� �մϴ�

CREATE OR REPLACE PROCEDURE 
SP_RENT_RETURN (V_RM_IDX TB_RENT_MASTER.RM_IDX%TYPE, V_RB_IDX  TB_RENT_BOOK.RB_IDX%TYPE, V_USER_ID TB_MEMBER.USER_ID%TYPE)
-- �Ű����� : �����ȣ, ���⵵����ȣ, ȸ�����̵�
IS
    V_B_IDX TB_BOOK.B_IDX%TYPE;  --������ȣ ����
    V_RETURN_DATE TB_RENT_BOOK.RETURN_DATE%TYPE; --�ݳ����� ����
    V_LATE_DATE NUMBER; --��ü�� ����
    V_RENT_BOOK_CNT NUMBER; --���� å ���� ����
BEGIN

    SELECT B_IDX INTO V_B_IDX FROM TB_RENT_BOOK WHERE RB_IDX = V_RB_IDX; --������ȣ ���� INTO����
    SELECT RETURN_DATE INTO V_RETURN_DATE  FROM TB_RENT_BOOK WHERE RB_IDX = V_RB_IDX; -- �ݳ����� ���� INTO ����
    V_LATE_DATE := SYSDATE - V_RETURN_DATE; --��ü�� ���� �� �ʱ�ȭ
    SELECT RENT_BOOK_CNT INTO V_RENT_BOOK_CNT FROM TB_RENT_MASTER WHERE RM_IDX = V_RM_IDX;  --�� ������� ����å ����
    
    --1. �ݳ��� ����Ǹ� ���� ���̺��� �ش� ������ ������ 1 �����ؾ� �մϴ�.
    UPDATE TB_BOOK SET BOOK_AMT = BOOK_AMT+1 WHERE B_IDX = V_B_IDX;
    --2. ���� �ݳ�����(RETURN_DATE) ���Ŀ� �ݳ��� �� ��ü ó���� �ȴٸ� ��ü�� ������ 4�� ��ŭ�� �Ⱓ���� ������ �Ұ����մϴ�.
   -- ȸ�����̺��� ���� ��������(RENTABLE_DATE)�� �ݳ��� ���� * 4��ŭ�� ���ڸ� ������� �մϴ�.
   IF TRUNC(V_RETURN_DATE) < TRUNC(SYSDATE) 
   THEN 
        --��ü��
        UPDATE TB_MEMBER SET RENTABLE_DATE  = SYSDATE+(V_LATE_DATE*4) WHERE USER_ID = V_USER_ID;
   END IF;
   --3. �ݳ��� ����Ǹ� ���⵵�����̺��� ���� ���´� �ݳ�����, �ݳ����� ���÷� ������Ʈ �Ǿ�� �մϴ�.
   UPDATE TB_RENT_BOOK SET STATE = 'RE03' WHERE RM_IDX = V_RM_IDX;
   UPDATE TB_RENT_BOOK SET RETURN_DATE = SYSDATE WHERE RM_IDX = V_RM_IDX;
   --4. �ݳ��� ������ ���� ����ǿ� �� �̻� �ݳ��� ������ ���ٸ� TB_RENT_MASTER ���̺��� 
   --   IS_RETURN ���� TRUE�� ������ �ϳ��� ��������� UPDATE ����� �մϴ�.
   IF V_RENT_BOOK_CNT = 1
   THEN 
        UPDATE TB_RENT_MASTER SET IS_RETURN = 1 WHERE RM_IDX = V_RM_IDX;
   END IF;
    --5. �ݳ��� ����Ǿ��ٸ� ���� �����丮 ���̺� '�ݳ�' ������ ��ϵǾ�� �մϴ�   
    UPDATE TB_RENT_HISTORY SET STATE = 'RE03' WHERE RM_IDX = V_RM_IDX;
END;
/

---------------------------------------------------------------------------------------------------------------    
--���� ���ν��� ����  (SP_RENT_EXTEND)
--�����ȣ, ���⵵����ȣ�� �Ű������� �޾� ����ó���� �����ϴ� ���ν����� �����ϼ���
--1. ���� ó���� ����Ǹ� �ݳ����ڰ� 7�� �����ϰ� �˴ϴ�.
--2. ���� ó���� ����Ǹ� ����Ƚ���� 1 �����ϰ� �˴ϴ�.
--3. ���� ó���� ����Ǹ� ���⵵���� ���°� '����'���� ����ǰ� �˴ϴ�.
--4. ���� ó���� ����Ǹ� ���� �����丮 ���̺� '����' ������ ��ϵǾ�� �մϴ�.

CREATE OR REPLACE PROCEDURE 
SP_RENT_EXTEND (V_RM_IDX TB_RENT_MASTER.RM_IDX%TYPE, V_RB_IDX TB_RENT_BOOK.RB_IDX%TYPE)
IS

BEGIN
    --1. ���� ó���� ����Ǹ� �ݳ����ڰ� 7�� �����ϰ� �˴ϴ�.
    UPDATE TB_RENT_BOOK SET RETURN_DATE  = RETURN_DATE+7 WHERE RB_IDX = V_RB_IDX;
    --2. ���� ó���� ����Ǹ� ����Ƚ���� 1 �����ϰ� �˴ϴ�.
    UPDATE TB_RENT_BOOK SET EXTENTION_CNT = EXTENTION_CNT+1 WHERE RB_IDX = V_RB_IDX;
    --3. ���� ó���� ����Ǹ� ���⵵���� ���°� '����'���� ����ǰ� �˴ϴ�.
    UPDATE TB_RENT_BOOK SET STATE = 'RE01' WHERE RB_IDX = V_RB_IDX;
    --4. ���� ó���� ����Ǹ� ���� �����丮 ���̺� '����' ������ ��ϵǾ�� �մϴ�.
    UPDATE TB_RENT_HISTORY SET STATE = 'RE01' WHERE RB_IDX = V_RB_IDX;
END;
/
    
    
    


    
    





     
    
    

    

    
    
    
 


