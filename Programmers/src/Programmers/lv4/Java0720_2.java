// 올바른 괄호의 갯수 - 커뮤러닝 솔루션
//ex) n=2 일때, (()) / ()()
//- 열리는 괄호를 먼저 배치하기
//- 그 이후에 앞의 열린괄호의 갯수에 맞게 닫히는 괄호 배치하기
//- 괄호는 2*n개 초과하여 사용할 수 없다.
//- 열리기 전에는 닫히는 괄호를 사용할 수 없다.


package Programmers.lv4;
import java.util.*;


// 방법1) 스택을 활용한 BFS
class P{
	public P(int open, int close) {
		this.open = open;
		this.close = close;
	}

	// 열린 괄호ㅇ 갯수, 닫힌 괄호 갯수 담당할 멤버
	int open,close;
	
}

public class Java0720_2 {
	
	public int solution(int n) {
		int answer = 0;
		
		Stack<P> stack = new Stack<P>();
		stack.push(new P(0,0)); // 시작은 각각 0개 이기에
		
		while(!stack.isEmpty()) {
			
			P p = stack.pop();
			
			if(p.open > n) continue; // 열린괄호의 수가 n개보다 많으면 안됨
			if(p.open<p.close) continue; // 닫힌 괄호수가 더 많으면 안됨
			if(p.open + p.close == 2*n) { // 짝이 맞고 갯수를 다 채웠다면 
				answer++;
				continue;
			}
			
			stack.push(new P(p.open+1,p.close)); // 열린괄호를 먼저 추가 배치
			stack.push(new P(p.open,p.close+1)); 
			
		}
		return answer;
	}
}

//  방법2) 재귀를 할용한 DFS
class Solution{
	static int answer;
	
	public int solution(int n) {
		
		answer =0;
		dfs(0,0,n);
		
		return answer;
	}
	
	public static void dfs(int open,int close,int n) {
		
		if(open>n||close>n) return;
		if(open < close)	return;
		
		if(open==n&&close==n) {
			answer++;
			return;
		}
		
		dfs(open+1,close,n);
		dfs(open,close+1,n);
	}
}
