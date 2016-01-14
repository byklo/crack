
// given two strings, write a method to decide if one is a permutation of the other

// assume problem is case insensitive
// assume strings are all regular alphabet characters

public class PermutationChecker {

	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];

		// quick check
		if (s1.length() != s2.length()) {
			System.out.println("strings are not permutations of each other");
			return;
		}

		int[] asciiCounter1 = new int[128];
		int[] asciiCounter2 = new int[128];

		for (int i = 0; i < Math.max(s1.length(), s2.length()); i++) {
			if (i < s1.length()) {
				asciiCounter1[(int) s1.charAt(i)]++;
			}
			if (i < s2.length()) {
				asciiCounter2[(int) s2.charAt(i)]++;
			}
		}

		for (int j = 0; j < 128; j++) {
			if (asciiCounter1[j] != asciiCounter2[j]) {
				System.out.println("strings are not permutations of each other");
				return;
			}
		}

		System.out.println("strings are permutations of each other");
	}
}
