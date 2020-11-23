package level_1;

import java.util.ArrayList;
import java.util.List;

public class 크레인_인형뽑기_게임 {

	public static void main(String[] args) {

		int[][] board = new int[5][5]; 
		board[0][0] = 0;board[0][1] = 0;board[0][2] = 0;board[0][3] = 0;board[0][4] = 0;
		board[1][0] = 0;board[1][1] = 0;board[1][2] = 1;board[1][3] = 0;board[1][4] = 3;
		board[2][0] = 0;board[2][1] = 2;board[2][2] = 5;board[2][3] = 0;board[2][4] = 1;
		board[3][0] = 4;board[3][1] = 2;board[3][2] = 4;board[3][3] = 4;board[3][4] = 2;
		board[4][0] = 3;board[4][1] = 5;board[4][2] = 1;board[4][3] = 3;board[4][4] = 1;
		
		int[] moves = new int[8];
		moves[0] = 1;
		moves[1] = 5;
		moves[2] = 3;
		moves[3] = 5;
		moves[4] = 1;
		moves[5] = 2;
		moves[6] = 1;
		moves[7] = 4;

		int answer = solution(board, moves);
		System.out.println(answer);
		
	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<moves.length; i++){
            //int k = moves[i]-1; // 0
            for(int j=0; j<board.length; j++){
                if(board[j][moves[i]-1]!=0){
                    list.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        //list를 다 만듬
        for(int i=0; i<list.size(); i++){
            if(i != (list.size()-1)){
                if(list.get(i) == list.get(i+1)){
                    list.remove(i);
                    list.remove(i);
                    answer += 2;
                    i = -1;
                }
            }
        }
        return answer;
    }
}
