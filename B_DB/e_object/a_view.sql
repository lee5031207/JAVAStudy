--VIEW
--SELECT 쿼리의 실행결과를 저장하는 객체
--논리적인 가상테이블, 실질적으로 데이터를 저장하고 있지는 않지만
-- 본테이블과 참조되어있기 때문에 테이블을 사용하는 것처럼 DML 활용 가능
--[VIEW 생성 표현식]
-- CREATE [OR REPLACE] VIEW 뷰이름 AS SUBQUERY
-- [OR REPLACE] : VIEW를 생성할 때 만약 같은 이름의 VIEW가 있다면 해당 VIEW를 덮어쓴다.

-- 사번, 이름, 부서명, 근무 지역을 조회하고
-- 그결과를 V_EMPLOYEE 라는 VIEW에 저장하시오
CREATE OR REPLACE VIEW V_EMPLOYEE
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON(E.DEPT_CODE =D.DEPT_ID)
LEFT JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE);

SELECT * FROM V_EMPLOYEE;

-- 참조되는 테이블이 변하면 VIEW도 변경되는지 확인


-- VIEW가 변경되면 BASE TABLE도 함께 변경

INSERT INTO V_EMPLOYEE(EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME)
VALUES (999,'하명도','자바학부','ASIA1);