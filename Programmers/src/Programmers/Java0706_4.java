// 두 개 뽑아서 더하기 
import java.util.*;

package Programmers;

public class Java0706_4 {
	
	public TreeSet<Integer> set;
	
	public void dfs(int[] arr,int depth,int start,int sum) {
		if(depth==2) {
			set.add(sum);
			return;
		}
		
		for(int i=start; i<arr.length;i++)
			dfs(arr,depth+1,i+1,sum+arr[i]);
		
	}
	
    public Integer[] solution(int[] numbers) {
    	
        Integer[] answer = {};
        set = new TreeSet<>();
        
        dfs(numbers,0,0,0);
        answer = set.toArray(new Integer[0]);
        // set -> array
        // 이떄 배열 크기를 0으로 지정하면 자동으로 배열의 크기가 지정됨        
        
        return answer;
    }
}
