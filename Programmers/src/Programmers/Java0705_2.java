// 폰켓몬
package Programmers;

import java.util.HashSet;

public class Java0705_2 {
    public int solution(int[] nums) {
        
        int ans= nums.length/2;
        
        // 중복없애기위해 set활용
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums) set.add(i);
        
        // ans와 set.size()중 더 작은 값 리턴
        if(set.size()>ans) {
        	return ans;
        }else return set.size();
        //  return nums.length/2 > list.size()?list.size():nums.length/2;
        
    }
}
