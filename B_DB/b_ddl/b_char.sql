--CHAR 문자 입력하기
INSERT INTO TB_TYPE(CHAR_TEST) VALUES ('HELLO WORLD!');

--VARCHAR2 문자 입력하기 , VARCHAR2데이터를 사용하자 문자열에서는
INSERT INTO TB_TYPE(VARCHAR2_TEST) VALUES ('HELLO WORLD!');

--CLOB, BLOB에 데이터 입력하기
INSERT INTO TB_TYPE(CLOB_TEST) VALUES ('CLOB HELLO');
INSERT INTO TB_TYPE(BLOB_TEST) VALUES ('123456789');


--COMMIT : 테이블에 발생한 추가,수정,삭제 내역을 반영
-- 이전 COMMT 지점 이후에 발생한 변경 사항을 반영
COMMIT;

--ROLLBACK : 테이블에 발생한 추가, 수정, 삭제 내역을 반영하지 않고 되돌림 
-- 이전 COMMIT 직후 상태로 돌아간다

SELECT * FROM TB_TYPE;