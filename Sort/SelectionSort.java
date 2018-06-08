/*
  Insertion Sort:

  Take current element, swap it with the smallest element of the remaining unsorted elements

  Best: O(n)
  Average: O(n^2)
  Worst: O(n^2)

*/

class SelectionSort {

	public static void iterativeSort (int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i +1; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int swap = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = swap;
		}
	}

	private static void recursiveSort (int arr[], int i) {
		if (i < arr.length) {
			int minIdx = i;
			for (int j = i +1; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int swap = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = swap;

			recursiveSort (arr, i+1);
		}
	}

	public static void recursiveSort (int arr[]) {
		recursiveSort (arr, 0);
	}
}