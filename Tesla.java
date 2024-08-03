import java.util.HashMap;

public class Tesla implements ICar {
    public String licNumber;
    public Integer builtYear;

    public Tesla(String lic, Integer yearBuilt) {
        this.builtYear = yearBuilt;
        this.licNumber = lic;
    }

    public String getLic() {
        return this.licNumber;
    }

    public Integer getCount() {
        return ICar.count;
    }

    public Integer getbulitYear() {
        return this.builtYear;
    }

    public boolean runDiagnostics() {
        System.out.println("Tesla: Run the diagnostics!");
        return true;
    }

    public int compress(char[] chars) {
        int finalCount = 0;
        if (chars != null && chars.length > 0) {
            HashMap<Character, Integer> hashM = new HashMap<Character, Integer>();
            for (int i = 0; i < chars.length; i++) {
                if (hashM.containsKey(chars[i])) {
                    Integer tempCount = hashM.get(chars[i]);
                    hashM.put(chars[i], tempCount + 1);
                } else {
                    hashM.put(chars[i], 1);
                }
            }
            StringBuilder strb = new StringBuilder();
            // Walk through the hashmap and push to a stringbuilder
            for (HashMap.Entry<Character, Integer> entry : hashM.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                strb.append(key);
                strb.append(value);
            }
            System.out.println(strb.toString());
            finalCount = strb.length();
        }
        return finalCount;
    }
}
