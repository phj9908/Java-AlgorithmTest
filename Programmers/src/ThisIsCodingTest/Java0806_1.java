// 치킨배달

package ThisIsCodingTest;

import java.util.ArrayList;
import java.util.Scanner;

class Position{
	public Position(int i, int j) {
		this.y=i;
		this.x =j;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	private int y,x;
	
	
}

class Combination{
	
	private int n; // 치킨 집 전체 개수
	private int m;
	
	private int[] nowCombi; // 현재 조합
	private ArrayList<ArrayList<Position>> result; // 모든 조합	
	
	public Combination(int size, int m) {
		this.n = size;
		this.m = m;
		 
		this.nowCombi = new int[m];
		this.result = new ArrayList<ArrayList<Position>>();
	}

	public ArrayList<ArrayList<Position>> getResult() {
		return result;
	}

	// 조합을 구하기 위해 dfs활용
	public void combinationDFS(ArrayList<Position> chicken, int depth, int idx, int chickenIdx) {
		if(depth==m) {
			ArrayList<Position> temp = new ArrayList<>();
			for(int i=0;i<nowCombi.length;i++)
				temp.add(chicken.get(nowCombi[i]));
			
			result.add(temp);
			return;
		}
		
		if(chickenIdx==n) return;	
		nowCombi[idx] = chickenIdx;	// 치킨 인덱스? 저장 (52line 참고)
		combinationDFS(chicken,depth+1,idx+1,chickenIdx+1); // 포함	
		combinationDFS(chicken, depth, idx, chickenIdx+1);  // 비포함
	}
}

public class Java0806_1 {
	public static int n,m;
	public static int[][] map = new int[50][50]; 
	
	public static ArrayList<Position> house = new ArrayList<>();
	public static ArrayList<Position> chicken = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] ==1) // 집
					house.add(new Position(i,j));
				else if(map[i][j]==2)	// 치킨 집
					chicken.add(new Position(i,j));
			}
		}
		
		// 모든 치킨 집 중에서 m개의 조합 계산
		Combination combi = new Combination(chicken.size(),m);
		combi.combinationDFS(chicken,0,0,0);
		ArrayList<ArrayList<Position>> chickenList = combi.getResult();
		
		// 치킨 거리의 합의 최소 출력
        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);
	}
	
	    public static int getSum(ArrayList<Position> candidates) {
        int result = 0;
          // 모든 집에 대하여
          for (int i = 0; i < house.size(); i++) {
              int hx = house.get(i).getX();
              int hy = house.get(i).getY();
              // 가장 가까운 치킨 집을 찾기
              int temp = (int) 1e9;
              for (int j = 0; j < candidates.size(); j++) {
                  int cx = candidates.get(j).getX();
                  int cy = candidates.get(j).getY();
                  temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
              }
              // 가장 가까운 치킨 집까지의 거리를 더하기
              result += temp;
          }
          // 치킨 거리의 합 반환
          return result;
    }
	
}
