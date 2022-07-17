// 서로소집합 알고리즘(재귀를 이용한 경로압축)

package ThisIsCodingTest;

import java.util.Scanner;

public class Java0716_1 {
	
	// 노드 수 v, 간선 수 e
	public static int v,e;
	public static int[] parent = new int[100001];
	// 최대 노드 수 100,000개로 가정
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		// 부모테이블 상에서, 루트노드를 일단 자기 자신으로 초기화
		for(int i=0;i<=v;i++) parent[i] =i;
		
		for(int i=0;i<e;i++) {
			int a= sc.nextInt();
			int b = sc.nextInt();
			
			unionParent(a,b);
		}
		
		// 각 원소가 속한 집합(최종 루트노드) 출력하기
        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();
        
        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
		
	}
	
	// 두 원소가 속한 집합을 합치기(둘 다 같은 루트노드를 가지도록) 
	public static void unionParent(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);
		if(a>b) parent[a] = b;
		else parent[b] = a;
		
	}
	
	// 특정 원소가 속한 집합(최종 루트노드)를 찾기
	public static int findParent(int x) {
		
		if(x == parent[x]) return x;
		// 루트노드는 부모테이블 값이 자기 자신과 동일함.(main에서 초기화함)
		// 루트노드가 아니라면, 루트노드를 찾을 때까지 재귀
		
		return parent[x] = findParent(parent[x]);
        // 최종 루트노드를 parent[x] 에 저장함과 동시에 리턴
	}
}
