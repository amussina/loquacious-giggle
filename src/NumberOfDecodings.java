public class NumberOfDecodings {

    public int numDecodings(String s) {

        if (s==null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            if (s.charAt(0) < '1' || s.charAt(0) > '9') {

            }
        }
        int [] dp = new int [s.length() +1];
        dp[0]=0;
        dp[1] = 0;
        for (int i = 1; i <=s.length(); i++) {

        }

        return -1;




    }
}
