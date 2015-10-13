import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            if (s.isEmpty()) {
                sb.append("0");
            } else {
                int len = s.length();
                int digits = (int)Math.ceil(len * 1.0 / 10);
                sb.append(""+digits);
                sb.append(""+len);
                sb.append(s);
            }
        }

        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public static  List<String> decode(String s) {
        List<String> res = new LinkedList<String>();

        if (s == null || s.isEmpty()) {
            return res;
        }
        int i = 0;
        int n = s.length();
        while (i < n) {
            int digits = s.charAt(i) - '0';
            if (digits == 0) {
                continue;
            }
            String num = s.substring(i+1, i + 1 + digits);

            int len = Integer.parseInt(num);
            String str = s.substring(i + 1 + digits, i  + 1 + len  + digits);
            i += (1 + len + digits);
            res.add(str);
        }
        return res;
    }

    public static void main(String [] args) {

        String [] arr = {""};//{"63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "};

        List<String> list = Arrays.asList(arr);

        String str = encode(list);
        System.out.print(str);

        List<String> decList = decode(str);

        System.out.println(Arrays.toString(decList.toArray()));
    }
}