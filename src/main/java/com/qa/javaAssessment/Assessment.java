package com.qa.javaAssessment;

public class Assessment {

	public static void main(String[] args) {

		Assessment evenlySpaced = new Assessment();
		// System.out.println(evenlySpaced.evenlySpaced(4, 3, 5)); //done

		Assessment amISearch = new Assessment();
		// System.out.println(amISearch.amISearch(" am aam am ami am a")); //done but
		// slightly cheaty

		Assessment fizzBuzz = new Assessment();
		// System.out.println(fizzBuzz.fizzBuzz(3)); //done

		Assessment nMid = new Assessment();
		// System.out.println(nMid.nMid("unliked", 3)); // done

		Assessment getBert = new Assessment();
		// System.out.println(getBert.getBert("bertadambert")); //done
		
		Assessment superBlock = new Assessment();
		System.out.println(superBlock.superBlock("aaaaaaabbbddddc"));

	}
	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i < input.length(); i++) {
			word += input.substring(i, i + 1);
			word += input.substring(i, i + 1);
			word += input.substring(i, i + 1);
		}
		return word;
	}

	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {

		String newWord = "";

		for (int i = 0; i < input.length() - 3; i++) {
			if (input.substring(i, i + 4).equals("bert")) {

				for (int n = i + 4; n < input.length() - 3; n++) {

					if (input.substring(n, n + 4).equals("bert")) {
						newWord = input.substring(i + 4, n);

					}

				}
			} else {
				return newWord;
			}
		}

		return newWord;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {

		int x = Math.abs(a - b);
		int y = Math.abs(b - c);
		int z = Math.abs(a - c);

		if ((x == z) || (x == y) || ((z == y))) {

			return true;
		} else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the
	// 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input
	// is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		int stringLength = input.length();
		int middle = stringLength / 2;
		String newWord = "";

		for (int i = 0; i < input.length(); i++) { 

			if (a % 2 != 0) {
				if (i < (middle - a / 2) || i > (middle + a / 2)) {
					newWord += input.substring(i, i + 1);

				} else {
					newWord += "";

				}

			}

			else {
				System.out.println(newWord);
				if (i < (middle - a / 2) || i > (middle + (a / 2) - 1)) {
					newWord += input.substring(i, i + 1);
					System.out.println(newWord);
				} else {
					newWord += "";

				}

			}
		}
		return newWord;
	}

	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		
		int i = 0;
		int counter = 0;
		
		for (i = 0; i <input.length(); i++)	{
			for (int n = 0; n < input.length()-2; n++) {
				if (input.substring(i, n+1).equals(input.substring(n , n+1))) {
					
					System.out.println(input.substring(n,n+1));
					counter++;
					}
			}
			
		}
		return counter;
	}

	// given a string - return the number of times "am" appears in the String
	// ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by
	// other letters
	//
	// amISearch("Am I in Amsterdam") ==> 1
	// amISearch("I am in Amsterdam am I?") ==> 2
	// amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		int counter = 0;

		if (arg1.substring(0, 3).equals("am ") || arg1.substring(0, 3).equals("Am ")) {
			counter++;
		}
		if (arg1.substring(arg1.length() - 3).equals(" am")) {
			counter++;
		}
		for (int i = 1; i < arg1.length() - 2; i++) {
			if (arg1.substring(i, i + 2).equals("am") || arg1.substring(i, i + 2).equals("Am")) {
				if (arg1.substring(i - 1, i + 3).equals(" am ")) {
					counter++;
				}

			}
		}
		return counter;
	}

	// given a number
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3 and 5return "fizzbuzz"
	//
	// fizzBuzz(3) ==> "fizz"
	// fizzBuzz(10) ==> "buzz"
	// fizzBuzz(15) ==> "fizzbuzz"

	public String fizzBuzz(int arg1) {
		if (arg1 % 5 == 0 && arg1 % 3 == 0) {
			return "fizzbuzz";
		} else if (arg1 % 3 == 0) {
			return "fizz";
		} else if (arg1 % 5 == 0) {
			return "buzz";
		} else {
			return null;
		}

	}

	// Given a string split the string into the individual numbers present
	// then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	// largest("55 72 86") ==> 14
	// largest("15 72 80 164") ==> 11
	// largest("555 72 86 45 10") ==> 15

	public int largest(String arg1) {

		// for (int i = 0; i < arg1.length(); i++) {
		// int first = arg1.substring(i);

		// valueOf(arg1.substring())
		// }
		// return -1;
		return 1;// }
	}
}
