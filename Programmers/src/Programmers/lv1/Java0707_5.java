// 최소공배수와 최대공약수
package Programmers.lv1;

public class Java0707_5 {
	
	public int gcd(int a, int b) {
		if(a==0) return b;
		
		return gcd(b%a,a);
	}
	
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = gcd(n,m);
        answer[1] = n*m/answer[0];
        
        return answer;
    }
}
