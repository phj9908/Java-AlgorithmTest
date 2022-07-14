// 피보나치 수열
package ThisIsCodingTest;

// 보텀 업 : 반복문 활용
public class Java0714_7 {
	
	public static long[] d = new long[100];
	
	public static void main(String[] args) {
		
		d[1] = 1;
		d[2] = 2;
		int n = 50; // 50 번째 피보나치 수 계산
		
		for(int i=3; i<n;i++) d[i] = d[i-1]+d[i-2];
		
		System.out.print(d[n]);
	}
}

// 탑 다운 : 재귀 함수 이용
public class Main{
	public static long[] d = new long[100];
	
	public static void main(String[] args) {
		
		System.out.print(fibo(50));
	}

	public static long fibo(int x) {
		
		if(x==1||x==2) return 1;
		
		// 이미 계산한 적 있다면 그대로 반환
		if(d[x] !=0) return d[x];
		
		d[x] = fibo(x-1) + fibo(x-2);
		return d[x];
	}
}