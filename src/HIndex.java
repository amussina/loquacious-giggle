import java.util.Arrays;

public class HIndex {

    public static  int hIndex(int[] citations) {
        Arrays.sort(citations);

        int h = 1;
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            if (n-i >= citations[i]) {
                h = citations[i];
            } else {
                break;
            }

        }

        return h;
    }

    public static void main(String [] args) {
        int [] c = {3, 0, 6, 1, 5};
        System.out.print(hIndex(c));
    }
}
