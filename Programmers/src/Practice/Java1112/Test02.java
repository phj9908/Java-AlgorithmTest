package Practice.Java1112;

// 계수정렬
public class Test02 {

	// 0부터 9까지원소로 이뤄진 배열
	private static int MAX_VALUE=9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=15;
		int[] arr =  {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
		
		int[] cnt = new int[MAX_VALUE +1];
		
		for(int i=0; i<n; i++)
			cnt[arr[i]]+=1;
		
		for(int i=0;i<=MAX_VALUE;i++) {
			for(int j=0;j<cnt[i];j++) {
				System.out.println(i+" ");
			}
		}
	}	

}
