// 체육복

package Programmers.HighScoreKit;

public class Greedy0805_1 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer =n;
		int[] arr = new int[n];
		
		for(int l:lost) arr[l-1]--;
		for(int r:reserve) arr[r-1]++;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==-1) { 	// 본인이 체육복이 없을 때
				if(i-1>0&&arr[i-1]==1) {
					arr[i-1]--;
					arr[i]++;
				}
				else if(i+1<arr.length&&arr[i+1]==1) {
					arr[i+1]--;
					arr[i]++;
				}
				else answer--;
			}
		}
		return answer;
	}
}
