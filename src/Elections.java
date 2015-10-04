import java.util.Scanner;

public class Elections {

    static class Candidate {
        public  int index ;
        public int vote ;
        public Candidate(int index, int vote) {
            this.index=index;
            this.vote=vote;
        }

    }

    public static void main(String [] args) throws Exception {

        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int m = read.nextInt();

        int [][] arr = new int [m][n];

        for (int i = 0; i < m; i++) {
            for (int j=0; j < n;j++) {
                arr[i][j] = read.nextInt();
            }
        }

        Candidate [] bestInCities = new Candidate[m];

        for (int i = 0; i < m; i++) {
            int maxVote = Integer.MIN_VALUE;
            for (int j=0; j < n;j++) {
                if (arr[i][j] > maxVote) {
                    maxVote = arr[i][j];

                    bestInCities[i] = new Candidate(j, maxVote);
                }
            }
        }

        int [] cityCount = new int [101];
        for (int i=0;i<101; i++) {
            cityCount[i]=0;
        }
        for (int i = 0; i < m; i++) {
            cityCount[bestInCities[i].index]++;
        }
        int bestCandidateIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<101; i++) {
            if (max < cityCount[i]) {
                max = cityCount[i];
                bestCandidateIndex = i;
            }
        }

        System.out.println(bestCandidateIndex + 1); ;

    }
}
