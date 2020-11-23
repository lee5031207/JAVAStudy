--함수(FUNCTION) :  값을 읽고 연산하여 결과를 반환
-- 단일행 함수 : 컬럼에 기록된 N개의 값을 읽어서 하나의 값을 RETURN
-- 그룹 함수 : 총합이나 평균, 최대값등 통계와 관련된 결과를 반환하는 함수

--1. 문자 관련 함수
-- LENGTH, LENGTHB, SUBSTR, INSTR, CONCAT, REPLACE, TRIM, LPAD, RPAD
-- ***LENGTH*** : 문자열의 길이를 반환
-- ***LENGTHB*** : 문자열의 바이트 크기를 반환
SELECT LENGTH('오라클'), LENGTHB('오라클') FROM DUAL; -->DUAL 가상의 테이블
SELECT LENGTH('ORACLE'), LENGTHB('ORACLE') FROM DUAL;

-- ***INSTR*** : 문자열에서 찾고자 하는 문자의 위치를 반환하는 함수
SELECT INSTR('AABAACAABBAA','B') FROM DUAL;
SELECT INSTR('AABAACAABBAA','B',4) FROM DUAL;
SELECT INSTR('AABAACAABBAA','B',4,2) FROM DUAL; --2번째 B의 위치
--탐색할 방향을 오른쪽에서 왼쪽으로 지정
SELECT INSTR('AABAACAABBAA','B',-1,3) FROM DUAL;  --3번째 B의 위치


-- *** SUBSTR ***
-- 컬럼이나 문자열에서 지정한 위치부터 지정한 개수의 문자를 잘라내어 반환
--> SUBSTRING(STRING, POSITION[,LENGTH])
-- STRGIN : 컬럼 또는 문자열
-- POSITION : 문자열을 자를 위치, 양수면 시작 방향, 음수면 끝방향 부터 COUNT
SELECT SUBSTR('PCLASS',2) FROM DUAL;
SELECT SUBSTR('PCLASS',2,1) FROM DUAL;
SELECT SUBSTR('PCLASS',-1) FROM DUAL;

--EMPLOYEE 테이블에서 남자인 직원들을 조회
SELECT EMP_NAME FROM EMPLOYEE 
WHERE '1' = SUBSTR(EMP_NO,8,1);

--EMPLOYEE 테이블에서 이메일 아이디 (이메일에서 @ 앞에 붙는 아이디)를 조회
SELECT SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1) FROM EMPLOYEE; 


-- ***LAPD/RPAD
-- 주어진 컬럼이나 문자열에 임의의 문자를 왼쪽 또는 오른쪽에 덧붙여 지정한 길이의 문자열을 반환
-- 덧 붙일 문자열을 지정하지 않으면 공백을 붙인다.
SELECT LPAD(EMAIL,20) FROM EMPLOYEE;
SELECT LPAD(EMAIL,20,'#') FROM EMPLOYEE;
SELECT RPAD(EMAIL,20) FROM EMPLOYEE;
SELECT RPAD(EMAIL,20,'-') FROM EMPLOYEE;

-- ***LTRIM.RTRIM
-- 주어진 컬럼이나 문자열의 왼쪽 또는 오른쪽 끝에서 부터, 
--지정한 문자 집합을 모두 찾아 제거한 뒤 나머지를 반환
SELECT LTRIM('       LEESUNGUK') FROM DUAL;
SELECT LTRIM(PHONE,010) FROM EMPLOYEE;
SELECT LTRIM(000123456,'0') FROM DUAL;
SELECT LTRIM(000123456,'01') FROM DUAL;
SELECT RTRIM(123456000, '012456') FROM DUAL;

-- ***TRIM
-- 주어진 컬럼 또는 문자열의 앞뒤 쪽에서 지정한 문자집합을 모두 제거
SELECT TRIM('          KH         ') FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL;

-- *** CONCAT ***
--문자열 결합 함수
SELECT CONCAT(EMP_NAME,EMP_ID) FROM EMPLOYEE;

-- *** REPLACE ***
--문자열 REPLACE 하는 함수
SELECT REPLACE('서울시 강남구 역삼동','역삼동') FROM DUAL;
SELECT REPLACE('서울시 강남구 역삼동','역삼동','삼섬동') FROM DUAL;

