// 올바른 괄호의 갯수 - 커뮤러닝
// 풀이 마저 찾아보던지 주말에 강의 듣던지

package Programmers.lv4;

import java.nio.charset.Charset;
import java.util.*;

public class Java0720_2 {
	
	public char[] braket = {'(',')'};
	public Queue<Char> q = new LinkedList<>();
	public int answer =0;
	
    public int solution(int n) {
    	
    	dfs(q,n,0);
    	
        return answer;
    }

    // 광호를 만드는 함수
	public void dfs(Queue<Char> q, int depth, int cnt) {
		
		if(depth == cnt) {
			if(check(q))
				answer++;
			return;
		}
		
		while(cnt<depth) {
			q.add(braket[cnt%2]);
			dfs(q,depth+1,cnt+1);
		}
		
	}
	
	// 올바른 괄호인지 판단하는 함수
	private boolean check(Queue<Char> q) {

		Stack<Char> stack = new Stack<>();
		
		while(!q.isEmpty()) {
			
			char c = q.peek();
			if(c==')') return false;
			
			stack.
					
		}
		
		
		return false;
	}
    

}
