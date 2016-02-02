// describe how you could use a single array to implement three stacks

public class Question1 {
	
	public static void main(String[] args) {

		// create an array such that each individual stack is "interleaved" with each other
		// [ 0 ] [ 1 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ] [ 6 ] [ 7 ] [ 8 ] [ 9 ] [ 10 ] [ 11 ]
		// index 0, 3, 6, 9 belong to stack 1
		// index 1, 4, 7, 10 belong to stack 2
		// index 2, 5, 8, 11 belong to stack 3

		// double the array length when limit is reached
		// halve the array length when capacity drops below 25%
	}
}