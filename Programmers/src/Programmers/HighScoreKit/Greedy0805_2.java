// 조이스틱

package Programmers.HighScoreKit;

public class Greedy0805_2 {
	public int solution(String name) {
		
		int answer=0;
		int min_move = name.length()-1;
		
		for(int i=0;i<name.length();i++) {
			
			// up과 down을 했을 때 더 작은 횟수
			answer+=Math.min(name.charAt(i)-'A','Z'+1-name.charAt(i));
			
			int next = i+1;	// 마지막 A다음 문자의 인덱스
			while(next<name.length()&&name.charAt(next)=='A')
				next++;
			// 'JAAZ'면 i=0일 때 next=3까지 채우고 반복문 탈출	
			
			min_move = Math.min(min_move, i+i+name.length()-next);
			// 블로그 참고. 정방향으로 갔을 때 vs 반대방향으로 갔을 때
			
			// BBBBAAAAAAB 같이, 연속된 A의 앞쪽보다 뒷쪽이 짧은 경우
			// 뒷쪽부터 조작하는 것이 더 적은 이동횟수를 가질 경우까지 고려해서
			min_move = Math.min(min_move,(name.length()-next)*2+i);
		}
		
		answer+=min_move;
		
		return answer;
	}
}
