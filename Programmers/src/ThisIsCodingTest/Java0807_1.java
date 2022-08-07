// 외벽점검(완전탐색)
// 주의) 외벽의 길이(n)는 12가 아님. 1~200 범위다

package ThisIsCodingTest;

public class Java0807_1 {
	
	public int[] weak,dist;
	public int[][] weakAllCase;
	public int n,answer;
	
    public int solution(int n, int[] weak, int[] dist) {
    	
    	weakAllCase = new int[weak.length][weak.length];
    	
    	this.weak = weak;
    	this.dist = dist;
    	this.answer = dist.length + 1; // Math.min을 위한 초기화
    	this.n=n;
    	
    	//	weak의 모든 케이스 구하기
    	makeWeakAllCase(); 		
    	
    	// dist의 모든 케이스 구하기(DFS)
    	makeDistAllCase(new boolean[dist.length],new int[dist.length],0);
    	
    	
        
        return answer==dist.length+1 ? -1:answer;
    }

	private void makeDistAllCase(boolean[] visited, int[] distCase, int idx) {
		
		if(idx == dist.length) {
			for(int[] weakCase:weakAllCase)
				check(distCase,weakCase);
		}
		
		for(int i=0;i<dist.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				distCase[idx] = dist[i]; // 원소 할당
				
				makeDistAllCase(visited, distCase, idx+1);
				visited[i]=false;
				distCase[idx]=0;  // 다시 빼기
				
			}
		}
		
	}

	private void check(int[] distCase, int[] weakCase) {
		
		int currentWeakIdx =0;
		int nextWeakIdx=0;
		int distIdx =0;
		
		while(currentWeakIdx<weakCase.length&& distIdx<distCase.length) {
			
			nextWeakIdx = currentWeakIdx+1;
			while(nextWeakIdx<weakCase.length&&
					weakCase[currentWeakIdx]+distCase[distIdx]>=weakCase[nextWeakIdx])
				nextWeakIdx++;
			
			currentWeakIdx = nextWeakIdx;
			distIdx++;
		}
		
		if(currentWeakIdx == weakCase.length)
			answer = Math.min(answer, distIdx);
		
	}

	private void makeWeakAllCase() {
		
		int[] weakCase = this.weak.clone();
		weakAllCase[0] = weakCase.clone(); // 맨처음 케이스는 원본 배열
		
		// 원형 큐의 rotate방식으로 각 케이스 셍성
		for(int i=1;i<weak.length;i++) {
			int temp = weakCase[0]; 	// 맨뒤로 이동 할 맨 앞 원소
			
			// 나머지 원소는 한 칸씩 앞으로 떙기기
			for(int j=1;j<weak.length;j++)
				weakCase[j-1] = weakCase[j];
			
			// 위치차 계산을 쉽게 하기위해 맨뒤로 이동한 원소는 +n
			weakCase[weak.length-1] = temp+n;
			
			weakAllCase[i] = weakCase.clone();
		}
		
	}
}
