package Practice.Java1112;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 성적 오름차순 학생 출력
//<String, Integer>로 묶어 이차원 어레이리스트를 생성
class Students implements Comparable<Students>{
	
	private String name;
	private int score;
	
	public Students(String name, int score) {
		super();
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
	
	// 오름차순 정렬
	@Override
	public int compareTo(Students o) {
		// TODO Auto-generated method stub
		if(this.score < o.score) return -1;
		return 1;
	}
	
	
}


public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// '홍길동 96'입력 받아 각각 이름, 점수로 할당
		List<Students> students = new ArrayList<>();

		for(int i=0;i<students.size();i++) {
			String name = sc.next();
			int score = sc.nextInt();
			
			students.add(new Students(name,score));
		}
		
		Collections.sort(students);
		
		for(int i=0;i<students.size();i++)
			System.out.println(students.get(i).getName());
		
	}

}
