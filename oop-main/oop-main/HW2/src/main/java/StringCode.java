import java.util.HashSet;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A run is a series of adjacent chars that are the same.
     * @param str input string
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str == null || str.isEmpty()) return 0;

        int max = 1;
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * Digits at the end are ignored.
     * @param str input string
     * @return blown up string
     */
    public static String blowup(String str) {
        if (str == null || str.isEmpty()) return str;
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                if (i + 1 < n) {
                    int times = ch - '0';
                    char next = str.charAt(i + 1);
                    for (int k = 0; k < times; k++) {
                        sb.append(next);
                    }
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null || len <= 0) return false;
        if (len > a.length() || len > b.length()) return false;

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <= a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }

        for (int j = 0; j <= b.length() - len; j++) {
            if (set.contains(b.substring(j, j + len))) {
                return true;
            }
        }

        return false;
    }

    // Quick test main
    public static void main(String[] args) {
        System.out.println("maxRun:");
        System.out.println(maxRun("xxyyyz"));
        System.out.println(maxRun("xyz"));
        System.out.println(maxRun(""));
        System.out.println(maxRun("aaaa"));

        System.out.println("\nblowup:");
        System.out.println(blowup("a3tx2z"));
        System.out.println(blowup("12x"));
        System.out.println(blowup("a0b1c"));

        System.out.println("\nstringIntersect:");
        System.out.println(stringIntersect("abcdef", "xyzcdmn", 2));
        System.out.println(stringIntersect("abcdef", "xyzcdmn", 3));
        System.out.println(stringIntersect("hello", "yellow", 3));
    }
}
