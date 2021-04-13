package spring.di.ui;

import spring.di.entity.Exam;

public class InlineConsole implements Console {

	Exam exam;
	
	public InlineConsole() {
		
	}
	
	public InlineConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("총합 : "+exam.total()+" / 평균 : "+exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		this.exam = exam;
	}

}
