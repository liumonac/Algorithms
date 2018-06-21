/*

Tower of Hanoi

Description: Puzzle game with 3 rods and n disks.
Objective: re-stack the disks in the same order on a different rod.


example for 2 disks:
shift first disk from rod 1 to rod 2
shift second disk from rod 1 to rod 3
shit first disk from rod 2 to rod 3

*/

class TowerOfHanoi {

	static void recurseTower (int n, int fromRod, int toRod, int otherRod) {
		if (n == 1) {
			System.out.println ("Move disk 1 from rod " + fromRod + " to Rod " + toRod);
			return;
		}

		recurseTower (n-1, fromRod, otherRod, toRod);
		System.out.println ("Move disk " + n + " from rod " + fromRod + " to Rod " + toRod);

	}

	public static void main (String args[]) {
		int n = 2;

		int fromRod = 1;
		int otherRod = 2;
		int toRod = 3;

		recurseTower (n, fromRod, toRod, otherRod);
	}
	
}