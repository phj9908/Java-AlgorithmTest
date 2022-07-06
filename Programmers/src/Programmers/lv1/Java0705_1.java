// 체육복

package Programmers.lv1;

public class Java0705_1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] arr = new int[n]; // default로 크기 n만큼 원소 0 부여
        						// arr =  {0,0,0,0,0,...]
        // 0외의 다른값으로 할당하고 싶을 때
        //  Arrays.fill(arr,1);
        
        for(int l : lost) arr[l-1]--;
        for(int r: reserve) arr[r-1]++;
        
        // 잃어버린 사람은 -1, 여분의 체육복이 있는 사람은 +1
        for(int i=0;i<arr.length;i++) {
        	if(arr[i] == -1 ) {			   // 본인은 체육복이 없는 상태
        		if(i-1>=0&& arr[i-1]==1) { // 앞 사람이 체육복이 있을 때
        			arr[i-1]--;
        			arr[i]++;
        		}
        		else if(i+1<arr.length && arr[i+1]==1) { // 뒷 사람이 체육복이 있을 때
        			arr[i+1]--;
        			arr[i]++;
        		}else 
        			answer--;
        	}
        }
        
        return answer;
    }
}
