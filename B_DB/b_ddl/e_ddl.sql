-- CREATE TABLE ���̺�� (�÷���  Ÿ��  �������� ...);

CREATE TABLE MY_EMPLOYEE(
    -- �������� ���� �÷��� �߰�
    PHONE VARCHAR2(13),
    
    --DEFAULT : �⺻ �� ����, �����Ͱ� ���̺� �Էµ� �� �ش� �÷��� ���� ���� ���ٸ�
    --               �⺻ ������ ������ ���� �Է�
    HIRE_DATE DATE DEFAULT SYSDATE,
    
    --�������Ἲ(UNIQUE) : ���̺��� Ư�� �÷� ���� ���ؼ� �� ROW�� 
    --                               ������ ������ ���� �޶�� �Ѵٴ� ����
    ENO CHAR(14) UNIQUE,
    
    --NULL ���Ἲ(NOT NULL) : ���̺��� Ư�� �÷� ���� NULL �� �� �� ������ �ϴ� ����
    ENAME VARCHAR2(20) NOT NULL,
    
    
    --DOMAIN���Ἲ(CHECK) : Ư�� �÷����� �� �÷��� ���ǵ� 
    --                                   ������(����)�� ���� ���̾�� �Ѵٴ� ����
    MARRIAGE CHAR(1) DEFAULT 'N' CHECK(MARRIAGE IN('Y','N')),
    AGE NUMBER CHECK(AGE>20),
    
    --�⺻Ű(PRIMARY KEY) ����
    --�⺻Ű�� ���̺��� �� ���� �����ϰ� �ĺ��ϴ� ������ ����Ѵ�.
    --���̺� �� �ϳ��� ���� ����
    --�⺻Ű�� �ĺ�Ű�� ���̺��� ��ǥ�ϴ� Ű�̴�. 
    --���� �ĺ�Ű�� ������ �ּҼ��� ���ϼ��� �����ؾ� �Ѵ�.
    --�⺻Ű�� ������ �ĺ�Ű���� ��üŰ��� �̾߱��Ѵ�.
    --�⺻Ű�� �����ϸ� ���� �ε����� �ڵ����� ������ �ȴ�.
    --�ε��� : �����ͺ��̽����� �˻� ������ ����ȭ �ϱ� ���� ����ϴ� �÷� ������ ������ ������ ����
    -- �ε����� ����ϸ� ���ϴ� ������ ������ �˻��� �� �ִ�.
    EID CHAR(10) PRIMARY KEY
    
    
    --�������� �ɾ��ֱ�
    -- CONSTRAINT ���� ���Ǹ� �������� ����(�÷���)
    
    
    --���� �°Ἲ : �⺻Ű�� ����Ű ���� ���谡 �׻� ����
    --�θ� ���̺��� �ڽ��� ���� �ϰ� �ִ� �ڽ� ���̺��� �������� �ʴ� ��, ���� �� �� ����
    --�ڽ� ���̺��� �θ����̺��� �÷��� �������� �ʴ� ���� �÷� ������ ���� �� ����.
    --CONSTRAINT �������Ǹ� FOREIGN KEY(�÷���) REFERENCES �θ����̺��(�÷���)
    --ON UPDATE CASCADE : �θ����̺��� �÷��� �����Ǹ� �ڽ� ���̺� ���� ����
    --ON DELETE CASCADE : �θ����̺��� ROW�� �����Ǹ� �ڽ����̺��� �൵ ���� ����
    --ON DELETE SET NULL : �θ����̺��� ROW�� �����Ǹ� �ڽ����̺��� �÷� ���� NULL�� ����
);  

--1. AGE�� 20���� ���� ���� �ְ� MARRIAGE�� Z�� �־� 
--   ������ ���Ἲ�� ��ܺ���!
INSERT INTO MY_EMPLOYEE (ENAME, AGE, MARRIAGE, EID) VALUES ('�̼���',19,'Z','AAA');

--2. NOT NULL�� ������ �÷��� NULL�� �־� NULL���Ἲ�� ��ܺ���
--INSERT ������ ���� �������� ���� �÷��� �ڵ����� NULL�� ���� �ȴ�
--INSERT INTO MY_EMPLOYEE (AGE, MARRIAGE) VALUES (19,'Z');

--3. PRIMARY KEY�� ������ E_ID�� NULL���� �־ �⺻Ű�� �ּҼ��� Ȯ���ϰ�
--   �ߺ��� ���� �־ �⺻Ű�� ���ϼ��� Ȯ��
INSERT INTO MY_EMPLOYEE (ENAME, AGE, MARRIAGE, EID) VALUES ('�̼���',21,'N','AAA');

