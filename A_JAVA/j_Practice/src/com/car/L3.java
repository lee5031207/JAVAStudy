package com.car;

public class L3 extends Car implements Temp{

	public L3() {
		
	}

	
	public L3(String name, String engine, int oilTank, int oilSize, int distance) {
		super(name, engine, oilTank, oilSize, distance);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void go(int distance) {
		// TODO Auto-generated method stub
		this.setDistance(this.getDistance()+distance);
		int minusTemp = distance/10;
		this.setOilSize(this.getOilSize()-minusTemp);
		
	}
	@Override
	public void setOil(int oilSize) {
		// TODO Auto-generated method stub
		this.setOilSize(this.getOilSize()+oilSize);
	}

	@Override
	public int getTempGage() {
		int temp = 0;
		temp = this.getDistance() / 10;
		return temp;
		// TODO Auto-generated method stub
		
	}
	

}
