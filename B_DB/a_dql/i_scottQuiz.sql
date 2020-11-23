-- SCOTT 함수 연습문제 


-- 1. COMM 의 값이 NULL이 아닌 정보 조회
SELECT * FROM EMP
WHERE COMM IS NOT NULL;


-- 2. 커미션을 받지 못하는 직원 조회
SELECT * FROM EMP
WHERE COMM IS NULL;


-- 3. 관리자가 없는 직원 정보 조회
SELECT * FROM EMP
WHERE MGR IS NULL;

-- 4. 급여를 많이 받는 직원 순으로 조회
SELECT * FROM EMP
ORDER BY SAL DESC;

-- 5. 급여가 같을 경우 커미션을 내림차순 정렬 조회
SELECT * FROM EMP
ORDER BY SAL DESC, COMM DESC;


-- 6. EMP 테이블에서 사원번호, 사원명,직급, 입사일 조회
-- 단 입사일을 오름차순 정렬 처리함.
SELECT EMPNO, ENAME, JOB, HIREDATE
FROM EMP
ORDER BY HIREDATE;
      
-- 7. EMP 테이블로 부터 사원번호, 사원명 조회
-- 사원번호 기준 내림차순 정렬
SELECT EMPNO,ENAME
FROM EMP
ORDER BY EMPNO DESC;

-- 8. 사번, 입사일, 사원명, 급여 조회
-- 부서번호가 빠른 순으로, 같은 부서번호일 때는 최근 입사일순으로 처리
SELECT EMPNO, HIREDATE, ENAME, SAL, DEPTNO
FROM EMP
ORDER BY DEPTNO, HIREDATE DESC;


/***** 함수 *****/

-- 9.시스템으로 부터 오늘 날짜에 대한 정보를 얻고자 할 때
SELECT SYSDATE FROM DUAL;

-- 10. EMP 테이블로 부터 사번, 사원명, 급여 조회
-- 단, 급여는 100단위 까지의 값만 출력 처리함.
-- 급여 기준 내림차순 정렬함.
SELECT EMPNO, ENAME, ROUND(SAL,-2) 
FROM EMP
ORDER BY SAL DESC;

-- 11. EMP 테이블로 부터 사원번호가 홀수인 사원들을 조회
SELECT * FROM EMP
WHERE MOD(EMPNO,2) = 1;

/* 문자 처리 함수*/  

-- 12. EMP 테이블로 부터 사원명, 입사일 조회
-- 단, 입사일은 년도와 월을 분리 추출해서 출력
SELECT ENAME, 
--EXTRACT(YEAR FROM HIREDATE) AS "입사한 년",
--EXTRACT(MONTH FROM HIREDATE) AS "입사한 달"
SUBSTR(HIREDATE,1,2) AS 입사년도,
SUBSTR(HIREDATE,4,2) AS 입사월
FROM EMP;

-- 13. EMP 테이블로 부터 9월에 입사한 직원의 정보 조회
SELECT * FROM EMP
WHERE EXTRACT(MONTH FROM HIREDATE) = 9;

-- 14. EMP 테이블로 부터 '81'년도에 입사한 직원 조회
SELECT * FROM EMP
WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;

-- 15. EMP 테이블로 부터 이름이 'E'로 끝나는 직원 조회
SELECT * FROM EMP
WHERE SUBSTR(ENAME,-1) = 'E';

-- 16. emp 테이블로 부터 이름의 세번째 글자가 'R'인 직원의 정보 조회
-- LIKE 연산자를 사용
SELECT * FROM EMP
WHERE ENAME LIKE '__R%';
-- SUBSTR() 함수 사용
SELECT * FROM EMP
WHERE SUBSTR(ENAME,3,1) = 'R';


/************ 날짜 처리 함수 **************/

-- 17. 입사일로 부터 40년 되는 날짜 조회
SELECT HIREDATE, ADD_MONTHS(HIREDATE,12*40)  FROM EMP;

-- 18. 입사일로 부터 33년 이상 근무한 직원의 정보 조회
SELECT * FROM EMP
WHERE  EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIREDATE) > 33;

-- 19. 오늘 날짜에서 년도만 추출
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;






   



