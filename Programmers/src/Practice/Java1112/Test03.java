package Practice.Java1112;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 특정 key값을 기준으로 정렬(implements Comparable)
class Fruit implements Comparable<Fruit>{
	
	private String name;
	private int score;
	
	public Fruit(String name, int score) {
		//super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	// 정렬기준 : 오름차순
	@Override
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		if(this.score<o.score) return -1;
		return 1;
	}	
}



public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Fruit> fruits = new ArrayList<>();
		
		fruits.add(new Fruit("a",2));
		fruits.add(new Fruit("b",5));
		fruits.add(new Fruit("c",3));
	
		Collections.sort(fruits); // Fruit에서 오버라이드한대로 정렬
		
		for(int i=0; i<fruits.size();i++)
			System.out.print("(" + fruits.get(i).getName() + "," + fruits.get(i).getScore()+ ") ");
		
	}

}
