import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StrobogrammaticII {
    public static List<String> findStrobogrammatic(int n) {

        if (n == 0) {
            new LinkedList<String>();
        }

        List<String> first = new ArrayList<String>();
        first.add("0");
        first.add("1");
        first.add("8");


        if (n == 1) {
            return first;
        }

        List<String> second = new ArrayList<String>();
        second.add("11");
        second.add("69");
        second.add("88");
        second.add("96");

        if (n == 2) {
            return second;
        }

        ArrayList<List<String>> resList = new ArrayList<List<String>>();
        resList.add(first);
        resList.add(second);


        for (int i=3; i <= n; i++) {
            List<String> curList = new ArrayList<String>();

            int size = resList.size();



            if (i % 2 == 1) {

                for (String prev : resList.get(size-1)) {
                    for (String prevPrev : resList.get(size - 2)) {
                        int m = i/2;
                        curList.add(prev.substring(0, m) + prevPrev + prev.substring(m));
                    }
                }

            } else {
                for (String prev : resList.get(size-1)) {

                    int m = (size)/2;
                    char midChar = prev.charAt(m);

                    curList.add(prev.substring(0, m) + midChar + prev.substring(m));
                }
            }

            resList.add(curList);
        }

        return resList.get(n-1);

    }

    public static void print(List<String> res) {
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void main(String [] args) {

        List<String> res = findStrobogrammatic(5);
        print(res);

    }


}
