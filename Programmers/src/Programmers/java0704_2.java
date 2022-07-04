// K번째 수

package Programmers;

import java.util.Arrays;

public class java0704_2 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length;i++) {
        	int[] arr = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]); 
        	// 인덱스 commands[i][0]부터 commands[i][1] 까지만 남기기 
        	
        	Arrays.sort(arr); // 배열 오름차순 정렬
        	answer[i] = arr[commands[i][2]-1]; //  이런식으로 추가하는게..?
        }
        return answer;
    }
}
