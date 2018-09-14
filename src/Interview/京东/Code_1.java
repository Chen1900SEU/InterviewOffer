package Interview.京东;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code_1 {
    private static int counter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        for (int i = 0; i < s.length() - t.length() + 1; i++) {
            for (int j = 0; j < t.length(); j++) {
                //  if(s.charAt(i)-t.charAt(j))
            }

        }

        //System.out.println(s);
        int res = method(s, t);
        System.out.println(res);


    }

    public static int method(String string, String a) {

        int counter = 0;
        for (int i = 0; i <= string.length() - a.length(); i++) {
            if (string.substring(i, i + a.length()).equals(a)) {
                counter++;
            }
        }
        return counter;
    }

    public static int countStrNum(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }
}
