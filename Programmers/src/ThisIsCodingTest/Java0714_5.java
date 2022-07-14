// 부품 찾기

package ThisIsCodingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 방법 1 : 이진탐색
public class Java0714_5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i=0;i<n;i++) arr1[i] = sc.nextInt();
		
		Arrays.sort(arr1);
		// 이진 탐색을 위해 사전 정렬
		
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i=0;i<m;i++) arr2[i] = sc.nextInt();
		
		for(int i:arr2) {
			if(binarySearch(arr1,i,0,n-1)==-1) System.out.print("no ");
			else System.out.print("yes ");
		}
	}

	public static int binarySearch(int[] arr,int target, int startIdx, int endIdx) {
		
        while (startIdx <= endIdx) {
            int mid = (startIdx + endIdx) / 2;
            
            if (arr[mid] == target) return mid;
            
            else if (arr[mid] > target) endIdx = mid - 1;
            
            else startIdx = mid + 1; 
        }
        return -1;
	}
}

// 방법 2: 계수 정렬
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[x] = 1;
        }

        // M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[n];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            if (arr[targets[i]] == 1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }

}

// ***방법 3 : Hashset활용 하여 contains()메서드 쓰기
public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<n;i++) {
			int x = sc.nextInt();
			set.add(x);
		}
		
        int m = sc.nextInt();
        int[] targets = new int[n];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        
        for(int i:targets) {
        	if(set.contains(i)) System.out.print("no");
        	else System.out.print("yes");
        }
	}
}
