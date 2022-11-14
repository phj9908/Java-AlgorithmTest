package Practice.Java1114;

import java.util.Scanner;

// 서로소 집합 알고리즘
public class Test05 {

	public static int v,e; // 노드 수, 간선 수
	public static int[] parent = new int[100001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		// 부모 테이블 상에서, 루트노드는 자기 자신으로 초기화
		for(int i=0;i<=v;i++) parent[i] = i;
		
		for(int i=0;i<e;i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			unionParent(a,b);
		}
		
		// 각 원소가 속한 집합(최종 루트노드) 출력하기
		System.out.println("각 원소가 속한 집합: ");
		for(int i=1;i<=v;i++)
			System.out.print(findParent(i)+ " ");
		System.out.println();
		
	}

	private static void unionParent(int a, int b) {
		// TODO Auto-generated method stub
		a = findParent(a);
		b = findParent(b);
		
		if(a>b) parent[a] = b; // 더 작은게 상대의 부모가 됨
		else parent[b] =a;
	}

	private static int findParent(int x) {
		// TODO Auto-generated method stub
		
		// 루트노드면 그대로 리턴, 루트노드는 부모테이블 값이 자기자신과 동일함.
		if(x == parent[x]) return x;
		else return parent[x] = findParent(parent[x]);
		// 루트노드가 아니면 루트노드를 찾을 때까지 재귀,
		// 최종 루트노드를 parent[x]에 저장함과 동시에 리턴
	}

}
