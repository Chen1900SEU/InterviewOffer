package Interview.华为;

import java.util.*;

public class Code_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s += " ";
        final char[] chars = s.toCharArray();
        String str = "";
        String count = "";
        List<SubString> store = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                count += chars[i];
            } else {
                if (!count.equals("")) {
                    store.add(new SubString(Integer.parseInt(count), str));
                    count = "";
                    str = "";
                }
                str += chars[i];
            }
        }
        Collections.sort(store, new Comparator<SubString>() {
            @Override
            public int compare(SubString o1, SubString o2) {
                if (o1.count == o2.count) {
                    return o1.str.compareTo(o2.str);
                } else {
                    return o1.count - o2.count;
                }
            }
        });
        StringBuilder res = new StringBuilder();
        for (SubString subString : store) {
            res.append(subString.midStr);
        }
        System.out.println(res.toString());
    }

    private static class SubString {
        private int count;
        private String str;
        private String midStr;

        public SubString(int count, String str) {
            this.count = count;
            this.str = str;
            midStr = new String(new char[count]).replace("\0", str);

        }
    }

}
