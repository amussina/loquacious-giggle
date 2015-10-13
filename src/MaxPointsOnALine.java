import java.util.HashMap;

public class MaxPointsOnALine {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }


    public static  int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }

        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int max = 0;

        for (int i = 0; i < n-1; i++) {
            HashMap<Double, Integer> HM = new HashMap<Double, Integer>();
            int sameX = 1;
            int sameP = 0;

            Point a = points[i];

            for (int j = i+1; j < n; j++) {
                Point b = points[j];

                if (a.x == b.x && b.y == a.y) {
                        sameP++;
                }
                if (a.x == b.x)
                {
                    sameX++;
                    continue;
                }


                double slope = (b.y == a.y) ? 0 :
                               (1.0 * (b.y - a.y)/ (b.x - a.x));

                if (HM.containsKey(slope)) {
                    HM.put(slope, HM.get(slope)  + 1);
                } else {
                    HM.put(slope, 2);
                }

                max = Math.max(max, HM.get(slope) + sameP);


            }

            max = Math.max(max, sameX);

        }
        return max;
    }


    public static void main (String [] args) {
        Point [] p = new Point[6];

        p[0]= new Point(11,1);
        p[1]= new Point(11,1);
        p[2] = new Point (10,1);
        p[3] = new Point (10,1);
        p[4] = new Point (1,1);
        p[5] = new Point (1,1);

//        p[0]= new Point(2,3);
//        p[1] = new Point (3,3);
//       p[2] = new Point(-5,3);

//        p[0]= new Point(0,0);
//        p[1] = new Point (-1,-1);
//        p[2] = new Point(0,0);
//        p[3]= new Point(-1,-1);
//        p[4]= new Point(-1,-1);
//        p[5]= new Point(-1,5);
//        p[6]= new Point(-1,7);
//        p[7]= new Point(-1,-3);

        int n = maxPoints(p);
        System.out.print(n);
    }

}
