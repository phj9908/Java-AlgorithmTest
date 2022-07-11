// 기지국 설치 - 커뮤러닝 코테

package Programmers.lv3;

public class Java0708_1 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start =1;
        
        for(int s:stations){
            if(start<s-w){
                int end = s-w;
                int length = end-start;                 
                
                answer+= (length%(2*w+1)==0)? length/(2*w+1):length/(2*w+1)+1;
            }
            start = s+w+1;
        }
        
        // 만약 마지막 기지국 + w 뒤에 또 기지국 설치할 구간이 있다면
        if (start<=n){
            int end = n+1;
            int length = end-start;
            
            answer+=(length%(2*w+1)==0)? length/(2*w+1):length/(2*w+1)+1;
        }
        return answer;
    }
}
