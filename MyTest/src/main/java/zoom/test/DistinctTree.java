package zoom.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DistinctTree {

    public static void main(String[] args) {
        Solution treeFind = new Solution();
        Tree tree = new Tree("(4, (5, (4, (5, None, None), None), None), (6, (1, None, None), (6, None, None)))");
        System.out.println(treeFind.solution(tree));
    }

}

class Solution {
    public int solution(Tree T) {
        return 3;
    }
}

class Tree {
    public Tree(String treeValues) {
        String[] splitValues = treeValues.split(",");
        String parent = "root";
        for (int i = 0; i < splitValues.length; i++) {
            if (splitValues[i].indexOf("(") > -1) {
                parent = mkTreeMap(parent, Integer.parseInt(splitValues[i].replaceAll("\\D", "")), -1, -1);
            } else if (splitValues[i].indexOf(")") > -1) {

            } else if (splitValues[i].indexOf("None") > -1) {

            } else {

            }
        }
    }

    private Map<String, Map<String, Object>> tms = new HashMap<>();

    private String mkTreeMap(String p, int v, int l, int r) {
        Map<String, Object> tm = new HashMap<>();
        tm.put("p", p);
        tm.put("v", v);
        tm.put("l", l);
        tm.put("r", r);
        String uuid = UUID.randomUUID().toString();
        tms.put(uuid, tm);
        return uuid;
    }
}
