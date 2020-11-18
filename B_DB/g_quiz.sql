--------------------------------------------------실습문제-------------------------------------------------------
-- BONUS, DEPT, EMP ,SALGRADE
--1. 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급을 출력하라.
SELECT ENAME, SAL FROM EMP 
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'SMITH');

--2. 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급,
-- 부서번호를 출력하라.
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE SAL IN (SELECT SAL FROM EMP WHERE DEPTNO = 10);

--3. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데
-- 'BLAKE'는 빼고 출력하라.
SELECT ENAME, HIREDATE FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='BLAKE')
AND NOT ENAME = 'BLAKE';

--4. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력하라.
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP) ORDER BY SAL DESC;

--5. 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고
-- 있는 사원의 사원번호와 이름을 출력하라.
SELECT EMPNO, ENAME FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

--6. 20번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다
-- 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하라.
--(단, ALL 또는 ANY 연산자를 사용할 것)  -> 이해가안감
SELECT ENAME, DEPTNO, SAL FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 20);

--7. 'DALLAS'에서 근무하고 있는 사원과 같은 부서에서 일하는 사원의
-- 이름, 부서번호, 직업을 출력하라.
SELECT ENAME, DEPTNO, JOB FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

--8. SALES 부서에서 일하는 사원들의 부서번호, 이름, 직업을 출력하라.
SELECT DEPTNO, ENAME, JOB FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

--9. 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력하라.
--    매니저가 king인 모든 사원의 이름과 급여를 출력하시오 
SELECT ENAME, SAL FROM EMP 
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');

--10. 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는
-- 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름,
-- 급여를 출력하라.
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
AND DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%S%');
--WHERE DEPTNO IN (
--SELECT DEPTNO FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP) AND ENAME LIKE '%S%');




--11. 커미션을 받는 사원과 부서번호, 월급이 같은 사원의
-- 이름, 월급, 부서번호를 출력하라.
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, SAL FROM EMP WHERE  COMM  IS NOT NULL); 

--12. 30번 부서 사원들과 월급과 커미션이 같지 않은
-- 사원들의 이름, 월급, 커미션을 출력하라.

SELECT ENAME, SAL, COMM FROM EMP
WHERE NOT (SAL,COMM)  IN (SELECT SAL,COMM FROM EMP WHERE DEPTNO=30);

