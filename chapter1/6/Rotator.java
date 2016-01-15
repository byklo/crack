
// given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees
// can you do this in place?

// 4 bytes = 32 bits = int

// imagine this as your matrix

// 9 4 7 3 5
// 0 2 4 4 6
// 0 7 8 9 7
// 5 3 9 9 8
// 1 5 1 4 4

// you want to get rotate it into this

// 5 6 7 8 4
// 3 4 9 9 4
// 7 4 8 9 1
// 4 2 7 3 5
// 9 0 0 5 1

public class Rotator{

	public static void main(String[] args) {

		int n = 5;

		int[][] givenMatrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				givenMatrix[i][j] = (int) (Math.random() * 10);
			}
		}

		// print original
		System.out.println("ORIGINAL");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(givenMatrix[i][j] + " ");
			}
			System.out.print("\n");
		}


	}
}
