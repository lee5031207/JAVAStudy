-- *** GROPU BY��***
-- Ư�� �÷��� �������� �׷��� ����� �׷��Լ��� Ȱ���� �������� ���
-- �׷��Լ��� 
-- SUM(�÷���), AVG(�÷���), COUNT(�÷���), MAX(�÷���), MIN(�÷���), 

SELECT DEPT_CODE, SUM(SALARY), AVG(SALARY) FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE AS �μ��ڵ�, JOB_CODE AS �����ڵ�,  COUNT(*) AS �����, SUM(SALARY) AS �հ�޿�
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;




