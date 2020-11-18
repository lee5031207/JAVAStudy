-- where 절
--조회할 테이블에서 원하는 row를 조회하기 위해 작성하는 조건문
-- select 컬럼명 from 테이블명 where 조건절

-- ***비교 연산자, 논리 연산자***
-- 비교 연산자 : <,>,<=,>=,=
-- 같지 않다 : != ^= <>
-- 논리 연산자 : and, or, not
--1. EMPLOYEE 테이블에서 부서코드가 'D9'인 직원의 이름, 부서 코드 조회
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

--2. EMPLOYEE 테이블에서 급여가 4,000,000이상인 직원들의 이름과 연봉을 조회
SELECT EMP_NAME, SALARY*12 FROM EMPLOYEE WHERE SALARY >= 4000000;

--3. EMPLOYEE 테이블에서 부서코드가 'D9'가 아닌 사원의 사번, 이름, 부서코드를 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE != 'D9';

--4. EMPLOYEE 테이블에서 퇴사여부가 N인 직원을 조회하고, 근무 여부를 '재직중'으로
-- 표시하여 사번, 이름, 고용일, 근무 여부를 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, '근무중' AS 근무여부 
FROM EMPLOYEE WHERE ENT_YN = 'N';

--5. EMPLOYEE 테이블에서 월급이 3000000 이상인 사원의 이름, 월급, 고용일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE FROM EMPLOYEE WHERE SALARY >3000000;

--6. EMPLOYEE 테이블에서 실제연봉(세후 연봉, 세금3%)이 4500만원 이상인
-- 사원의 이름, 월급, 실수령액, 고용일을 조회
SELECT EMP_NAME, SALARY, (SALARY*0.97) AS 실수령월급, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY * 0.97 * 12 >45000000;

--  *** AND, OR ***
--1. 부서코드 'D6' 이고 급여를 200만원 보다 많이 받는 직원의 이름, 부서코드, 급여를 조회
SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE = 'D6' AND SALARY>2000000;
--2. EMPLOYEE 테이블에서 월급이 400만원 이상이고 JOB코드가 12인 사원이 모든 컬럼을 조회
SELECT * FROM EMPLOYEE WHERE SALARY>4000000 AND JOB_CODE = 'J1';
--3. EMPLOYEE 테이블에서 부서코드가 D9이거나 D5인 사원중 고용일이 02/01/01보다 빠른
--사원의 이름, 부서코드, 고용일 조회
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' OR DEPT_CODE = 'D5' AND HIRE_DATE < '02/01/01';

--4. EMPLOYEE 테이블에서 월급이 350만원 이상이고,
-- 600만원 이하인 직원의 사번,이름,급여, 직급코드 조회
SELECT EMP_ID, EMP_NAME, SALARY, JOB_CODE FROM EMPLOYEE
WHERE SALARY > 3500000 AND SALARY < 6000000;


-- *** BETWEEN  A AND B ***
SELECT EMP_ID, EMP_NAME, SALARY, JOB_CODE FROM EMPLOYEE
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;

--1. EMPLOYEE 테이블에서 고용일이 90/01/01~01/01/01이 아닌 사원의 전체 내용을 조회
SELECT * FROM EMPLOYEE
WHERE NOT HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';


-- ***LIKE***
-- 컬럼의 문자 값이 LIKE절의 지정한 특정 패턴을 만족시키면 TRUE가 반환
-- 컬럼명 LIKE '문자 패턴'
-- '%', '_'
-- '%' : '글자%' ('글자'로 시작하는 문자열)
-- '%' : '%글자' ('글자'로 끝나는 문자열)
-- '%' : '%글자%' ('글자'를 포함하는 문자열)
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- 성이 이씨이고 입사일이 12/01/01 이후인 사원의 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE FROM EMPLOYEE
WHERE EMP_NAME LIKE '이%' AND HIRE_DATE >= '12/01/01';

-- 이름에 '이'가 포함되고 부서코드가 D5인 사람을 조회
SELECT EMP_NAME FROM EMPLOYEE
WHERE EMP_NAME LIKE '%이%' AND DEPT_CODE = 'D5';

--이름이 '연'으로 끝나는 사람을 조회
SELECT EMP_NAME FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

--문자 자리수 지정 : '_' 한자리 의미
--                        " '__'두자리 의미
--EMPLOYEE  테이블에서 전화번호 4자리 부터 9로 시작하는 사원의 사번, 이름, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE FROM EMPLOYEE
--WHERE PHONE LIKE '___9%';
WHERE PHONE LIKE '%9___';

-- 이메일중 '_'의 앞글자가 3자리인 이메일 주소를 가진 사원의 모든 정보를 조회
-- ex)  SUN_DI@KH.OR.KR
-- EXCAPE 문자를 등록 가능 해당 특수 문자를
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' ESCAPE '#';

-- 실습 문제 ----
--1. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';

--2. EMPLOYEE 테이블에서 메일 주소 '_'의 앞이 4글자 이면서
--   DEPT_CODE가 D9 또는 D6이고
--  고용일이 90/01/01 ~ 00/12/01 이면서 급여가 270만원 이상인 사원의 전체 정보를 조회
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '____#_%' ESCAPE '#' 
AND (DEPT_CODE = 'D6' OR DEPT_CODE = 'D9')
AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
AND SALARY >= 2700000;

-- 연산자 우선순위를 고려해야함 
--  1순위 : 산술연산자
--  2순위 : 연결연산자
--  3순위 : 비교연산자
--  4순위 : IS NULL, LIKE, IN
--  5순위 : BETWEEN A AND B
--  6순위 : NOT
--  7순위 : AND
--  8순위 : OR
-- OR에 연산은 괄호로 묶어주자 AND보다 우선순위 낮으니깨
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '____#_%' ESCAPE '#' 
AND (DEPT_CODE = 'D6' OR DEPT_CODE = 'D9')
AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
AND SALARY >= 2700000;

-------------------실습 문제--------------------------
--1. 직급이 J7 또는 J2인 직원 중에 급여가 200이상인 직원의 이름, 급여, 직급 코드를 조회
SELECT EMP_NAME, SALARY, JOB_CODE FROM EMPLOYEE
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') AND SALARY >= 2000000; 

-- *** IN ***
-- 비교하는 값 목록에 일치하는 값이 있으면 true를 반환
-- 컬럼명 IN (값,값,값,......)
-- OR를 편하게 사용할 수 있다

-- D6부서와 D8부서의 사원들의 이름, 부서코드, 급여를 조회
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6','D8' );

-- ***IS NULL***
-- 해당 컬럼의 널인지 아닌지 판단해 TRUE, FALSE반환

--보너스 컬럼이 NULL인 사원의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS FROM EMPLOYEE
WHERE BONUS IS  NULL;

SELECT * FROM TB_STUDENT WHERE STUDENT_ADDRESS LIKE '%과천%';
