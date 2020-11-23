--------------------------------------------------�ǽ�����-------------------------------------------------------
-- BONUS, DEPT, EMP ,SALGRADE
--1. 'SMITH'���� ������ ���� �޴� ������� �̸��� ������ ����϶�.
SELECT ENAME, SAL FROM EMP 
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'SMITH');

--2. 10�� �μ��� ������ ���� ������ �޴� ������� �̸�, ����,
-- �μ���ȣ�� ����϶�.
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE SAL IN (SELECT SAL FROM EMP WHERE DEPTNO = 10);

--3. 'BLAKE'�� ���� �μ��� �ִ� ������� �̸��� ������� �̴µ�
-- 'BLAKE'�� ���� ����϶�.
SELECT ENAME, HIREDATE FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='BLAKE')
AND NOT ENAME = 'BLAKE';

--4. ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������
-- ����ϵ�, ������ ���� ��� ������ ����϶�.
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP) ORDER BY SAL DESC;

--5. �̸��� 'T'�� �����ϰ� �ִ� ������ ���� �μ����� �ٹ��ϰ�
-- �ִ� ����� �����ȣ�� �̸��� ����϶�.
SELECT EMPNO, ENAME FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

--6. 20�� �μ��� �ִ� ����� �߿��� ���� ���� ������ �޴� �������
-- ���� ������ �޴� ������� �̸�, �μ���ȣ, ������ ����϶�.
--(��, ALL �Ǵ� ANY �����ڸ� ����� ��)  -> ���ذ��Ȱ�
SELECT ENAME, DEPTNO, SAL FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 20);

--7. 'DALLAS'���� �ٹ��ϰ� �ִ� ����� ���� �μ����� ���ϴ� �����
-- �̸�, �μ���ȣ, ������ ����϶�.
SELECT ENAME, DEPTNO, JOB FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

--8. SALES �μ����� ���ϴ� ������� �μ���ȣ, �̸�, ������ ����϶�.
SELECT DEPTNO, ENAME, JOB FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

--9. 'KING'���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�.
--    �Ŵ����� king�� ��� ����� �̸��� �޿��� ����Ͻÿ� 
SELECT ENAME, SAL FROM EMP 
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');

--10. �ڽ��� �޿��� ��� �޿����� ����, �̸��� 'S'�� ����
-- ����� ������ �μ����� �ٹ��ϴ� ��� ����� �����ȣ, �̸�,
-- �޿��� ����϶�.
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
AND DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%S%');
--WHERE DEPTNO IN (
--SELECT DEPTNO FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP) AND ENAME LIKE '%S%');




--11. Ŀ�̼��� �޴� ����� �μ���ȣ, ������ ���� �����
-- �̸�, ����, �μ���ȣ�� ����϶�.
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, SAL FROM EMP WHERE  COMM  IS NOT NULL); 

--12. 30�� �μ� ������ ���ް� Ŀ�̼��� ���� ����
-- ������� �̸�, ����, Ŀ�̼��� ����϶�.

SELECT ENAME, SAL, COMM FROM EMP
WHERE NOT (SAL,COMM)  IN (SELECT SAL,COMM FROM EMP WHERE DEPTNO=30);

