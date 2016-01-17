
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

import java.util.List;
import java.util.ArrayList;

public class Rotator{

	public Rotator() {

	}

	public static void main(String[] args) {
		Rotator rotator = new Rotator();

		int[] matrixSizes = new int[] {2, 3, 4, 5, 6};
		List<int[][]> matrices = new ArrayList<int[][]>();

		for (int m = 0; m < matrixSizes.length; m++) {
			int n = matrixSizes[m];
			matrices.add(m, new int[n][n]);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrices.get(m)[i][j] = (int) (Math.random() * 10);
				}
			}
			System.out.println("ORIGINAL");
			rotator.printMatrix(matrices.get(m));
			System.out.println("ROTATED");
			rotator.printMatrix(rotator.rotateMatrix(matrices.get(m)));
		}
	}

	// assumes input is a square matrix
	public int[][] rotateMatrix(int[][] givenSquareMatrix) {

		int n = givenSquareMatrix.length;
		int[][] rotatedMatrix = givenSquareMatrix;

		// after mucking around, i found an algorithm that magically works and seems efficient and scalable. it's O(n), n = # elements, not dimensions
		// it's done in two steps - 1. diagonal swap and 2. vertical swaps

		// 1. diagonal swap
		for (int j = n-1; j >= 0; j--) {
			for (int i = j-1; i >= 0; i--) {
				// in memory swap
				rotatedMatrix[i][j] += rotatedMatrix[j][i];
				rotatedMatrix[j][i] = rotatedMatrix[i][j] - rotatedMatrix[j][i];
				rotatedMatrix[i][j] -= rotatedMatrix[j][i];
			}
		}

		// 2. vertical swap
		for (int j = 0; j < n; j++) {
			int top = 0;
			int bottom = n - 1;
			while (top < bottom) {
				rotatedMatrix[top][j] += rotatedMatrix[bottom][j];
				rotatedMatrix[bottom][j] = rotatedMatrix[top][j] - rotatedMatrix[bottom][j];
				rotatedMatrix[top][j] -= rotatedMatrix[bottom][j];
				top++;
				bottom--;
			}
		}

		return rotatedMatrix;
	}

	// assumes input is square matrix
	public void printMatrix(int[][] matrix) {
		int n  = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
