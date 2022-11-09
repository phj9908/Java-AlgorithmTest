package Practice.Java1109;

import java.util.Arrays;

// 선택 정렬
public class Test05 {

	public void selectionSort(int[] arr) {
		int indexMin,temp;
		for(int i=0;i<arr.length-1;i++) {
			indexMin =i;
			
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[indexMin])
					indexMin = j;
			}
		temp = arr[indexMin];
		arr[indexMin] = arr[i];
		arr[i] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
