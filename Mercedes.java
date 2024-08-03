import java.io.*;
import java.util.*;

public class Mercedes implements ICar, ICarDriverActions {

    public String licNumber;
    public Integer builtYear;

    public Mercedes(String lic, Integer yearBuilt) {
        this.builtYear = yearBuilt;
        this.licNumber = lic;
    }

    public String getLic() {
        return this.licNumber;
    }

    public Integer getbulitYear() {
        return this.builtYear;
    }

    public boolean startEngine() {
        // implement a start your engine
        System.out.println("Mercedes: Engine Started");
        return true;
    }

    public boolean runDiagnostics() {
        // implement a diagnostics check
        System.out.println("Mercedes: Run Diagtool");
        return true;
    }

    public String mergeAlternately(String word1, String word2) {
        if (word1.length() > 0 && word2.length() > 0) {
            // find the max of two string
            Integer longestWord = word1.length() > word2.length() ? word1.length() : word2.length();
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < longestWord; i++) {
                if (i < word1.length())
                    strb.append(word1.charAt(i));
                if (i < word2.length())
                    strb.append(word2.charAt(i));
            }
            return strb.toString();
        }
        return "";
    }

    public String gcdOfStrings(String str1, String str2) {
        StringBuilder strb = new StringBuilder();
        // Need a hash of all chars and only keep those that have 2 or more.
        // If both are contained in each hash and both hash have 2 or more then print.

        // Input: str1 = "ABCABC", str2 = "ABC"
        // Output: "ABC"
        if (str1.length() > 0 && str2.length() > 0) {
            HashMap<Character, Integer> hashstr1 = new HashMap<Character, Integer>();
            HashMap<Character, Integer> hashstr2 = new HashMap<Character, Integer>();

            // build the hash of str1
            for (int i = 0; i < str1.length(); i++) {
                if (hashstr1.containsKey(str1.charAt(i))) {
                    Integer currentCount = hashstr1.get(str1.charAt(i));
                    hashstr1.put(str1.charAt(i), currentCount + 1);
                }
                hashstr1.put(str1.charAt(i), 1);
            }
            // build the has of str2
            for (int i = 0; i < str2.length(); i++) {
                if (!hashstr2.containsKey(str2.charAt(i))) {
                    hashstr2.put(str2.charAt(i), 1);
                }
            }
            // Check to see if there are
            for (HashMap.Entry<Character, Integer> entry : hashstr2.entrySet()) {
                Character key = entry.getKey();
                // Integer value = entry.getValue();
                // System.out.println("Key=" + key + ", Value=" + value);
                if (hashstr1.containsKey(key)) {
                    // check if the value is atleast 2 then output.
                    if (hashstr1.get(key) > 1) {
                        // WIN Output
                        strb.append(key);
                        // System.out.println(key);
                    }
                }
            }
        }
        String finalStr = strb.toString();
        if (finalStr.length() > 1)
            return finalStr;
        else
            return "";
    }

    public Integer largestPalindrome() {
        Integer count = 0;
        Integer largestValue = 0;
        Integer value = 0;
        for (Integer i = 1; i < 1000; i++) {
            for (Integer j = 1; j < 1000; j++) {
                value = i * j;
                count++;
                if (isPalindrome(value)) {
                    largestValue = value;
                    System.out.println("count:" + count + " i:" + i + " j:" + j);
                }
            }
        }
        return largestValue;
    }

    public boolean isPalindrome(Integer int1) {
        // 1, 12, 123, 1221, 12221
        String str = Integer.toString(int1);
        if (str.length() > 2) {
            Integer stringLength = str.length();
            for (Integer i = 0; i < stringLength / 2; i++) {

                if (str.charAt(i) != str.charAt((stringLength - 1) - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String reverseWords(String s) {
        StringBuilder stb = new StringBuilder();

        if (s != null && s.length() > 0) {
            String strTrimedString = s.trim();
            Stack<String> stackOfStrings = new Stack<String>();
            for (int i = 0; i < strTrimedString.length(); i++) {

                if (strTrimedString.charAt(i) == 32) {
                    if (stb.length() > 0) {
                        stackOfStrings.push(stb.toString());
                        String tmp = stackOfStrings.peek();
                        if (tmp.charAt(0) != 32)
                            stackOfStrings.push(" ");
                        stb.delete(0, stb.length());
                    } else {
                        stackOfStrings.push(" ");
                    }
                } else {
                    stb.append(strTrimedString.charAt(i));
                }
                // build the string

            }
            if (stb.length() > 0) {
                stackOfStrings.push(stb.toString());
            }
            // now create a string builder and pop it all off.
            StringBuilder x = new StringBuilder();
            while (!stackOfStrings.isEmpty()) {
                x.append(stackOfStrings.pop().toString());
            }

            return x.toString();
        }
        return "";
    }

    public String reverseWords2(String s) {
        StringBuilder stb = new StringBuilder();
        // Check if the string is empty.
        // Split the string by spaces into an array
        // Push each entry into a stack of strings.
        // I'll pop off the stack into a aString Builder object
        // Finall I'll call .toString() on the String Builder Object.

        if (s != null && s.length() > 0) {
            String strTrimedString = s.trim();
            String[] splited = strTrimedString.split(" ");
            Integer whiteSpaceCount = splited.length - 1;
            for (int i = splited.length - 1; i >= 0; i--) {
                stb.append(splited[i]);
                if (i >= 1)
                    stb.append(" ");
            }
        }
        return stb.toString();
    }

}
