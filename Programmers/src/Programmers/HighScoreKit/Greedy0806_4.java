// 단속 카메라

package Programmers.HighScoreKit;

import java.util.Arrays;

public class Greedy0806_4 {
	public int solution(int[][] routes) {
		
		// 진출시간 기준 오름차순 정렬
		Arrays.sort(routes,(a,b)->Integer.compare(a[1], b[1]));
		
		int answer=0;
		int camera = -30000; // 문제 제한사항 중 최소 진입지점이 -30000
		
		for(int[] r:routes) {
			if(camera<r[0]) { // 카메라가 진입점 밖에 있다면
				answer++;	
				camera=r[1];	// 진출점 갱신
								// 진출점으로 지정해야 다음 루트의 진입점과 비교하기 쉬움
			}
		}
		
		return answer;
	}
}
