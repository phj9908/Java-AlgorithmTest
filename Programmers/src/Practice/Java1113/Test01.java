package Practice.Java1113;


// DP - 피보나치 수열

 //반복문(보텀 업)
public class Test01 {

	public static long[] d = new long[100];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		d[1] = 1;
		d[2] = 2;
		int n = 50; // 50번째 까지
		
		for(int i=3;i<n;i++) d[i] = d[i-1]+d[i-2];
		
		System.out.println(d[n]);
	}

}

//// 재귀(탑 다운)
//public class Test01 {
//
//	public static long[] d = new long[100];
//	
//	public static void main(String[] args) {
//		System.out.println(fibo(50));
//	}
//	
//	public static long fibo(int x) {
//		
//		if(x==1||x==2) return 1;
//		
//		// 이미 계산한 적 있다면
//		if(d[x] !=0) return d[x];
//		
//		d[x] = fibo(x-1) + fibo(x-2);
//		return d[x];
//	}
//
//}