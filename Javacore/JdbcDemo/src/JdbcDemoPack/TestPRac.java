package JdbcDemoPack;

import java.util.Arrays;


public class TestPRac {
	public static void main(String[] args) {
		String[] abc= {"hello"," ","World"};
		StringBuilder sb=new StringBuilder();
		System.out.println(String.join("",abc));
		int[] a= {1,4,5,6,8,4};
		Arrays.sort(a);
		for(int x:a) {
			System.out.println(x);
		}
		System.out.println();
	}
	
//	public int countDigits(int a) {
//		
//		
//		return 1;
//	}
//	
//	public int[] sortArray(int[] arr) {
//	    if (arr == null || arr.length == 0) {
//	        return new int[0];
//	    }
//	    // Create arrays to store digit counts and original indices
//	    int n = arr.length;
//	    int[] digitCounts = new int[n];
//	    Integer[] indices = new Integer[n];
//	    for (int i = 0; i < n; i++) {
//	        digitCounts[i] = countDigits(arr[i]);
//	        indices[i] = i;
//	    }
//	    // Sort indices based on digit counts and original order
//	    Arrays.sort(indices, (i, j) -> {
//	        if (digitCounts[i] != digitCounts[j]) {
//	            return Integer.compare(digitCounts[i], digitCounts[j]);
//	        } else {
//	            return Integer.compare(i, j);
//	        }
//	    });
//	    
//	}
}


