import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Skyline {

    class Point implements Comparable<Point> {
        public int x;
        public int height;

        Point (int x, int height) {
            this.x = x;
            this.height = height;
        }

        @Override
        public int compareTo(Point other) {
            int c = this.x - other.x;

            if (c != 0) {
                return c;
            } else {
                return this.height - other.height;
            }
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();

        if (buildings == null || buildings.length == 0) {
            return res;
        }

        int n = buildings.length;

        Point [] points = new Point[2*n];

        for (int i = 0; i < n; i++) {
            points[2*i] = new Point(buildings[i][0], buildings[i][2]);
            points[2*i+1] = new Point(buildings[i][1], (-1) * buildings[i][2]);
        }

        Arrays.sort(points);

        PriorityQueue<Integer> PQ = new PriorityQueue<Integer>(1, Collections.reverseOrder());

        for (int i = 0; i < points.length; i++) {
            int [] pointHeight = new int [2];
            int heightMagnitude = points[i].height;
            if (heightMagnitude > 0) {
                PQ.add(heightMagnitude);
            } else {
                PQ.remove(-heightMagnitude);
            }

            if (i < points.length - 1 && points[i].x == points[i+1].x) {
                continue;
            }

            pointHeight[0] = points[i].x;
            pointHeight[1] = PQ.isEmpty() ? 0 : PQ.peek();


            if (res.size() == 0) {
                res.add(pointHeight);
            } else {
                int [] lastPointHeight = res.get(res.size() - 1);

                if (lastPointHeight[1] != pointHeight[1]) {
                    res.add(pointHeight);
                }

            }



        }

        return res;

    }
}
