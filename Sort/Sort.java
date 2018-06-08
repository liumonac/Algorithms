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
			if (method == SortMethod.RECURSE) {
				InsertionSort.recursiveSort (arr);
			} else if (method == SortMethod.ITERATE) {
				InsertionSort.iterativeSort (arr);
			} 
		} else if (type == SortType.SELECT) {
			if (method == SortMethod.RECURSE) {
				InsertionSort.recursiveSort (arr);
			} else if (method == SortMethod.ITERATE) {
				InsertionSort.iterativeSort (arr);
			}
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
		/*
			Defaul Cases:
			Sort
			Sort --i
			Sort --i --i
		*/
		if (    args.length == 0
			 || (args.length == 1 && args[0].equals("--i"))
			 || (args.length == 2 && args[0].equals("--i") && args[1].equals("--i"))
		   ) {
			sort (defaultArr, SortType.INSERT, SortMethod.ITERATE);
		/*
			Cases:
			Sort --help
			Sort --s
		*/
		} else if (args.length == 1) {
			if (args[0].equals ("--help")) {
				printUsage();
			} else if (args[0].equals("--s")) {
				sort (defaultArr, SortType.SELECT, SortMethod.ITERATE);
			} else {
				printUsage();
			}
	    /* 
	        Cases:
	        Sort --i --r
	        Sort --i [x,y,z]

	    */
	    } else if (args.length == 2) {
	        if (args[0].equals ("--i")) {
	        	//insert
				if (args[1].equals ("--r")) {
					sort (defaultArr, SortType.INSERT, SortMethod.RECURSE);
				} else if (!args[1].contains ("--")) {
					int arr[] = convertStringArr (args[1]);
					sort (arr, SortType.INSERT, SortMethod.ITERATE);
				} else {
					printUsage();
				}
		    /* 
		        Cases:
		        Sort --s --r
		        Sort --s --i
		        Sort --s [x,y,z]
		    */
	        } else if (args[0].equals ("--s")) {
	        	//select
				if (args[1].equals ("--r")) {
					sort (defaultArr, SortType.SELECT, SortMethod.RECURSE);
				} else if (args[1].equals ("--i")) {
					sort (defaultArr, SortType.SELECT, SortMethod.ITERATE);
				} else {
					int arr[] = convertStringArr (args[1]);
					sort (arr, SortType.SELECT, SortMethod.ITERATE);
				}
	        } else {
	        	printUsage();
	        }
	    /* 
	        Cases:
	        Sort --i --i [x,y,z]
	        Sort --i --r [x,y,z]
	        Sort --s --i [x,y,z]
	        Sort --s --r [x,y,z]

	    */
		} else if (args.length == 3) {
			int arr[] = convertStringArr (args[2]);

			if (args[0].equals ("--i")) {
				if (args[1].equals ("--i")) {
					sort (arr, SortType.INSERT, SortMethod.ITERATE);
				} else if (args[1].equals ("--r")) {
					sort (arr, SortType.INSERT, SortMethod.RECURSE);
				}
			} else if (args[0].equals ("--s")) {
				if (args[1].equals ("--i")) {
					sort (arr, SortType.SELECT, SortMethod.ITERATE);
				} else if (args[1].equals ("--r")) {
					sort (arr, SortType.SELECT, SortMethod.RECURSE);
				}
			} else {
				printUsage();
			}
		} else {
			printUsage();
		}

	}

}