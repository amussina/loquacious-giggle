public class AddDigits {
    public static int addDigits(int num) {
        while (!isSingleDigit(num)) {
            int res = 0;
            while (num > 0) {
                res += num%10;
                num/=10;
            }
            num = res;
        }
        return num;
    }

    public static boolean isSingleDigit(int num) {
        if (num == 10) {
            return false;
        }
        int div = (int)Math.ceil(num/10.0);
        return div == 1;
    }

    public static void main(String [] args) {
        System.out.print(addDigits(109));
    }


}
