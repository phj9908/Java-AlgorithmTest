// 베스트 앨범

// 같은 장르내에서 재생횟수가 많은 순으로하되 같으면 오름차순으로 정렬 >> 이 부분을 클래스를 이용해 구현한 코드는
//  https://hyeyun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Programmers-Level-3-%EB%B2%A0%EC%8A%A4%ED%8A%B8-%EC%95%A8%EB%B2%94-JAVA-%EC%9E%90%EB%B0%94?category=1229492

package Programmers.HighScoreKit;

import java.util.*;

public class Hash0808_5 {
	public int[] solution(String[] genres,int[] plays) {
		
		// (장르, 누적횟수)
		HashMap<String,Integer> playTimeMap = new HashMap<>();
		
		// (장르, (인덱스, 해당 횟수))
		HashMap<String,HashMap<Integer,Integer>> musicMap = new HashMap<>();
		
		// 각 HashMap 초기화
		for(int i=0;i<genres.length;i++) {
			
			// musicMap 초기화
			if(musicMap.containsKey(genres[i])) 
				musicMap.get(genres[i]).put(i, plays[i]);			
			else {
				HashMap<Integer,Integer> map = new HashMap<>();
				map.put(i, plays[i]);
				musicMap.put(genres[i], map);
			}
			
			// playTimeMap 초기화
			playTimeMap.put(genres[i], playTimeMap.getOrDefault(genres[i], 0)+plays[i]);
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		// playTimeMap의 key들을 리스트로 만들어 누적횟수 내림차순으로 정렬
		List<String> keySet = new ArrayList(playTimeMap.keySet());
		Collections.sort(keySet,(a,b) -> playTimeMap.get(b) - playTimeMap.get(a));
		
		// 같은 장르내에서 플레이 횟수 내림차순 정렬 
		for(String key:keySet) {
			
			HashMap<Integer,Integer> map = musicMap.get(key);
			List<Integer> mapKey = new ArrayList(map.keySet());
			Collections.sort(mapKey,(a,b) -> map.get(b) - map.get(a));
			
			// 각 장르별로 가장 큰것 2개까지만 담기
			answer.add(mapKey.get(0)); // 가장 큰 것
			if(mapKey.size()>1)
				answer.add(mapKey.get(1)); // 두번째 큰 것
		}
		
		// ArrayList를 int배열로 리턴
		return answer.stream().mapToInt(i->i).toArray();
	}
}




