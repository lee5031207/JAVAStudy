-- *** JOIN
-- �ϳ� �̻��� ���̺��� ���̺��� ��ȸ�ϱ� ���� ���
-- �������� �ϳ��� RESULT SET���� ���´�
-- ������ �����ͺ��̽������� �������� �ߺ��� �ּ�ȭ �ϱ� ���� 
-- �ּ����� �����͸� ���̺� �����ص��, �ʿ��� �� ���̺� ���� ���踦 ����
-- �����͸� �����ؼ� �����Ѵ�.

--1.������ȣ ,������, �μ��ڵ�, �μ����� ��ȸ

--1-1.���������� ����ϴ� ��� (��ȿ����)
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
(SELECT DEPT_TITLE FROM DEPARTMENT WHERE DEPT_ID = E.DEPT_CODE) AS �μ���
FROM EMPLOYEE E;

--1-2. JOIN���� Ȱ��
SELECT *--EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E JOIN DEPARTMENT D
ON(E.DEPT_CODE = D.DEPT_ID);


-- JOIN�� ����
-- CROSS JOIN, INNER JOIN, OUTER JOIN(LEFT JOIN, RIGHT JOIN)


-- 0. CROSS JOIN(�Ⱦ�)
-- CARTEEN ���� �߻��� ������� �ʴ´�
-- �� �� ���̺��� ��� ��� �ٸ� ���̺��� ��� ���� JOIN
-- EMPLOYEE ���̺��� ROW�� * DEPARTMENT ���̺��� ROW�� ��ŭ�� ROW ����
-- EX. 3���� ��ǰ�����Ϳ� 5������ �ֹ������͸� CROSS JOIN�ϸ� 15�ﰳ�� ROW�� ��ȯ
-- �볻 ��ȿ���� ��������
SELECT * 
FROM EMPLOYEE CROSS JOIN DEPARTMENT
ORDER BY EMP_ID DESC, DEPT_ID ASC; 

-- 1. INNER JOIN(� ����(EQUALS JOIN))
-- JOIN ������ �ۼ��ؼ� �����ϴ� ROW�鸸 JOIN����
-- ON() �ȿ� JOIN ������ �ۼ�
-- ���࿡ ���������� ����� �� ���̺��� �÷����� ���ٸ� USING(�÷���) ��� ����

--ANSI ǥ�� ����(�̱� ���� ǥ�� ��ȸ)
--ANSI ǥ�� ������ ��� DBMS���� ���������� ����ϴ� ����
SELECT *
FROM EMPLOYEE E  INNER JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);
--USING ���
SELECT *
FROM EMPLOYEE E  JOIN JOB J USING(JOB_CODE);
--ORACLE ����
SELECT *
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;


--���� ���̺� JOIN�غ���(ANSI)
-- EMPLOYEE, DEPARTMENT, LOCATION
SELECT * FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
INNER JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE);

--���� ���̺� JOIN�غ���(ORACLE)
-- EMPLOYEE, DEPARTMENT, LOCATION
SELECT * FROM EMPLOYEE E, DEPARTMENT D, LOCATION L
WHERE E.DEPT_CODE = D.DEPT_ID
AND D.LOCATION_ID = L.LOCAL_CODE;

--�μ� ���̺��� �μ��� �������� ��ȸ�ϼ���(ANSI)
SELECT DEPT_ID, DEPT_TITLE, LOCAL_NAME FROM DEPARTMENT D
INNER JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE);
--�μ� ���̺��� �μ��� �������� ��ȸ�ϼ���(ORACLE)
SELECT DEPT_TITLE, LOCAL_NAME
FROM DEPARTMENT D, LOCATION L
WHERE d.location_id = l.local_code;



