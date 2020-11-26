--VIEW
--SELECT ������ �������� �����ϴ� ��ü
--������ �������̺�, ���������� �����͸� �����ϰ� ������ ������
-- �����̺�� �����Ǿ��ֱ� ������ ���̺��� ����ϴ� ��ó�� DML Ȱ�� ����
--[VIEW ���� ǥ����]
-- CREATE [OR REPLACE] VIEW ���̸� AS SUBQUERY
-- [OR REPLACE] : VIEW�� ������ �� ���� ���� �̸��� VIEW�� �ִٸ� �ش� VIEW�� �����.

-- ���, �̸�, �μ���, �ٹ� ������ ��ȸ�ϰ�
-- �װ���� V_EMPLOYEE ��� VIEW�� �����Ͻÿ�
CREATE OR REPLACE VIEW V_EMPLOYEE
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON(E.DEPT_CODE =D.DEPT_ID)
LEFT JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE);

SELECT * FROM V_EMPLOYEE;

-- �����Ǵ� ���̺��� ���ϸ� VIEW�� ����Ǵ��� Ȯ��


-- VIEW�� ����Ǹ� BASE TABLE�� �Բ� ����

INSERT INTO V_EMPLOYEE(EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME)
VALUES (999,'�ϸ�','�ڹ��к�','ASIA1);