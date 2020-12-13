package level_1;

public class 문자열내py의개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("pPY"));
	}
	
    public static boolean solution(String s) {
        boolean answer = true;
        int p=0, y=0;
        
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i)=='p' ||s.charAt(i)=='P') {
        		p++;
        	}else if(s.charAt(i)=='y' ||s.charAt(i)=='Y') {
        		y++;
        	}
        }
       
        if(p==y) {
        	answer = true;
        }else {
        	answer = false;
        }
        return answer;
    }

}
