-- *** GROPU BY절***
-- 특정 컬럼을 기준으로 그룹을 만들어 그룹함수를 활용할 목적으로 사용
-- 그룹함수란 
-- SUM(컬럼명), AVG(컬럼명), COUNT(컬럼명), MAX(컬럼명), MIN(컬럼명), 

SELECT DEPT_CODE, SUM(SALARY), AVG(SALARY) FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE AS 부서코드, JOB_CODE AS 직급코드,  COUNT(*) AS 사원수, SUM(SALARY) AS 합계급여
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;




