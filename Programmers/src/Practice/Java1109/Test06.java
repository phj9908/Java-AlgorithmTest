package Practice.Java1109;

import java.util.Arrays;

//삽입정렬
public class Test06 {

	public void insertSort(int[] arr) {
		for(int idx =1;idx<arr.length;idx++) {
			
			int temp = arr[idx];
			int prev = idx -1;
			while((prev>=0)&&(arr[prev]>temp)) {
				arr[prev+1] = arr[prev];
				prev--;
			}
			arr[prev +1] =temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
