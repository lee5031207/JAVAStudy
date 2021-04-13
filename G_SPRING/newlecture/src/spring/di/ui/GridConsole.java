package spring.di.ui;

import spring.di.entity.Exam;

public class GridConsole implements Console {

	Exam exam;
	
	public GridConsole() {
	
	}
	
	
	public GridConsole(Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.println("---------");
		System.out.println("총합:"+exam.total());
		System.out.println("평균:"+exam.avg());
		System.out.println("---------");

	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
