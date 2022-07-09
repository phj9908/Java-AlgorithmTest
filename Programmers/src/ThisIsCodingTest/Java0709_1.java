// 큰 수의 법칙
package ThisIsCodingTest;

import java.util.*;

public class Java0709_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// n,m,k 공백을 기준으로 입력 받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		// n개의 수를 공백을 기준으로 구분해 하나씩 입력받기
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);
		int fisrt = arr[n - 1];
		int second = arr[n - 2];
		
		// ---  방법1) 공식을 도출해 계산
		int first_cnt = (m / (k + 1)) * k;
		first_cnt += m % (k + 1);
		// 가장 큰 수가 더해지는 횟수

		int answer = 0;
		answer += fisrt * first_cnt;
		answer += (m - first_cnt) * second;
		
//		// --- 방법2) 반복문 활용
//		while(true) {
//			for(int i=0;i<k;i--) {
//				if(m==0) break;
//				answer+= first;
//				m--;
//			}
//			if(m==0) break;
//			answer+=second;
//			m--;
//		}

		System.out.println(answer);
	}
}


