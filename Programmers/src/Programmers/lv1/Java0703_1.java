// 숫자문자열과 영단어

package Programmers.lv1;

import java.util.Arrays;

class Solution {
    public int solution(String s) {
    	
        String[] arr= {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(String str : arr) {
        	int idx = Arrays.asList(arr).indexOf(str);
        	s=s.replaceAll(str, Integer.toString(idx));
        }
        
        int answer = Integer.parseInt(s);
        return answer;
    }
}

 // OR HashMap  활용

//import java.util.HashMap;
//
// HashMap<String,Integer> map = new HashMap<>();
// String[] arr= {"zero","one","two","three","four","five","six","seven","eight","nine"};
// 
// for(int i=0; i<arr.length();i++){
//	 map.put(arr[i], i);
// }
// 
// for (String key:map.keySet()) {
//	 s = s.replaceAll(key,map.get(key));
// }