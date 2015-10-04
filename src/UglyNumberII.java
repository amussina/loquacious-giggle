import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class UglyNumberII {

    public static  int nthUglyNumber(int n) {

        PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        PQ.add(1);
        set.add(1);

        Integer uglyNumber = 1;

        for (int i = 1; i <=n; i++) {
            uglyNumber = PQ.poll();

            if (i==n) {
                break;
            }

            if (uglyNumber <= Integer.MAX_VALUE/2 && !set.contains(uglyNumber*2)) {
                Integer ugly = uglyNumber*2;
                PQ.offer(ugly);
                set.add(ugly);
            }
            if (uglyNumber <= Integer.MAX_VALUE/3 && !set.contains(uglyNumber*3)) {
                Integer ugly = uglyNumber*3;
                PQ.offer(ugly);
                set.add(ugly);
            }
            if (uglyNumber <= Integer.MAX_VALUE/5 && !set.contains(uglyNumber*5)) {
                Integer ugly = uglyNumber*5;
                PQ.offer(ugly);
                set.add(ugly);
            }

        }
        return uglyNumber;


    }

    public static void main(String [] args) {
        System.out.print(nthUglyNumber(11));
    }

}
