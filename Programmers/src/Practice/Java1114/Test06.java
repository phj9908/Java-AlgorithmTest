package Practice.Java1114;

import java.util.Scanner;

// 서로소 집합을 활용한 사이클 판별
// 루트노드가 같으면 사이클 발생
// 아니면 두 노드에 대해 합집합 연산 수행
public class Test06 {
// 사이클이 발생하면 종료하도록 하기
	
	public static int v,e;
	public static int[] parent = new int[100001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean cycle = false;
		
		Scanner sc = new Scanner(System.in);
		v= sc.nextInt();
		e = sc.nextInt();
		
		for(int i=1;i<=v;i++) parent[i] = i;
		
		for(int i=0;i<e;i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 루트노드가같으면 ,즉 집합이 같으면 종료!
			if(findParent(a) == findParent(b)) {
				cycle = true;
				break;
			}else unionParent(a,b); // 아니면 합집합 시키기
			
		if(cycle) System.out.println("사이클 발생");
		else System.out.println("사이클 비발생");
		}
	}

	private static void unionParent(int a, int b) {
		// TODO Auto-generated method stub
		a = findParent(a);
		b = findParent(b);
		
		if(a>b) parent[a] = b;
		else parent[b] = a;
	}

	private static int findParent(int x) {
		// TODO Auto-generated method stub
		if(x == parent[x]) return x;
		return parent[x] =findParent(x);
	}

}
