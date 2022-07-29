// 세균증식(임시 제목) - 커뮤러닝 기말고사(DFS)
// 재귀 스택오버플로 발생. 추후 수정 필요

package Programmers.lv2;

public class Java0729_2 {
	
	public static int[][] arr;
	public static int[][] d= {{-1,0},{1,0},{0,1},{0,-1}};
	
    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        
    	arr= new int[rows][columns];
    	
    	for(int[] q:queries)
    		dfs(q[0]-1,q[1]-1,rows,columns,max_virus);
    	
        return arr;
    }

	private void dfs(int y, int x,int row,int col, int max_virus) {
		
		if(y<0||y>row-1||x<0||x>col-1) return;
		if(arr[y][x]>=max_virus) {
			for(int[] dir:d) {
				dfs(y+dir[0],x+dir[1],row,col,max_virus);
			}
			
		}
		else arr[y][x]++;
			
		return;
	}
}
