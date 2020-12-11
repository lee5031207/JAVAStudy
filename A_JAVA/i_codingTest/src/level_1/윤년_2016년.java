package level_1;
public class 윤년_2016년 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(1, 24));
	}
	
    public static String solution(int a, int b) {
        String answer = "";
        //2016년 2월은 29일까지 존재
        //2016년 1월 1일은 금요일 부터니까
        
        String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int [] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        //날짜수를 센다
        int dayCount = 0;
        for(int i=0; i<a-1; i++) {
        	dayCount += month[i];
        }
        dayCount += (b-1);
        dayCount %= 7;
        answer = week[dayCount];
        return answer;
    }

}
