// 2주차_커뮤러닝 모의테스트 - 그리디

package Programmers.lv2;

import java.util.Arrays;

public class Java0713_1 {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        
        Arrays.sort(people);
        Arrays.sort(tshirts);

        int tIdx=0;
        LOOP1:
            for (int p : people) {
                
                LOOP2:
                    while(true){
                        if (tIdx<tshirts.length && p <= tshirts[tIdx]){
                            answer++;
                            tIdx++;
                            break LOOP2;                    
                        }
                        if(tIdx+1<tshirts.length) 
                            tIdx++;  
                        else break LOOP1;            
                    }
                    
		}

        return answer;
    }
}
