package Practice.Java1115;

import java.util.Scanner;

// 서로소 집합 알고리즘 예제
public class Test03 {
	
	public static int n,m;
	public static int[] parent = new int[100001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) parent[i] =i;
		
		for(int i=0;i<m;i++) {
			
			int x = sc.nextInt();
			int a = sc.nextInt();
			int b= sc.nextInt();
			
			if(x==0) unionParent(a,b);
			else {
				int findA = findParent(a);
				int findB = findParent(b);
				
				if(findA == findB) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}

	private static void unionParent(int a, int b) {
		// TODO Auto-generated method stub
		a = findParent(a);
		b = findParent(b);
		if(a>b) parent[a] = b;
		else parent[b] =a;
	}

	private static int findParent(int x) {
		// TODO Auto-generated method stub
		if( x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}

}
