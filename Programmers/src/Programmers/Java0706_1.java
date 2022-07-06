// 실패율

package Programmers;

import java.util.*;

// 방법1) 2차원 ArrayList<double[]> 를 사용해서 각 {스테이지 번호, 그 스테이지의 실패율} 저장
public class Java0706_1 {
    public int[] solution(int N, int[] stages) {
        
        int whole = stages.length;
        List<double[]> fail = new ArrayList<>();
        
        int cnt=0;
 	
    	//stage는 1부터 N + 1까지 있음, 실패율은 N까지만 구하기
        for(int i=1;i<=N; i++)
        {
        	// 각 스테이지의 사람수 구하기
        	for(int j=0;j<stages.length;j++) {
        		if(i==stages[j])
        			cnt++;
        	}
        	
        	// {스테이지 번호, 실패율} 구하기
        	double fail_rate = 0;
        	fail_rate = (cnt==0) ? 0: cnt/(double)whole;
        	fail.add(new double[] {i,fail_rate});
        	// 나누는 수가 0이면 나누기 연산에서 에러가 나기에 미리 0할당
        	// 직접형변환(double) 꼭 해주기!
        	
        	whole -= cnt;
        	cnt=0;
        }
        
        // (두번째 요소)실패울을 기준으로 내림착순 정렬
        fail.sort((a,b) -> Double.compare(b[1], a[1]));
        
        // 스테이지 번호 구하기
        int[] answer = new int[N];
        for(int i=0; i<fail.size();i++) answer[i]=(int)fail.get(i)[0];

        return answer;
    }

}

// 방법2) class 생성하여 class멤버 변수로 스테이지 번호, 실패율 할당
public class Java0706_1 {
	
	static class Fail{
		int idx;		// stage 번호
		double rate;	// 실패율
		
		public Fail(int idx, double rate) {
			this.idx = idx;
			this.rate = rate;
		}
	}
	
    public int[] solution(int N, int[] stages) {
        
        int whole = stages.length;      
        int cnt=0;
 	
    	//stage는 1부터 N + 1까지 있음, 실패율은 N까지만 구하기
        ArrayList<Fail> fail = new ArrayList<>();
        for(int i=1;i<=N; i++)
        {
        	// 각 스테이지의 사람수 구하기
        	for(int j=0;j<stages.length;j++) {
        		if(i==stages[j])
        			cnt++;
        	}
        	
        	// {스테이지 번호, 실패율} 구하기
        	double fail_rate = 0;
        	fail_rate = (cnt==0) ? 0: cnt/(double)whole;
        	fail.add(new Fail(i,fail_rate));
        	// 나누는 수가 0이면 나누기 연산에서 에러가 나기에 미리 0할당
        	// 직접형변환(double) 꼭 해주기!
        	
        	whole -= cnt;
        	cnt=0;
        }
        
        // 실패울을 기준으로 내림착순 정렬
        fail.sort((a,b) -> Double.compare(b.rate, a.rate));
        
        // 스테이지 번호 구하기
        int[] answer = new int[N];
        for(int i=0; i<fail.size();i++) answer[i]=(int)fail.get(i).idx;

        return answer;
    }

}