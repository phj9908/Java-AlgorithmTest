package Practice.Java1112;

import java.util.*;

// 부품 확인 - 방법3) HashSet,contains()활용
public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashSet<Integer> arr1 = new HashSet<>();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			arr1.add(x);
		}
		
		int m = sc.nextInt();
		int[] targets = new int[n];
		for(int i=0;i<m;i++)
			targets[i] = sc.nextInt();
		
		for(int t:targets) {
			if(arr1.contains(t)) System.out.println("Yes");
			else System.out.println("no");
		}
	}

}
