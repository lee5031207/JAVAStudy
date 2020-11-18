package com.kh.tour.controller;

import com.kh.tour.model.vo.Airline;
import com.kh.tour.model.vo.Tourist;

public class TourController {
	
	private Airline al1 = new Airline("미국행",3000,300000);
	private Airline al2 = new Airline("중국행",2000,200000);
	private Airline al3 = new Airline("일본행",1500,150000);
		
	private Tourist tt = new Tourist(1000000, 50000);
	
	public TourController() {
		
	}
	
	public boolean isAble(int num) {
		boolean result = true;
		// 잔액 + 마일리지 한 금액으로 비행기 티켓 살 수 있는지 없는지 판단
		int myAll = tt.getMyMoney()+tt.getMyMile();
		
		if(num == 1) { //미국행 선택
			if(myAll < al1.getAirfare() ) {
				return false;
			}
		}else if(num == 2) { //중국행 선택
			if(myAll < al2.getAirfare() ) {
				return false;
			}
		}else if(num == 3) { //일본행 선택
			if(myAll < al3.getAirfare() ) {
				return false;
			}
		}
		return true;
	}
	
	public void buyTicket1() {
		if(tt.getMyMoney() >= al1.getAirfare()) {
			tt.setMyMoney(tt.getMyMoney() - al1.getAirfare());
			tt.setMyMile(tt.getMyMile() + al1.getMileage());
		}else {
			int needMile = al1.getAirfare()-tt.getMyMoney();
			tt.setMyMile(tt.getMyMile()- needMile);
			tt.setMyMile(tt.getMyMile()+al1.getMileage());
			tt.setMyMoney(0);
		}
	}	
	public void buyTicket2() {
		if(tt.getMyMoney() >= al2.getAirfare()) {
			tt.setMyMoney(tt.getMyMoney() - al2.getAirfare());
			tt.setMyMile(tt.getMyMile() + al2.getMileage());
		}else {
			int needMile = al2.getAirfare()-tt.getMyMoney();
			tt.setMyMile(tt.getMyMile()- needMile);
			tt.setMyMile(tt.getMyMile()+al2.getMileage());
			tt.setMyMoney(0);
		}
	}
	public void buyTicket3() {
		if(tt.getMyMoney() >= al3.getAirfare()) {
			tt.setMyMoney(tt.getMyMoney() - al3.getAirfare());
			tt.setMyMile(tt.getMyMile() + al3.getMileage());
		}else {
			int needMile = al3.getAirfare()-tt.getMyMoney();
			tt.setMyMile(tt.getMyMile()- needMile);
			tt.setMyMile(tt.getMyMile()+al3.getMileage());
			tt.setMyMoney(0);
		}
	}
	
	public int bringMyMoney() {
		return tt.getMyMoney();
	}
	
	public int bringMyMile() {
		return tt.getMyMile();
	}

}
