// 모의고사

package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class java0704_3 {
    public List<Integer> solution(int[] answers) {
    	
    	int[] answer = {0,0,0};
    	
    	int[] stu1 = {1,2,3,4,5};
    	int[] stu2 = {2,1,2,3,2,4,2,5};
    	int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
    	
    	for(int i=0;i<answers.length;i++) {
    		if(answers[i]==stu1[i%stu1.length]) answer[0]+=1;
    		if(answers[i]==stu2[i%stu2.length]) answer[1]+=1;
    		if(answers[i]==stu3[i%stu3.length]) answer[2]+=1;
    	}
    	
    	int max=Arrays.stream(answer).max().getAsInt(); // 배열 내 최댓값 찾기
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	for(int i=0;i<answer.length;i++) {
    		if(answer[i]==max) ans.add(i+1); // 순서가 1부터 시작
    	}
        
        return ans;
    }
}
