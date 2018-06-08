import java.util.Arrays;

class Sort {

	public static void printArray (int arr[]) {
		String output = "[";

		for (int i = 0; i < arr.length; i++) {
			output = output + arr[i] + ", ";
		}

		output = output.replaceAll (", $", "");
		output = output + "]";

		System.out.println (output);
	}

	public static void printUsage () {
		System.out.println ("Usage:");
		System.out.println ("Sort --option1 --option2 [optional_input]");
		System.out.println ("  Options1:");
		System.out.println ("    --help    Show this screen");
		System.out.println ("    --i       Insertion (default)");
		System.out.println ("    --s       Selection");

		System.out.println ("  Options2:");
		System.out.println ("    --i       Iterative (default)");
		System.out.println ("    --r       Recursive");
	}

	public static void sort (int arr[], SortType type, SortMethod method) {
		System.out.println ("Original Array:");
		printArray (arr);

		System.out.println ("Sort using " + method.getName() + " " + type.getName() + ":");

		if (type == SortType.INSERT) {
			InsertionSort.sort (arr, method);
		} else if (type == SortType.SELECT) {
			SelectionSort.sort (arr, method);
		}

		printArray (arr);
	}

	public static int[] convertStringArr (String arg) {
		String[] input = arg.split(",");
		int arr[] = new int[input.length];

		for (int i = 0; i < input.length; i++) {
			arr[i] = Integer.parseInt (input[i]);
		}

		return arr;
	}

	public static void main (String args[]) {
		int defaultArr[] = {9,2,5,3,1,8,7,6,4};

		SortType pickType = SortType.NONE;
		SortMethod pickMethod = SortMethod.NONE;

		if (args.length >= 1) {
			pickType = SortType.getType (args[0]);
			if (args.length >= 2) {
				pickMethod = SortMethod.getMethod (args[1]);
			}
		}

		/*
			Defaul Case:
			Sort
		*/
		if (args.length == 0) {
			sort (defaultArr, SortType.INSERT, SortMethod.ITERATE);
		}
		/*
			Cases:
			Sort --help
			Sort --i
			Sort --s
		*/
		else if (args.length == 1) {
			if (pickType == SortType.NONE) {
				printUsage();
			} else {
				sort (defaultArr, pickType, SortMethod.ITERATE);
			}
		}
		/*
			Cases:
			Sort --i --i
			Sort --i --r
			Sort --i [x,y,z]

			Sort --s --i
			Sort --s --r
			Sort --s [x,y,z]
		*/
		else if (args.length == 2) {
			if (pickType == SortType.NONE) {
				printUsage();
			} else {
				if (pickMethod == SortMethod.NONE) {
					int arr[] = convertStringArr (args[1]);
					sort (arr, pickType, SortMethod.ITERATE);
				} else {
					sort (defaultArr, pickType, pickMethod);
				}
			}
		}
		/*
			Cases:
			Sort --i --i [x,y,z]
			Sort --i --r [x,y,z]
			Sort --s --i [x,y,z]
			Sort --s --r [x,y,z]
		*/
		else if (args.length == 3) {
			int arr[] = convertStringArr (args[2]);

			if (pickMethod == SortMethod.NONE || pickType == SortType.NONE) {
				printUsage();
			} else {
				sort (arr, pickType, pickMethod);
			}
		} else {
			printUsage();
		}

	}

}