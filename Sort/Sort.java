import java.util.Arrays;

class Sort {

	public static void printArray (int arr[]) {
		String output = "";

		for (int i = 0; i < arr.length; i++) {
			output = output + arr[i] + ", ";
		}

		System.out.println (output);
	}

	public static void main (String args[]) {
		int arr[] = {9,2,5,3,1,8,7,6,4};
		System.out.println ("Original:");
		printArray (arr);
		InsertionSort.iterativeSort (arr);
		System.out.println ("Iterative Sort:");
		printArray (arr);

		int arr2[] = {9,2,5,3,1,8,7,6,4};
		System.out.println ("Original:");
		printArray (arr2);
		InsertionSort.iterativeSort (arr2);
		System.out.println ("Recursive Sort:");
		printArray (arr2);
	}

}