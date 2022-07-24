// 자물쇠와 열쇠
// 코드 참고 https://jino-dev-diary.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9E%90%EB%AC%BC%EC%87%A0%EC%99%80-%EC%97%B4%EC%87%A0-java

package ThisIsCodingTest;

public class Java0723_5 {
    public boolean solution(int[][] key, int[][] lock) {
        
    	int padSize = lock.length -1; // -1은 최소한으로 겹칠 때 하나의 좌표.
    	
    	// i=0 : 90도 회전, i=1 : 180도 회전...
    	for(int i=0;i<4;i++) {
    		
    		key = rotate(key); 		// 90도 회전한 key 반환
    		int[][] paddleKey = resizePad(key,padSize);	
    		// padding + 중심에 회전한key 놓기
    		
    		// 패딩한 key내에서 각 출발점 (j,k)부터 lock(j,k)+key(j,k) = 1 이 되는가
    		for(int j =0; j<paddleKey.length - padSize;j++) {
    			for(int k=0; k<paddleKey.length - padSize;k++) {
    				if(isValid(lock,paddleKey,j,k))
    					return true;
    			}
    		}
    	}
        
        return false;
    }

	public boolean isValid(int[][] lock, int[][] paddleKey, int j, int k) {
		
		for(int jj = 0;jj<lock.length;jj++) {
			for(int kk=0;kk<lock.length;kk++) {
				if(lock[jj][kk] + paddleKey[j+jj][k+kk]!=1) 
					return false;
			}
		}
		
		return true;
	}

	public int[][] resizePad(int[][] key, int padSize) {
		
		int[][] result = new int[key.length+padSize*2][key.length + padSize*2];
		
		for(int i =0;i<key.length;i++) {
			for(int j=0;j<key.length;j++) {
				result[padSize +i][padSize+j] = key[i][j];
				// 중심에만 회전한 key놓음
			}
		}
		
		return result;
	}

	public int[][] rotate(int[][] key) {
		
		int[][] result = new int[key.length][key.length];
		
		for(int i=0;i<key.length;i++) {
			for(int j=0;j<key.length;j++) {
				result[i][j] = key[key.length-1-j][i];
				// 오른쪽 90도 회전 점화식
				// 풀이 영상 참고
			}
		}
		
		return result;
	}


}
