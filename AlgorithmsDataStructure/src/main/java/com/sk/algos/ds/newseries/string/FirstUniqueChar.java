package com.sk.algos.ds.newseries.string;

public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        int[] nodes = new int[26];
        char[] charArr = s.toCharArray();

        for (char ch: charArr) {
            nodes[ch - 'a'] += 1;
        }

        for (int i=0; i < charArr.length; i++) {
            char ch = charArr[i];
            if (nodes[ch - 'a'] == 1)
                return i;
        }

       /* Solution 2: Using java api
          Map<Character, Integer> map = new LinkedHashMap<>();
          for (char ch: s.toCharArray()) {
               map.put(ch, map.getOrDefault(ch, 0)+ 1);
           }

           for (Map.Entry<Character, Integer> entry: map.entrySet()) {
               if (entry.getValue() == 1) {
                   return s.indexOf(entry.getKey());
              }
           }*/

        return -1;
    }

    public static void main(String[] args) {
        String[] strTC = {
                "leetcode",
                "loveleetcode",
                "aabb"
        };
        int[] resultTC = {
                0,
                2,
                -1
        };

        int totalCases = strTC.length;
        int passedCases = 0;
        FirstUniqueChar UniqueCharObj = new FirstUniqueChar();
        for (int cntr=0; cntr < strTC.length; cntr++) {
            if (UniqueCharObj.firstUniqChar(strTC[cntr]) == resultTC[cntr]) {
                passedCases++;
            }else {
                System.out.println("Failed case :" + (cntr + 1));
            }

        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        }else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases));
        }

    }
}
