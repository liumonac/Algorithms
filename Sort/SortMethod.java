public class SortMethod {
	public static final SortMethod ITERATE = new SortMethod (0, "Iterative");
	public static final SortMethod RECURSE = new SortMethod (1, "Recursive");

	public static final SortMethod NONE = new SortMethod (-1, "None");

	private int value;
	private String name;

	private SortMethod (int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName () {
		return name;
	}

	public static SortMethod getMethod (String option) {
		if (option.equals ("--i")) {
			return ITERATE;
		} else if (option.equals ("--r")) {
			return RECURSE;
		} else {
			return NONE;
		}
	}
}