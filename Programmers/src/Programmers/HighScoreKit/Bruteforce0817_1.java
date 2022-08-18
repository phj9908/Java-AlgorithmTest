// 최소직사각형

package Programmers.HighScoreKit;

public class Bruteforce0817_1 {
	
	public int solution(int[][] sizes) {
		
		int maxCol=0;
		int maxRow=0;
        
		// 더 긴부분 = col, 더 짧은 부분 = row로 정하기
		for(int i=0;i<sizes.length;i++) {
			
			int c = Math.max(sizes[i][0], sizes[i][1]);
			int r = Math.min(sizes[i][0], sizes[i][1]);
			
			maxCol = Math.max(maxCol, c);
			maxRow = Math.max(maxRow, r);
            //System.out.println(maxCol+","+maxRow);
		}
		
		return maxCol*maxRow;
	}

}
