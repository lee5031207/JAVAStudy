--select
--���̺��� ���ϴ� �����͸� ��ȸ�ϴ� ����
--select���� ����� -> result set(��ȯ�� ����� ����)
--�ۼ��� : select �÷��� from ���̺�� where ���ǽ�
--���̺��� ���ǽĿ� �����ϴ� row���� �÷� ������ ��ȸ

-- �ּ� : --
-- ��ҹ��� ���� X

-------------�ǽ�-------------
--1. JOB���̺��� ���� �̸� ��ȸ
SELECT JOB_NAME FROM JOB;

--2. EMPLOYEE���̺��� ����� �̸�, �޿��� ��ȸ
SELECT EMP_ID,EMP_NAME,SALARY FROM EMPLOYEE;

--4. JOB ���̺��� ��� ���� ��ȸ
SELECT * FROM JOB;

--5. DEPARTMENT ���̺��� ��� ���� ��ȸ
SELECT * FROM DEPARTMENT;

--6. EMPLOYEE ���̺��� ������, �̸���, ��ȭ��ȣ, ����� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE FROM EMPLOYEE;

--7. EMPLOYEE ���̺��� �����, ��� �̸�, ���� ��ȸ
SELECT HIRE_DATE, EMP_NAME, SALARY FROM EMPLOYEE;

-- ***��������� : +,-,*,/***
--SELECT�� �ۼ��� SELECT�� �� ��������� �̿��Ͽ� ����� ��ȸ

--1. EMPLOYEE ���̺��� �������� �̸��� ������ ��ȸ(������ �޿� X 12)
SELECT EMP_NAME, SALARY*12 FROM EMPLOYEE;
SELECT EMP_NAME AS �����, SALARY*12 AS ���� FROM EMPLOYEE;

--�ǽ�--
--1. EMPLOYEE ���̺��� ������ �̸�, ����, ���ʽ��� �߰��� ����
SELECT EMP_NAME AS �̸�, SALARY*12 AS ����, 
SALARY *(1+BONUS)*12 AS ���ʽ�����
FROM EMPLOYEE;
--1(NULL ����)  NVL�Լ��� NVL(�÷�,0) �÷��� NULL�̸� 0���� ��� 
SELECT EMP_NAME AS �̸�, SALARY*12 AS ����, 
SALARY *(1+NVL(BONUS,0))*12 AS ���ʽ�����
FROM EMPLOYEE;


-- ***���ͷ�***
-- ���Ƿ� ������ ���ڿ�, ��¥�� SELECT ���� ����ϸ�, ���̺� �����ϴ� ������ó�� ���
-- ���ͷ��� RESULT SET�� ��� �࿡ �ݺ� ǥ��
-- ���ͷ��� ����Ҷ��� ''���

--1. EMPLOYEE ���̺��� ������ ��ȭ��ȣ, �����, �޿�, ����(��)�� ��ȸ
SELECT PHONE, EMP_NAME, SALARY, '��' AS ���� 
FROM EMPLOYEE;

-- ***���ڿ� ���� ������***
-- || ������
-- �÷��� ���ͷ��� �����ؼ� ����ϰų�, ���� �÷��� �ϳ��� �÷� ó�� ��� ����
--1. EMPLOYEE ���̺��� ���, �̸�, �޿��� �����ϴ� ���
SELECT EMP_ID || EMP_NAME || SALARY FROM employee;

--2. EMPLOYEE ���̺��� �÷��� ���ͷ��� �����غ���
SELECT EMP_NAME || '���� ������' || SALARY || '���Դϴ�.' FROM EMPLOYEE;

-- �ǽ����� --
--1. EMPLOYEE ���̺��� �̸�, �����, �ٹ��ϼ��� ��ȸ
-- HINT : ��¥(DATE)���ĵ� +,- ������ ����
-- HINT2 : ���� ��¥�� SYSDATE �� ���� �� �ִ�.

SELECT EMP_NAME AS �̸�,
HIRE_DATE AS �����,
TRUNC(SYSDATE - HIRE_DATE) AS �ٹ��ϼ� 
FROM EMPLOYEE;

-- *** DISTINCT ***
-- �÷��� ���Ե� �ߺ� ���� �����ϰ� ǥ���ϰ��� �� �� ���
-- RMPLOYEE ���̺��� ������ ���� �ڵ带 ��ȸ
SELECT JOB_CODE FROM employee;
SELECT DISTINCT JOB_CODE FROM EMPLOYEE;
SELECT DISTINCT DEPT_CODE, JOB_CODE FROM EMPLOYEE;