/*
  Merge Sort:

  Divide and Conquer.  Divide array in half, sort the halves, and merge back

  Time Complexity:
	Best: O(nlog(n))
	Average: O(nlog(n))
	Worst: O(nlog(n))

  Space Complexity:
	O(n)

*/

class MergeSort {

	private static void iterativeSort (int arr[]) {
		System.out.println ("not implemented.");
	}

	private static void topDownMerge (int arr[], int left, int middle, int right) {
		//create arrays
		int leftArr[] = new int [middle - left];
		int rightArr[] = new int [right - middle];

		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[middle + i];
		}

		int l = 0;
		int r = 0;
		int k = left;

		//sort and merge arrays
		while (l < leftArr.length && r < rightArr.length) {
			if (leftArr [l] <= rightArr[r]) {
				arr[k] = leftArr[l];
				l++;
			} else {
				arr[k] = rightArr[r];
				r++;
			}
			k++;
		}

		//copy over remainder after sort
		while (l < leftArr.length) {
			arr[k] = leftArr[l];
			l++;
			k++;
		}
		while (r < rightArr.length) {
			arr[k] = rightArr[r];
			r++;
			k++;
		}
	}

	private static void topDownSort (int arr[], int left, int right) {
		//1 element is sorted
		if (right - left > 1 ) {
			int middle = (left + right) / 2;

			topDownSort (arr, left, middle);
			topDownSort (arr, middle, right);

			topDownMerge (arr, left, middle, right);
		}
	}

	private static void recursiveSort (int arr[]) {
		topDownSort (arr, 0, arr.length);
	}

	public static void sort (int arr[], SortMethod method) {
		if (method == SortMethod.ITERATE) {
			iterativeSort (arr);
		} else if (method == SortMethod.RECURSE) {
			recursiveSort (arr);
		}
	}
}