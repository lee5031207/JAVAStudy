--�Լ�(FUNCTION) :  ���� �а� �����Ͽ� ����� ��ȯ
-- ������ �Լ� : �÷��� ��ϵ� N���� ���� �о �ϳ��� ���� RETURN
-- �׷� �Լ� : �����̳� ���, �ִ밪�� ���� ���õ� ����� ��ȯ�ϴ� �Լ�

--1. ���� ���� �Լ�
-- LENGTH, LENGTHB, SUBSTR, INSTR, CONCAT, REPLACE, TRIM, LPAD, RPAD
-- ***LENGTH*** : ���ڿ��� ���̸� ��ȯ
-- ***LENGTHB*** : ���ڿ��� ����Ʈ ũ�⸦ ��ȯ
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ') FROM DUAL; -->DUAL ������ ���̺�
SELECT LENGTH('ORACLE'), LENGTHB('ORACLE') FROM DUAL;

-- ***INSTR*** : ���ڿ����� ã���� �ϴ� ������ ��ġ�� ��ȯ�ϴ� �Լ�
SELECT INSTR('AABAACAABBAA','B') FROM DUAL;
SELECT INSTR('AABAACAABBAA','B',4) FROM DUAL;
SELECT INSTR('AABAACAABBAA','B',4,2) FROM DUAL; --2��° B�� ��ġ
--Ž���� ������ �����ʿ��� �������� ����
SELECT INSTR('AABAACAABBAA','B',-1,3) FROM DUAL;  --3��° B�� ��ġ


-- *** SUBSTR ***
-- �÷��̳� ���ڿ����� ������ ��ġ���� ������ ������ ���ڸ� �߶󳻾� ��ȯ
--> SUBSTRING(STRING, POSITION[,LENGTH])
-- STRGIN : �÷� �Ǵ� ���ڿ�
-- POSITION : ���ڿ��� �ڸ� ��ġ, ����� ���� ����, ������ ������ ���� COUNT
SELECT SUBSTR('PCLASS',2) FROM DUAL;
SELECT SUBSTR('PCLASS',2,1) FROM DUAL;
SELECT SUBSTR('PCLASS',-1) FROM DUAL;

--EMPLOYEE ���̺��� ������ �������� ��ȸ
SELECT EMP_NAME FROM EMPLOYEE 
WHERE '1' = SUBSTR(EMP_NO,8,1);

--EMPLOYEE ���̺��� �̸��� ���̵� (�̸��Ͽ��� @ �տ� �ٴ� ���̵�)�� ��ȸ
SELECT SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1) FROM EMPLOYEE; 


-- ***LAPD/RPAD
-- �־��� �÷��̳� ���ڿ��� ������ ���ڸ� ���� �Ǵ� �����ʿ� ���ٿ� ������ ������ ���ڿ��� ��ȯ
-- �� ���� ���ڿ��� �������� ������ ������ ���δ�.
SELECT LPAD(EMAIL,20) FROM EMPLOYEE;
SELECT LPAD(EMAIL,20,'#') FROM EMPLOYEE;
SELECT RPAD(EMAIL,20) FROM EMPLOYEE;
SELECT RPAD(EMAIL,20,'-') FROM EMPLOYEE;

-- ***LTRIM.RTRIM
-- �־��� �÷��̳� ���ڿ��� ���� �Ǵ� ������ ������ ����, 
--������ ���� ������ ��� ã�� ������ �� �������� ��ȯ
SELECT LTRIM('       LEESUNGUK') FROM DUAL;
SELECT LTRIM(PHONE,010) FROM EMPLOYEE;
SELECT LTRIM(000123456,'0') FROM DUAL;
SELECT LTRIM(000123456,'01') FROM DUAL;
SELECT RTRIM(123456000, '012456') FROM DUAL;

-- ***TRIM
-- �־��� �÷� �Ǵ� ���ڿ��� �յ� �ʿ��� ������ ���������� ��� ����
SELECT TRIM('          KH         ') FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL;

-- *** CONCAT ***
--���ڿ� ���� �Լ�
SELECT CONCAT(EMP_NAME,EMP_ID) FROM EMPLOYEE;

-- *** REPLACE ***
--���ڿ� REPLACE �ϴ� �Լ�
SELECT REPLACE('����� ������ ���ﵿ','���ﵿ') FROM DUAL;
SELECT REPLACE('����� ������ ���ﵿ','���ﵿ','�Ｖ��') FROM DUAL;

