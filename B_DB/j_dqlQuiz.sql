--1. 부서명과 부서별 평균급여를 구하시오
--평균 급여는 소수점에서 내림처리하여 정수로 표현하세요
--부서에 사원이 존재하지 않아 평균급여가 null일경우는 0원으로 표시하세요
SELECT 
FLOOR(AVG(E.SAL)) AS 평균급여,
E.DEPTNO AS 부서코드,
D.DNAME AS 부서이름
FROM EMP E  JOIN DEPT D ON D.DEPTNO = E.DEPTNO
GROUP BY D.DNAME, E.DEPTNO;

--2. 각 부서별 급여의 합계들을 구하여, 
--부서 급여합이 100만을 초과하는 부서명과 부서별 급여합계를 조회하는
--SELECT 문을 작성하시오.
SELECT D.DNAME, E.DEPTNO, SUM(E.SAL) AS 부서별급여합
FROM EMP E INNER JOIN DEPT D ON D.DEPTNO = E.DEPTNO
GROUP BY D.DNAME, E.DEPTNO;


--3. 사원명, 주민번호, 나이, 입사일, 
--오늘 날짜 기준 현재까지의 근무년수를 조회하는 SELECT 문을 작성하시오.
--단 나이와 근무년수는 만 으로 적용하세요

--4. 직원 테이블에서 
--사번, 이름, 부서명, 직급명, 입사일, 보너스를 포함한 연봉, 순위
--를 출력하세요.
SELECT ROWNUM, E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME, E.HIRE_DATE,
E.SALARY*(NVL(E.BONUS,0)+1) AS 보너스포함연봉
FROM (
EMPLOYEE E
INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
INNER JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
)
ORDER BY E.SALARY*(NVL(E.BONUS,0)+1) DESC;
--ORDER BY E.SALARY*(NVL(E.BONUS,0)+1) DESC



--5. 직원 테이블에서 보너스 포함한 연봉이 높은 5명의
-- 사번, 이름, 부서명, 직급명, 입사일을 조회하세요


--6.70년대 생이면서 성별이 여성이고 성이 전씨인 사원의
--이름, 주민등록번호, 부서명, 직업명을 출력하세요.


--7. 이름에 '형'이 들어가는 사원의 사원ID, 사원이름, 직업명을 출력하세요 


--8. 부서명이 D5, D6 인 사원의 이름, 직업명, 부서코드, 부서명을 출력하세요


--9. 사번, 사원명, 급여
--급여가 500만원 이상이면 '고급'
--급여가 300~500만원이면 '중급'
--그 이하는 '초급'으로 출력처리 하고 별칭은 '구분' 으로 한다.


--10. 주민번호 앞 6자리(생년월일) 중에서 (결과X)
--월을 나타내는 숫자가 12보다 크거나
--일을 나타내는 숫자가 30보다 큰 경우
--월의 경우 12로
--일의 경우 30로 바꿔서 이름과 함께 출력하는 쿼리를 작성하세요
-- 619988-1111111  -> 611231 - 1111111


--11. 부서에서 가장 어린 사원의 사원ID, 이름, 나이, 부서명, 직업명을 출력하세요


--12. 보너스를 받은 사원의 사원명, 보너스, 부서명, 지역명을 출력하세요


--13. 부서가 위치한 국가가 한국이나 일본인 사원의
--이름, 부서명, 지역명, 국가명을 출력하시오


--14. job_code가 'J4', 'J7'이면서 보너스를 받지 못한 사원의 
--이름, 직급명, 급여, 보너스금액(0원으로) 출력하세요
















