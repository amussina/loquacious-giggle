import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BuildOrderInDegreeVersionLeetcode {

    static class Build {
        public int name;
        public int inDegree;
        public List<Build> children;

        Build(int s) {
            name=s;
            inDegree = 0;
            children = new LinkedList<Build>();
        }

        public void addChild(Build b) {
            children.add(b);
        }

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }

        int [] res = new int [numCourses];
        HashMap<Integer, Build> buildsMap = new HashMap<Integer, Build>();

        for (int i=0; i < numCourses; i++) {
            buildsMap.put(i, new Build(i));
        }

        for (int i = 0; i < prerequisites.length; i++) {

            int child = prerequisites[i][0];
            int parent = prerequisites[i][1];

            Build childBuild = buildsMap.get(child);
            childBuild.inDegree++;
            buildsMap.get(parent).addChild(childBuild);

        }

        int buildSize = numCourses;

        int index = 0;
        while (index < buildSize) {

            Build cur = getZeroIndegreeBuild(buildsMap);
            if (cur == null) {
                return new int[0];
            }

            res[index] = cur.name;

            for (Build ch : cur.children) {
                ch.inDegree--;
            }
            index++;
        }
        return res;
    }


    private static Build getZeroIndegreeBuild(HashMap<Integer, Build> buildsMap) {
        Build res = null;
        Integer key = null;
        for (Map.Entry<Integer, Build> entry: buildsMap.entrySet()) {
            if (entry.getValue().inDegree == 0) {
                key = entry.getKey();
                res = entry.getValue();
            }
        }
        if (key != null)
            buildsMap.remove(key);
        return res;
    }


    private static void print(int [] ints) {
        for (int i = 0; i<ints.length;i++) {
            System.out.print(ints[i] + ", ");
        }
        System.out.println();

    }
    public static void main(String args []) {


        int [][] depends = {{1, 2},
                            {2,0},
                            {3,1},
                            {2,1}};



       int [] res = findOrder(4, depends);

        print(res);

    }

}
