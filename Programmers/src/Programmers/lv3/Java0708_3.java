// 숫자 게임 - 커뮤러닝 코테

package Programmers.lv3;

import java.util.Arrays;

public class Java0708_3 {
    public int solution(int[] A, int[] B) {
        int answer =0;
        
        // 오름차순 정렬한 뒤
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 큰 수부터 비교하기 위해 뒤에서 부터 탐색
        // A보다 큰 B찾기
        int b_idx = A.length-1;
        for(int a_idx=A.length-1; a_idx>=0;a_idx--) {
        	if(B[b_idx] > A[a_idx]) {
        		answer++;
        		b_idx--; // B가 더 클 때만 b_idx감소
        	}
        }
        
    return answer;
    }
    
}
