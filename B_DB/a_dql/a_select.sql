--select
--테이블에서 원하는 데이터를 조회하는 구문
--select문의 결과물 -> result set(반환된 행들의 집합)
--작성법 : select 컬럼명 from 테이블명 where 조건식
--테이블에서 조건식에 부합하는 row들의 컬럼 값들을 조회

-- 주석 : --
-- 대소문자 구분 X

-------------실습-------------
--1. JOB테이블의 직급 이름 조회
SELECT JOB_NAME FROM JOB;

--2. EMPLOYEE테이블의 사번과 이름, 급여를 조회
SELECT EMP_ID,EMP_NAME,SALARY FROM EMPLOYEE;

--4. JOB 테이블의 모든 정보 조회
SELECT * FROM JOB;

--5. DEPARTMENT 테이블의 모든 정보 조회
SELECT * FROM DEPARTMENT;

--6. EMPLOYEE 테이블의 직원명, 이메일, 전화번호, 고용일 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE FROM EMPLOYEE;

--7. EMPLOYEE 테이블의 고용일, 사원 이름, 월급 조회
SELECT HIRE_DATE, EMP_NAME, SALARY FROM EMPLOYEE;

-- ***산술연산자 : +,-,*,/***
--SELECT문 작성시 SELECT절 에 산술연산을 이용하여 결과를 조회

--1. EMPLOYEE 테이블에서 직워느이 이름과 연봉을 조회(연봉은 급여 X 12)
SELECT EMP_NAME, SALARY*12 FROM EMPLOYEE;
SELECT EMP_NAME AS 사원명, SALARY*12 AS 연봉 FROM EMPLOYEE;

--실습--
--1. EMPLOYEE 테이블에서 직원의 이름, 연봉, 보너스를 추가한 연봉
SELECT EMP_NAME AS 이름, SALARY*12 AS 연봉, 
SALARY *(1+BONUS)*12 AS 보너스연봉
FROM EMPLOYEE;
--1(NULL 수정)  NVL함수는 NVL(컬럼,0) 컬럼이 NULL이면 0으로 취급 
SELECT EMP_NAME AS 이름, SALARY*12 AS 연봉, 
SALARY *(1+NVL(BONUS,0))*12 AS 보너스연봉
FROM EMPLOYEE;


-- ***리터럴***
-- 임의로 지정한 문자열, 날짜를 SELECT 절에 사용하면, 테이블에 존재하는 데이터처럼 사용
-- 리터럴은 RESULT SET의 모든 행에 반복 표시
-- 리터럴을 사용할때는 ''사용

--1. EMPLOYEE 테이블에서 직원의 전화번호, 사원명, 급여, 단위(원)을 조회
SELECT PHONE, EMP_NAME, SALARY, '원' AS 단위 
FROM EMPLOYEE;

-- ***문자열 결합 연산자***
-- || 연산자
-- 컬럼과 리터럴을 연결해서 사용하거나, 여러 컬럼을 하나의 컬럼 처럼 사용 가능
--1. EMPLOYEE 테이블에서 사번, 이름, 급여를 연결하는 경우
SELECT EMP_ID || EMP_NAME || SALARY FROM employee;

--2. EMPLOYEE 테이블에서 컬럼과 리터럴을 연결해보기
SELECT EMP_NAME || '씨의 월급은' || SALARY || '원입니다.' FROM EMPLOYEE;

-- 실습문제 --
--1. EMPLOYEE 테이블에서 이름, 고용일, 근무일수를 조회
-- HINT : 날짜(DATE)형식도 +,- 연산이 가능
-- HINT2 : 오늘 날짜는 SYSDATE 로 구할 수 있다.

SELECT EMP_NAME AS 이름,
HIRE_DATE AS 고용일,
TRUNC(SYSDATE - HIRE_DATE) AS 근무일수 
FROM EMPLOYEE;

-- *** DISTINCT ***
-- 컬럼에 포함된 중복 값을 제거하고 표시하고자 할 때 사용
-- RMPLOYEE 테이블에서 직원의 직급 코드를 조회
SELECT JOB_CODE FROM employee;
SELECT DISTINCT JOB_CODE FROM EMPLOYEE;
SELECT DISTINCT DEPT_CODE, JOB_CODE FROM EMPLOYEE;