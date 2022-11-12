package Practice.Java1112;

import java.util.Scanner;

// 부품찾기 - 방법2) 계수정렬
public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// N(가게의 부품개수)
		int n = sc.nextInt();
		int[] arr1 = new int[1000001];
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			arr1[x] = 1;
		}
		
		// M(손님이 확인 요청한 부품개수)
		int m = sc.nextInt();
		int[] targets = new int[n];
		for(int i=0;i<m;i++)
			targets[i] = sc.nextInt();
		
		//손님이 확인 요청한 부품번호를 하나씩 확인
		for(int i=0;i<m;i++) {
			
			//해당 부품이 존재하는지 확인
			if(arr1[targets[i]] == 1)
				System.out.println("yes");
			else
				System.out.println("no");
			
		}
	}

}
