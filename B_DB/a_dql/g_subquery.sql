--SUBQUERY
--�ϳ��� SQL�� �ȿ� ���Ե� �Ǵٸ� SQL��
--SUBQUERY�� SELECT��, FROM��, WHERE��, HAVING���� ��� ����

--�μ��ڵ尡 ���ö����� ���� �Ҽ��� ���� ����� ��ȸ
SELECT * FROM EMPLOYEE
WHERE  DEPT_CODE = 
(SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '���ö');

--�� ���� ��� �޿����� ���� �޿��� �ް� �ִ� ������ 
--���, �̸�, �����ڵ�, �޿��� ����ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE); 


----------------------------------------------------------------------------------------------------------
-- 1. ������ �������� : ���������� ��ȸ ��� ���� 1���� ���� ����
-- �񱳿����� ��� (<, >, <=, >=, =, !=, ^=, <>)

--1-1. ���ö ����� �޿����� ���� �޴� ������
-- ���, �̸�, �μ�, ����, �޿��� ��ȸ
SELECT EMP_ID, EMP_NAME,  DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '���ö');

--1-2. ���� ���� �޿��� �޴� ������
-- ���, �̸�, �޿�, �μ�, ����, �Ի����� ��ȸ
SELECT EMP_ID, EMP_NAME,  DEPT_CODE, JOB_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

--1-3. �μ��� �޿��� �հ谡 ���� ū �μ��� ��ȸ
SELECT DEPT_CODE FROM EMPLOYEE
GROUP BY DEPT_CODE HAVING SUM(SALARY) = 
(SELECT MAX(SUM(SALARY)) FROM EMPLOYEE GROUP BY DEPT_CODE);


----------------------------------------------------------------------------------------------------------
--2. ������ ��������
-- ���������� ��ȸ ��� ���� �������� ���� ����

-- IN, ANY, ALL, EXISTS ������ ���
-- IN : ���������� ��� ���� �߿��� �ϳ��� ��ġ�ϴ� ���� ������ TRUE
-- �ְ� �޿��� 4,999,999 ������ ���� �޿� ����� ������ ��ȸ
SELECT  * 
FROM EMPLOYEE
WHERE SAL_LEVEL IN (SELECT SAL_LEVEL FROM SAL_GRADE WHERE MAX_SAL < 4999999);

--�񱳿����� ANY : ���������� ��� ���� �߿��� �ϳ��� �񱳿���� TRUE�� ������ TRUE ��ȯ
--                         WHERE 1 >ANY(��������)  -> ��� ���� 0,3,5 -->TRUE
-- �ڳ��� ���� �μ��� ���� ���� �޿��� �޴� ������� ���� �ް� 
-- �ڳ��� ���� �μ� �������� ���� �޿��� �޴� ������� ���� �޿��� �޴� ������� ����� ��ȸ
SELECT * FROM EMPLOYEE
WHERE SALARY < ANY(SELECT SALARY FROM EMPLOYEE WHERE DEPT_CODE = 
                                    (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '�ڳ���'))
AND SALARY > ANY(SELECT SALARY FROM EMPLOYEE WHERE DEPT_CODE = 
                                    (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '�ڳ���'));

--�񱳿����� ALL : ���������� ��� ������ ��� �񱳿���� TRUE�� ���;� TRUE
--                         WHERE 1 >ALL(��������)  -> ��� ���� 0, 0.5, 0.7 -->TRUE
--�ڳ��� ���� �μ��� ����� �� ���� ���� �޿��� �޴� �������
--�� ���� �޿��� �޴� ���� ��� ��ȸ
SELECT EMP_NAME, SALARY FROM EMPLOYEE
WHERE SALARY > ALL(SELECT SALARY FROM EMPLOYEE WHERE DEPT_CODE = 
                                    (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '�ڳ���'));

-- EXIST : ���������� ����� �����ϸ� TRUE ������ FALSE
SELECT * FROM EMPLOYEE E
WHERE EXISTS(SELECT EMP_ID FROM EMPLOYEE WHERE EMP_ID = E.MANAGER_ID);

-------------------------------------------------------------------------------------------------------------
-- *** ���߿� ��������
-- ���������� ����� �÷��� ���� ���� ���
-- ����� ������ ���� �μ�, ���� ���޿� �ش��ϴ� ����� �̸�, ����, �μ�, �Ի����� ��ȸ
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_CODE FROM EMPLOYEE WHERE ENT_YN = 'Y')
AND JOB_CODE IN (SELECT JOB_CODE FROM EMPLOYEE WHERE ENT_YN = 'Y');
-- ��ó�� �� ������ ���߿� ���������� �̿��ϸ�
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN 
(SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN = 'Y');


-------------------------------------------------------------------------------------------------------------
-- *** ��ȣ ���� ���� OR ��� ����
-- ��������� ���� ������ ����ϴ� �÷� ���� ���� ������ �̿��ϴ� ����
-- ���������� �÷� ���� �ٲ�� ���������� ��� ���� �ٲ��


--�������� ������ ���, �̸�, �μ��ڵ�, ������ ��� ��ȸ
SELECT EMP_NAME, DEPT_CODE, EMP_ID, MANAGER_ID
FROM EMPLOYEE E
WHERE EXISTS (SELECT EMP_ID FROM EMPLOYEE WHERE MANAGER_ID = E.EMP_ID);


-- *** ��Į��(���ϰ�) ��������
-- SELECT ������ ���Ǵ� ��������
-- ��Į�� ���������� �ݵ�� ����� ���� ���� ��ȯ�Ǿ�� �Ѵ�
-- ��� ����� ���, �̸�, �����ڻ��, �����ڸ��� ��ȸ
SELECT EMP_ID, EMP_NAME, MANAGER_ID,
(SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_ID = E.MANAGER_ID) AS ������
FROM EMPLOYEE E;

-- *** ROWNUM : �ٹ�ȣ
-- SELECT���� ����Ǵ� �ñ⿡ ���� ����
-- SELECT�� ���Ŀ� ����Ǵ� ORDER BY���� ����� ��� ROWNUM�� ���׹��׵ȴ�


-- *** �ζ��� ��
--FROM ������ �������� ���
-- ���������� ����� ���̺� ������� ���
-- ****��ȸ���� ������� ���� 5���� ��ȸ���� �̷������� ���� ���****

-- �� ���� �� �޿��� ���� ���� ���� 5���� ����, �̸�, �޿��� ��ȸ�Ͻÿ�
SELECT ROWNUM AS ���� ,
EMP_NAME, SALARY FROM (SELECT * FROM EMPLOYEE ORDER BY SALARY DESC)
WHERE ROWNUM < 6;

-- �� ���� �� �Ի����� ���� ���� ��� 5���� ����, �̸�, �Ի����� ��ȸ�Ͻÿ�
SELECT ROWNUM AS �Ի�õ��,
EMP_NAME, HIRE_DATE FROM (SELECT * FROM EMPLOYEE ORDER BY HIRE_DATE DESC)
WHERE ROWNUM < 6;

-- *** WITH
-- ������ �̸��� �ٿ� �̸����� �ش� ������ ����� ȣ��
-- ������ ����� �޸𸮿� ������ �ξ��ٰ�, �̸����� ȣ�� �� �� �ҷ����� ���
-- ���� �ӵ��� ������.

WITH TOPN_SAL AS(SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE
    ORDER BY SALARY DESC)
SELECT ROWNUM, EMP_NAME, SALARY
FROM TOPN_SAL;





