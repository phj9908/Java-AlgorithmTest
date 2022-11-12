package Practice.Java1112;

// 퀵 정렬
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] arr= {7,5,9,0,3,1,6,2,4,8};
		
		quickSort(arr,0,n-1);
		
		for(int i=0;i<n;i++)
			System.out.println(arr[i]+" ");
	}

	private static void quickSort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end) return;
		
		int pivot = start; //피벗은 첫번째 원소
		int left = start + 1;
		int right = end;
		
		while(left<=right) {
			
			// 왼쪽에서 부터 피벗보다 큰게 마주치면 정지
			while(left <= end && arr[left]<=arr[pivot]) left++;
			
			// 오른쪽에서 부터 피벗보다 작은게 마주치면 정지
			while(right>=start && arr[right]>=arr[pivot])	right++;
			
			// left,right 엇갈리면 작은 우너소와 피벗을 교체
			if(left>right){
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[pivot] = temp;
			}
			else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			
			quickSort(arr,start,right-1);
			quickSort(arr,right+1,end);
		}
		
	}

}
