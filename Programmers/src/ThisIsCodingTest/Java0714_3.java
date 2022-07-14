// 두 배열의 원소 교체

package ThisIsCodingTest;
import java.util.*;

public class Java0714_3 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Integer[] arr1 = new Integer[n];
		Integer[] arr2 = new Integer[n]; 
		// Collections.reverseOrder 함수를 적용하기 위해 Wrapper 객체로 생성
		
		for(int i=0;i<n;i++) {
			arr1[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			arr2[i] = sc.nextInt();
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2,Collections.reverseOrder());
		
		for(int i=0;i<n;i++) {
			if(k>0&&arr1[i]<arr2[i]) {

				int temp=arr1[i];
				arr1[i] = arr2[i];
				arr2[i] = temp;
				
				k--;
			}
			else break;
		}
		
		int sum=0;
		for(int i:arr1) sum+=i;
		
		System.out.println(sum);
		//System.out.print(Arrays.toString(arr1)); // 배열 출력
	}

}
