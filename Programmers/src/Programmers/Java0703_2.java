// 키패드 누르기
// 중간 키패드 누를때 양손의 위치 구하기 -> 위아래 거리는 3차이, 양 옆으로 1차이 이용해서 (현재 번호 - 누를 번호)/3 + (현재 번호 - 누를 번호) %3
// * =>10 , 0 =>11, # => 12 로 치환 

package Programmers;

import java.util.*;

class Solution{
	
	public String solution(int[] numbers, String hand) {

		String answer="";
		int left =10;
		int right = 12;
		
		for(int num:numbers) {
			if(num==1||num==4||num==7) {
				answer+="L";
				left = num;
			}
			else if(num==3||num==6||num==9) {
				answer+="R";
				right=num;
			}
			else {			               // 가운데 키패드 누르기, 더 가까운 손가락의 거리 구하기
				if(num==0) 
					num=11;
				
				int left_dist = Math.abs(num-left)/3 + Math.abs(num-left)%3; // 위아래 거리 + 좌우거리
				int right_dist = Math.abs(num-right)/3 + Math.abs(num-right)%3;
				
				if(left_dist<right_dist) {
					answer +="L";
					left = num;
				}else if ( left_dist>right_dist) {
					answer +="R";
					right = num;
				}else {
					if(hand.equals("left")) {
						answer+="L";
						left = num;
					}else {
						answer+="R";
						right = num;
					}
				}
			}
		}
		return answer;
	}
}

// // 수정 전
//class Solution {
//    public String solution(int[] numbers, String hand) {
//    	
//    	String answer = "";
//    	Queue<Integer> queue = new LinkedList<>();
//    	
//    	// 스택에 데이터 추가
//    	for(int i:numbers) {
//    		queue.add(i); // 또는 offer()
//    	}
//    	
//    	// 양 손의 위치
//    	// 일반 배열은 크기가 고정되어있지만 ArrayList는 크키가 고정되어있지 않기에 값을 추가하기 쉽다.
//    	List<Integer> l_hands = new ArrayList<Integer>();
//    	List<Integer> r_hands = new ArrayList<Integer>();    	
//    	
//    	// 키패드에 따른 좌표
//    	// Map에 배열을 넣기 위해서는 넣을 배열을 미리 생성해놔야 함
//    	int arr[][] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
//    	HashMap<Integer,int[]> keypad = new HashMap<>();
//    	
//    	for(int i=0;i<arr.length;i++) {
//    		keypad.put(i,arr[i]);
//    	}
//    	
//    	while(!queue.isEmpty()) {
//    		int x= queue.poll();
//    		if(x==1||x==4||x==7) {
//    			l_hands.add(x);
//    			answer+="L";
//    		}
//    		else if(x==3||x==6||x==9) {
//    			r_hands.add(x);
//    			answer+="R";
//    		}
//    		else { 							// 가운데 키패드 누르기, 더 가까운 손가락의 거리 구하기
//    			int ky = keypad.get(x)[0];
//    			int kx = keypad.get(x)[1];
//    			
//    			int ly=0; int lx =0;
//    			if(!l_hands.isEmpty()) {
//    				ly = keypad.get(l_hands.get(l_hands.size()-1))[0];
//    				lx = keypad.get(l_hands.get(l_hands.size()-1))[1];
//    			}  
//    			else {
//    				ly=3;
//    				lx =0;
//    			}
//    			
//    			int ry=0; int rx=0;
//    			if(!r_hands.isEmpty()) {
//    				ry = keypad.get(r_hands.get(r_hands.size()-1))[0];
//    				rx = keypad.get(r_hands.get(r_hands.size()-1))[1];
//    			}
//    			else {
//    				ry=3;
//    				rx=2;
//    			}
//    			
//    			if ( Math.abs(ly-ky)+Math.abs(lx-kx)>Math.abs(ry-ky)+Math.abs(rx-kx)) {
//    				r_hands.add(x);
//    				answer+="R";
//    			}
//    			else if ( Math.abs(ly-ky)+Math.abs(lx-kx)<Math.abs(ry-ky)+Math.abs(rx-kx)) {
//    				l_hands.add(x);
//    				answer+="L";
//    			}
//    			else {
//    				if (hand.equals("left")) {
//    					l_hands.add(x);
//    					answer+="L";
//    				}
//    				else {
//    					r_hands.add(x);
//    					answer+="R";
//    				}
//    			}
//    			
//    			
//    		}
//    	}
//    	
//        
//        return answer;
//    }
//}