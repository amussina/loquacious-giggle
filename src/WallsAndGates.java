import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class WallsAndGates {


        static class PointE implements Comparable<PointE> {
            public int x;
            public int y;
            public int d;

            public PointE(int x, int y, int d) {
                this.x = x;
                this.y = y;
                this.d = d;
            }

            @Override
            public int compareTo(PointE other) {
                return Integer.compare(this.d , other.d);
            }
        }

        public static void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length==0) {
                return;
            }
            int m = rooms.length;
            int n = rooms[0].length;

            List<PointE> gates = getGates(rooms, m , n);

            for (int i=0; i < gates.size(); i++) {
                boolean [][] used = new boolean[m][n];
                PointE gate = gates.get(i);
                bfs(gate, rooms, used, m , n);
            }

        }

        public static void bfs(PointE gate, int[][] rooms, boolean[][] used, int m, int n) {
            PriorityQueue<PointE> PQ = new PriorityQueue<PointE>();

            PQ.add(gate);
            used[gate.x][gate.y] = true;


            while (!PQ.isEmpty()) {
                PointE curPoint = PQ.poll();
                if (rooms[curPoint.x][curPoint.y] >= curPoint.d) {
                    rooms[curPoint.x][curPoint.y] = curPoint.d;
                    LinkedList<PointE> neighbors = getNeighbors(curPoint, rooms, used, m, n);

                    for (PointE p: neighbors) {
                        PQ.add(p);
                        used[p.x][p.y] = true;
                        //rooms[p.x][p.y] = Math.min(rooms[p.x][p.y], p.d);
                    }
                }

            }

        }

        public static LinkedList<PointE> getNeighbors(PointE point, int [][] rooms, boolean[][] used, int m, int n) {
            LinkedList<PointE> res = new LinkedList<PointE> ();

            if (point.x - 1 >= 0 && rooms[point.x - 1][point.y] != -1 && !used[point.x-1][point.y]) {
                res.add(new PointE(point.x-1, point.y, point.d+1));
            }

            if (point.x + 1 <= m - 1  && rooms[point.x + 1][point.y] != -1 && !used[point.x+1][point.y]) {
                res.add(new PointE(point.x+1, point.y, point.d+1));
            }

            if (point.y - 1 >= 0 && rooms[point.x][point.y-1] != -1 && !used[point.x][point.y-1]) {
                res.add(new PointE(point.x, point.y-1, point.d+1));
            }

            if (point.y + 1 <= n - 1 && rooms[point.x][point.y+1] != -1 && !used[point.x][point.y+1]) {
                res.add(new PointE(point.x, point.y+1, point.d+1));
            }
            return res;
        }

        public static List<PointE> getGates(int [][] rooms, int m, int n) {
            List<PointE> gates = new ArrayList<PointE>();
            for (int i=0; i < m; i++) {
                for (int j=0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        PointE gate = new PointE(i, j, 0);
                        gates.add(gate);
                    }
                }
            }
            return gates;
        }

    public static void print (int [][] rooms) {
        for (int i=0;i<rooms.length; i++) {
            for (int j=0; j< rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " " );
            }
            System.out.println();
        }
    }

    public static void main(String [] args) {

        int [][] rooms = { {2147483647, -1, 0, 2147483647},
                           {2147483647,2147483647,2147483647,-1},
                           {2147483647,-1,2147483647,-1},
                           {0,-1,2147483647,2147483647}};

        wallsAndGates(rooms);

        print(rooms);
    }
}
