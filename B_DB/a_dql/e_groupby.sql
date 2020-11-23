-- *** GROPU BY절***
-- 특정 컬럼을 기준으로 그룹을 만들어 그룹함수를 활용할 목적으로 사용
-- 그룹함수란 
-- SUM(컬럼명), AVG(컬럼명), COUNT(컬럼명), MAX(컬럼명), MIN(컬럼명), 

SELECT DEPT_CODE, SUM(SALARY), AVG(SALARY) FROM EMPLOYEE
GROUP BY DEPT_CODE;