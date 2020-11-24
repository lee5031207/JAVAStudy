package com.car;

public class CarTest {

	public static void main(String[] args) {
		Car[] carArr = new Car[2];
		carArr[0] = new L3("L3", "1500", 50, 25, 0);
		carArr[1] = new L5("L5", "2000", 75, 35, 0);
		System.out.println("vehicleName     engineSize     oilTank     oilSize     distance     temperature");
		System.out.println("===============================================================================");
		for(Car car : carArr) {
			System.out.println(car.getName()+"\t\t"+car.getEngine()+"\t\t"+car.getOilTank()+"\t     "+car.getOilSize()+"\t\t   "+car.getDistance()+"\t\t"+car.getTempGage());			
		}
		System.out.println("");
		
		//25 주유
		System.out.println("25 주유");
		System.out.println("vehicleName     engineSize     oilTank     oilSize     distance     temperature");
		System.out.println("===============================================================================");
		for(Car car : carArr) {
			car.setOil(25);
			System.out.println(car.getName()+"\t\t"+car.getEngine()+"\t\t"+car.getOilTank()+"\t     "+car.getOilSize()+"\t\t   "+car.getDistance()+"\t\t"+car.getTempGage());
		}
		System.out.println("");
		
		//80주행
		System.out.println("80주행");
		System.out.println("vehicleName     engineSize     oilTank     oilSize     distance     temperature");
		System.out.println("===============================================================================");
		for(Car car : carArr) {
			car.go(80);
			System.out.println(car.getName()+"\t\t"+car.getEngine()+"\t\t"+car.getOilTank()+"\t     "+car.getOilSize()+"\t\t   "+car.getDistance()+"\t\t"+car.getTempGage());
		}
		System.out.println("");
		
	}
}
