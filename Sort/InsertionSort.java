/*
  Insertion Sort:

  Take current element, insert it at correct position, move other elements as needed.

  Time Complexity:
	Best: O(n)
	Average: O(n^2)
	Worst: O(n^2)

  Space Complexity:
	O(1)

*/

class InsertionSort {

	private static void iterativeSort (int arr[]) {
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

	private static void recursiveSort (int arr[]) {
		recursiveSort (arr, 1);
	}

	public static void sort (int arr[], SortMethod method) {
		if (method == SortMethod.ITERATE) {
			iterativeSort (arr);
		} else if (method == SortMethod.RECURSE) {
			recursiveSort (arr);
		}
	}
}