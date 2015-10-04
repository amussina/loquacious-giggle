public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        Integer [] catalan = new Integer[n+1];

        catalan[0]=catalan[1]=1;

        for (int num = 2; num <=n ; num++) {
            int sum = 0;
            for (int i=0; i < num; i++) {
                sum += catalan[i]*catalan[num-i-1];
            }
            catalan[num] = sum;
        }

        return catalan[n];
    }



    public static void main(String [] args) {


        int n = numTrees (5);
        System.out.print(n);
    }
}
