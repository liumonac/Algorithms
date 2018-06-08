public class SortType {
	public static final SortType INSERT = new SortType (0, "Insertion");
	public static final SortType SELECT = new SortType (0, "Selection");

	private int value;
	private String name;

	private SortType (int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName () {
		return name;
	}
}