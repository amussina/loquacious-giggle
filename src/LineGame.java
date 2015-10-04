public class LineGame {
    private int n;

    public int getN() {
        return n;
    }

    public void setN(final int n) {
        this.n = n;
    }

    public void move() {
        if (n == 0) {
            n = 1;
            return;
        }

        double rand = Math.random() * 1;
        long direction_outcome = Math.round(rand);

        if (direction_outcome == 1) {
            n++;
        } else {
            n--;
        }
    }
}
