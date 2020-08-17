package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length()) {
			return s1;
		}else {
			return s2;
		}
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		String newString = "";
		if(s.contains("underscores")) {
			for(int i = 0; i<s.length(); i++) {
				if(s.charAt(i) == ' ') {
					newString+="_";
				}else {
					newString+=s.charAt(i);
				}
			}
			return newString;
		}else {
			return s;
		}
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String newS1 = "";
		for(int i = 0; i<s1.length(); i++) {
			if(i>0 && i<s1.length()-1) {
				if(Character.isLetter(s1.charAt(i-1)) && s1.charAt(i) == ' ' && Character.isLetter(s1.charAt(i+1))) {
					newS1+= s1.charAt(i);
				}
			}
			if(Character.isLetter(s1.charAt(i))) {
				newS1+=s1.charAt(i);
			}
		}
		String newS2 = "";
		for(int i = 0; i<s2.length(); i++) {
			if(i>0 && i<s2.length()-1) {
				if(Character.isLetter(s2.charAt(i-1)) && s2.charAt(i) == ' ' && Character.isLetter(s2.charAt(i+1))) {
					newS2+= s2.charAt(i);
				}
			}
			if(Character.isLetter(s2.charAt(i))) {
				newS2+=s2.charAt(i);
			}
		}
		String newS3 = "";
		for(int i = 0; i<s3.length(); i++) {
			if(i>0 && i<s3.length()-1) {
				if(Character.isLetter(s3.charAt(i-1)) && s3.charAt(i) == ' ' && Character.isLetter(s3.charAt(i+1))) {
					newS3+= s3.charAt(i);
				}
			}
			if(Character.isLetter(s3.charAt(i))) {
				newS3+=s3.charAt(i);
			}
		}
		char s1Last = ' ';
		char s2Last = ' ';
		char s3Last = ' ';
		for(int i = 0; i<s1.length()-2; i++) {
			if(Character.isLetter(s1.charAt(i)) && s1.charAt(i+1) == ' ' && Character.isLetter(s1.charAt(i+2))) {
				s1Last = s1.charAt(i+2);
			}
		}
		for(int i = 0; i<s2.length()-2; i++) {
			if(Character.isLetter(s2.charAt(i)) && s2.charAt(i+1) == ' ' && Character.isLetter(s2.charAt(i+2))) {
				s2Last = s2.charAt(i+2);
			}
		}
		for(int i = 0; i<s3.length()-2; i++) {
			if(Character.isLetter(s3.charAt(i)) && s3.charAt(i+1) == ' ' && Character.isLetter(s3.charAt(i+2))) {
				s3Last = s3.charAt(i+2);
			}
		}
		if(s1Last<s2Last && s1Last<s3Last) {
			return newS1;
		}else if(s2Last<s1Last && s2Last<s3Last) {
			return newS2;
		}else {
			return newS3;
		}
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for(int i = 0; i<s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				sum+=Integer.parseInt(Character.toString(s.charAt(i)));
			}
		}
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int subs = 0;
		String str = "";
		for(int i = 0; i < s.length()-substring.length()+1; i++) {
			for(int j = i; j < i + substring.length(); j++) {
				str += s.charAt(j);
			}
			if(str.equalsIgnoreCase(substring)) {
				subs++;
			}
			str = "";
		}
		return subs;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		char[] c = s.toCharArray();
		byte[] b = new byte[c.length];
		for(int i = 0; i < c.length; i++) {
			b[i] = (byte) c[i];
		}
		return Utilities.encrypt(b, (byte) key);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte)key);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int subs = 0;
		String str = "";
		for(int i = substring.length(); i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				for(int j = i - substring.length(); j < i; j++) {
					str += s.charAt(j);
				}
				if(str.equalsIgnoreCase(substring)) {
					subs++;
				}
				str = "";
			}
		}
		return subs;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int index = s.indexOf(substring) + substring.length();
		int index2 = s.lastIndexOf(substring);
		return index2 - index;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String str = "";
		String str2 = "";
		for(int i = 0; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i))) {
				str += s.charAt(i);
			}
		}
		for(int i = str.length()-1; i >= 0; i--) {
				str2 += str.charAt(i);
		}
		if(str.equalsIgnoreCase(str2)) {
			return true;
		}else {
			return false;
		}
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
