package 강사님;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 타임특가세일 {
	//  타임 특가 세일 이벤트
	//  2021년 1월 1일부터 1월 3일 매일 오후 1시부터 4시까지
	//  실행되면 "초특가 이벤트!" 라고 출력하고,
	//  그 이외의 시간에 접속하면 "환영합니다!" 라고 출력합니다.
    /*
     * 출력형태
     *
     * - 평상시
     * 현재시간 : 2020년 12월 31일 오후 1시 49분환영합니다!
     *
     * - 이벤트 시간
     *현재시간 : 2021년 1월 1일 오후 1시 30분 초특가 이벤트!
     *
     * */
	
	public static void main(String[] args) {
		sale();
	}
	
	public static void sale() {
		Date now =  new Date();
		String ampm = "";
		int hours = 0;
		
		if(now.getHours()>=12 && now.getHours()<24) {
			ampm = "오후";
			hours = ((int)now.getHours() - 12);
		}else {
			ampm = "오전";
			hours = ((int)now.getHours());
		}
		
		if(now.getYear()+1900 == 2021 && (now.getMonth()+1)==1 && 
				now.getDate()>1 && now.getDate()<=3 && ampm=="오후" && hours>1 && hours<4) {
			System.out.println("현재 시간 : "+ ((int)now.getYear()+1900)+"년 "+
					(now.getMonth()+1)+"월 "+ now.getDate()+"일 " +ampm+" "+ hours+"시"
							+ " "+now.getMinutes()+"분 초특가 이벤트");
		}else {
			System.out.println("현재 시간 : "+ ((int)now.getYear()+1900)+"년 "+
					(now.getMonth()+1)+"월 "+ now.getDate()+"일 " +ampm+" "+ hours+"시"
							+ " "+now.getMinutes()+"분 환영합니다");
		}
	}
}
