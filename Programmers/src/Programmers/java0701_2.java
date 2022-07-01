package Programmers;
import java.util.Arrays;
import java.util.stream.IntStream;

// 

class Solution1 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] arr = {6,6,5,4,3,2,1};
        int zeros = 0;
        int same = 0;
        
        for(int l:lottos) {
        	if(l==0) zeros++;
        	if(IntStream.of(win_nums).anyMatch(x -> x== l)) same++; 
        }
        
        int[] answer = {arr[zeros+same],arr[same]};
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] lottos= {44,1,0,0,31,25};
    	int[] win_nums = {31, 10, 45, 1, 6, 19};
    	
    	Solution sol = new Solution();
    	System.out.println(sol.solution(lottos, win_nums));
    }
}