--4. HIRE_DATE�� NULL�� �־ DEFAULT�� ������ ���� �� �ԷµǴ��� Ȯ��

--SELECT���� Ȱ���ؼ� ���̺� ����
--CREATE TABLE COPY_EMPLOYEE
--AS SELECT * FROM EMPLOYEE;
--SELECT * FROM COPY_EMPLOYEE;
--DROP TABLE COPY_EMPLOYEE;

--���̺� �÷��� �����ؿ���, ������ (X)
--CREATE TABLE COPY_EMPLOYEE
--AS SELECT * FROM EMPLOYEE WHERE 1=0;
--SELECT * FROM COPY_EMPLOYEE;
--DROP TABLE COPY_EMPLOYEE;


-----------------------------------------------------------------------------------------------------
--���̺� ����
--1. �÷�
-- ALTER TABLE ���̺�� ADD|MODIFY|DROP (�÷��� Ÿ�� DEFAULT ��������)

-- 1-1. �÷� �߰�(ADD)
ALTER TABLE MY_EMPLOYEE ADD(JOB_CODE CHAR(2));
SELECT * FROM MY_EMPLOYEE;
-- 1-2. �÷� ����(MODIFY)
-- �÷��� Ÿ���� ���� �Ұ�, �� ���̺�  �����Ͱ� �ϳ��� ������ Ÿ�Ժ��� ����
-- �÷��� ũ��� ���ݺ��� ū ũ��θ� ���� ����
-- NOT NULL ���������� ������ �� �ִ�. �� �̹� NULL�� ���� �����ϸ� ���� �Ұ�
-- UNIQUE ���������� ������ �� �ִ�. ��, �̹� �ߺ��� �����Ͱ� ������ ���� �Ұ�
ALTER TABLE MY_EMPLOYEE MODIFY(JOB_CODE CHAR(10));
ALTER TABLE MY_EMPLOYEE MODIFY(JOB_CODE NOT NULL);
INSERT INTO MY_EMPLOYEE (ENAME, AGE, MARRIAGE, EID, JOB_CODE) VALUES ('�纸��',21,'N','BBB','J7');
INSERT INTO MY_EMPLOYEE (ENAME, AGE, MARRIAGE, EID, JOB_CODE) VALUES ('�纸��',21,'N','CCC','J7');
ALTER TABLE MY_EMPLOYEE MODIFY(JOB_CODE UNIQUE);
-- 1-3. �÷� ����(DROP)
ALTER TABLE MY_EMPLOYEE DROP COLUMN JOB_CODE;


-- �⺻Ű �߰��ϱ�, �⺻Ű �����ϱ�
ALTER TABLE MY_EMPLOYEE ADD PRIMARY KEY(ENAME);

--���� �⺻Ű ����
ALTER TABLE MY_EMPLOYEE DROP PRIMARY KEY;

--�������� �߰��ϱ�, �������� �����ϱ�
--MY_EMPLOYEE ���̺��� ENO�÷��� NOT NULL �������� �߰�
--ALTER TABLE ���̺�� ADD CONSTRAINT �������Ǹ� ���� ���� ���� (�÷���)
ALTER TABLE MY_EMPLOYEE ADD CONSTRAINT ENO_NULL CHECK (ENO IS NOT NULL);
SELECT * FROM MY EMPLOYEE;

--�������� �����ϱ�
--ALTER TABLE ���̺�� DROP CONSTRAINT �������Ǹ�

--���̺� ����
--DROP TABLE ���̺��
DROP TABLE MY_EMPLOYEE;
--DROP TABLE ���̺�� CASCADE CONSTRAINT;
--���̺�� ���������� ���̺��� ���� �������ǵ� �Բ� ����

--�ܷ�Ű �߰�
--ALTER TABLE ���̺�� ADD CONSTRAINT �������Ǹ� FOREIGN KEY(�÷���) REFERNCES �θ����̺��(�÷���)
ALTER TABLE TB_BOARD ADD CONSTRAINT FK_BOARD_MEMBER
FOREIGN KEY(USER_ID) REFERENCES TB_MEMBER(USER_ID);
--�ܷ�Ű ����
--ALTER TABLE ���̺�� DROP CONSTRAINT �������Ǹ�;
ALTER TABLE TB_BOARD DROP CONSTRAINT FK_BOARD_MEMBER;


--[����]
-- DATA DICTIONARY : ������ ����
--�б� �������� �����Ǵ� ���̺� �Ǵ� VIEW�� ����, �����ͺ��̽� ���ݿ� ���� ������ ����
--����� ����, ���� ����, ���� ����, ��ü���� ���
-- �������ǿ� ���� ������ ��� �ִ� DICTIONARY ��ȸ
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TB_BOARD';

