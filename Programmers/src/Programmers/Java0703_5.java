// 크레인 인형뽑기 게임

package Programmers;

import java.util.*;

class Java0703_5 {
	
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		for (int m : moves) {
			m -= 1;

			Loop1: 
			for (int i = 0; i < board.length; i++) {

				if (board[i][m] != 0) {

					if (!stack.isEmpty() && stack.peek()== board[i][m]) {
						answer += 2;
						stack.pop();

					} else {
						stack.add(board[i][m]);
					}
					board[i][m] = 0;
					break Loop1; 			// 특정 반복문 중지
				}
			}
		}

		return answer;
	}
}
