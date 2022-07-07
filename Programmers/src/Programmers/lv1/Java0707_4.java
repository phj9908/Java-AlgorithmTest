// 문자열 내림차순 정렬
package Programmers.lv1;

import java.util.Arrays;

// StringBuilder 활용
public class Java0707_4 {
    public String solution(String s) {
        String answer = "";
        
        char[] arr = s.toCharArray(); 
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder(new String(arr));
        // String의 경우 new StringBuilder(String)
        // char[]의 경우 new StringBuilder(new String(char[])
        
        answer = sb.reverse().toString();
        
        return answer;
    }
}

// Character[]에 나눠 담아 Arrays.sort() 활용
public class Java0707_4 {
    public String solution(String s) {
        String answer = "";
        
        Character[] arr = new Character[s.length()]; 
        for(int i=0; i<arr.length; i++) arr[i] = s.charAt(i);
        
        Arrays.sort(arr,Collections.reverseOrder());
        // 이때 arr는 char[] 이 아닌 Character[] 이어야 함
        
        for(int i=0;i<arr.length;i++) answer+=arr[i];
        
        return answer;
    }
}

// String[]에 나눠 담아 Arrays.sort() 활용
public class Java0707_4 {
 public String solution(String s) {
     String answer = "";
     
     String[] arr = s.split("");
     Arrays.sort(arr,Collections.reverseOrder());
     
     for(int i=0;i<arr.length;i++) answer+=arr[i];
     
     return answer;
 }
}