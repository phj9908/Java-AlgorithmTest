// 팀 결성

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0716_5 {

	public static int n,m;
	public static int[] parent = new int[100001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) parent[i] = i;
		
		for(int i=0;i<m;i++) {
			
			int x = sc.nextInt();
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(x==0) unionParent(a,b);
			else {
				
				int findA = findParent(a);
				int findB = findParent(b);
				
				if (findA ==findB) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}

	public static int findParent(int x) {
		
		if(x == parent[x] ) return x;
		return parent[x] = findParent(parent[x]);
	}

	private static void unionParent(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
		
	}
}
