--1. �μ���� �μ��� ��ձ޿��� ���Ͻÿ�
--��� �޿��� �Ҽ������� ����ó���Ͽ� ������ ǥ���ϼ���
--�μ��� ����� �������� �ʾ� ��ձ޿��� null�ϰ��� 0������ ǥ���ϼ���
SELECT DEPT_TITLE, NVL(FLOOR(AVG(SALARY)),0) AS ��ձ޿�
FROM EMPLOYEE E
RIGHT JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
GROUP BY DEPT_TITLE;

--2. �� �μ��� �޿��� �հ���� ���Ͽ�, 
--�μ� �޿����� 100���� �ʰ��ϴ� �μ���� �μ��� �޿��հ踦 ��ȸ�ϴ�
--SELECT ���� �ۼ��Ͻÿ�.
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE 
HAVING SUM(SALARY) > 1000000;


--3. �����, �ֹι�ȣ, ����, �Ի���, 
--���� ��¥ ���� ��������� �ٹ������ ��ȸ�ϴ� SELECT ���� �ۼ��Ͻÿ�.
--�� ���̿� �ٹ������ �� ���� �����ϼ���
SELECT EMP_NAME, EMP_NO,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6))) AS ����,
HIRE_DATE,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) AS �ٹ����
FROM EMPLOYEE;


--4. ���� ���̺��� 
--���, �̸�, �μ���, ���޸�, �Ի���, ���ʽ��� ������ ����, ����
--�� ����ϼ���.
SELECT ROWNUM, EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, HIRE_DATE,
SALARY*(1+NVL(BONUS,0))*12 AS ����
FROM  (
    SELECT * 
    FROM EMPLOYEE E
    INNER JOIN DEPARTMENT D ON(E.DEPT_CODE=D.DEPT_ID)
    INNER JOIN JOB J USING(JOB_CODE)
    ORDER BY SALARY*(1+NVL(BONUS,0))*12 DESC
);


--5. ���� ���̺��� ���ʽ� ������ ������ ���� 5����
-- ���, �̸�, �μ���, ���޸�, �Ի����� ��ȸ�ϼ���
SELECT ROWNUM, EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, HIRE_DATE,
SALARY*(1+NVL(BONUS,0))*12 AS ����
FROM  (
    SELECT * 
    FROM EMPLOYEE E
    INNER JOIN DEPARTMENT D ON(E.DEPT_CODE=D.DEPT_ID)
    INNER JOIN JOB J USING(JOB_CODE)
    ORDER BY SALARY*(1+NVL(BONUS,0))*12 DESC
)WHERE ROWNUM <=5;


--6.70��� ���̸鼭 ������ �����̰� ���� ������ �����
--�̸�, �ֹε�Ϲ�ȣ, �μ���, �������� ����ϼ���.
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J USING(JOB_CODE)
WHERE EMP_NO LIKE '7%'
AND EMP_NAME LIKE '��%'
AND SUBSTR(EMP_NO,8,1) = 2;


--7. �̸��� '��'�� ���� ����� ���ID, ����̸�, �������� ����ϼ��� 
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB USING(JOB_CODE)
WHERE EMP_NAME LIKE '%��%';

--8. �μ����� D5, D6 �� ����� �̸�, ������, �μ��ڵ�, �μ����� ����ϼ���
SELECT EMP_NAME, JOB_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J USING(JOB_CODE)
WHERE DEPT_CODE IN ('D5','D6');

--9. ���, �����, �޿�
--�޿��� 500���� �̻��̸� '���'
--�޿��� 300~500�����̸� '�߱�'
--�� ���ϴ� '�ʱ�'���� ���ó�� �ϰ� ��Ī�� '����' ���� �Ѵ�.
SELECT EMP_ID, EMP_NAME, SALARY,
CASE WHEN SALARY >= 5000000 THEN '���'
         WHEN SALARY >= 3000000 THEN '�߱�'
         ELSE '�ʱ�'
         END AS ����
FROM EMPLOYEE;


--10. �ֹι�ȣ �� 6�ڸ�(�������) �߿��� (���X)
--���� ��Ÿ���� ���ڰ� 12���� ũ�ų�
--���� ��Ÿ���� ���ڰ� 30���� ū ���
--���� ��� 12��
--���� ��� 30�� �ٲ㼭 �̸��� �Բ� ����ϴ� ������ �ۼ��ϼ���
-- 619988-1111111  -> 611231 - 1111111
SELECT EMP_NAME,
SUBSTR(EMP_NO,1,2) ||
CASE WHEN SUBSTR(EMP_NO,3,2) > 12
OR SUBSTR(EMP_NO,5,2) > 30 THEN '1230'
ELSE  SUBSTR(EMP_NO,3,4)
END
|| SUBSTR(EMP_NO,7) AS �ֹι�ȣ
FROM EMPLOYEE;

--11. �μ����� ���� � ����� ���ID, �̸�, ����, �μ���, �������� ����ϼ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6))) AS ����,
DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J USING(JOB_CODE)
WHERE (DEPT_CODE, TO_DATE(SUBSTR(EMP_NO,1,6))) IN(
    SELECT DEPT_CODE, MAX(TO_DATE(SUBSTR(EMP_NO,1,6))) AS MINAGE
    FROM EMPLOYEE E
GROUP BY DEPT_CODE);
-- ȸ�� ��ü
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6))) AS ����,
DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J  USING(JOB_CODE)
WHERE  TO_DATE(SUBSTR(EMP_NO,1,6)) = (SELECT MAX(TO_DATE(SUBSTR(EMP_NO,1,6))) FROM EMPLOYEE );

--12. ���ʽ��� ���� ����� �����, ���ʽ�, �μ���, �������� ����ϼ���
SELECT EMP_NAME, BONUS, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE=D.DEPT_ID)
INNER JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
WHERE BONUS IS NOT NULL;

--13. �μ��� ��ġ�� ������ �ѱ��̳� �Ϻ��� �����
--�̸�, �μ���, ������, �������� ����Ͻÿ�
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON(l.national_code = N.national_code)
WHERE NATIONAL_NAME IN('�ѱ�','�Ϻ�');


--14. job_code�� 'J4', 'J7'�̸鼭 ���ʽ��� ���� ���� ����� 
--�̸�, ���޸�, �޿�, ���ʽ��ݾ�(0������) ����ϼ���
SELECT EMP_NAME, JOB_NAME, SALARY, NVL(BONUS,0)
FROM EMPLOYEE
INNER JOIN JOB J USING(JOB_CODE)
WHERE JOB_CODE IN('J4','J7')
AND BONUS IS NULL;















