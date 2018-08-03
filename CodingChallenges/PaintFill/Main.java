public class Main {

	public static void main(String args[]) {
		Screen myScreen = new Screen();

		System.out.println ("Initial Screen:");
		myScreen.print();

		System.out.println ("Iterative Test:");
		int x = 0;
		int y = 0;

		myScreen.iterativeFill (x, y, 2);
		System.out.println ("filled at: " + x + ", " + y);
		myScreen.print();
		//reset screen
		myScreen.iterativeFill (x, y, 0);

		x = 3;
		y = 3;
		myScreen.iterativeFill (x, y, 2);
		System.out.println ("filled at: " + x + ", " + y);
		myScreen.print();
		//reset screen
		myScreen.iterativeFill (x, y, 0);

		x = 2;
		y = 4;
		myScreen.iterativeFill (x, y, 2);
		System.out.println ("filled at: " + x + ", " + y);
		myScreen.print();
		//reset screen
		myScreen.iterativeFill (x, y, 1);


		System.out.println ("Recursive Test:");
		x = 0;
		y = 0;

		myScreen.recursiveFill (x, y, 2);
		System.out.println ("filled at: " + x + ", " + y);
		myScreen.print();
		//reset screen
		myScreen.recursiveFill (x, y, 0);

		x = 3;
		y = 3;
		myScreen.recursiveFill (x, y, 2);
		System.out.println ("filled at: " + x + ", " + y);
		myScreen.print();
		//reset screen
		myScreen.recursiveFill (x, y, 0);

		x = 2;
		y = 4;
		myScreen.recursiveFill (x, y, 2);
		System.out.println ("filled at: " + x + ", " + y);
		myScreen.print();
		//reset screen
		myScreen.recursiveFill (x, y, 1);
	}

}