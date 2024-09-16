public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!!");
        System.out.println("Hello, World!!");
        System.out.println("Hello, World!!");
        MyNewClass my = new MyNewClass();
        System.out.println(my.GetLogs());
        System.out.println(my.FindPalindrone("aba"));
        System.out.println(my.FindPalindrone("AAAA"));
        System.out.println(my.FindPalindrone("AAAB"));
        System.out.println(my.FindPalindrone("AAB"));
        System.out.println(my.FindPalindrone(""));

        // Anagram
        final String anagramWord = "loops";
        final String[] listOfStrings = { "polos", "pools", "sloop", "spool" };

        System.out.println("Anagram is" + my.isAnagram(anagramWord, listOfStrings));

        final String anaSentence = "eleven plus two";
        final String[] listOfSentence = { "twelve plus one" };
        System.out.println("Anagram is" + my.isAnagram(anaSentence, listOfSentence));

        LinkedList2 list = new LinkedList2();
        list.setDataValue(100);
        LinkedList2 node2 = new LinkedList2();
        node2.setDataValue(1);
        list.setNode(node2);

        System.out.println(list.getDataValue());
        System.out.println(list.getNextNode().getDataValue());

        Mercedes myBenz = new Mercedes("6VVP090", 1980);
        myBenz.startEngine();
        myBenz.runDiagnostics();
        System.out.println(myBenz.getLic());
        System.out.println(myBenz.getbulitYear());
        System.out.println(myBenz.mergeAlternately("ABC", "123"));
        System.out.println(myBenz.mergeAlternately("ABC", "123456789"));
        System.out.println(myBenz.mergeAlternately("ABCDEFGHI", "123"));
        System.out.println(myBenz.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(myBenz.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(myBenz.gcdOfStrings("LEET", "CODE"));

        System.out.println(myBenz.largestPalindrome());
        Tesla myTesla = new Tesla("9JKL009", 2023);
        myTesla.runDiagnostics();

        char[] chr = { 'a', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' };
        System.out.println(myTesla.compress(chr));

        char[] chr2 = { 'b', 'b', 'a', 'a', 'c', 'c', 'c', 'c' };
        System.out.println(myTesla.compress(chr2));

        System.out.println(myTesla.getCount());
        System.out.println(myBenz.reverseWords("The Sky Is Blue"));

    }
}
