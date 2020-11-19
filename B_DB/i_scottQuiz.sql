-- SCOTT �Լ� �������� 


-- 1. COMM �� ���� NULL�� �ƴ� ���� ��ȸ
SELECT * FROM EMP
WHERE COMM IS NOT NULL;


-- 2. Ŀ�̼��� ���� ���ϴ� ���� ��ȸ
SELECT * FROM EMP
WHERE COMM IS NULL;


-- 3. �����ڰ� ���� ���� ���� ��ȸ
SELECT * FROM EMP
WHERE MGR IS NULL;

-- 4. �޿��� ���� �޴� ���� ������ ��ȸ
SELECT * FROM EMP
ORDER BY SAL DESC;

-- 5. �޿��� ���� ��� Ŀ�̼��� �������� ���� ��ȸ
SELECT * FROM EMP
ORDER BY SAL DESC, COMM DESC;


-- 6. EMP ���̺��� �����ȣ, �����,����, �Ի��� ��ȸ
-- �� �Ի����� �������� ���� ó����.
SELECT EMPNO, ENAME, JOB, HIREDATE
FROM EMP
ORDER BY HIREDATE;
      
-- 7. EMP ���̺�� ���� �����ȣ, ����� ��ȸ
-- �����ȣ ���� �������� ����
SELECT EMPNO,ENAME
FROM EMP
ORDER BY EMPNO DESC;

-- 8. ���, �Ի���, �����, �޿� ��ȸ
-- �μ���ȣ�� ���� ������, ���� �μ���ȣ�� ���� �ֱ� �Ի��ϼ����� ó��
SELECT EMPNO, HIREDATE, ENAME, SAL, DEPTNO
FROM EMP
ORDER BY DEPTNO, HIREDATE DESC;


/***** �Լ� *****/

-- 9.�ý������� ���� ���� ��¥�� ���� ������ ����� �� ��
SELECT SYSDATE FROM DUAL;

-- 10. EMP ���̺�� ���� ���, �����, �޿� ��ȸ
-- ��, �޿��� 100���� ������ ���� ��� ó����.
-- �޿� ���� �������� ������.
SELECT EMPNO, ENAME, ROUND(SAL,-2) 
FROM EMP
ORDER BY SAL DESC;

-- 11. EMP ���̺�� ���� �����ȣ�� Ȧ���� ������� ��ȸ
SELECT * FROM EMP
WHERE MOD(EMPNO,2) = 1;

/* ���� ó�� �Լ�*/  

-- 12. EMP ���̺�� ���� �����, �Ի��� ��ȸ
-- ��, �Ի����� �⵵�� ���� �и� �����ؼ� ���
SELECT ENAME, 
--EXTRACT(YEAR FROM HIREDATE) AS "�Ի��� ��",
--EXTRACT(MONTH FROM HIREDATE) AS "�Ի��� ��"
SUBSTR(HIREDATE,1,2) AS �Ի�⵵,
SUBSTR(HIREDATE,4,2) AS �Ի��
FROM EMP;

-- 13. EMP ���̺�� ���� 9���� �Ի��� ������ ���� ��ȸ
SELECT * FROM EMP
WHERE EXTRACT(MONTH FROM HIREDATE) = 9;

-- 14. EMP ���̺�� ���� '81'�⵵�� �Ի��� ���� ��ȸ
SELECT * FROM EMP
WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;

-- 15. EMP ���̺�� ���� �̸��� 'E'�� ������ ���� ��ȸ
SELECT * FROM EMP
WHERE SUBSTR(ENAME,-1) = 'E';

-- 16. emp ���̺�� ���� �̸��� ����° ���ڰ� 'R'�� ������ ���� ��ȸ
-- LIKE �����ڸ� ���
SELECT * FROM EMP
WHERE ENAME LIKE '__R%';
-- SUBSTR() �Լ� ���
SELECT * FROM EMP
WHERE SUBSTR(ENAME,3,1) = 'R';


/************ ��¥ ó�� �Լ� **************/

-- 17. �Ի��Ϸ� ���� 40�� �Ǵ� ��¥ ��ȸ
SELECT HIREDATE, ADD_MONTHS(HIREDATE,12*40)  FROM EMP;

-- 18. �Ի��Ϸ� ���� 33�� �̻� �ٹ��� ������ ���� ��ȸ
SELECT * FROM EMP
WHERE  EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIREDATE) > 33;

-- 19. ���� ��¥���� �⵵�� ����
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;






   



