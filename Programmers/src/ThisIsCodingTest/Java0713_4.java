// 특정 key값을 기준으로 정렬

package ThisIsCodingTest;

import java.util.*;

class Fruit implements Comparable<Fruit>{
	
		
	private String name;
	private int score;
	
	public Fruit(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}
	

	// 정렬 기준 : 점수가 낮은 순서(오름차순)
	@Override
	public int compareTo(Fruit o) {
		if(this.score < o.score) return -1; // 음수 :오름차순 정렬
		return 1; // 양수 : 내림차순 정렬
	}

}

public class Java0713_4 {
	
	public static void main(String[] args) {
		List<Fruit> fruits = new ArrayList<>();
		
		fruits.add(new Fruit("바나나",2));
		fruits.add(new Fruit("사과",5));
		fruits.add(new Fruit("당근",3));
		
		Collections.sort(fruits); // Fruit에서 오버라이드한 내둉대로 정렬( 점수가 낮은 순으로 정렬 )
		
		for(int i=0; i<fruits.size();i++) {
			System.out.print("(" + fruits.get(i).getName() + "," + fruits.get(i).getScore()+ ") ");
		}
	}
}


// 결과 : [('바나나',2),('당근',3),('사과',5)]