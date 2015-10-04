public class Main {

    public static int steps (int start, int end) {
        int steps = 0;
        LineGame line = new LineGame();
        line.setN(44);
        while (line.getN() != 4444) {
            line.move();
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        int runs = 50;

        int sum = 0;
        for (int i = 0; i < runs; i++) {
            sum+=steps(44, 4444);
        }
        long average_steps = Math.round((sum * 1.0)/runs);

        System.out.println("steps: " + average_steps);
    }
}
