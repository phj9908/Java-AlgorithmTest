// 커뮤러닝 - 정수 삼각형

package Programmers.lv3;

import java.util.Arrays;

public class Java0723_1 {
    public int solution(int[][] triangle) {
    	
    	int length = triangle.length;
    	int[][] d = new int[length][triangle[length-1].length];
    	
    	d[0][0] = triangle[0][0];
    	for(int i=0;i<length-1;i++) {
    		for(int j=0;j<triangle[i].length;j++) {
        		d[i+1][j] = Math.max(d[i+1][j],d[i][j]+triangle[i+1][j]);			
        		d[i+1][j+1] = Math.max(d[i+1][j+1],d[i][j]+triangle[i+1][j+1]);	
    		}
    	}
        
        //return Arrays.toString(d[length-1]); // 배열 값 확인
        return Arrays.stream(d[length-1]).max().getAsInt();
    }
}
