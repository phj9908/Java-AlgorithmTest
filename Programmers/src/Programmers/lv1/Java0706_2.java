// 예산(lv1)

package Programmers.lv1;

import java.util.Arrays;

public class Java0706_2 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int i:d) {
        	budget-=i;
        	if(budget>=0) answer++;
        	else break;
        }
        return answer;
    }
}
