// 뱀
// 이코드는 틀렸다. 원인은 못찾음

package ThisIsCodingTest;

import java.util.*;

class TurnDir{
	public TurnDir(int time, char dir) {

		this.time = time;
		this.direction = dir;

	}

	public char getDirection() {
		return this.direction;
	}

	public int getTime() {
		return this.time;
	}

	private int time;
	private char direction;
}

class Position{
	
	private int y,x;
	public Position(int y,int x) {
		this.y = y;
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public int getX() {
		return this.x;
	}
}

public class Java0724_1 {
	
	public static int n,k,l;
	public static int[][] arr;
	public static ArrayList<TurnDir> plan = new ArrayList<TurnDir>();
	// 회전 시간, 방향 정보 

	public static int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
	// 동,남,서,북
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
 
		arr = new int[n][n];
		for(int i=0;i<k;i++) 
		{
			int y = sc.nextInt()-1; // 문제에서 주는 입력값은 좌표 시작점 (1,1)임
			int x = sc.nextInt()-1;
			arr[y][x] = 1; // 사과가 있는 위치는 1을 가짐
		}
		
		l = sc.nextInt();
		for(int i=0;i<l;i++) {
			int time = sc.nextInt();
			//sc.nextLine(); // nextInt 다음 nextLine할 때만
			
			char str = sc.next().charAt(0);
			
			plan.add(new TurnDir(time,str));
		}
		
		System.out.print(simulate());

	}


	private static int simulate() {
		
		int y=0,x=0;
		arr[y][x] = 2; 
		// 뱀이 있는 위치 2/ 사과가 있는 위치/ 그 외 0으로 정하자

		int dir =0; // 방향 인덱스
		int t=0;
		int idx=0; // ArrayList plan의 인덱스
		
		Queue<Position> q = new LinkedList<>();
		q.offer(new  Position(y, x));
		
		while(true) {
			
			int ny = y+d[dir][0];
			int nx = x+d[dir][1];
			
			if(nx>=0&&ny>=0&&ny<n&&nx<n&&arr[ny][nx]!=2) {
				
				// 사과가 없다면 이동 후 꼬리가 위차한 좌표는 큐에서 없애기
				if(arr[ny][nx]==0) {
					arr[ny][nx]=2;
					q.offer(new Position(ny, nx));
					Position tail = q.poll();
					arr[tail.getX()][tail.getY()] = 0;
				}
				else if(arr[ny][nx]==1) {
					// 사과가 있으면 이동 후에 큐에 이동한 좌표 넣기
					arr[ny][nx] = 2;
					q.offer(new Position(ny, nx));
				}
				
			}
			else { // 벽이나 몸에 부딪혔다면
				t++;
				break;
			}
			
			x = nx; y = ny; // 다음 위치로 이동
			t++;
			
			if(idx<l&&plan.get(idx).getTime() == t) {
				dir= turn(dir,plan.get(idx).getDirection());
				idx++;
			}
		}
		
		return t;
	}


	public static int turn(int dir,char direction) {
		if(direction == 'L') 
			dir = (dir==0)? 3:dir-1;
		else
			dir = (dir+1)%4;
		
		return dir;
	}
}
