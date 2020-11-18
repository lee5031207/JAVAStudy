package com.kh.d_controllStatement.d_coffeeManager;

import java.util.*;

public class CoffeeManager {

	public static void main(String[] args) {

		CoffeeManager test = new CoffeeManager();
		test.app();
	}
	
	public void app() {
		Scanner sc = new Scanner(System.in);
		
		int all_sales = 0; //매출 변수 선언
		int all_buys = 0;  //지출 변수 선언
		int ame_sale_cnt = 0; //아메리카노 판매량
		int lat_sale_cnt = 0; //라떼 판매량
		int moc_sale_cnt = 0; //모카 판매량
		
		
		// 잔고 등록 
		System.out.print("잔고를 등록하시오 : ");
	    int money = sc.nextInt();
	    System.out.println("============");
	   
	    // 아메리카노 판매가,원가,재고,안전재고 등록
	    System.out.print("아메리카노 판매가를 등록하세요 : " );
	    int ame_sale = sc.nextInt();
	    System.out.print("아메리카노 원가를 등록하세요 : " );
	    int ame_buy = sc.nextInt();                            
	    System.out.print("아메리카노 재고를 등록하세요 : " );
	    int ame_cnt = sc.nextInt();
	    System.out.print("아메리카노 안전재고를 등록하세요 : " );
	    int ame_safecnt = sc.nextInt();
	    System.out.println("============");
	    
	    // 라떼 판매가,원가,재고,안전재고 등록
	    System.out.print("라떼 판매가를 등록하세요 : " );
	    int lat_sale = sc.nextInt();
	    System.out.print("라떼 원가를 등록하세요 : " );
	    int lat_buy = sc.nextInt();                            
	    System.out.print("라떼 재고를 등록하세요 : " );
	    int lat_cnt = sc.nextInt();
	    System.out.print("라떼 안전재고를 등록하세요 : " );
	    int lat_safecnt = sc.nextInt();
	    System.out.println("============");
	      
	    // 모카 판매가,원가,재고,안전재고 등록
	    System.out.print("모카 판매가를 등록하세요 : " );
	    int moc_sale = sc.nextInt();
	    System.out.print("모카 원가를 등록하세요 : " );
	    int moc_buy = sc.nextInt();							   
	    System.out.print("모카 재고를 등록하세요 : " );
	    int moc_cnt = sc.nextInt();
	    System.out.print("모카 안전재고를 등록하세요 : " );
	    int moc_safecnt = sc.nextInt();
	    
	    while(true) {
		    System.out.println("======MENU=====");
		    System.out.println("판매등록(1)");
		    System.out.println("현황(2)");                          
		    System.out.println("종료(3)");                  
		    System.out.print("입력 : ");
		    int menu = sc.nextInt();
		    
		    
		    if(menu == 1) {  //판매등록 선택
		    	System.out.println("*****음료 메뉴*****");
		    	System.out.println("아메리카노(1)");	
		    	System.out.println("라떼(2)");
		    	System.out.println("모카(3)");
		    	System.out.println("****************");
		    	System.out.print(" * 판매한 커피의 코드를 입력하시오 : ");
		    	int code = sc.nextInt();
		    	System.out.print(" * 판매량을 입력하시오 : ");
		    	int sales = sc.nextInt();
		    	
		    	if(code == 1) { //아메리카노 선택
		    		if(ame_cnt < sales) {  //아메리카노 재고가 주문량보다 적을시 (예외사항1)
		    			if(money >= sales*ame_buy) {  //잔고가 매입할돈보다 많다 즉, 매입가능
		    				ame_cnt += sales; // 판매량 만큼 재고 추가
		    				money -= sales*ame_buy;  //잔고에서 아메리카노 원가*매입수 만큼 차감
		    				all_buys += sales*ame_buy;  //지출에 쓴돈 추가
		    				System.out.println(" * 재고를 "+sales+"개 추가합니다");
		    			}else if(money < sales*ame_buy) {  //잔고가 매입할돈보다 적다 즉, 매입불가능  (예외사항1-2)
		    				System.out.println(" * 잔고가 부족해 재고를 추가하지 못했습니다");
		    				System.out.println(" * 주문이 취소되었습니다");
		    				continue;
		    			}
		    		}
		    		ame_cnt -= sales;  //아메리카노 재고 - 판매량 
		    		money += ame_sale * sales;  // 잔고에  아메리카노 (판매가x판매량)만큼 추가       
		    		all_sales += ame_sale * sales;  //매출에  아메리카노 (판매가x판매량)만큼 추가
		    		ame_sale_cnt += sales;  //아메리카노 판매량에 판매량만큼 추가
		    		System.out.println(" * 판매가 완료되었습니다 ");
		    		System.out.println("제품명 : 아메리카노");
		    		System.out.println("판매가 : "+ ame_sale);
		    		System.out.println("판매량 : "+ sales);
		    		System.out.println("결제금액 : "+ ame_sale * sales);
		    		System.out.println("남은 재고 : "+ ame_cnt);
		    		
		    		if(ame_cnt<ame_safecnt) {   // 재고가 안전재고보다 적다면  ( 예외사항2 )
		    			if(money >= ame_safecnt*2*ame_buy) {  //안전재고 2배를 살 돈이 있다면
		    				ame_cnt += ame_safecnt*2;   //안전재고 2 배만큼 재고량 추가
		    				money -= ame_safecnt*2*ame_buy;  //잔고에서 (안전재고x2x매입원가)  만큼  차감
		    				all_buys += ame_safecnt*2*ame_buy;  //지출에 쓴돈 추가
		    				System.out.println(" * 안전재고가 부족해 안전재고를 추가합니다");
		    				System.out.println("아메리카노 재고 : "+ame_cnt);
		    			}else {
		    				System.out.println(" * 잔고가 부족해 안전재고를 추가하지 못했습니다");
		    			}
		    		}
		    		continue;
		    	}else if(code == 2) { //라떼 선택
		    		if(lat_cnt < sales) {  //라떼 재고가 주문량보다 적을시 (예외사항1)
		    			if(money >= sales*lat_buy) {  //잔고가 매입할돈보다 많다 즉, 매입가능
		    				lat_cnt += sales; // 판매량 만큼 재고 추가
		    				money -= sales*lat_buy;  //잔고에서 라떼 원가*매입수 만큼 차감
		    				all_buys += sales*lat_buy;  //지출에 쓴돈 추가
		    				System.out.println(" * 재고를 "+sales+"개 추가합니다");
		    			}else if(money < sales*lat_buy) {  //잔고가 매입할돈보다 적다 즉, 매입불가능  (예외사항1-2)
		    				System.out.println(" * 잔고가 부족해 재고를 추가하지 못했습니다");
		    				System.out.println(" * 주문이 취소되었습니다");
		    				continue;
		    			}
		    		}
		    		lat_cnt -= sales;  //라떼 재고 - 판매량 
		    		money += lat_sale * sales;  // 잔고에  라떼 (판매가x판매량)만큼 추가       
		    		all_sales += lat_sale * sales;  //매출에  라떼 (판매가x판매량)만큼 추가
		    		lat_sale_cnt += sales;  //라떼 판매량에 판매량만큼 추가
		    		System.out.println(" * 판매가 완료되었습니다 ");
		    		System.out.println("제품명 : 라떼");
		    		System.out.println("판매가 : "+ lat_sale);
		    		System.out.println("판매량 : "+ sales);
		    		System.out.println("결제금액 : "+ lat_sale * sales);
		    		System.out.println("남은 재고 : "+ lat_cnt);
		    		
		    		if(lat_cnt<lat_safecnt) {   // 재고가 안전재고보다 적다면  ( 예외사항2 )
		    			if(money >= lat_safecnt*2*lat_buy) {  //안전재고 2배를 살 돈이 있다면
		    				lat_cnt += lat_safecnt*2;   //안전재고 2 배만큼 재고량 추가
		    				money -= lat_safecnt*2*lat_buy;  //잔고에서 (안전재고x2x매입원가)  만큼  차감
		    				all_buys += lat_safecnt*2*lat_buy;  //지출에 쓴돈 추가
		    				System.out.println(" * 안전재고가 부족해 안전재고를 추가합니다");
		    				System.out.println("라떼 재고 : "+lat_cnt);
		    			}else {
		    				System.out.println(" * 잔고가 부족해 안전재고를 추가하지 못했습니다");
		    			}
		    		}
		    		continue;
		    	}else if(code == 3) { //모카 선택
		    		if(moc_cnt < sales) {  //모카 재고가 주문량보다 적을시 (예외사항1)
		    			if(money >= sales*moc_buy) {  //잔고가 매입할돈보다 많다 즉, 매입가능
		    				moc_cnt += sales; // 판매량 만큼 재고 추가
		    				money -= sales*moc_buy;  //잔고에서 모카 원가*매입수 만큼 차감
		    				all_buys += sales*moc_buy;  //지출에 쓴돈 추가
		    				System.out.println(" * 재고를 "+sales+"개 추가합니다");
		    			}else if(money < sales*moc_buy) {  //잔고가 매입할돈보다 적다 즉, 매입불가능  (예외사항1-2)
		    				System.out.println(" * 잔고가 부족해 재고를 추가하지 못했습니다");
		    				System.out.println(" * 주문이 취소되었습니다");
		    				continue;
		    			}
		    		}
		    		moc_cnt -= sales;  //모카 재고 - 판매량 
		    		money += moc_sale * sales;  // 잔고에  모카 (판매가x판매량)만큼 추가       
		    		all_sales += moc_sale * sales;  //매출에  모카 (판매가x판매량)만큼 추가
		    		moc_sale_cnt += sales;  //모카 판매량에 판매량만큼 추가
		    		System.out.println(" * 판매가 완료되었습니다 ");
		    		System.out.println("제품명 : 모카");
		    		System.out.println("판매가 : "+ moc_sale);
		    		System.out.println("판매량 : "+ sales);
		    		System.out.println("결제금액 : "+ moc_sale * sales);
		    		System.out.println("남은 재고 : "+ moc_cnt);
		    		
		    		if(moc_cnt<moc_safecnt) {   // 재고가 안전재고보다 적다면  ( 예외사항2 )
		    			if(money >= moc_safecnt*2*moc_buy) {  //안전재고 2배를 살 돈이 있다면
		    				moc_cnt += moc_safecnt*2;   //안전재고 2 배만큼 재고량 추가
		    				money -= moc_safecnt*2*moc_buy;  //잔고에서 (안전재고x2x매입원가)  만큼  차감
		    				all_buys += moc_safecnt*2*moc_buy;  //지출에 쓴돈 추가
		    				System.out.println(" * 안전재고가 부족해 안전재고를 추가합니다");
		    				System.out.println("모카 재고 : "+moc_cnt);
		    			}else {
		    				System.out.println(" * 잔고가 부족해 안전재고를 추가하지 못했습니다");
		    			}
		    		}
		    		continue;
		    	}
		    }else if(menu==2) { //현황 선택
		    	System.out.println("================판매현황=======================");
		    	System.out.println("아메리카노 재고 :"+ame_cnt+" | 판매량 :"+ame_sale_cnt);
		    	System.out.println("    라떼 재고 :"+lat_cnt+" | 판매량 :"+lat_sale_cnt);
		    	System.out.println("    모카 재고 :"+moc_cnt+" | 판매량 :"+moc_sale_cnt);
		    	System.out.println("잔고 :"+money+"원  | 매출 :"+all_sales+"원 | 지출 :"+all_buys+"원");
		    	continue;
		    }else if(menu==3) {  //종료 선택
		    	System.out.println("프로그램을 종료합니다");
		    	break;
		    }	      
	    }
	}
}
