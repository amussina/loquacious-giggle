import com.sun.org.apache.xpath.internal.operations.Bool;

public class LCSInterleave {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int m=s1.length();
        int n= s2.length();
        int l = s3.length();

        if (m+n != l) {
            return false;
        }
        Boolean [][] DP = new Boolean [m+1][n+1];

        boolean LCS = isInterleaveHelper(0, 0, s1, s2, s3, DP);
        return (LCS);

    }

    public static boolean isInterleaveHelper(int i, int j, String s1, String s2, String s3, Boolean [][] DP) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        }
        if (i + j == s3.length()) {
            return true;
        }

        if (DP[i][j] != null) {
            return DP[i][j];
        }
        if (i == s1.length() && s2.charAt(j) == s3.charAt(i + j)) {
            DP[i][j] = isInterleaveHelper(i, j + 1, s1, s2, s3, DP);
        } else if (j == s2.length() && s1.charAt(i) == s3.charAt(i + j)) {
            DP[i][j] = isInterleaveHelper(i + 1, j, s1, s2, s3, DP);
        } else if (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) != s3.charAt(i+j)) {
                DP[i][j] = isInterleaveHelper(i + 1, j, s1, s2, s3, DP);
            } else if(s1.charAt(i) != s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)) {
                DP[i][j] = isInterleaveHelper(i, j+1, s1, s2, s3, DP);
            } else if (s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)) {
                DP[i][j] = isInterleaveHelper(i, j+1, s1, s2, s3, DP) || isInterleaveHelper(i + 1, j, s1, s2, s3, DP);
            } else {
                DP[i][j] = false;
            }
        } else {
            DP[i][j] = false;
        }

        return DP[i][j];

    }

    // A function to run test cases
    public static void test( String A, String B, String C)
    {
        if (isInterleave(A, B, C))
            System.out.println(String.format("%s is interleaved of %s and %s", A, B, C));
        else
            System.out.println(String.format("%s is not interleaved of %s and %s", A, B, C));

    }

    public static void main(String [] args) {
        String s1 = "aabcc";

        String s2 = "dbbca";

        String s3 = "aadbbcbcac";
        String s4= "aadbbbaccc";

        test(s1, s2, s3);
        test(s1, s2, s4);

        test("XXY", "XXZ", "XXZXXXY");
        test("XY" ,"WZ" ,"WZXY");
        test ("XY", "X", "XXY");
        test ("YX", "X", "XXY");
        test ("XXY", "XXZ", "XXXXZY");
    }

}
