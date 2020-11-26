--1. PL/SQL(PROCEDURE LANGUAGE EXTENTION TO SQL)  - ���α׷��� ����!
-- ����Ŭ ��ü�� ����Ǿ� �ִ� ������ ���
-- ������ ����, ���ǹ�, �ݺ���, �Լ�, PROCEDURE

--2. �з�
-- PL/SQL ���(ANONYMOUS BLOCK) : �͸���, ������ �ڵ带 �ۼ� �� �� ���
-- PROCEDURE : �̸��� �ִ� PL/SQL��
--                      �ܵ����� ����ǰų� �ٸ� ���ν����� ���� ȣ��Ǿ� ���� ��
-- FUCTION : PROCEDURE�� ���� �̸��� �ִ� PL/SQL��, ���� ��ȯ�Ѵ�
-- TRIGGER : Ư���� ���̺� DML���� ����Ǿ��� �� ����Ǵ� PL/SQL��

--3. PL/SQL ���� ����
-- �����(DECLARE SECTION) : ������ ����� ����
-- �����(EXECUTABLE SECTION) : ���� ���
-- ����ó����(EXCEPTION SECTION) : ����ο��� ���ܰ� �߻����� �� ����ó���� ���� �ڵ�
-- END;

--4. PL/SQL �⺻ ����
SET SERVEROUTPUT ON;
-- PL/SQL���� �������� ��� , �α��� �� ������ ������ �ٽ� �ؾ���
SHOW ERRORS; 
--����Ȯ��

--5.  HELLO WORLD!! ���
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLP WORLD!!');
    -- DBMS_OUTPUT.PUT_LINE ����Լ�
END;
/

--6. ���� ���� �� �ʱ�ȭ
DECLARE
-- ������  Ÿ��
    EMP_ID NUMBER;
    EMP_NAME VARCHAR2(30);
-- ����� CONSTANT Ÿ��
    PI CONSTANT NUMBER := 3.14;
