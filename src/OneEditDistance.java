public class OneEditDistance {
    public static boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (s.equals(t)) {
            return false;
        }

        int sLen = s.length();
        int tLen = t.length();

        if (sLen == tLen) {
            return isOneCharEdit(s, t, sLen);
        } if (sLen + 1 == tLen) {
            return isOneCharAdd(s,t, sLen);
        } if (sLen == 1 + tLen) {
            return isOneCharAdd(t, s, tLen);//isOneCharRemove(s,t, tLen);
        }
        return false;
    }

    private static boolean isOneCharEdit(String s, String t, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (i==0) {
                if (s.substring(1).equals(t.substring(1))) {
                    return true;
                }
            } else if (i == n-1) {
                if (s.substring(0, n-1).equals(t.substring(0,n -1))) {
                    return true;
                }
            } else {
                if (s.substring(0, i).equals(t.substring(0,i)) &&
                    s.substring(i+1).equals(t.substring(i+1))
                        ) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isOneCharAdd(String s, String t, int n) {
        if (n == 0) {
            return true;
        }
        for (int i=0; i < n; i++) {

            if (s.equals(t.substring(1))) {
                return true;
            }

            if (s.equals(t.substring(0, n))) {
                return true;
            }

            if (s.substring(0, i).equals(t.substring(0,i)) &&
                    s.substring(i, n).equals(t.substring(i+1, n + 1 ))) {
                    return true;
            }



        }

        return false;
    }



    public static void main(String [] args) {
        String s = "ab";
        String t = "acb";

        boolean oneEdit = isOneEditDistance(s, t);

        System.out.print(oneEdit);
    }
}
