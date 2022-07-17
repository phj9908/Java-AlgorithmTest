// 무지의 먹방라이브
// foodtimes를 우선순위 큐에 넣기. 그냥 반복문 돌리기엔 범위가 메우 크다.

package ThisIsCodingTest;

import java.util.*;

class Food implements Comparable<Food>{
	
	private int time;
	private int idx;
	
	public Food(int time, int idx) {
		this.time = time;
		this.idx = idx;
	}
	
	public int getIdx() {
		return this.idx;
	}
	
	public int getTime() {
		return this.time;
	}

	@Override // 짧은 시간 소요되는 음식 우선으로!(오름차순)
	public int compareTo(Food o) {
		 
		return this.time - o.time;
	}
	
	
}

public class Java0717_7 {
    public int solution(int[] food_times, long k) {

    	// 시간이 작은 음식부터 뺄 수 있도록 우선순위 큐 
        PriorityQueue<Food> q = new PriorityQueue<>();
        
        long total = 0;	 // 전체음식을 먹는 시간        
        for(int i=0;i<food_times.length;i++) {
        	q.add(new Food(food_times[i],i+1));
        	
        	if( total <=k ) total+= food_times[i];
        }
        if(total <= k) return -1;
        // 전체음식을 먹는 시간보다 k가 크거나 같다면 -1   
        
        total =0;  				// 먹기 위해 사용한 시간
        long previous =0; 		// 직전에 다 먹은 음식 시간
        long length = food_times.length;	// 남은 음식 갯수
        
        // ((pq.peek().getTime() - previous) * length)
        // = ( 현재 음식 시간 - 이전 음식 시간 )*현재 음식 갯수 
        // = 이전음식을 다 먹고 남은 현재음식을 마저 다 먹는 데 소요되는 시간
        // 위 시간 + 이전음식을 다 먹느라 소요한 시간(total) 이 k보다 작을 때만 while문
        while(total + ((q.peek().getTime() - previous)* length) <= k){
        	
        	int nowTime = q.poll().getTime();
        	total += (nowTime - previous)*length;
        	length--; // 다 먹은 음식 제외
        	previous = nowTime;
        }
        
        // 이제 남은 음식중에서 몇벙째 음식이 당첨되는지 
        ArrayList<Food> answer = new ArrayList<>();
        while(!q.isEmpty()) answer.add(q.poll());
        
        Collections.sort(answer, new Comparator<Food>() { 
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.getIdx(), b.getIdx());
                // 남은 음식 인덱스기준 오름차순 정렬
                // (문제에서 무지는 음식번호 순서대로 먹는다 했으니까)
            }
        });
        
        return answer.get((int) ((k - total) % length)).getIdx();
    }
}
