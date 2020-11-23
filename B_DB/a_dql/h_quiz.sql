------------------------------------------INNER JOIN �ǽ�--------------------------------


--1-1. �޿��� 200���� �̻��� �븮 ���� ������ ��ȸ�ϼ��� (ANSI)
SELECT EMP_NAME, SALARY, JOB_CODE, JOB_NAME
FROM EMPLOYEE E 
INNER JOIN  JOB J USING(JOB_CODE)
WHERE SALARY > 2000000 AND JOB_NAME ='�븮';
--1-2. �޿��� 200���� �̻��� �븮 ���� ������ ��ȸ�ϼ��� (ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code=j.job_code AND SALARY > 2000000;

--2-1. ���� ���� ������ �޿��� ��ȸ�ϼ���(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J USING(JOB_CODE)
WHERE JOB_NAME ='����';
--2-2. ���� ���� ������ �޿��� ��ȸ�ϼ���(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME ='����';

--3-1.�븮 ������ ������ �߿��� ���������� �ּ� �޿����� ���� �޴� ������ ��ȸ(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J ON(E.JOB_CODE=J.JOB_CODE)
WHERE JOB_NAME = '�븮' 
AND SALARY >
(SELECT MIN(SALARY) FROM EMPLOYEE E
INNER JOIN JOB J 
USING(JOB_CODE)
WHERE JOB_NAME = '����');
--3-2.�븮 ������ ������ �߿��� ���������� �ּ� �޿����� ���� �޴� ������ ��ȸ(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME='�븮' 
AND SALARY >
(SELECT MIN(SALARY)
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME = '����');

---4-1 �޿��� 200���� �̻��� ���� ���� ������ ��ȸ�ϼ���(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J ON(E.JOB_CODE=J.JOB_CODE)
WHERE SALARY > 2000000 AND JOB_NAME = '����';
---4-2 �޿��� 200���� �̻��� ���� ���� ������ ��ȸ�ϼ���(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME ='����'
AND SALARY >2000000;

--5-1. ���� ���� ������ �޿��� ��ȸ�ϼ���(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J USING(JOB_CODE)
WHERE JOB_NAME ='����';
--5-2. ���� ���� ������ �޿��� ��ȸ�ϼ���(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME ='����';

--6-1.���� ������ ������ �߿��� ���������� �ִ� �޿����� ���� �޴� ������ ��ȸ(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J ON(E.JOB_CODE=J.JOB_CODE)
WHERE JOB_NAME = '����' 
AND SALARY >
(SELECT MAX(SALARY) FROM EMPLOYEE E
INNER JOIN JOB J 
USING(JOB_CODE)
WHERE JOB_NAME = '����');
--6-2.���� ������ ������ �߿��� ���������� �ִ� �޿����� ���� �޴� ������ ��ȸ(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME='����' 
AND SALARY >
(SELECT MAX(SALARY)
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME = '����');

--7-1 ���޺� �޿� ��հ� ���� ����, �޿��� ���� ������ ��ȸ�Ͻÿ�(ANSI)
SELECT EMP_NAME, SALARY
FROM EMPLOYEE E
WHERE (JOB_CODE, SALARY) IN 
(SELECT JOB_CODE, AVG(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE);
--7-2 ���޺� �޿� ��հ� ���� ����, �޿��� ���� ������ ��ȸ�Ͻÿ�(ORACLE)

--8. ����Դ� 
--�μ��� �޿� �հ谡 ��ü �޿� �� ���� 20%���� ���� �μ��� �μ����, �μ��� �޿� �հ�
SELECT DEPT_TITLE, SUM(SALARY) FROM EMPLOYEE E
JOIN DEPARTMENT D  ON(E.DEPT_CODE= D.DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) FROM EMPLOYEE)*0.2;


--8-1. �μ��� �޿� �հ谡 ��ü �޿� �� ���� 20%���� ���� �μ��� �μ����, �μ��� �޿� �հ�
SELECT E.DEPT_CODE, E.SALARY FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
GROUP BY E.DEPT_CODE, E.SALARY;
HAVING SALARY > (SELECT SUM(SALARY)*0.2 FROM EMPLOYEE); 


