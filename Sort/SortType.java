public class SortType {
	public static final SortType INSERT = new SortType (0, "Insertion");
	public static final SortType SELECT = new SortType (0, "Selection");

	public static final SortType NONE = new SortType (-1, "None");

	private int value;
	private String name;

	private SortType (int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName () {
		return name;
	}

	public static SortType getType (String option) {
		if (option.equals ("--i")) {
			return INSERT;
		} else if (option.equals ("--s")) {
			return SELECT;
		} else {
			return NONE;
		}
	}
}