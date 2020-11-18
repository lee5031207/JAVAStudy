package com.kh.z_coffeemanager.d_polymorphism;

//고급 포장 비용 2000원이 추가되는 프리미엄 커피
//판매가에 포장비용 2000원이 추가
//제품을 매입시에도 포장 비용 2000원을 같이 추가 지출

public class PremiumCoffee extends Coffee {
	// 상속할때 확인할것 is a 관계 확인
	// 프리미엄 커피는 커피이다
	
	
	private int packagingCost; //포장비용 

	public PremiumCoffee() {

	}

	public int getPackagingCost() {
		return packagingCost;
	}

	public void setPackagingCost(int packagingCost) {
		this.packagingCost = packagingCost;
	}
	
	@Override
	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice+packagingCost;
		// this를 쓸 수 있는 이유는 
		// Coffee클래스의 필드 변수를 Protected로 변경해주었기 때문		
	}
	
	@Override
	protected int deductStock(int coffeeCnt) {
		//재고가 충분해서 재고 차감이 가능한 경우
		if(stock > coffeeCnt) {
			stock -= coffeeCnt;
			
			//재고 차감 이후
			//만약 재고가 안전재고 보다 적다면
			if(stock < safetyStock) {
				secureSafetyStock();
			}
			
			return coffeeCnt;
		//재고가 충분하지 않아서 재고를 추가하고 차감해야 하는 경우
			//재고를 추가할 경우 매입가+프리미엄 비용이 지출되어야 함
		}else if(addStock(coffeeCnt, perchacePrice + packagingCost) > 0) {
			stock -= coffeeCnt;
			return coffeeCnt;
		//재고가 충분하지 않은데 잔고가 부족해서 재고 추가가 불가능
		}else {
			return 0;
		}
	}
	
	@Override
	//안전재고 확보
	//안전재고 * 2만큼 재고를 확보하고 추가한 재고의 수를 반환
	protected void secureSafetyStock() {
		System.out.println(" * 안전 재고가 부족해 재고를 확보합니다.");
		//추가할 재고 수량
		int needCnt = safetyStock * 2;
		addStock(needCnt, perchacePrice + packagingCost);
	}
	
	
	
}
