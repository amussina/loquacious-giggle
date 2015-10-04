public class SummatorUmnojator {

    public static int calc(String str) {
        char [] arr = str.toCharArray();

        int sum = 0;

        int product = 1;

        if (str == null || str.length() == 0) {
            return 0;
        }

        product = Character.getNumericValue(arr[0]);

        int i = 1;

        for (; i < arr.length; i+=2) {
            if (arr[i] == '+') {
                sum += product;
                product = Character.getNumericValue(arr[i+1]);

            } else if (arr[i] == '*') {
                product*= Character.getNumericValue(arr[i+1]);
            }
        }

        sum += product;

        return sum;
    }

    public static void main(String[] args) {
        String str = "1+9*2+7+8+1*3";
        System.out.println(str);
        System.out.println(String.format("%d", calc(str)));
    }
}
