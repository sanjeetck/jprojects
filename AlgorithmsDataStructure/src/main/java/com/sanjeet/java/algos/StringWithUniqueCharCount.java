package com.sanjeet.java.algos;

import java.util.*;

public class StringWithUniqueCharCount {

	/* original string : aaabbbaccceeedde
	* Get char count in the string Eg: a : 4 , c : 3
	* Group the chars as per count Eg: 4: a:b:e , 3: c , 2: d
	* For each count if there are multiple characters
	* 	Except for the first char, take all chars and add them to the list of lower level count
	*  (Eg: Move b:e from 4 to 3: c:b:e
	* 	First the chars in the original string and mark them with # (For later removal)
	*
	* Once this process is complete,
	* 	There will be only 1 char per count for each character
	* 	4:a 3:c 2:d 1:b
	 */
	
	static int getUniqueCharInStringCount(String str, String strResult) {
		System.out.println("String S:" + str);
		if (str == null || str.trim().equals("")) {
			return 0;
		}

		Map<Character, Integer> mapOfChar = getCharacterIntegerMap(str);
		//printMapByChar(mapOfChar);

		Map<Integer, String> mapByCount = new HashMap<>();
		boolean duplicates = getIntegerStringMap(mapOfChar, mapByCount);
		//printMayByCount(mapByCount);

		if (duplicates) {
			str = doProcess(str, mapByCount);
		}

		//printMayByCount(mapByCount);

		System.out.println("String S after processing:" + str);
		String newString = getFinalNewString(str);
		System.out.println("New String :" + newString);

		if (strResult.equals(newString)) {
			System.out.println("Result matches with newString : " + strResult);
		}

		return newString.length();
	}

	private static String doProcess(String str, Map<Integer, String> mapByCount) {
		String existingChars;
		String charsAtLevel1Lower;
		List<Integer> countList = new ArrayList<>(mapByCount.keySet());
		Collections.sort(countList, Collections.reverseOrder());

		for (int counter: countList) {
			//System.out.println("counter:" + counter + ":: " + mapByCount.get(counter));
			existingChars = mapByCount.get(counter);

			if (existingChars.indexOf(':') != -1) {
				// Split if there is a :
				String[] chars = existingChars.split(":", 0);
				//System.out.println("chars[]:" + chars.toString());

				if (counter > 0) {
					charsAtLevel1Lower = mapByCount.get(counter - 1);
					if (charsAtLevel1Lower == null) {
						charsAtLevel1Lower = new String();
					}

					for (int i = 1; i < chars.length; i++) {
						if (charsAtLevel1Lower.isEmpty()) {
							charsAtLevel1Lower = ""+chars[i];
						}else {
							charsAtLevel1Lower += ":" + chars[i];
						}
						// to be removed at the end
						str = str.replaceFirst(chars[i], "#");
					}
					mapByCount.put(counter, chars[0]);
					mapByCount.put(counter-1, charsAtLevel1Lower);
				}
			}
		}
		return str;
	}

	private static void printMapByChar(Map<Character, Integer> mapOfChar) {
		for (char c: mapOfChar.keySet()) {
			System.out.println("Key:" + c + ":: " + mapOfChar.get(c));
		}
	}

	private static void printMayByCount(Map<Integer, String> mapByCount) {
		for (int v : mapByCount.keySet()) {
			System.out.println("Key:" + v + ":: " + mapByCount.get(v));
		}
	}

	private static String getFinalNewString(String str) {
		String[] strSplit = str.split("#", 0);

		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0; i<strSplit.length; i++) {
			stringBuilder.append(strSplit[i]);
		}
		return stringBuilder.toString();
	}

	private static boolean getIntegerStringMap(Map<Character, Integer> mapOfChar, Map<Integer, String> mapByCount) {
		boolean duplicates = false;
		int count;
		String existingChars;

		// This is the fallback counter.. for chars to be removed
		mapByCount.put(0, new String());

		for (char c: mapOfChar.keySet()) {
			count = mapOfChar.get(c);
			existingChars = mapByCount.computeIfAbsent(count, (key -> new String()));
			if (existingChars.isEmpty()) {
				existingChars = ""+c;
			}else {
				existingChars += ":" + c;
				duplicates = true;
			}
			mapByCount.put(count, existingChars);
		}
		return duplicates;
	}

	private static Map<Character, Integer> getCharacterIntegerMap(String str) {
		int n = str.length();
		Map<Character, Integer> mapOfChar = new HashMap<>();

		for(int cntr = 0; cntr < n; cntr++) {
			char c = str.charAt(cntr);
			if (mapOfChar.get(c) == null) {
				mapOfChar.put(c, 1);
			}else {
				int count = mapOfChar.get(c);
				mapOfChar.put(c, ++count);
			}
		}
		return mapOfChar;
	}


	public static void main(String[] args) {
		boolean java8Ver = false;
		String[] strTC = {"aaaabbbb" , "aaabbbcccda", "aaacccbbbda", "aabbccdde", "abcd", null, "", "aab"};
		int[] resultTC = {7, 10, 10, 3, 1, 0, 0, 3};
		String[] resultTC2 = {"aaaabbb" , "aaabbbccda", "aaacccbbda", "aae", "a", null, "", "aab"};
		int totalCases = strTC.length;
		int passedCases = 0;
		for (int cntr=0; cntr < strTC.length; cntr++) {
			if (java8Ver) {

			}else {
				if (getUniqueCharInStringCount(strTC[cntr], resultTC2[cntr]) == resultTC[cntr]) {
					passedCases++;
				}
			}
		}
		
		if (totalCases == passedCases) {
			System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
		}else {
			System.out.println("Nomber of cases failed : " + (totalCases - passedCases));
		}

	}

}
