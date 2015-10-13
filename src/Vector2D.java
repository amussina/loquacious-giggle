import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Vector2D {

    int n;
    int cur = 0;
    ArrayList<Iterator<Integer>> iteratorList;

    public Vector2D(List<List<Integer>> vec2d) {
        this.n = vec2d.size();
        iteratorList = new ArrayList<Iterator<Integer>>();

        for (List<Integer> list: vec2d) {
            Iterator<Integer> iter = list.iterator();
            iteratorList.add(iter);
        }
    }

    public int next() {

        Iterator iter = iteratorList.get(cur);

        if (hasNext()) {
            return iteratorList.get(cur).next();
        } else {
            return -1;
        }

    }

    public boolean hasNext() {
        if (cur < n - 1) {
            Iterator iter = iteratorList.get(cur);
            if (iter.hasNext()) {
                return iter.hasNext();
            } else {
                cur++;
                return hasNext();
            }
        } else if (cur == n - 1){
            Iterator iter = iteratorList.get(cur);
            return iter.hasNext();
        }
        return false;
    }

    public static void main(String [] args) {
        List<List<Integer>> vec2d = new LinkedList<List<Integer>>();

        List<Integer> first = new LinkedList<Integer>();
        first.add(1);
        first.add(2);
        List<Integer> sec = new LinkedList<Integer>();
        sec.add(3);
        List<Integer> third = new LinkedList<Integer>();
        third.add(4);
        third.add(5);

        vec2d.add(first);
        vec2d.add(sec);
        vec2d.add(third);



        Vector2D vIter = new Vector2D(vec2d);

        while (vIter.hasNext()) {
            System.out.println(vIter.next());
        }
    }
}
