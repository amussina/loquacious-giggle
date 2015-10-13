import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res  = new LinkedList<String>();

        restoreIpAddresses(s, 4, new ArrayList<String>(), res);
        return res;

    }

    private boolean restoreIpAddresses(String s, int partsNum, List<String> cur, List<String> res) {
        if (partsNum == 1) {
            if (isValidIPPArt(s)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(cur.get(i));
                    sb.append(".");
                }
                sb.append(s);
                res.add(sb.toString());
            }
        }

        for (int i = 0; i < 3; i++) {
            String sub = s.substring(i+1);
            if (isValidIPPArt(sub)) {
                cur.add(sub);
                restoreIpAddresses(s.substring(i+1), partsNum - 1, cur, res);
                cur.remove(cur.size()-1);
            }
        }
        return false;
    }

    private boolean isValidIPPArt(String s) {
        try {
            Integer IP = Integer.parseInt(s);
            return IP >=0 && IP <=255;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
