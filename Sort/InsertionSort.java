/*
  Insertion Sort goes up the array sorting one element at a time behind it.
*/

class InsertionSort {

	public static void iterativeSort (int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j-1] > arr[j]) {
				int swap = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = swap;
				j--;
			}
		}
	}

	private static void recursiveSort (int arr[], int i) {
		if (i < arr.length && i > 0) {
			int j = i;
			while (j > 0 && arr[j-1] > arr[j]) {
				int swap = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = swap;
				j--;
			}
			recursiveSort (arr, i+1);
		}
	}

	public static void recursiveSort (int arr[]) {
		recursiveSort (arr, 1);
	}
}