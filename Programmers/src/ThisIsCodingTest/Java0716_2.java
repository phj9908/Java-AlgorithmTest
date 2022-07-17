// 서로소 집합을 이용한 사이클 판별
// 사이클이 발생했다면 종료하는 로직

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0716_2 {
	
	public static int v,e;
	public static int[] parent = new int[100001];
	
	public static void main(String[] args) {
		
		boolean cycle = false;
		
		Scanner sc = new Scanner(System.in);
		
		v= sc.nextInt();
		e = sc.nextInt();
		
		for(int i=1;i<=v;i++) parent[i] = i;
		
		for(int i=0;i<e;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 루트노드가 같다면, 즉 집합이 같다면 종료
			if(findParent(a) == findParent(b)) {
				cycle = true;
				break;
			}else unionParent(a,b); // 아니면 합집합 수행
			
		if(cycle) System.out.print("사이클이 발생했습니다.");
		else System.out.print("사이클이 발생하지 않았습니다.");
			
		}
	}
	
	
	public static void unionParent(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);
		if(a<b) parent[b] = a;
		else parent[a] = b;
		
	}

	public static int findParent(int x) {
		
		if(x == parent[x]) return x;
		
		return parent[x] = findParent(parent[x]);
	}
}
