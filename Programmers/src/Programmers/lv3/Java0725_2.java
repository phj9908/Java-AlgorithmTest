// 커뮤러닝 솔루션 - 정수 삼각형 
// 내 풀이 와 달리 밑에서 위로 올라오는 순서
// 가장 윗줄에 가장 큰 수 가 담기도록

package Programmers.lv3;

public class Java0725_2 {

	public int solution(int[][] triangle) {
		
		for(int i=triangle.length-2;i>=0;i--) { // 마지막 줄이 triangle.length-1. 그위의 줄 부터 시작
			for(int j=0;j<triangle[i].length;j++) {
				int left = triangle[i][j] + triangle[i+1][j];
				int right = triangle[i][j] + triangle[i+1][j+1];
				
				triangle[i][j] = Math.max(left, right);
			}
		}
		return triangle[0][0];
	}
}
