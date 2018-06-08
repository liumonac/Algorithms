import java.util.Arrays;

class Sort {

	private static final int ITERATE = 0;
	private static final int RECURSE = 1;

	public static void printArray (int arr[]) {
		String output = "";

		for (int i = 0; i < arr.length; i++) {
			output = output + arr[i] + ", ";
		}

		System.out.println (output);
	}

	public static void printUsage () {
		System.out.println ("Usage:");
		System.out.println ("Sort --option [optional_input]");
		System.out.println ("  Options:");
		System.out.println ("    --help    Show this screen");
		System.out.println ("    --i       Iterative (default)");
		System.out.println ("    --r       Recursive");
	}

	public static void sort (int arr[], int method) {
		System.out.println ("Original:");
		printArray (arr);

		if (method == RECURSE) {
			InsertionSort.recursiveSort (arr);
			System.out.println ("Recursive Sort:");
		} else if (method == ITERATE) {
			InsertionSort.iterativeSort (arr);
			System.out.println ("Iterative Sort:");
		} else {
			System.out.println ("Invalid Method.");
			return;
		}

		printArray (arr);
	}

	public static void main (String args[]) {
		int defaultArr[] = {9,2,5,3,1,8,7,6,4};
		//default
		if (    args.length == 0
			 || (args.length == 1 && args[0].equals("--i"))
		   ) {
			sort (defaultArr, ITERATE);
		} else if (args.length == 1) {
			if (args[0].equals ("--help")) {
				printUsage();
			} else if (args[0].equals ("--r")) {
				sort (defaultArr, RECURSE);
			} else {
				String[] input = args[0].split(",");
				int arr[] = new int[input.length];

				for (int i = 0; i < input.length; i++) {
					arr[i] = Integer.parseInt (input[i]);
				}

				sort (arr, ITERATE);
			}

		} else if (args.length == 2) {
			String[] input = args[1].split(",");

			int arr[] = new int[input.length];

			for (int i = 0; i < input.length; i++) {
				arr[i] = Integer.parseInt (input[i]);
			}

			if (args[0].equals ("--i")) {
				sort (arr, ITERATE);
			} else if (args[0].equals ("--r")) {
				sort (arr, RECURSE);
			} else {
				printUsage();
			}
		} else {
			printUsage();
		}

	}

}