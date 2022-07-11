// 예산(lv3) - 커뮤러닝 코테
package Programmers.lv3;

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
			int sum=0;
			
			for (int b : budgets) {
				// 상한액보다 작으면 b, 상한액보다 크면 answer
				sum += (mid > b) ? b : mid;
			}

			if (M < sum)
				end = mid-1;
			else
				start = mid+1;
				answer = mid;
		}
		return answer;
	}
}

// Stream 활용

public class Java0706_3 {
	public int solution(int[] budgets, int M) {
		
		int answer=0;
		int start =0;
		int end = IntStream.of(budgets).max().OrElse(0);
		
		while (start <= end) {
			final int  mid = (start + end) / 2; 
			// final : Stream을 사용할 때 쓰이는 변수들은 가변적이지 않아야함
			
			int sum=IntStream.of(budgets)
					.map( x -> Math.min(x,mid)) // 상한액이하만 더할 수 있도록
					.sum();

			if (sum>M)
				end = mid-1;
			else
				start = mid+1;
				answer = mid;
		}
		return answer;
	}
}