--EMPLOYEE 테이블에서 사원명과 주민번호를 조회하세요
--단 주민번호는 생년월일과 '-' 까지만 보이게하고 나머지 자리의 숫자들은 *로바꾸어 출력
SELECT EMP_NAME, 
REPLACE(EMP_NO,SUBSTR(EMP_NO,8),'*******') AS 주민등록번호,
RPAD(SUBSTR(EMP_NO,1,7),14,'*') AS 강사님답,
SUBSTR(EMP_NO,1,7)||'*******' AS 강사님답2
FROM EMPLOYEE;

--------------------------------------------------------------------------------------------------------
--2. 숫자 처리 함수
-- ABS, MOD, ROUND, FLOOR, TRUNC, CEIL

-- ***ABS***  :  절대값 반환
SELECT ABS(-2323) FROM DUAL;

-- ***MOD***  :  나머지 함수
SELECT MOD(31,3) FROM DUAL;
SELECT MOD(-31,3) FROM DUAL;

-- ***ROUND*** : 반올림 함수
SELECT ROUND(32.734) FROM DUAL;
SELECT ROUND(32.737,2) FROM DUAL;

--***FLOOR*** : 내림처리 함수
SELECT FLOOR(32.5454) FROM DUAL;

--***TRUNC*** : 내림처리 함수, 원하는 위치에서 숫자를 절삭하 수 있다.
SELECT TRUNC(32.5454) FROM DUAL;
SELECT TRUNC(32.5454,1) FROM DUAL;
SELECT TRUNC(32.5454,-1) FROM DUAL;
SELECT TRUNC(2975,-2) FROM DUAL;

--***CEIL*** : 올림처리 하는 함수
SELECT CEIL(123.111) FROM DUAL;


--1. EMPLOYEE 테이블에서 사원명, 근무일수, 근무일수 2를 조회하세요
-- 근무일수1 : 입사일- 오늘날짜
-- 근무일수2 : 오늘날짜 - 입사일
-- 근무일수 1,2는 모두 정수이면서 양수이게끔 처리 해주세여
SELECT EMP_NAME,
ABS(FLOOR(HIRE_DATE - SYSDATE)),
FLOOR(SYSDATE - HIRE_DATE)
FROM EMPLOYEE;

--2. EMPLOYEE 테이블에서 사번이 홀수인 직원들의 정보를 조회하세요
SELECT * FROM EMPLOYEE
WHERE 0 != MOD(EMP_ID,2);


----------------------------------------------------------------------------------------------------
--3. 날짜 처리
--SYSDATE, MONTHS_BETWEEN, ADD_MONTHS, EXTRACT

--SYSDATE : 시스템에 저장되어 있는 현재 시간을 반환하는 함수
SELECT SYSDATE FROM DUAL;

--MONTHS_BETWEEN : 인수로 받은 두 DATE의 개월수 차이를 반환하는 함수
SELECT EMP_NAME, HIRE_DATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS 근무개월수
FROM EMPLOYEE ORDER BY 근무개월수 DESC;

--ADD_MONTHS : 날짜에 인수로 넘긴 숫자만큼 개월수를 더하여 날짜를 반환
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE,12) FROM EMPLOYEE;


--EXTRACT : 인수로 넘긴 시간에서 원하는 요소를 추출하여 반환
SELECT EMP_NAME, 
EXTRACT(YEAR FROM HIRE_DATE) AS "입사한 년도",
EXTRACT(MONTH FROM HIRE_DATE) AS "입사한 달",
EXTRACT(DAY FROM HIRE_DATE) AS "입사한 날",
--EXTRACT 함수 안에서는 TIMEZONE이 적용되지 않아 그리니치 표준시로 시간이 표현
EXTRACT(HOUR FROM systimestamp)+9 AS "현재 시간",
EXTRACT(YEAR FROM systimestamp) AS "현재 년도"
--EXTRACT(DAY FROM DATE '2020-11-18') AS "오늘날짜"
FROM EMPLOYEE;

SELECT SYSTIMESTAMP FROM DUAL;

--1. EMPLOYEE 테이블에서 근무년수가 20년 이상인 직원 정보를 조회
SELECT EMP_NAME, HIRE_DATE, FLOOR(FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))/12) AS 근무년수   
FROM EMPLOYEE 
WHERE FLOOR(FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))/12) > 20
ORDER BY 근무년수 DESC;


