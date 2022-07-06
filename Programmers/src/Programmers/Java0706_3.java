// 예산(lv3) - 커뮤러닝 코테
package Programmers;

import java.util.Arrays;

public class Java0706_3 {
	public int solution(int[] budgets, int M) {
		
		int answer=0;
		
		Arrays.sort(budgets);
		int start = 0;
		//int end = Arrays.stream(budgets).max().getAsInt(); // 시간초과
		int end = budgets[budgets.length-1];
		int mid = 0;
		
		while (start <= end) {
			mid = (start + end) / 2;
			// 초기 상한액 = 최대 예산과 0의 중간값
			
			for (int b : budgets) {
				int x = 0;
				x = (mid > b) ? b : mid;
				// 상한액보다 작으면 b, 상한액보다 크면 answer
				M -= x;

				if (M < 0)
					break;
			}

			if (M < 0)
				end = mid+1;
			else
				start = mid-1;
				answer = mid;
		}
		return answer;
	}
}
