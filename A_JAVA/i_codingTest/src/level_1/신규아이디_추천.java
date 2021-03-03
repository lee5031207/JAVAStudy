package level_1;

public class 신규아이디_추천 {

	public static void main(String[] args) {
		solution("...!@BaT#*..y.abcdefghijklm");


	}
    public static String solution(String new_id) {
        String answer1 = "";
        String answer2 = "";
        String answer3 = "";
        String answer4 = "";
        String answer5 = "";
        String answer6 = "";
        String answer = "";
        
        
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        for(int i=0; i<new_id.length(); i++) {
        	//1. 대문자 -> 소문자
        	answer1 += Character.toLowerCase(new_id.charAt(i));
        }
        System.out.println("1단계 :"+answer1);
        
        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for(int i=0; i<answer1.length(); i++) {
        	if(Character.isDigit(answer1.charAt(i)) || Character.isLowerCase(answer1.charAt(i)) || answer1.charAt(i)=='-' || answer1.charAt(i)=='_' || answer1.charAt(i)=='.'){
        		answer2 += answer1.charAt(i);
        	}
        }
        System.out.println("2단계 :"+answer2);
        
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        int dotCnt = 0;
        for(int i=0; i<answer2.length(); i++) {      	
        	if(answer2.charAt(i)== '.') {
        		dotCnt++;
        		if(dotCnt == 2) {
        			dotCnt--;
        		}else {
        			answer3 += answer2.charAt(i); 
        		}
        	}else {
        		answer3 += answer2.charAt(i); 
        		dotCnt = 0;
        	}
        }
        System.out.println("3단계 :"+answer3);
              
        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        for(int i=0; i<answer3.length(); i++) {
        	if(!((answer3.charAt(i)=='.' && i==0) || (answer3.charAt(i)=='.' && i==answer3.length()-1))) {
        		answer4 += answer3.charAt(i);
        	}
        }

        
        System.out.println("4단계 :"+answer4);
               
        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(answer4.equals("")) {
        	answer5 += 'a';
        }else {
        	answer5 = answer4;
        }
        System.out.println("5단계 :"+answer5);
        
        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        for(int i=0; i<answer5.length(); i++) {
        	if(i<15) {
        		answer6 += answer5.charAt(i);
        	}
        }
        if(answer6.charAt(answer6.length()-1) == '.') {
        	answer6 = answer6.substring(0, answer6.length()-1);
        }
        System.out.println("6단계 :"+answer6);
        
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        char impl;
        if(answer6.length() <= 2) {
        	impl = answer6.charAt(answer6.length()-1);
        	while(answer6.length()<3) {
        		answer6 += impl;
        	}        	
        }
        answer = answer6;
        System.out.println("7단계 :"+answer);
        
        return answer;
    }
    


}