----------------------------------------------------------------------------------------------------------
--4. 형변환 함수
-- 데이터를 원하는 타입의 데이터로 변환

-- ***TO_CHAR***
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE,'SYYYY"년" MONTHDD"일"') FROM DUAL;

--TO_CHAR(NUMBER)
SELECT TO_CHAR(123456789,'999,999,999') FROM DUAL;
SELECT TO_CHAR(10000, '$999999') FROM DUAL;
SELECT TO_CHAR(10000, '$000000') FROM DUAL;
SELECT TO_CHAR(10000, 'L99999') FROM DUAL;

----------------------------------------------------------------------------------------------------------
--5. NULL 처리 함수
-- ***NVL***  : 파라미터 1이 NULL 이면 파라미터2로 출력
SELECT EMP_NAME, BONUS, NVL(BONUS,0) FROM EMPLOYEE;
SELECT EMP_NAME, DEPT_CODE, NVL(DEPT_CODE, '무소속') FROM EMPLOYEE;

-- ***NVL2***  : 파라미터가 3 개인 함수, NULL이면 파라미터2, NULL이 아니면 파라미터3
SELECT EMP_NAME, BONUS, NVL2(BONUS,'보너스NULL아님','보너스NULL') FROM EMPLOYEE;

--***NULLIF*** : ?
SELECT NULLIF('1234','1234') FROM DUAL;
SELECT NULLIF('1234','123') FROM DUAL;

----------------------------------------------------------------------------------------------------------
--5. 선택 함수 
--DECODE, CASE WHEN, 

--DECODE  : SWITCH CASE문 같은 조건 함수
--주민번호 8번째 자리가 짝수면 '여', 홀수라면'남으로' 표시하여 
--직원들의 이름, 주민번호, 성별을 조회하시오
SELECT EMP_NAME, EMP_NO
, DECODE(MOD(SUBSTR(EMP_NO,8,1),2),1,'남',0,'여')
FROM EMPLOYEE;
--직원의 급여를 인상하고자 한다.
--직급코드가 J7인 직원은 급여의 10%를 인상하고
--직급코드가 J8인 직원은 급여의 15%를 인상하고
--직급코드가 J5인 직원은 급여의 20%를 인상하며
-- 나머지 직원의 급여는 5%만 인상한다
-- 인상된 급여를 직원명, 직급코드, 급여와 함께 조회
SELECT EMP_NAME, JOB_CODE, SALARY AS 인상전급여,
DECODE(JOB_CODE,'J7',SALARY*1.1,'J8',SALARY*1.15,'J5',SALARY*1.2,SALARY*1.05) AS 인상후급여
FROM EMPLOYEE;

--CASE WHEN 조건식 THEN 결과값
--        WHEN 조건식 THEN 결과값
--        ELSE 결과값
--주민번호 8번째 자리가 짝수면 '여', 홀수라면'남으로' 표시하여 
--직원들의 이름, 주민번호, 성별을 조회하시오
SELECT EMP_NAME, EMP_NO,
CASE WHEN MOD(SUBSTR(EMP_NO,8,1),2) = 1 THEN '남'
        --WHEN MOD(SUBSTR(EMP_NO,8,1),2) = 0 THEN '여'
        ELSE '여'
        END AS 성별
FROM EMPLOYEE;

--직원의 급여를 인상하고자 한다.
--직급코드가 J7인 직원은 급여의 10%를 인상하고
--직급코드가 J8인 직원은 급여의 15%를 인상하고
--직급코드가 J5인 직원은 급여의 20%를 인상하며
-- 나머지 직원의 급여는 5%만 인상한다
-- 인상된 급여를 직원명, 직급코드, 급여와 함께 조회
SELECT EMP_NAME, JOB_CODE, SALARY AS 인상전급여,
CASE WHEN JOB_CODE = 'J7' THEN SALARY*1.1
        WHEN JOB_CODE = 'J8' THEN SALARY*1.15
        WHEN JOB_CODE = 'J5' THEN SALARY*1.2
        ELSE SALARY*1.05
        END AS 인상후급여
FROM EMPLOYEE;



