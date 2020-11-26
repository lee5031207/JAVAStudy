--DCL
--���Ѱ��� 
-- *** ������ ���� : �����ͺ��̽��� ������ ������  ����ϴ� ���� ����
--                        �����ͺ��̽��� ���� ��� ���Ѱ� å���� ������ �ִ�. (DBA)
-- *** ����� ����  : �����ͺ��̽����� ������ ���� �۾��� �����ϴ� ����
--                         �ý��� ������ ������ ���� ������ �ʿ��� �ּ����� ���Ѹ��� ������

-- 1. ��������
-- CREATE USER ���̵� IDENTIFIED BY PASSWORD;
CREATE USER bookmanager IDENTIFIED BY user11;


--2. ���Ѻο�
-- BM�������� CREATE SESSION������ �ο�����!
-- GRANT ���� �̸�, ���� �̸� ... TO �����ID
GRANT CREATE SESSION TO bookmanager;

--3. ����ȸ��
-- REVOKE  ���� ����,  ���� �̸�... FROM �����ID
REVOKE CREATE SESSION FROM bookmanager;

--4. ROLE : �پ��� ������ �ϳ��� �̸����� ������� ��
-- RESOURCE, CONNECT
-- RESOURCE : ����ڰ� ��ü�� ������ �� �ֵ��� ��ü������ ���õ� ���ѵ��� ����
--                  CREATE TABLE, CREATE VIEW, CREATE SEQUENCE, CREATE TRIGGER
-- CONNECT : ������� ���ٰ� ���õ� ���ѵ��� ����
--                  CREATE SESSION


--BM������ ROLE�� Ȱ���� ������ �ο�
GRANT CONNECT, RESOURCE TO bookmanager;


--ROLE�� ����
--ǥ�� ���
--CREATE ROLE ROLE�̸�;
--GRANT �����̸�, �����̸� .. TO ROLE�̸�

CREATE ROLE BOOKMANAGER_ROLE;

GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW, CREATE SEQUENCE
TO BOOKMANAGER_ROLE;


