package com.kh.tour_refactoring.controller;

import com.kh.tour.model.vo.Airline;
import com.kh.tour.model.vo.Tourist;

public class TourController {
	
	private com.kh.tour_refactoring.model.vo.Tourist tt = new com.kh.tour_refactoring.model.vo.Tourist(1000000,50000);
	private Airline[] airArr = {new Airline("미국행",3000,300000), new Airline("중국행",2000,200000), new Airline("일본행",1500,150000)};
	
	public TourController() {
		
	}
	
	public boolean isAble(int num) {
		boolean result = true;
		// 잔액 + 마일리지 한 금액으로 비행기 티켓 살 수 있는지 없는지 판단
		int myAll = tt.getMyMoney()+tt.getMyMile();		
		if(myAll < airArr[num-1].getAirfare()) {
			return false;
		}		
		return result;
	}
	
	public void buyTicket(int num) {
		if(tt.getMyMoney() >= airArr[num-1].getAirfare()) {
			tt.setMyMoney(tt.getMyMoney() - airArr[num-1].getAirfare());
			tt.setMyMile(tt.getMyMile() + airArr[num-1].getMileage());
		}else {
			int needMile = airArr[num-1].getAirfare()-tt.getMyMoney();
			tt.setMyMile(tt.getMyMile() - needMile);
			tt.setMyMile(tt.getMyMile() + airArr[num-1].getMileage());
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
