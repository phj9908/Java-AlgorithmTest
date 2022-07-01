// 로또의 최고 순위 최저 순위

package Programmers;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero=0;
        int same=0;
        
        for(int l:lottos) {
        	if(l==0) zero++;
        	else {
        		for(int w:win_nums) {
        			if(l==w) same++;
        		}
        	}
        }
        int[] answer = {Math.min(7-(same+zero),6),Math.min(7-same, 6)}; // 7개 불일치 하면 6등으로 출력해야 하니까 min( ,6) 해주기
        
        return answer;
        
        }
    }
    
//    public static void main(String[] args) {
//    	int[] lottos= {44,1,0,0,31,25};
//    	int[] win_nums = {31, 10, 45, 1, 6, 19};
//    	
//    	Solution_lotto sol = new Solution_lotto();
//    	System.out.println(sol.solution(lottos, win_nums));
//    }
}