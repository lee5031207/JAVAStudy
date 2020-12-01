--TRIGGER
--���̺��� VIEW�� DML�� ���� ���� �� ���
--�ڵ����� ����� ������ PL/SQL�������� �����Ͽ� �����ϴ� ��ü

--TRIGGER�� ����
SET SERVEROUTPUT ON;
--1. SQL���� ���� �ñ⿡ ���� �з�
--  BEFORE TRIGGER : SQL�� ���� �� Ʈ���� ����
--  AFTER TRIGGER : SQL�� ���� �� Ʈ���� ����

--2. TRIGGER ���� Ƚ���� ���� �з�
--  ROW TRIGGER : DML�� ���� ������ ���� ���� �� ��ŭ TRIGGER ����
--  STATEMENT TRIGGER : �ѹ��� ����(DEFAULT)

--TRIGGER ���� ����
--CREATE OR REPLACE TRIGGER Ʈ���Ÿ�
-- BEFORE | AFTER
-- INSERT | UPDATE | DELETE    ���߿� ���� ����Ǹ� ����
-- ON ���̺��
-- [FOR EACH ROW]  -- ROW TRIGGER �ɼ�
-- DECLARE
-- �����
-- BEGIN
-- �����
-- [EXCCEPTION]
-- END;
-- /

--EMP_DEPT ���̺� INSERTR�� �߻��� ���
-- '���Ի���� �Ի��߽��ϴ�' ����ϴ� TRIGGER �ۼ�
CREATE OR REPLACE TRIGGER TG_WELCOME
AFTER INSERT ON EMP_DEPT
BEGIN
    DBMS_OUTPUT.PUT_LINE('���Ի���� �Ի��߽��ϴ�');
END;
/

INSERT INTO EMP_DEPT(EMP_ID,EMP_NAME,DEPT_TITLE)
VALUES(777,'�޽�','������');

INSERT INTO EMP_DEPT(EMP_ID,EMP_NAME,DEPT_TITLE)
VALUES(777,'ȣ����','������');

SELECT * FROM EMP_DEPT;
DELETE FROM EMP_DEPT;

-- EMP_DEPT���� �μ����� ����� ���� ����� ROW TRIGGER�� �ۼ��Ͻÿ�
-- :NEW >> DML�� ���� ����� ROW�� �����ϴ� REFERENCE
-- :OLD >> DML�� ���� ����Ǳ� �� ROW�� �����ϴ� REFERENCE
CREATE OR REPLACE TRIGGER TG_UPDATE_EMP_DEPT
AFTER UPDATE ON EMP_DEPT
FOR EACH ROW
BEGIN 
    DBMS_OUTPUT.PUT_LINE(
        :NEW.EMP_NAME || '�� �μ����� ' || :OLD.DEPT_TITLE || '  ����  '
        || :NEW.DEPT_TITLE || '�� ����Ǿ����ϴ�.'
    );
END;
/

UPDATE EMP_DEPT 
SET DEPT_TITLE = '�����ĳ�'
WHERE DEPT_TITLE = '������';

