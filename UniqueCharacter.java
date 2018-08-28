import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class UniqueCharacter {
	
	//in interview
	/*
	public static String findUnique (String input) {
		HashMap<Character,Integer> counts = new HashMap<Character,Integer>();
		//address issue preserve order when looking for count 1
		ArrayList<Character> unique = new ArrayList<Character>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (counts.	containsKey (c) ) {
				int j = counts.get (c);
				counts.put (c, j+1);
			} else {
				counts.put (c, 1);
				unique.add (c);
			}

		}

		for (char c : unique) {
			int count = counts.get (c);

			if (count == 1) {
				return String.valueOf (c);
			}
		}

		return "";
	}
	*/

	public static String findUnique (String input) {
		//preserves order when iterating
		LinkedHashMap<Character,Integer> counts = new LinkedHashMap<Character,Integer>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (counts.	containsKey (c) ) {
				int j = counts.get (c);
				counts.put (c, j+1);
			} else {
				counts.put (c, 1);
			}

		}

		for (Map.Entry<Character,Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return String.valueOf (entry.getKey());
			}
		}

		return "";
	}
	public static void main (String args[]) {
		String input = "abbbbcccddd";
		String result = findUnique (input);
		System.out.println ("input: " + input + ", result: " + result);

		input = "";
		result = findUnique (input);
		System.out.println ("input: " + input + ", result: " + result);

		input = "abcdf";
		result = findUnique (input);
		System.out.println ("input: " + input + ", result: " + result);

		input = "aaaaaaaaaa";
		result = findUnique (input);
		System.out.println ("input: " + input + ", result: " + result);

		input = "aaaaaaaaaab";
		result = findUnique (input);
		System.out.println ("input: " + input + ", result: " + result);
	}

}