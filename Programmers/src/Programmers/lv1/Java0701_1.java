// 평균 구하기
// sum은 Stream API 쓰는것 보다 for-loop쓰는걸 추천, 그게 더빠름

package Programmers.lv1;

import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0); // orElse(0) : average()의 리턴값이 null일 때 0을 반환하도록 
        // or (double)(Arrays.stream(arr).sum())/arr.length
    }

////	//결과 확인 테스트
//    public static void main(String[] args) {
//    	int[] x= {1,2,3};
//    	Solution_aver sol = new Solution_aver();
//    	
//    	System.out.print(sol.solution(x));	
//    }
}
