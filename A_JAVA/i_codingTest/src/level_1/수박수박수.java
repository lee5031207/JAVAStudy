package level_1;

public class 수박수박수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(5);
		
	}
	public static String solution(int n) {
        String answer = "";
        String[] array = new String[2];
        array[0] = "수";
        array[1] = "박";
        for(int i=0; i<n; i++) {
        	answer += array[i%2];
        }
        System.out.println(answer);
        return answer;
    }

}
