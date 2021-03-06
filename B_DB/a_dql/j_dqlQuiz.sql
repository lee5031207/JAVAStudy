--1. 부서명과 부서별 평균급여를 구하시오
--평균 급여는 소수점에서 내림처리하여 정수로 표현하세요
--부서에 사원이 존재하지 않아 평균급여가 null일경우는 0원으로 표시하세요
SELECT DEPT_TITLE, NVL(FLOOR(AVG(SALARY)),0) AS 평균급여
FROM EMPLOYEE E
RIGHT JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
GROUP BY DEPT_TITLE;

--2. 각 부서별 급여의 합계들을 구하여, 
--부서 급여합이 100만을 초과하는 부서명과 부서별 급여합계를 조회하는
--SELECT 문을 작성하시오.
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE 
HAVING SUM(SALARY) > 1000000;


--3. 사원명, 주민번호, 나이, 입사일, 
--오늘 날짜 기준 현재까지의 근무년수를 조회하는 SELECT 문을 작성하시오.
--단 나이와 근무년수는 만 으로 적용하세요
SELECT EMP_NAME, EMP_NO,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6))) AS 나이,
HIRE_DATE,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) AS 근무년수
FROM EMPLOYEE;


--4. 직원 테이블에서 
--사번, 이름, 부서명, 직급명, 입사일, 보너스를 포함한 연봉, 순위
--를 출력하세요.
SELECT ROWNUM, EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, HIRE_DATE,
SALARY*(1+NVL(BONUS,0))*12 AS 연봉
FROM  (
    SELECT * 
    FROM EMPLOYEE E
    INNER JOIN DEPARTMENT D ON(E.DEPT_CODE=D.DEPT_ID)
    INNER JOIN JOB J USING(JOB_CODE)
    ORDER BY SALARY*(1+NVL(BONUS,0))*12 DESC
);


--5. 직원 테이블에서 보너스 포함한 연봉이 높은 5명의
-- 사번, 이름, 부서명, 직급명, 입사일을 조회하세요
SELECT ROWNUM, EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, HIRE_DATE,
SALARY*(1+NVL(BONUS,0))*12 AS 연봉
FROM  (
    SELECT * 
    FROM EMPLOYEE E
    INNER JOIN DEPARTMENT D ON(E.DEPT_CODE=D.DEPT_ID)
    INNER JOIN JOB J USING(JOB_CODE)
    ORDER BY SALARY*(1+NVL(BONUS,0))*12 DESC
)WHERE ROWNUM <=5;


--6.70년대 생이면서 성별이 여성이고 성이 전씨인 사원의
--이름, 주민등록번호, 부서명, 직업명을 출력하세요.
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J USING(JOB_CODE)
WHERE EMP_NO LIKE '7%'
AND EMP_NAME LIKE '전%'
AND SUBSTR(EMP_NO,8,1) = 2;


--7. 이름에 '형'이 들어가는 사원의 사원ID, 사원이름, 직업명을 출력하세요 
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE E
INNER JOIN JOB USING(JOB_CODE)
WHERE EMP_NAME LIKE '%형%';

--8. 부서명이 D5, D6 인 사원의 이름, 직업명, 부서코드, 부서명을 출력하세요
SELECT EMP_NAME, JOB_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J USING(JOB_CODE)
WHERE DEPT_CODE IN ('D5','D6');

--9. 사번, 사원명, 급여
--급여가 500만원 이상이면 '고급'
--급여가 300~500만원이면 '중급'
--그 이하는 '초급'으로 출력처리 하고 별칭은 '구분' 으로 한다.
SELECT EMP_ID, EMP_NAME, SALARY,
CASE WHEN SALARY >= 5000000 THEN '고급'
         WHEN SALARY >= 3000000 THEN '중급'
         ELSE '초급'
         END AS 구분
FROM EMPLOYEE;


--10. 주민번호 앞 6자리(생년월일) 중에서 (결과X)
--월을 나타내는 숫자가 12보다 크거나
--일을 나타내는 숫자가 30보다 큰 경우
--월의 경우 12로
--일의 경우 30로 바꿔서 이름과 함께 출력하는 쿼리를 작성하세요
-- 619988-1111111  -> 611231 - 1111111
SELECT EMP_NAME,
SUBSTR(EMP_NO,1,2) ||
CASE WHEN SUBSTR(EMP_NO,3,2) > 12
OR SUBSTR(EMP_NO,5,2) > 30 THEN '1230'
ELSE  SUBSTR(EMP_NO,3,4)
END
|| SUBSTR(EMP_NO,7) AS 주민번호
FROM EMPLOYEE;

--11. 부서에서 가장 어린 사원의 사원ID, 이름, 나이, 부서명, 직업명을 출력하세요
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6))) AS 나이,
DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J USING(JOB_CODE)
WHERE (DEPT_CODE, TO_DATE(SUBSTR(EMP_NO,1,6))) IN(
    SELECT DEPT_CODE, MAX(TO_DATE(SUBSTR(EMP_NO,1,6))) AS MINAGE
    FROM EMPLOYEE E
GROUP BY DEPT_CODE);
-- 회사 전체
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6))) AS 나이,
DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J  USING(JOB_CODE)
WHERE  TO_DATE(SUBSTR(EMP_NO,1,6)) = (SELECT MAX(TO_DATE(SUBSTR(EMP_NO,1,6))) FROM EMPLOYEE );

--12. 보너스를 받은 사원의 사원명, 보너스, 부서명, 지역명을 출력하세요
SELECT EMP_NAME, BONUS, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE=D.DEPT_ID)
INNER JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
WHERE BONUS IS NOT NULL;

--13. 부서가 위치한 국가가 한국이나 일본인 사원의
--이름, 부서명, 지역명, 국가명을 출력하시오
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON(l.national_code = N.national_code)
WHERE NATIONAL_NAME IN('한국','일본');


--14. job_code가 'J4', 'J7'이면서 보너스를 받지 못한 사원의 
--이름, 직급명, 급여, 보너스금액(0원으로) 출력하세요
SELECT EMP_NAME, JOB_NAME, SALARY, NVL(BONUS,0)
FROM EMPLOYEE
INNER JOIN JOB J USING(JOB_CODE)
WHERE JOB_CODE IN('J4','J7')
AND BONUS IS NULL;















