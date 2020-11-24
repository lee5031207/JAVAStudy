package level_1;

import java.util.ArrayList;
import java.util.Collections;

public class 모의고사_완전탐색 {

	public static void main(String[] args) {
		//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
		//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
		//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
		//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		int[] answers = {1,2,3,4,5};
		solution(answers);
		
	}
	public static int[] solution(int[] answers) {

        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        ArrayList<Integer> st1 = new ArrayList<Integer>();
        ArrayList<Integer> st2 = new ArrayList<Integer>();
        ArrayList<Integer> st3 = new ArrayList<Integer>();
        for(int i=0; i<50; i++) {
        	st1.add(0);
        	st2.add(0);
        	st3.add(0);
        } 
        ArrayList<Integer> st1_answer = new ArrayList<Integer>();
        ArrayList<Integer> st2_answer = new ArrayList<Integer>();
        ArrayList<Integer> st3_answer = new ArrayList<Integer>();
        
        for(int i=0; i<answers.length; i++) {
        	if(st1.get(i) == 0) { //만약 st1.get(i)가 비었다면
        		for(int a : student1) {
                	st1.add(i,a);  //0을 숫자로바꿔줌
                	st1_answer.add(st1.get(i));
                }
        	}
        	if(st2.get(i) == 0) {
        		for(int b : student2){
        			st2.add(i,b); //그만큼 추가
        			st2_answer.add(st2.get(i));
        		}
        	}
        	if(st3.get(i) == 0) {
        		for(int c : student3){
        			st3.add(i,c); //그만큼 추가
        			st3_answer.add(st3.get(i));
        		}
        	}
        }
        //답안지를 다 만들었다 이제 비교하면 된다 answer하고
        System.out.println(st1_answer);
        System.out.println(st2_answer);
        System.out.println(st3_answer);
        int st1_count = 0, st2_count = 0, st3_count = 0;
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == st1_answer.get(i)) {
        		st1_count++;
        	}
        	if(answers[i] == st2_answer.get(i)) {
        		st2_count++;
        	}
        	if(answers[i] == st3_answer.get(i)) {
        		st3_count++;
        	}
        }
        System.out.println("수포자 1 점수 : "+st1_count);
        System.out.println("수포자 2 점수 : "+st2_count);
        System.out.println("수포자 3 점수 : "+st3_count);

        int maxScore = Math.max(st1_count, Math.max(st2_count, st3_count)); 
        System.out.println(maxScore);
        
        ArrayList<Integer> list_answer = new ArrayList<Integer>();
        if(st1_count == maxScore) { list_answer.add(1);}
        if(st2_count == maxScore) { list_answer.add(2);}
        if(st3_count == maxScore) { list_answer.add(3);}
        

        int[] answer = new int[list_answer.size()];       
        for(int i=0; i<list_answer.size(); i++) {
        	answer[i] = list_answer.get(i);
        }

        return answer;
    }

}
