// 문자열 압축(다시풀기)

package ThisIsCodingTest;

public class Java0723_4 {
    public int solution(String s) {
    	
    	int answer = s.length();
    	for(int step=1;step<=s.length()/2;step++) {
    		
    		String prev=s.substring(0,step); 
    		// 앞에서부터 step수 만큼 문자열 추출
    		
    		String result="";
    		int cnt=1;
    		
    		for(int i=step;i<s.length();i+=step) {
    			String now="";
    		    for(int idx=i;idx<i+step;idx++) {
    				if( idx<s.length()) 
    					now+= s.charAt(idx);
    		    }
    		    
    		    if(now.equals(prev)) cnt++;
    		    else {
    		    	if(cnt>=2) {
    		    		result+=cnt+prev; // int + String = String 이용
    		    		cnt=1;
    		    	}
    		    	else result+= prev;
    		    	
    		    	now="";
    		    	for(int idx=i;idx<i+step;idx++) {
    		    		if(idx<s.length()) now += s.charAt(idx);
    		    		// idx가 문자열길이 넘어갈 수도 있기에 substring말고 for문
    		    	}
    		    	prev = now;
    		       	// 다시 이전 문자열초기화
    		    }
    		    			
    		}
	    	if(cnt>=2) 
	    		result+=cnt+prev;
	    	else
	    		result+=prev;
    		
	    	answer = Math.min(answer, result.length());
    	}
    	
        
        return answer;
    }
}
