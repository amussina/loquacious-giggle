import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Candy {
/*
    public static class Student{
        int rank;
        int index;
        int candy;

        public Student(int rank, int index) {
            this.rank=rank;
            this.index = index;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(final int rank) {
            this.rank = rank;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(final int index) {
            this.index = index;
        }

        public int getCandy() {
            return candy;
        }

        public void setCandy(final int candy) {
            this.candy = candy;
        }
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int [] r = new int [N];
        int [] candies = new int [N];
        Student [] students = new Student[N];
        PriorityQueue<Student> PQ = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(final Student o1, final Student o2) {
                return o1.rank - o2.rank;
            }
        });

        for (int i = 0; i < N; i++) {
            r[i] = in.nextInt();
            students[i] = new Student(r[i], i);

            PQ.add(students[i]);
        }


        int minCandy = 1;
        while(!PQ.isEmpty()) {
            Student rank = PQ.poll();

            candies[index] = getMinCandyForNeightbor(index, r, candies, N);
            minCandy++;

            Integer leftNeighbor = (index>0 && candies[index-1] == 0) ? r[index - 1] : null;
            if (leftNeighbor != null) {
                PQ.add(leftNeighbor);
            }
            Integer rightNeighbor = (index < N-1 && candies[index+1] == 0) ? r[index + 1] : null;
            if (rightNeighbor != null) {
                PQ.add(rightNeighbor);
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum+=candies[i];
        }

        System.out.println(sum);
    }

    private static int getMinCandyForNeightbor(int index, int [] rank, int [] candies, int N) {
        if (index == 0) {
            if (rank[index + 1] < rank[index]) {
                return candies[index+1];
            } else {
                return 1;

            }
        } else if (index == N - 1 ) {
            if (rank[index] > rank[index - 1]) {
                return candies[index - 1];
            } else {
                return 1;
            }
        } else {
            int leftCandy = candies[index-1];
            int rightCandy = candies[index + 1];

            int min = Math.min((leftCandy > 0) ? leftCandy : 1,
                               (rightCandy > 0) ? rightCandy : 1);
            return min;

        }
    }
    */

}
