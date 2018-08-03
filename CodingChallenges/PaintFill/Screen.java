import java.util.Queue;
import java.util.LinkedList;

//colors represented by ints
public class Screen {

	int screen[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
					  {0, 0, 0, 0, 0, 0, 0, 0},
					  {0, 0, 1, 1, 1, 1, 0, 0},
					  {0, 0, 1, 0, 0, 1, 0, 0},
					  {0, 0, 1, 0, 0, 1, 0, 0},
					  {0, 0, 1, 1, 1, 1, 0, 0},
					  {0, 0, 0, 0, 0, 0, 0, 0},
					  {0, 0, 0, 0, 0, 0, 0, 0}
					 };

	public Screen() {

	}

	public Screen(int[][] screen) {
		this.screen = screen;
	}

	private boolean isValidFill (int x, int y, int clickedColor) {
		if (x < 0 || y < 0) {
			return false;
		}

		int numRows = screen.length;
		int numCols = screen[0].length;

		if (x >= numRows || y >= numCols) {
			return false;
		}

		if (screen[x][y] != clickedColor) {
			return false;
		}

		return true;
	}

	private void recurse (int x, int y, int clickedColor, int fillColor) {
		if (! isValidFill (x, y, clickedColor) ) {
			return;
		}

		//visited, done
		screen[x][y] = fillColor;

		recurse (x+1, y, clickedColor, fillColor);
		recurse (x-1, y, clickedColor, fillColor);
		recurse (x, y+1, clickedColor, fillColor);
		recurse (x, y-1, clickedColor, fillColor);
	}

	public void recursiveFill (int clickedX, int clickedY, int fillColor) {
		int clickedColor = screen[clickedX][clickedY];
		recurse (clickedX, clickedY, clickedColor, fillColor);
	}

	public void iterativeFill (int clickedX, int clickedY, int fillColor) {
		Queue<IntPair> cells = new LinkedList<IntPair>();
		IntPair clicked = new IntPair (clickedX, clickedY);
		int clickedColor = screen[clickedX][clickedY];

		cells.add(clicked);

		while (! cells.isEmpty()) {
			IntPair check = cells.remove();
			int checkX = check.getX();
			int checkY = check.getY();

			screen[checkX][checkY] = fillColor;

			if (isValidFill (checkX+1, checkY, clickedColor) ) {
				cells.add (new IntPair (checkX+1, checkY) );
			}
			if (isValidFill (checkX-1, checkY, clickedColor) ) {
				cells.add (new IntPair (checkX-1, checkY) );
			}
			if (isValidFill (checkX, checkY+1, clickedColor) ) {
				cells.add (new IntPair (checkX, checkY+1) );
			}
			if (isValidFill (checkX, checkY-1, clickedColor) ) {
				cells.add (new IntPair (checkX, checkY-1) );
			}
		}
	}

	public void print () {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				System.out.print (screen[i][j] + " ");
			}
			System.out.print ("\n");
		}
	}
}