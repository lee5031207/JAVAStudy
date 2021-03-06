package com.kh.test;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String[] q = {
				"조직이나 기업체의 중심이 되는 업무 시스템에서 모아진 정보를 일관된 스키마로 저장한 저장소",
				"범죄 사실의 전자적 증거물에 대해 수집, 분석 등을 진행하는 일련의 과정을 의미",
				"개발 일정이 지연된다고 해서 새로운 개발 인력을 투입할 경우 부작용으로 더욱 일정이 지연된다는 법칙",
				"데이터베이스 암호화 기법 중에서 애플리케이션 레벨에서 암호 모듈을 적용하는 애플리케이션 수정 방식의 암호화 기법",
				"사용자가 직접 제품을 사용하면서 미리 작성된 시나리오에 맞추어 과제를 수행한 후, 질문에 답",
				"프로세스가 자원을 기다리고 있는 시간에 비례하여 우선순위를 부여함으로써 무기한 대기하는 문제를 방지하는 기법, 기아현상을 해결하는 기법",
				"사용자와 시스템 사이에서 의사소통 할 수 있도록 고안된 물리적, 가상의 매개체",
				"일방향 해시 함수에서 다이제스트를 생성할 때 추가되는 바이트 단위의 임의의 문자열",
				"취약점을 공격하는 기술적 위험, 해당 취약점에 대한 패치가 나오지 않는 시점에서 이루어지는 공격",
				"네트워크에서 데이터의 종류에 따른 우선 순위에 따라 데이터를 전송하거나 특정 통신을 위한 네트워크 대역폭을 예약하고 일정한 속도로 통신 할 수 있는 기술", 
				"공중 네트워크를 통해 한 회사나 몇몇 단체가 내용을 바깥 사람에게 드러내지 않고 통신할 목적으로 쓰이는 사설 통신망",
				"기업이 재해로 타격을 입은 뒤 업무 운명을 어떻게 복구 재개하는지에 대한 계획",
				"네트워크상에서 동적으로 ip주소 및 기타 구성 정보 등을 부여/관리하는 프로토콜이다",
				"도출, 분석, 명세, 확인을 위해 수행되는 구조화된 활동의 집합, 체계적인 프로세스",
				"UNIX, LINUX 명령어, 파일의 내용을 화면에 표시",
				"관계형 데이터베이스에서 원하는 정보와 그 정보를 어떻게 유도하는가를 기술한 절차적 정형 언어",
				"사용자의 사진,문서 등을 암호화해 열지 못하도록 만들고 복호화의 대가로 금전을 요구하는 악성 프로그램",
				"데이터 마이닝에서 각 객체의 유사성을 측정하여, 유사성이 높은 대상 집단을 분류하고 집단의 특성을 도출하는 분석 방법",
				"하나의 프로세스가 작업 수행 과정에서 수행하는 기억 장치 접근을 지나치게 많이하고 페이지 폴트가 발생, 프로세스 수행 시간보다 이동에 시간이 더 소요되는 현상",
				"둘 이상의 프로세스가 서로 가진 한정된 자원을 요청하는 경우 발생하는 것",
				"요구사항 분석 기법 중 구문과 의미를 갖는 언어를 이용해 요구사항을 수학적 기호로 표현 후 분석",
				"트랜잭션이 사용하는 데이터 항목에 대하여 잠금을 설정한 트랜잭션이 해제할 때까지 독점적으로 사용할 수 있게 상호배제 기능을 제공하는 기법",
				"내부 정보 유출 방지를 의미, 기업 내에서 사용하는 주요 정보의 외부 유출을 방지하기 위해 사용하는 보안",
				"프로그램 문장을 하나씩 번역하고 실행할 수 있도록 하는 프로그램",
				"CPU가 현재 실행하는 프로세스의 문맥 상태를 PCB에 저장하고 다음 프로세스의 PDB로부터 문맥을 복원",
				"사용자 인터페이스로부터 비즈니스 로직을 분리",
				"유일성, 최소성, 대표성을 가지며 NULL을 허용하지 않는 키",
				"응용계층 프로토콜로 파일을 주고 받을 수 있는 원격 파일 전송 프로토콜 ",
				"IT 서비스 관리 분야에서 전세계적으로 검증 및 적용되는 Best Practice",
				"여러개의 하드디스크에 일부 중복된 데이터를 나눠서 저장하는 기술",
				"사용자가 정보에 대해 직접 접근해 대화식으로 정보를 분석하고 의사 결정에 활용하는 과정",
				"미리 정의된 보안 규칙에 기반, 들어오고 나가는 네트워크 트래픽을 모니터링하고 제어하는 보안 시스템",
                "메모리 관리 기법의 하나, 동적으로 할당했던 메모리 영역 중에 필요 없는 영역을 해제하는 기능",
                "1979년, SW의 규모를 측정 및 예측하는 기법",
                "자바, c++, .Net 등 다양한 언어를 지원하는 단위 테스트 프레임워크",
                "CREATE, DROP, ALTER, TRUNCATE",
                "1980년 데이빗 리드, TCP와 함께 데이터그램 으로 알려진 단문 메시지를 교환하기 위해 사용",
                "교착 상태를 해결하기 위한 회피 기법",
                "링크 상태 알고리즘을 사용, 토폴로지에 대한 정보가 전체 라우터에 동일하게 유지되는 프로토콜",
                " 최초의 라우팅 프로토콜",
                "공개키 암호 방식 기반으로 디지털 인증서를 활용하는 소프트웨어, 하드웨어, 사용자, 정책 및 제도를 총칭하는 암호기술",
                "전역 변수를 사용하지 않고 객체를 하나만 생성하도록 하여 생성된 객체를 어디에서든지 참조할 수 있도록 하는 디자인 패턴",
                "사용자 정보를 유지하기 위한 질의 및 디렉토리 서비스의 등록 수정, 삭제 및 검색을 위한 인터넷 프로토콜",
                "주어진 테스트 케이스에 의해 수행되는 소프트웨어 테스트 범위를 측정하는 테스트 품질 측정 기준",
                "서버와 네트워크, 프로그램 등의 정보시스템이 시스템의 장애에 대응하여 상당히 오랜 기간 동안 지속적으로 정상 운영이 가능한 성질",
                "애플리케이션에서 부하나 스트레스를 적용해 성능을 측정하는 도구, 종류는 JMeter, LoadUI, OpenSTA",
                "시스템 자원의 사용량을 확인하고, 분석이 가능한 도구, 종류는 Scouter, Zabbix",
                "하나의 송신자가 같은 서브 네트워크 상의 모든 수신자에게 데이터를 전송하는 기술",
                "SCADA , PLC, 이란 핵시설",
                "정보를 수집한 후, 저장만 하고 분석에 활용하고 있지 않은 다량의 데이터, 미래에 사용될 가능성이 있다는 이유로 삭제 X",
                "잃어버린 스마트폰을 주운 사람이 해당 폰을 켜서 이동통신망 혹은 와이파이에 접속하면 원 소유자가 원격으로 기기를 사용 불능 상태로 만들 수 있는 기술",
                "특수 목적은 가진 조직이 하나의 표적에 대해 다양한 IT 기술을 이용해서 지속적으로 정보를 수집하고 취약점을 파악하여 침투, 검색, 수집, 유출하는 공격기법",
                "온라인 상에서 불법 활동을 조장하기 위해 만들어진 컴퓨터 프로그램이다",
                "시스템에 과다한 정보량을 부하하는 테스트",
                "오류를 제거하거나 수정한 시스템에서 오류 제거와 수정에 의해 새로이 유입된 오류가 없는지 확인하는 일종의 반복 테스트 기법",
                "웹 기반 테스트 케이스 설계/실행/결과 확인 등을 지원하는 테스트 프레임워크",
                "루비(Ruby) 기반 웹 애플리케이션 테스트 프레임워크",
                "테스트의 일종이 아니라, 개발 황동이다",
                "요청 헤더의 Content-length를 비정상적으로 크게 설정하여 메시지 바디 부분을 매우 소량으로 보내 계속 연결 상태를 유지시켜 자원을 소진시키는 공격기법",
                "가장 객관적으로 하드웨어 성능을 나타내는 지표",
                "Log4j 로거로 성능을 개선",
                "사물과 컴퓨터에 동일하게 표현되는 가상 모델",
                "인증 시스템의 하나로 한 번의 인증을 통해서 여러 개의 서비스를 이용할 수 있는 시스템",
                "IKA, ESP, AH",
                "프로그램 내부에 위장해 숨어있다 프로그램이 동작 할　때 활성화되어 부작용을 일으키는 것",
                "설계자나 유지 보수 프로그램 작성자가 편의를 위해 보안을 제거해 놓은 비밀통로, 컴퓨터 범죄에 악용될 때 도 있다.",
                "UI 설계 지침",
                "객체 지향 특성",
                "UML의 3 요소",
                "대표적인 정적 테스트",
                "자신의 의지와 무관하게 공격자가 의도한 행동을 하는, 2008년 옥션, 쉬움",
                "정해진 메모리 범위를 넘치게 해 원래의 리턴 주소를 변경",
                "소인수분해, 공개키(비대칭키)",
                "해시 암호, 미국에서 1993",
                "56bit, 대칭키 암호",
                "우리나라에서 개발한 대칭키 암호",
                "LISP 기반 DRM, XML기반의 언어",
                "정보 시스템 침입자를 공격당하는 첫 속이는것",
                "공격자가 자신의 IP를 변조하거나 속이는 것",
                "관리자 만이 정보 자원의 분류를 설정, 변경하는",
                "리눅스+Mysql",
                "재해 복구 시스템",
                "추출, 변환 후 목적 시스템으로 전송 및 로딩",
                "사람과 컴퓨터 언어 사이 분석",
                "DB에서 변결된 데이터를  캡처",
                "소스코드에 직접 비번 같은게 들어감",
                "7가지 보안 강화 활동",
                "Google 대용량 데이터 분산 처리, Hadoop",
                "유지보수 생산성 향상을 목적으로 기능은 놔두고, 복잡한 소스코드의 수정 ",
                "인스턴스를 조립하는 디자인 패턴",
                "Undo 기능을 지원 하는 디자인 패턴",
                "기존에 구현된 클래스에 기능을 추가하는 디자인 패턴",
                "처음 부터 원형을 만드는 디자인 패턴"             				
		};
		
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[q.length];
		
		while(true) {
			System.out.print("문제를 푸시겠습니까 y/n : ");
			 char answer = sc.next().charAt(0);			 
			 if(answer == 'y') {				
				 int i = (int) (Math.random()*q.length);
				 if(a[i] == 0) {
					 System.out.println(q[i]);
					 a[i] = i;
					 
				 }else if(a[i] != 0){
					 continue;
				 }
				 
			 }else {
				 break;
			 }
	
		}
	}

}