BEGIN
    --������ �ʱ�ȭ
    EMP_ID := 888;
    EMP_NAME := '���峲';
    --���
    DBMS_OUTPUT.PUT_LINE(EMP_ID);
    DBMS_OUTPUT.PUT_LINE(EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(PI*1000000);
END;
/

--7. REFERENCE ������ ����� �ʱ�ȭ
-- ���̺��� �÷��� Ÿ���� �����ϴ� ����
-- ������ ���̺��.�÷���%TYPE;
DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    --SELECT���� ����� EMPLOYEE ���̺��� �÷��� ���� �޾ƿ� ����
    --����ڷκ��� ����� �Է¹޾� �ش� ����� ������� ���
    SELECT EMP_ID, EMP_NAME 
    INTO V_EMP_ID, V_EMP_NAME
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID'; --��ĳ�� ����
    -- '&' ��ȣ�� �ִ� ���ڿ��� ��ü ���� �Է��϶�� �ǹ�;
    -- ����ڷκ��� ���� �Է¹޾� �ش� ������ �־��ش�.
    
    DBMS_OUTPUT.PUT_LINE('V_EMP_ID : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('V_EMP_NAME : ' || V_EMP_NAME);
END;
/

--�ǽ����� 1
-- ���۷��� ������ V_EMP_ID, V_EMP_NAME, V_DEPT_TITLE, V_JOB_NAME�� �����ϰ�
-- SELECT���� ����� ����ڰ� �Է��� �̸��� ��ġ�ϴ� �����
-- ���, �̸�, �μ���, ���޸��� ������ ������ �ʱ�ȭ�ϰ� ���

DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    V_DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    V_JOB_NAME JOB.JOB_NAME%TYPE;
BEGIN
    SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME
    INTO V_EMP_ID, V_EMP_NAME, V_DEPT_TITLE, V_JOB_NAME
    FROM EMPLOYEE E
    INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
    INNER JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
    WHERE EMP_NAME = '&�̸�';
    
    DBMS_OUTPUT.PUT_LINE('V_EMP_ID : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('V_EMP_NAME : ' || V_EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('V_DEPT_TITLE : ' || V_DEPT_TITLE);
    DBMS_OUTPUT.PUT_LINE('V_JOB_NAME : ' || V_JOB_NAME);
END;
/

--8. ROWTYPE ����
-- ���̺��%ROWTYPE : ���̺�Ǵ� VIEW�� ROW�� ����
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT * INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID';

    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('EMP_NO : ' || E.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);
END;
/

------------------------------------------------------------------------------------------
-- ���ǹ�
-- IF��, IF-ELSE�� , IF-ELSE IF-ELSE��


--1. ���� ���ǹ�
-- IF ������ RHEN ���� END IF;
-- EMP_ID�� �Է¹޾� �ش� ����� ���, �̸�, �޿�, ���ʽ����� ���
-- �� ���ʽ��� ���� �ʴ� ����� ���ʽ��� ��� �� '���ʽ� ����' ���

DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    V_SALARY EMPLOYEE.SALARY%TYPE;
    V_BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID ,EMP_NAME, SALARY, BONUS
    INTO V_EMP_ID ,V_EMP_NAME, V_SALARY, V_BONUS
    FROM EMPLOYEE WHERE EMP_ID = '&ID';

    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || V_EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || V_SALARY);
    
    IF V_BONUS IS NULL
    THEN
        DBMS_OUTPUT.PUT_LINE('BONUS����');
    END IF;
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
END;
/

--IF ELSE
--IF ���ǹ� THEN ���� ELSE ���� END IF
--EMP_ID�� �Է¹޾� �ش� ����� ���, �̸�, �޿�, ���ʽ��� ���
--���ʽ��� ���� �ʴ� ����� ���ʽ��� ��� �� '���ʽ� ����' ���
--���ʽ��� �޴� ����� ���ʽ��� ����� ' ���ʽ� ����' ���
DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    V_SALARY EMPLOYEE.SALARY%TYPE;
    V_BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID ,EMP_NAME, SALARY, BONUS
    INTO V_EMP_ID ,V_EMP_NAME, V_SALARY, V_BONUS
    FROM EMPLOYEE WHERE EMP_ID = '&ID';
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || V_EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || V_SALARY);
    
    IF V_BONUS IS NULL
    THEN DBMS_OUTPUT.PUT_LINE('���ʽ� ����');
    ELSE
    --DBMS_OUTPUT.PUT_LINE('���ʽ� ����');
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
    END IF;
END;
/

--IF ���ǹ� THEN ���� ELSIF ���ǹ� THEN ���� ELSE ���� END IF;

--EMP_ID�� �Է¹޾� �ش� ����� ���, �̸� , �޿�, ���ʽ����� ���
--���ʽ��� ���� �ʴ� ����� ���ʽ��� ����� ' ���ʽ� ����' ���
--���ʽ��� 20%�̻��� ����� ���ʽ��� ����� ' ���ʽ� ����' ���
--���ʽ��� 20%������ ����� ���ʽ��� ����� ' ���ʽ� ����' ���
DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    V_SALARY EMPLOYEE.SALARY%TYPE;
    V_BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID ,EMP_NAME, SALARY, BONUS
    INTO V_EMP_ID ,V_EMP_NAME, V_SALARY, V_BONUS
    FROM EMPLOYEE WHERE EMP_ID = '&ID';
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || V_EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || V_SALARY);
    
    IF V_BONUS IS NULL
    THEN DBMS_OUTPUT.PUT_LINE('���ʽ� ����');
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
    ELSIF V_BONUS > 0.2
    THEN 
    DBMS_OUTPUT.PUT_LINE('���ʽ� ����');
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
    ELSE
    DBMS_OUTPUT.PUT_LINE('���ʽ� ����');
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
    END IF;
END;
/

