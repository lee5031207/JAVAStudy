-- *** ORDER BY ***
-- SELECT������ ����� ������ �� ����ϴ� ����
-- SELECT���� ���� ������ �ۼ�, ���� ������ ���� ������
-- �ؼ� ���� : FROM, WHERE, GROUP BY, HAVING, ORDDER BY 
-- SELECT ������ �������� ���� �÷����� ������ �� �� �����ϴ�.
-- �ۼ� ���
-- SELECT Į���� FROM ���̺�� WHERE ������ GROUP BY HAVING ORDER BY �÷��� 
-- ORDER BY �÷��� ASC : �������� / DEFAULT �� ���������̴�
-- ORDER BY �÷��� DESC : ��������
-- NULLS FIRST : ���� �����ϴ� ������ �Ǵ� �÷��� NULL�� �� ���� ��� �պκп� ����
-- NULLS LAST : ���� �����ϴ� ������ �Ǵ� �÷��� NULL�� �� ���� ��� �ںκп� ����

--����� �̸�, �޿�, �μ��ڵ�, ���ʽ�, ���� ������ ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE

--1.�̸����� �������� ����
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY EMP_NAME DESC;

--2.�������� �������� ����
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY SALARY;

--3.�ι� ° �÷����� �������� ���� (���⼭�� SALARY��������  ����)
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY 2 DESC;

--4.���� �������� �������� ����, ���������� ���� ROW���� �������� �������� ����
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY SAL_LEVEL, SALARY DESC;

--5.���ʽ��� �������� ����, ���� ������ �Ǵ� �÷��� NULL�� ������ ���� ����
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY BONUS NULLS FIRST;

--6.���ʽ��� �������� ����, ���� ������ �Ǵ� �÷��� NULL�� ������ �Ʒ��� ����
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY BONUS DESC NULLS LAST;


