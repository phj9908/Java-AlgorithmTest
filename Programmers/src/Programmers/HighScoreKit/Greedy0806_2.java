// 구명보트

package Programmers.HighScoreKit;

import java.util.Arrays;

public class Greedy0806_2 {
	public int solution(int[] people,int limit) {
		
		int cnt=0;
		Arrays.sort(people);
        //System.out.print(Arrays.toString(people));
		
		int minIdx=0;
		int maxIdx = people.length-1;
		
		while(minIdx<=maxIdx) { // 50,70,80 같은 경우를 위해 '='필요
			if(people[minIdx]+people[maxIdx]<=limit) 
				minIdx++;
			
			maxIdx--;
            cnt++;
		}
		
		return cnt;
	}
}
