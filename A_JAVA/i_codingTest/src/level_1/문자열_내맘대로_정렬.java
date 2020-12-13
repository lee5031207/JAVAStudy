package level_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열_내맘대로_정렬 {

	public static void main(String[] args) {
		// [sun, bed, car]	1	[car, bed, sun]
		
		String[] strings = {"sun","bed","car"};
		String[] strings2 = {"abce", "abcd", "cdx"};
		solution(strings2, 2);

	}
    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<strings.length; i++) {
        	list.add(strings[i].charAt(n)+strings[i]);
        }
//        
//        System.out.println(list);
        Collections.sort(list);
//        System.out.println(list);
        
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i).substring(1);
        }
        
//        for (String a : answer) {
//			System.out.println(a);
//		}
        
        System.out.println(answer[0]);
        return answer;
    }

}