--EMPLOYEE ���̺��� ������ �ֹι�ȣ�� ��ȸ�ϼ���
--�� �ֹι�ȣ�� ������ϰ� '-' ������ ���̰��ϰ� ������ �ڸ��� ���ڵ��� *�ιٲپ� ���
SELECT EMP_NAME, 
REPLACE(EMP_NO,SUBSTR(EMP_NO,8),'*******') AS �ֹε�Ϲ�ȣ,
RPAD(SUBSTR(EMP_NO,1,7),14,'*') AS ����Դ�,
SUBSTR(EMP_NO,1,7)||'*******' AS ����Դ�2
FROM EMPLOYEE;

--------------------------------------------------------------------------------------------------------
--2. ���� ó�� �Լ�
-- ABS, MOD, ROUND, FLOOR, TRUNC, CEIL

-- ***ABS***  :  ���밪 ��ȯ
SELECT ABS(-2323) FROM DUAL;

-- ***MOD***  :  ������ �Լ�
SELECT MOD(31,3) FROM DUAL;
SELECT MOD(-31,3) FROM DUAL;

-- ***ROUND*** : �ݿø� �Լ�
SELECT ROUND(32.734) FROM DUAL;
SELECT ROUND(32.737,2) FROM DUAL;

--***FLOOR*** : ����ó�� �Լ�
SELECT FLOOR(32.5454) FROM DUAL;

--***TRUNC*** : ����ó�� �Լ�, ���ϴ� ��ġ���� ���ڸ� ������ �� �ִ�.
SELECT TRUNC(32.5454) FROM DUAL;
SELECT TRUNC(32.5454,1) FROM DUAL;
SELECT TRUNC(32.5454,-1) FROM DUAL;
SELECT TRUNC(2975,-2) FROM DUAL;

--***CEIL*** : �ø�ó�� �ϴ� �Լ�
SELECT CEIL(123.111) FROM DUAL;


--1. EMPLOYEE ���̺��� �����, �ٹ��ϼ�, �ٹ��ϼ� 2�� ��ȸ�ϼ���
-- �ٹ��ϼ�1 : �Ի���- ���ó�¥
-- �ٹ��ϼ�2 : ���ó�¥ - �Ի���
-- �ٹ��ϼ� 1,2�� ��� �����̸鼭 ����̰Բ� ó�� ���ּ���
SELECT EMP_NAME,
ABS(FLOOR(HIRE_DATE - SYSDATE)),
FLOOR(SYSDATE - HIRE_DATE)
FROM EMPLOYEE;

--2. EMPLOYEE ���̺��� ����� Ȧ���� �������� ������ ��ȸ�ϼ���
SELECT * FROM EMPLOYEE
WHERE 0 != MOD(EMP_ID,2);


----------------------------------------------------------------------------------------------------
--3. ��¥ ó��
--SYSDATE, MONTHS_BETWEEN, ADD_MONTHS, EXTRACT

--SYSDATE : �ý��ۿ� ����Ǿ� �ִ� ���� �ð��� ��ȯ�ϴ� �Լ�
SELECT SYSDATE FROM DUAL;

--MONTHS_BETWEEN : �μ��� ���� �� DATE�� ������ ���̸� ��ȯ�ϴ� �Լ�
SELECT EMP_NAME, HIRE_DATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS �ٹ�������
FROM EMPLOYEE ORDER BY �ٹ������� DESC;

--ADD_MONTHS : ��¥�� �μ��� �ѱ� ���ڸ�ŭ �������� ���Ͽ� ��¥�� ��ȯ
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE,12) FROM EMPLOYEE;


--EXTRACT : �μ��� �ѱ� �ð����� ���ϴ� ��Ҹ� �����Ͽ� ��ȯ
SELECT EMP_NAME, 
EXTRACT(YEAR FROM HIRE_DATE) AS "�Ի��� �⵵",
EXTRACT(MONTH FROM HIRE_DATE) AS "�Ի��� ��",
EXTRACT(DAY FROM HIRE_DATE) AS "�Ի��� ��",
--EXTRACT �Լ� �ȿ����� TIMEZONE�� ������� �ʾ� �׸���ġ ǥ�ؽ÷� �ð��� ǥ��
EXTRACT(HOUR FROM systimestamp)+9 AS "���� �ð�",
EXTRACT(YEAR FROM systimestamp) AS "���� �⵵"
--EXTRACT(DAY FROM DATE '2020-11-18') AS "���ó�¥"
FROM EMPLOYEE;

SELECT SYSTIMESTAMP FROM DUAL;

--1. EMPLOYEE ���̺��� �ٹ������ 20�� �̻��� ���� ������ ��ȸ
SELECT EMP_NAME, HIRE_DATE, FLOOR(FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))/12) AS �ٹ����   
FROM EMPLOYEE 
WHERE FLOOR(FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))/12) > 20
ORDER BY �ٹ���� DESC;


