--NUMBER : 22BYTE ũ���� Ÿ��, 38�ڸ� ���� ǥ�� ����
--�ε��Ҽ���, �����Ҽ��� ǥ�� ����� ����

-- ***�ε��Ҽ��� ǥGUS ����� ����� ��
-- NUMBER_TEST NUMBER
INSERT INTO TB_TYPE(NUMBER_TEST) VALUES (12345.6789);
SELECT NUMBER_TEST FROM TB_TYPE;

--���� �Ҽ��� ǥ�� ���
--NUMBER(PRECISION, SCALE)
--PRECISION : �Ҽ����� ������ ��ü �ڸ���
--SCALE : �Ҽ��� ���� �ڸ��� (������ �ڸ����� PRECISION - SCALE)


--SCALE�� �����ϰ� PRECISION�� ������ ���
--�Ҽ������� �ݿø�ó���Ͽ� ������ ǥ��
--NUMBERR_TEST1 NUMBER(7)
INSERT INTO TB_TYPE(NUMBER_TEST1) VALUES(12345.6789);
SELECT NUMBER_TEST1 FROM TB_TYPE;

--SCALE�� ������ ���
--SCALE�� ������ �Ҽ��� �ڸ����� �ݿø� ó���Ͽ� ���ڸ� ǥ��
--NUMBERR_TEST1 NUMBER(7,1)
INSERT INTO TB_TYPE(NUMBER_TEST2) VALUES(12345.6789);
SELECT NUMBER_TEST2 FROM TB_TYPE;

--NUMBER_TEST3 NUMBER(7,3)
--PRECISION : 7, SCALE :3 ->������ 4�ڸ����� ǥ�� ����
INSERT INTO TB_TYPE(NUMBER_TEST3) VALUES(1234.6789);
SELECT NUMBER_TEST3 FROM TB_TYPE;

--NUMBER_TEST4 NUMBER(5,-2)
--SCALE�� ������ �����ϸ� �Ҽ����� ��������
--�������� SCALE�� ũ�⸸ŭ �̵��� �ڸ����� �ݿø� ó��
INSERT INTO TB_TYPE(NUMBER_TEST4) VALUES(1234.6789);
SELECT NUMBER_TEST4 FROM TB_TYPE;

------------------------------------------------------------------------------------------
--SCALE�� PRECISION���� ū ��� PRECISION�� 
--�Ҽ��� �ڸ��� �ִ� ������ ��ȿ�����ڸ����� ǥ��
-- ��ȿ�ڸ��� : �Ҽ��� �ڸ��� �ִ� �� �߿��� 0�� �ƴ� ���� �ǹ��Ѵ�
--SCALE�� ���е� ������ ������ �ȴ�. SCALE�� ������ �ͺ��� �� ������ ���� ���� ���� �� ����.

--NUMBER_TEST6 NUMBER(4,5)
INSERT INTO TB_TYPE(NUMBER_TEST6) VALUES (0.0234);
SELECT NUMBER_TEST6 FROM TB_TYPE;

--NUMBER_TEST7 NUMBER(4,5)
INSERT INTO TB_TYPE(NUMBER_TEST7) VALUES (0.0001234);

INSERT INTO TB_TYPE(NUMBER_TEST8) VALUES (0.0001234);

COMMIT;




