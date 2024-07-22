import java.util.HashMap;

public class MyNewClass {
    public MyNewClass() {

    };

    public String GetLogs() {
        String myString = "Hello, World Twice####";
        return myString;
    }

    public boolean FindPalindrone(String valu) {
        if (valu != null && valu.length() > 0) {
            int len = valu.length();
            for (int i = 0; i < len / 2; i++) {
                if (valu.charAt(i) != valu.charAt(len - 1)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isAnagram(String valu, String[] values, int setDefault) {
        boolean result = false;
        setDefault = 1;
        // check if strings are valid
        if (valu != null && valu.length() > 0 && values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                // Build reference hash
                // This is a new comment to help with the source code.
                if (valu.length() == values[i].length()) {
                    HashMap<Character, Integer> hash = BuildReferenceHashHelper(removeSpacesAndLowerCaseOnly(valu));
                    result = ContainsAnagramInStringHelper(hash, removeSpacesAndLowerCaseOnly(values[i]));
                    // loop through dictionary
                } else {
                    // if we ever encounter lengths that don't match it's not an anagram
                    result = false;
                }
            }
        }
        return result;
    }

    private HashMap<Character, Integer> BuildReferenceHashHelper(String refValue) {
        if (refValue != null && refValue.length() > 0) {
            HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
            for (int j = 0; j < refValue.length(); j++) {
                if (hash.containsKey(refValue.charAt(j))) {
                    int count = hash.get(refValue.charAt(j)) + 1;
                    hash.put(refValue.charAt(j), count);
                } else
                    hash.put(refValue.charAt(j), 1);
            }
            return hash;
        }
        return null;
    }

    // One flaw result is overwriiten and the last value is the winner.
    private boolean ContainsAnagramInStringHelper(HashMap<Character, Integer> referenceHash, String currentString) {
        boolean result = false;
        for (int k = 0; k < currentString.length(); k++) {
            Character ch = currentString.charAt(k);
            if (referenceHash.containsKey(ch)) {
                // pull out value and decrement.
                int count = referenceHash.get(ch);
                if (count <= 1) {
                    referenceHash.remove(ch);
                } else {
                    count = count - 1;
                    referenceHash.put(ch, count);
                }
            } else {
                // not in keys so it's automatically not an anagram
                // ie. "loops" compared against "foo"
                result = false;
            }
            // Finally if the hash is empty on all values it's an anagram
            if (referenceHash.isEmpty()) {
                result = true;
            }
        }
        return result;
    }

    private String removeSpacesAndLowerCaseOnly(String exampleString) {
        String str = "";
        if (exampleString != null && exampleString.length() > 0) {
            // use a regex
            str = exampleString.replaceAll("\\s+", "").toLowerCase();
        }
        return str;
    }
}
