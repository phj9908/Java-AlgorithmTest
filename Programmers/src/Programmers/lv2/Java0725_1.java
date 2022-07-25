// 커뮤러닝 솔루션 - 게임 맵 최단 거리
// ** 내가 푼 풀이와 다른점
//- 멤버가 y,x 좌표인 클래스, 그 좌표가 맵 내에 유효한 좌표인지 확인하는 메서드
//- int[][] count로 좌표마다 distance기록/ boolean[][] visited로 방문유무 기록

package Programmers.lv2;

import java.util.*;

class Position{
    int y,x;
    public Position(int y,int x){
        this.y = y;
        this.x = x;
    }
    
    boolean isValid(int n,int m){
        if(y<0||y>n-1||x<0||x>m-1) return false;
        
        return true;
    }
}

public class Java0725_1{
    
    public int n,m;
    public static int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int[][] count;
    public static boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        n=maps.length;
        m=maps[0].length;
        
        int[][] count = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0,0));
        count[0][0] = 1;
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            
            Position current = q.poll();
            int cost = count[current.y][current.x];
            
            for(int[] dir:d){
                
                Position move = new Position(current.y+dir[0],current.x+dir[1]);
                
                if(!move.isValid(n,m)) continue;		// 좌표 유무효를 따지기에 제일 먼저!
                if(visited[move.y][move.x]) continue;
                if(maps[move.y][move.x]==0) continue;

                count[move.y][move.x] = cost+1;
                visited[move.y][move.x] = true;
                q.offer(new Position(move.y,move.x));
            }
        }
        
        int answer = count[n-1][m-1];
        return answer==0 ? -1:answer;
    }
////////결과 확인 테스트
//	public static void main(String[] args) {
//		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//		Java0725_1 sol = new Java0725_1();
//		
//		System.out.print(sol.solution(maps));	
//	}    
}

