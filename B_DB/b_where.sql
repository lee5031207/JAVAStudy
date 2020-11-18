-- where ��
--��ȸ�� ���̺��� ���ϴ� row�� ��ȸ�ϱ� ���� �ۼ��ϴ� ���ǹ�
-- select �÷��� from ���̺�� where ������

-- ***�� ������, �� ������***
-- �� ������ : <,>,<=,>=,=
-- ���� �ʴ� : != ^= <>
-- �� ������ : and, or, not
--1. EMPLOYEE ���̺��� �μ��ڵ尡 'D9'�� ������ �̸�, �μ� �ڵ� ��ȸ
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

--2. EMPLOYEE ���̺��� �޿��� 4,000,000�̻��� �������� �̸��� ������ ��ȸ
SELECT EMP_NAME, SALARY*12 FROM EMPLOYEE WHERE SALARY >= 4000000;

--3. EMPLOYEE ���̺��� �μ��ڵ尡 'D9'�� �ƴ� ����� ���, �̸�, �μ��ڵ带 ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE != 'D9';

--4. EMPLOYEE ���̺��� ��翩�ΰ� N�� ������ ��ȸ�ϰ�, �ٹ� ���θ� '������'����
-- ǥ���Ͽ� ���, �̸�, �����, �ٹ� ���θ� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE, '�ٹ���' AS �ٹ����� 
FROM EMPLOYEE WHERE ENT_YN = 'N';

--5. EMPLOYEE ���̺��� ������ 3000000 �̻��� ����� �̸�, ����, ����� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE FROM EMPLOYEE WHERE SALARY >3000000;

--6. EMPLOYEE ���̺��� ��������(���� ����, ����3%)�� 4500���� �̻���
-- ����� �̸�, ����, �Ǽ��ɾ�, ������� ��ȸ
SELECT EMP_NAME, SALARY, (SALARY*0.97) AS �Ǽ��ɿ���, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY * 0.97 * 12 >45000000;

--  *** AND, OR ***
--1. �μ��ڵ� 'D6' �̰� �޿��� 200���� ���� ���� �޴� ������ �̸�, �μ��ڵ�, �޿��� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE = 'D6' AND SALARY>2000000;
--2. EMPLOYEE ���̺��� ������ 400���� �̻��̰� JOB�ڵ尡 12�� ����� ��� �÷��� ��ȸ
SELECT * FROM EMPLOYEE WHERE SALARY>4000000 AND JOB_CODE = 'J1';
--3. EMPLOYEE ���̺��� �μ��ڵ尡 D9�̰ų� D5�� ����� ������� 02/01/01���� ����
--����� �̸�, �μ��ڵ�, ����� ��ȸ
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' OR DEPT_CODE = 'D5' AND HIRE_DATE < '02/01/01';

--4. EMPLOYEE ���̺��� ������ 350���� �̻��̰�,
-- 600���� ������ ������ ���,�̸�,�޿�, �����ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, JOB_CODE FROM EMPLOYEE
WHERE SALARY > 3500000 AND SALARY < 6000000;


-- *** BETWEEN  A AND B ***
SELECT EMP_ID, EMP_NAME, SALARY, JOB_CODE FROM EMPLOYEE
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;

--1. EMPLOYEE ���̺��� ������� 90/01/01~01/01/01�� �ƴ� ����� ��ü ������ ��ȸ
SELECT * FROM EMPLOYEE
WHERE NOT HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';


-- ***LIKE***
-- �÷��� ���� ���� LIKE���� ������ Ư�� ������ ������Ű�� TRUE�� ��ȯ
-- �÷��� LIKE '���� ����'
-- '%', '_'
-- '%' : '����%' ('����'�� �����ϴ� ���ڿ�)
-- '%' : '%����' ('����'�� ������ ���ڿ�)
-- '%' : '%����%' ('����'�� �����ϴ� ���ڿ�)
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

-- ���� �̾��̰� �Ի����� 12/01/01 ������ ����� ���, �̸�, ����� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%' AND HIRE_DATE >= '12/01/01';

-- �̸��� '��'�� ���Եǰ� �μ��ڵ尡 D5�� ����� ��ȸ
SELECT EMP_NAME FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%' AND DEPT_CODE = 'D5';

--�̸��� '��'���� ������ ����� ��ȸ
SELECT EMP_NAME FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

--���� �ڸ��� ���� : '_' ���ڸ� �ǹ�
--                        " '__'���ڸ� �ǹ�
--EMPLOYEE  ���̺��� ��ȭ��ȣ 4�ڸ� ���� 9�� �����ϴ� ����� ���, �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_ID, EMP_NAME, PHONE FROM EMPLOYEE
--WHERE PHONE LIKE '___9%';
WHERE PHONE LIKE '%9___';

-- �̸����� '_'�� �ձ��ڰ� 3�ڸ��� �̸��� �ּҸ� ���� ����� ��� ������ ��ȸ
-- ex)  SUN_DI@KH.OR.KR
-- EXCAPE ���ڸ� ��� ���� �ش� Ư�� ���ڸ�
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' ESCAPE '#';

-- �ǽ� ���� ----
--1. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';

--2. EMPLOYEE ���̺��� ���� �ּ� '_'�� ���� 4���� �̸鼭
--   DEPT_CODE�� D9 �Ǵ� D6�̰�
--  ������� 90/01/01 ~ 00/12/01 �̸鼭 �޿��� 270���� �̻��� ����� ��ü ������ ��ȸ
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '____#_%' ESCAPE '#' 
AND (DEPT_CODE = 'D6' OR DEPT_CODE = 'D9')
AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
AND SALARY >= 2700000;

-- ������ �켱������ ����ؾ��� 
--  1���� : ���������
--  2���� : ���Ῥ����
--  3���� : �񱳿�����
--  4���� : IS NULL, LIKE, IN
--  5���� : BETWEEN A AND B
--  6���� : NOT
--  7���� : AND
--  8���� : OR
-- OR�� ������ ��ȣ�� �������� AND���� �켱���� �����ϱ�
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '____#_%' ESCAPE '#' 
AND (DEPT_CODE = 'D6' OR DEPT_CODE = 'D9')
AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
AND SALARY >= 2700000;

-------------------�ǽ� ����--------------------------
--1. ������ J7 �Ǵ� J2�� ���� �߿� �޿��� 200�̻��� ������ �̸�, �޿�, ���� �ڵ带 ��ȸ
SELECT EMP_NAME, SALARY, JOB_CODE FROM EMPLOYEE
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') AND SALARY >= 2000000; 

-- *** IN ***
-- ���ϴ� �� ��Ͽ� ��ġ�ϴ� ���� ������ true�� ��ȯ
-- �÷��� IN (��,��,��,......)
-- OR�� ���ϰ� ����� �� �ִ�

-- D6�μ��� D8�μ��� ������� �̸�, �μ��ڵ�, �޿��� ��ȸ
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6','D8' );

-- ***IS NULL***
-- �ش� �÷��� ������ �ƴ��� �Ǵ��� TRUE, FALSE��ȯ

--���ʽ� �÷��� NULL�� ����� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS FROM EMPLOYEE
WHERE BONUS IS  NULL;

SELECT * FROM TB_STUDENT WHERE STUDENT_ADDRESS LIKE '%��õ%';
