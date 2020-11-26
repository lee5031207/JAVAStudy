--1. PL/SQL(PROCEDURE LANGUAGE EXTENTION TO SQL)  - 프로그래밍 언어다!
-- 오라클 자체에 내장되어 있는 절차적 언어
-- 변수의 선언, 조건문, 반복문, 함수, PROCEDURE

--2. 분류
-- PL/SQL 블록(ANONYMOUS BLOCK) : 익명블록, 간단한 코드를 작성 할 때 사용
-- PROCEDURE : 이름이 있는 PL/SQL문
--                      단독으로 실행되거나 다른 프로시저에 의해 호출되어 실행 됨
-- FUCTION : PROCEDURE와 같이 이름이 있는 PL/SQL문, 값을 반환한다
-- TRIGGER : 특정한 테이블에 DML문이 수행되었을 때 실행되는 PL/SQL문

--3. PL/SQL 문의 구조
-- 선언부(DECLARE SECTION) : 변수나 상수를 선언
-- 실행부(EXECUTABLE SECTION) : 로직 기술
-- 예외처리부(EXCEPTION SECTION) : 실행부에서 예외가 발생했을 때 예외처리를 위한 코드
-- END;

--4. PL/SQL 기본 설정
SET SERVEROUTPUT ON;
-- PL/SQL문의 연산결과를 출력 , 로그인 할 때마다 설정을 다시 해야함
SHOW ERRORS; 
--에러확인

--5.  HELLO WORLD!! 찍기
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLP WORLD!!');
    -- DBMS_OUTPUT.PUT_LINE 출력함수
END;
/

--6. 변수 선언 및 초기화
DECLARE
-- 변수명  타입
    EMP_ID NUMBER;
    EMP_NAME VARCHAR2(30);
-- 상수명 CONSTANT 타입
    PI CONSTANT NUMBER := 3.14;
BEGIN
    --변수를 초기화
    EMP_ID := 888;
    EMP_NAME := '배장남';
    --출력
    DBMS_OUTPUT.PUT_LINE(EMP_ID);
    DBMS_OUTPUT.PUT_LINE(EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(PI*1000000);
END;
/

--7. REFERENCE 변수의 선언과 초기화
-- 테이블의 컬럼의 타입을 참조하는 변수
-- 변수명 테이블명.컬럼명%TYPE;
DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    --SELECT문을 사용해 EMPLOYEE 테이블에서 컬럼의 값을 받아와 대입
    --사용자로부터 사번을 입력받아 해당 사번과 사원명을 출력
    SELECT EMP_ID, EMP_NAME 
    INTO V_EMP_ID, V_EMP_NAME
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID'; --스캐너 개념
    -- '&' 기호가 있는 문자열은 개체 값을 입력하라는 의미;
    -- 사용자로부터 값을 입력받아 해당 변수에 넣어준다.
    
    DBMS_OUTPUT.PUT_LINE('V_EMP_ID : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('V_EMP_NAME : ' || V_EMP_NAME);
END;
/

--실습문제 1
-- 레퍼런스 변수로 V_EMP_ID, V_EMP_NAME, V_DEPT_TITLE, V_JOB_NAME을 선언하고
-- SELECT문을 사용해 사용자가 입력한 이름과 일치하는 사원의
-- 사번, 이름, 부서명, 직급명을 선언한 변수에 초기화하고 출력

DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    V_DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    V_JOB_NAME JOB.JOB_NAME%TYPE;
BEGIN
    SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME
    INTO V_EMP_ID, V_EMP_NAME, V_DEPT_TITLE, V_JOB_NAME
    FROM EMPLOYEE E
    INNER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
    INNER JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
    WHERE EMP_NAME = '&이름';
    
    DBMS_OUTPUT.PUT_LINE('V_EMP_ID : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('V_EMP_NAME : ' || V_EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('V_DEPT_TITLE : ' || V_DEPT_TITLE);
    DBMS_OUTPUT.PUT_LINE('V_JOB_NAME : ' || V_JOB_NAME);
END;
/

--8. ROWTYPE 변수
-- 테이블명%ROWTYPE : 테이블또는 VIEW의 ROW를 참조
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT * INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID';

    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('EMP_NO : ' || E.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);
END;
/

------------------------------------------------------------------------------------------
-- 조건문
-- IF문, IF-ELSE문 , IF-ELSE IF-ELSE문


--1. 단일 조건문
-- IF 조건절 RHEN 로직 END IF;
-- EMP_ID를 입력받아 해당 사원의 사번, 이름, 급여, 보너스율을 출력
-- 단 보너스를 받지 않는 사원은 보너스율 출력 전 '보너스 없음' 출력

DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    V_SALARY EMPLOYEE.SALARY%TYPE;
    V_BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID ,EMP_NAME, SALARY, BONUS
    INTO V_EMP_ID ,V_EMP_NAME, V_SALARY, V_BONUS
    FROM EMPLOYEE WHERE EMP_ID = '&ID';

    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || V_EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || V_SALARY);
    
    IF V_BONUS IS NULL
    THEN
        DBMS_OUTPUT.PUT_LINE('BONUS없음');
    END IF;
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
END;
/

--IF ELSE
--IF 조건문 THEN 로직 ELSE 로진 END IF
--EMP_ID를 입력받아 해당 사원의 사번, 이름, 급여, 보너스율 출력
--보너스를 받지 않는 사원은 보너스율 출력 전 '보너스 없음' 출력
--보너스를 받는 사원은 보너스율 출력전 ' 보너스 있음' 출력
DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    V_SALARY EMPLOYEE.SALARY%TYPE;
    V_BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID ,EMP_NAME, SALARY, BONUS
    INTO V_EMP_ID ,V_EMP_NAME, V_SALARY, V_BONUS
    FROM EMPLOYEE WHERE EMP_ID = '&ID';
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || V_EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || V_SALARY);
    
    IF V_BONUS IS NULL
    THEN DBMS_OUTPUT.PUT_LINE('보너스 없음');
    ELSE
    --DBMS_OUTPUT.PUT_LINE('보너스 있음');
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
    END IF;
END;
/

--IF 조건문 THEN 로직 ELSIF 조건문 THEN 로직 ELSE 로직 END IF;

--EMP_ID를 입력받아 해당 사원의 사번, 이름 , 급여, 보너스율을 출력
--보너스를 받지 않는 사원은 보너스율 출력전 ' 보너스 없음' 출력
--보너스를 20%이상인 사원은 보너스율 출력전 ' 보너스 많음' 출력
--보너스를 20%이하인 사원은 보너스율 출력전 ' 보너스 있음' 출력
DECLARE
    V_EMP_ID EMPLOYEE.EMP_ID%TYPE;
    V_EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    V_SALARY EMPLOYEE.SALARY%TYPE;
    V_BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID ,EMP_NAME, SALARY, BONUS
    INTO V_EMP_ID ,V_EMP_NAME, V_SALARY, V_BONUS
    FROM EMPLOYEE WHERE EMP_ID = '&ID';
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || V_EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || V_EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || V_SALARY);
    
    IF V_BONUS IS NULL
    THEN DBMS_OUTPUT.PUT_LINE('보너스 없음');
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
    ELSIF V_BONUS > 0.2
    THEN 
    DBMS_OUTPUT.PUT_LINE('보너스 많음');
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
    ELSE
    DBMS_OUTPUT.PUT_LINE('보너스 있음');
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || V_BONUS);
    END IF;
END;
/

