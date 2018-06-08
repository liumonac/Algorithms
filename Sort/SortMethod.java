public class SortMethod {
	public static final SortMethod ITERATE = new SortMethod (0, "Iterative");
	public static final SortMethod RECURSE = new SortMethod (0, "Recursive");

	private int value;
	private String name;

	private SortMethod (int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName () {
		return name;
	}
}