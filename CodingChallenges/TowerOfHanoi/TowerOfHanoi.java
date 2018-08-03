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
		recurseTower (n-1, otherRod, toRod, fromRod);
	}

	public static void main (String args[]) {
		int n = 4;

		int fromRod = 1;
		int otherRod = 2;
		int toRod = 3;

		if (args.length == 1) {
			n = Integer.parseInt (args[0]);
		}

		if (args.length == 4) {
			n = Integer.parseInt (args[0]);
			fromRod = Integer.parseInt (args[1]);
			toRod = Integer.parseInt (args[2]);
			otherRod = Integer.parseInt (args[3]);
		}

		recurseTower (n, fromRod, toRod, otherRod);
	}
	
}