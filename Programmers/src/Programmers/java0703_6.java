// 소수 만들기
// 조합 구현하기 -> dfs
// 중복되는 수는 안주기에 visited 체크는 안해도 됨

package Programmers;

class java0703_6 {

	public int answer = 0; // 클래스 내의 어느 함수에서도 접근가능하도록
	public boolean[] sieve; // 주의) 여기서 = new boolean[n] 하면 안됨 main에서 해야함

	public int solution(int[] nums) {

		sieve = new boolean[3001]; 		// 각 원소의 최댓값이 1000, 근데 3개 조합이기에 3000까지 소수 판별 해놔야 함

		isPrime(); // sieve 인덱스 숫자의 소수 여부 판별

		dfs(nums, 0, 0, 0); // 조합한 뒤 그 수의 인덱스가 소수이면 answer에 1증가

		return answer;
	}

	public void isPrime() {

		// true로 초기화
		for (int i = 2; i <= 3000; i++) {
			sieve[i] = true;
		}

		for (int i = 2; i <= (int) Math.sqrt(3000); i++) {
			for (int j = i * i; j <= 3000; j += i) { 		// i*i 미만은 이미 소수판단이 되었음
				sieve[j] = false;
			}
		}

	}

	public void dfs(int[] arr, int depth, int start, int sum) {
		if (depth == 3) {
			if (sieve[sum])
				answer++;
			return;
		}

		for (int i = start; i < arr.length; i++) {
			dfs(arr, depth + 1, i + 1, sum + arr[i]);
		}
	}

}
