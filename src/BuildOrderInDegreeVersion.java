import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BuildOrderInDegreeVersion {

    static class Build {
        public String name;
        public int inDegree;
        public List<Build> children;

        Build(String s) {
            name=s;
            inDegree = 0;
            children = new LinkedList<Build>();
        }

        public void addChild(Build b) {
            children.add(b);
        }

    }

    public static List<String> buildOrder(String [] builds, Map<String, String> dependsMap) {
        List<String> res = new LinkedList<String>();

        HashMap<String, Build> buildsMap = new HashMap<String, Build>();

        for (String s : builds) {
            buildsMap.put(s, new Build(s));
        }

        for (Map.Entry<String, String> entry: dependsMap.entrySet()) {

            String child = entry.getKey();
            String parent = entry.getValue();

            Build childBuild = buildsMap.get(child);
            childBuild.inDegree++;
            buildsMap.get(parent).addChild(childBuild);

        }

        int buildSize = builds.length;

        while (res.size() < buildSize) {
            Build cur = getZeroIndegreeBuild(buildsMap);
            if (cur == null) {
                return null;
            }

            res.add(cur.name);

            for (Build ch : cur.children) {
                ch.inDegree--;
            }
        }
        return res;
    }

    private static Build getZeroIndegreeBuild(HashMap<String, Build> buildsMap) {
        Build res = null;
        String key = null;
        for (Map.Entry<String, Build> entry: buildsMap.entrySet()) {
            if (entry.getValue().inDegree == 0) {
                key = entry.getKey();
                res = entry.getValue();
            }
        }
        if (key != null)
            buildsMap.remove(key);
        return res;
    }


    private static void print(List<String> list) {
        for (String s: list) {
            System.out.print(s + ", ");
        }
        System.out.println();

    }
    public static void main(String args []) {

        String [] p = {"0", "1", "2", "3"};

        HashMap<String, String> depends = new HashMap<String, String>();
        depends.put("1", "0");
        depends.put("2", "0");
        depends.put("3", "1");
        depends.put("2", "1");


        List<String> res = buildOrder(p, depends);

        print(res);

    }

}
