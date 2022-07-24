// 기둥과 보 설치

package ThisIsCodingTest;

import java.util.*;

class NodeXYStuff implements Comparable<NodeXYStuff>{
	public NodeXYStuff(int x,int y, int stuff) {
		this.x = x;
		this.y = y;
		this.stuff = stuff;
	}

	private int x,y,stuff;

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getStuff() {
		return this.stuff;
	}
	
	// x,y,stuff 순서대로 오름차순 정렬
	@Override
	public int compareTo(NodeXYStuff o) {
		
		// 우선순위 3, x도 같고 y도 같을 때 : stuff가 기준
		if(this.x==o.x&&this.y==o.y) 
			return Integer.compare(this.stuff, o.stuff);
		
		// 우선순위 2, x가 같을 때 : y가 기준
		if(this.x==o.x)
			return Integer.compare(this.y, o.y);
		
		// 우선순위 1 , x기준
		return Integer.compare(this.x, o.x);
	}
}

public class Java0724_2 {
    public int[][] solution(int n, int[][] build_frame) {
    	
    	ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
    	
    	for(int[] b:build_frame) {
    		
    		int x = b[0];
    		int y = b[1];
    		int stuff = b[2]; // 기둥/보
    		int operate = b[3]; // 설치/삭제
    		
    		if(operate==0) { 	// 삭제하는 경우// 일단 해당 stuff 삭제하기
    			int idx =0;
    			
    			// ArrayList에서 해당 명령이 있는 인덱스 찾기
    			for(int i=0;i<answer.size();i++) {
    				if (x==answer.get(i).get(0)&& y==answer.get(i).get(1) &&stuff==answer.get(i).get(2) )
    					idx = i;	
    			}
    			
    			ArrayList<Integer> erased = answer.get(idx);
    			answer.remove(idx);
    			
    			if(!possible(answer))	// 불가능한 구조물이라면 다시 설치
    				answer.add(erased);
    		}
    		else {				// 설치하는 경우 // 일단 설치
    			
    			ArrayList<Integer> inserted = new ArrayList<Integer>();
    			inserted.add(x);
    			inserted.add(y);
    			inserted.add(stuff);
    			
    			answer.add(inserted); // 왜 굳이 클래스 객체로 안넣고 이차원 리스트로 이렇게 한거지?
    								  // 삭제하는 경우 삭제를 하고 막상 불가능한 구조물이되면
    								  // 그 stuff를 찾아 다시 추가해야하는데, 
    								  // 이때 인덱스로 찾을 수 있도록 리스트를 사용
    			
    			if(!possible(answer)) // 불가능한 구조물이라면
    				answer.remove(answer.size()-1);	// 삭제
    			
    		}
    	}
    	
    	//  x좌표 기준 오름차순 정렬 + x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬
        ArrayList<NodeXYStuff> ans = new ArrayList<NodeXYStuff>();
        for(int i=0;i<answer.size();i++)
        	ans.add(new NodeXYStuff(answer.get(i).get(0),answer.get(i).get(1),answer.get(i).get(2)));
    	
        Collections.sort(ans);
    	
        // 배열로 바꿔 반환
        int[][] res = new int[ans.size()][3];
        for(int i=0;i<ans.size();i++) {
        	res[i][0] = ans.get(i).getX();
        	res[i][1] = ans.get(i).getY();
        	res[i][2] = ans.get(i).getStuff();
        }
        
        return res;
    }

	public boolean possible(ArrayList<ArrayList<Integer>> answer) {
		
		for(int i=0;i<answer.size();i++) {
			int x= answer.get(i).get(0);
			int y= answer.get(i).get(1);
			int stuff = answer.get(i).get(2);
			
			if(stuff ==0) { 		// 기둥일 때
				boolean check = false;
				
				if(y==0) check = true; // 바닥 위일 때 정상
				
				for(int j=0;j<answer.size();j++) {
					
					// 보의 끝점 끝부분 위 일때 정상 
					if(x-1==answer.get(j).get(0)&& y==answer.get(j).get(1)&& answer.get(j).get(2)==1)
						check = true;
					// 보의 시작점 끝부분 위 일때 정상
					if(x==answer.get(j).get(0)&& y==answer.get(j).get(1)&& answer.get(j).get(2)==1)
						check = true;
					// 다른 기둥 위 일때 정상
					if(x==answer.get(j).get(0)&& y-1==answer.get(j).get(1)&& answer.get(j).get(2)==0)
						check = true;
				}
				
				if(!check) return false;
			}
			else {				// 보 
				boolean check = false;
				boolean left = false;
				boolean right = false;
				
				for(int j=0;j<answer.size();j++) {
					
					// 보의 시작점이 기둥 위일 때 정상
					if(x==answer.get(j).get(0)&&y-1==answer.get(j).get(1)&&answer.get(j).get(2)==0)
						check = true;
					// 보의 끝점이 기둥 위일때 정상
					if(x+1==answer.get(j).get(0)&&y-1==answer.get(j).get(1)&&answer.get(j).get(2)==0)
						check = true;
					// 보의 시작점이 다른 보의 끝점과 연결되었을 때 정상
					if(x-1==answer.get(j).get(0)&&y==answer.get(j).get(1)&&answer.get(j).get(2)==1)
						left = true;
					// 보의 끝점이 다른 보의 시작점과 연결되었을 때 정상
					if(x+1==answer.get(j).get(0)&&y==answer.get(j).get(1)&&answer.get(j).get(2)==1)
						right = true;
				}
				
				if(left&&right) check = true;
				if(!check) return false;
				
			}
		}
		return true;
	}
}
