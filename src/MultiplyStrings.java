public class MultiplyStrings {
    public static String multiply(String num1, String num2) {

        if (num1 == null || num2 == null ||
            num1.length() == 0 || num2.length() == 0) {
            return "";
        }

        int n1 = num1.length();
        int n2 = num2.length();

        num1=new StringBuilder(num1).reverse().toString();
        num2=new StringBuilder(num2).reverse().toString();

        int [] res = new int [n1*n2];

        for (int i=0; i < n1; i++) {
            for (int j=0; j < n2; j++) {
                res[i+j] += (num1.charAt(i) - '0')  * (num2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < res.length; i++) {
            int sum = carry + res[i];
            int num = sum%10;
            sb.append(num);
            carry = sum/10;
        }
        if (carry > 0) {
            sb.append(carry);
        }

        sb = sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();


    }

    public static void main(String [] args) {
        String m = multiply("123", "456");

        System.out.print(m);
    }
}
