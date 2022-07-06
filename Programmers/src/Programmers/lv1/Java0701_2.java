// 로또의 최고 순위 최저 순위

package Programmers.lv1;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero=0;
        int same=0;
        
        for(int l:lottos) {
        	if(l==0) zero++;
        	else {
        		for(int w:win_nums) {
        			if(l==w) same++;
        		}
        	}
        }
        
        return new int[] {Math.min(7-(same+zero),6),Math.min(7-same, 6)};// 7개 불일치 하면 6등으로 출력해야 하니까 min( ,6) 해주기
        
        }
    }
    
//    public static void main(String[] args) {
//    	int[] lottos= {44,1,0,0,31,25};
//    	int[] win_nums = {31, 10, 45, 1, 6, 19};
//    	
//    	Solution_lotto sol = new Solution_lotto();
//    	System.out.println(sol.solution(lottos, win_nums));
//    }
}

// Map을 이용해 로또번호를 key값으로 할당 
/*
 import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true); // key할당
        }


        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++;
        }

        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
}
*/

// switch - return 함수 사용
/*
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int cnt1 = 0;
        int cnt2 = 0;
        for(int i : lottos) {
            if(i == 0) {
                cnt1++;
                continue;
            }
            for(int j : win_nums) {
                if(i == j) cnt2++;
            }
        }


        answer[0] = getGrade(cnt1+cnt2);
        answer[1] = getGrade(cnt2);

        return answer;
    }

    public int getGrade(int n) {
        switch(n) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }
}
*/