/*

Tower of Hanoi

Description: Puzzle game with 3 rods and n disks.
Objective: re-stack the disks in the same order on a different rod.

*/

class TowerOfHanoi {

	static void recurseTower (int n, int fromRod, int toRod, int otherRod) {
		if (n == 1) {
			System.out.println ("Move disk 1 from rod " + fromRod " to Rod " + toRod);
			return;
		}

		recurseTower (n-1, fromRod, otherRod, toRod);
	}

	public static void main (String args[]) {
		int n = 3;

		int fromRod = 1;
		int otherRod = 2;
		int toRod = 3;

		recurseTower (n, fromRod, toRod, otherRod);
	}
	
}