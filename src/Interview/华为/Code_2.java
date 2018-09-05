package Interview.华为;
//https://blog.csdn.net/qq_35246620/article/details/53183691?tdsourcetag=s_pctim_aiomsg

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Code_2 {
    public static boolean isNumeric(String str, int i) {
        if (!Character.isDigit(str.charAt(i))) {
            return false;
        } else
            return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        StringBuffer result = new StringBuffer();

        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (isNumeric(str, i) == false) {

            } else {
                if (map.containsKey(str.charAt(i))) {
                    map.get(str.charAt(i)).add(String.valueOf(temp));
                } else {
                    // map.put(str.charAt(i),temp);
                }
                //map.put(str.charAt(i),);
            }
        }
    }

}
