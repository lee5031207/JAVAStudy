------------------------------------------INNER JOIN 실습--------------------------------


--1-1. 급여가 200만원 이상인 대리 직급 직원을 조회하세요 (ANSI)
SELECT EMP_NAME, SALARY, JOB_CODE, JOB_NAME
FROM EMPLOYEE E 
INNER JOIN  JOB J USING(JOB_CODE)
WHERE SALARY > 2000000 AND JOB_NAME ='대리';
--1-2. 급여가 200만원 이상인 대리 직급 직원을 조회하세요 (ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code=j.job_code AND SALARY > 2000000;

--2-1. 과장 직급 직원의 급여를 조회하세요(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J USING(JOB_CODE)
WHERE JOB_NAME ='과장';
--2-2. 과장 직급 직원의 급여를 조회하세요(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME ='과장';

--3-1.대리 직급의 직원들 중에서 과장직급의 최소 급여보다 많이 받는 직원을 조회(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J ON(E.JOB_CODE=J.JOB_CODE)
WHERE JOB_NAME = '대리' 
AND SALARY >
(SELECT MIN(SALARY) FROM EMPLOYEE E
INNER JOIN JOB J 
USING(JOB_CODE)
WHERE JOB_NAME = '과장');
--3-2.대리 직급의 직원들 중에서 과장직급의 최소 급여보다 많이 받는 직원을 조회(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME='대리' 
AND SALARY >
(SELECT MIN(SALARY)
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME = '과장');

---4-1 급여가 200만원 이상인 과장 직급 직원을 조회하세요(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J ON(E.JOB_CODE=J.JOB_CODE)
WHERE SALARY > 2000000 AND JOB_NAME = '과장';
---4-2 급여가 200만원 이상인 과장 직급 직원을 조회하세요(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME ='과장'
AND SALARY >2000000;

--5-1. 차장 직급 직원의 급여를 조회하세요(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J USING(JOB_CODE)
WHERE JOB_NAME ='차장';
--5-2. 차장 직급 직원의 급여를 조회하세요(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME ='차장';

--6-1.과장 직급의 직원들 중에서 차장직급의 최대 급여보다 많이 받는 직원을 조회(ANSI)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB J ON(E.JOB_CODE=J.JOB_CODE)
WHERE JOB_NAME = '과장' 
AND SALARY >
(SELECT MAX(SALARY) FROM EMPLOYEE E
INNER JOIN JOB J 
USING(JOB_CODE)
WHERE JOB_NAME = '차장');
--6-2.과장 직급의 직원들 중에서 차장직급의 최대 급여보다 많이 받는 직원을 조회(ORACLE)
SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME='과장' 
AND SALARY >
(SELECT MAX(SALARY)
FROM EMPLOYEE E, JOB J
WHERE e.job_code = j.job_code AND JOB_NAME = '차장');

--7-1 직급별 급여 평균과 같은 직급, 급여를 가진 직원을 조회하시오(ANSI)
SELECT EMP_NAME, SALARY
FROM EMPLOYEE E
WHERE (JOB_CODE, SALARY) IN 
(SELECT JOB_CODE, AVG(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE);
--7-2 직급별 급여 평균과 같은 직급, 급여를 가진 직원을 조회하시오(ORACLE)

--8. 강사님답 
--부서별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서명과, 부서별 급여 합계
SELECT DEPT_TITLE, SUM(SALARY) FROM EMPLOYEE E
JOIN DEPARTMENT D  ON(E.DEPT_CODE= D.DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) FROM EMPLOYEE)*0.2;


--8-1. 부서별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서명과, 부서별 급여 합계
SELECT E.DEPT_CODE, E.SALARY FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
GROUP BY E.DEPT_CODE, E.SALARY;
HAVING SALARY > (SELECT SUM(SALARY)*0.2 FROM EMPLOYEE); 