----------------------------------------------------------------------------------------------------------
--4. ����ȯ �Լ�
-- �����͸� ���ϴ� Ÿ���� �����ͷ� ��ȯ

-- ***TO_CHAR***
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE,'SYYYY"��" MONTHDD"��"') FROM DUAL;

--TO_CHAR(NUMBER)
SELECT TO_CHAR(123456789,'999,999,999') FROM DUAL;
SELECT TO_CHAR(10000, '$999999') FROM DUAL;
SELECT TO_CHAR(10000, '$000000') FROM DUAL;
SELECT TO_CHAR(10000, 'L99999') FROM DUAL;

----------------------------------------------------------------------------------------------------------
--5. NULL ó�� �Լ�
-- ***NVL***  : �Ķ���� 1�� NULL �̸� �Ķ����2�� ���
SELECT EMP_NAME, BONUS, NVL(BONUS,0) FROM EMPLOYEE;
SELECT EMP_NAME, DEPT_CODE, NVL(DEPT_CODE, '���Ҽ�') FROM EMPLOYEE;

-- ***NVL2***  : �Ķ���Ͱ� 3 ���� �Լ�, NULL�̸� �Ķ����2, NULL�� �ƴϸ� �Ķ����3
SELECT EMP_NAME, BONUS, NVL2(BONUS,'���ʽ�NULL�ƴ�','���ʽ�NULL') FROM EMPLOYEE;

--***NULLIF*** : ?
SELECT NULLIF('1234','1234') FROM DUAL;
SELECT NULLIF('1234','123') FROM DUAL;

----------------------------------------------------------------------------------------------------------
--5. ���� �Լ� 
--DECODE, CASE WHEN, 

--DECODE  : SWITCH CASE�� ���� ���� �Լ�
--�ֹι�ȣ 8��° �ڸ��� ¦���� '��', Ȧ�����'������' ǥ���Ͽ� 
--�������� �̸�, �ֹι�ȣ, ������ ��ȸ�Ͻÿ�
SELECT EMP_NAME, EMP_NO
, DECODE(MOD(SUBSTR(EMP_NO,8,1),2),1,'��',0,'��')
FROM EMPLOYEE;
--������ �޿��� �λ��ϰ��� �Ѵ�.
--�����ڵ尡 J7�� ������ �޿��� 10%�� �λ��ϰ�
--�����ڵ尡 J8�� ������ �޿��� 15%�� �λ��ϰ�
--�����ڵ尡 J5�� ������ �޿��� 20%�� �λ��ϸ�
-- ������ ������ �޿��� 5%�� �λ��Ѵ�
-- �λ�� �޿��� ������, �����ڵ�, �޿��� �Բ� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY AS �λ����޿�,
DECODE(JOB_CODE,'J7',SALARY*1.1,'J8',SALARY*1.15,'J5',SALARY*1.2,SALARY*1.05) AS �λ��ı޿�
FROM EMPLOYEE;

--CASE WHEN ���ǽ� THEN �����
--        WHEN ���ǽ� THEN �����
--        ELSE �����
--�ֹι�ȣ 8��° �ڸ��� ¦���� '��', Ȧ�����'������' ǥ���Ͽ� 
--�������� �̸�, �ֹι�ȣ, ������ ��ȸ�Ͻÿ�
SELECT EMP_NAME, EMP_NO,
CASE WHEN MOD(SUBSTR(EMP_NO,8,1),2) = 1 THEN '��'
        --WHEN MOD(SUBSTR(EMP_NO,8,1),2) = 0 THEN '��'
        ELSE '��'
        END AS ����
FROM EMPLOYEE;

--������ �޿��� �λ��ϰ��� �Ѵ�.
--�����ڵ尡 J7�� ������ �޿��� 10%�� �λ��ϰ�
--�����ڵ尡 J8�� ������ �޿��� 15%�� �λ��ϰ�
--�����ڵ尡 J5�� ������ �޿��� 20%�� �λ��ϸ�
-- ������ ������ �޿��� 5%�� �λ��Ѵ�
-- �λ�� �޿��� ������, �����ڵ�, �޿��� �Բ� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY AS �λ����޿�,
CASE WHEN JOB_CODE = 'J7' THEN SALARY*1.1
        WHEN JOB_CODE = 'J8' THEN SALARY*1.15
        WHEN JOB_CODE = 'J5' THEN SALARY*1.2
        ELSE SALARY*1.05
        END AS �λ��ı޿�
FROM EMPLOYEE;



