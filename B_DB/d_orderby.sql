-- *** ORDER BY ***
-- SELECT쿼리의 결과를 정렬할 때 사용하는 구문
-- SELECT문의 가장 마지막 작성, 실행 순서도 가장 마지막
-- 해석 순서 : FROM, WHERE, GROUP BY, HAVING, ORDDER BY 
-- SELECT 절에서 지정하지 않은 컬럼으로 정렬을 할 수 없습니다.
-- 작성 방법
-- SELECT 칼럼명 FROM 테이블명 WHERE 조건절 GROUP BY HAVING ORDER BY 컬럼명 
-- ORDER BY 컬럼명 ASC : 오름차순 / DEFAULT 는 오름차순이다
-- ORDER BY 컬럼명 DESC : 내림차순
-- NULLS FIRST : 만약 정렬하는 기준이 되는 컬럼에 NULL이 이 있을 경우 앞부분에 정렬
-- NULLS LAST : 만약 정렬하는 기준이 되는 컬럼에 NULL이 이 있을 경우 뒤부분에 정렬

--사원의 이름, 급여, 부서코드, 보너스, 연봉 레벨을 조회
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE

--1.이름으로 내림차순 정렬
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY EMP_NAME DESC;

--2.연봉으로 오름차순 정렬
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY SALARY;

--3.두번 째 컬럼으로 내림차순 정렬 (여기서는 SALARY기준으로  정렬)
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY 2 DESC;

--4.연봉 레벨으로 오름차순 정렬, 연봉레벨이 같은 ROW들은 연봉으로 내림차순 정렬
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY SAL_LEVEL, SALARY DESC;

--5.보너스로 오름차순 정렬, 정렬 기준이 되는 컬럼에 NULL이 있으면 위에 정렬
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY BONUS NULLS FIRST;

--6.보너스로 내림차순 정렬, 정렬 기준이 되는 컬럼에 NULL이 있으면 아래에 정렬
SELECT EMP_NAME, SALARY, DEPT_CODE, BONUS, SAL_LEVEL
FROM EMPLOYEE
ORDER BY BONUS DESC NULLS LAST;


