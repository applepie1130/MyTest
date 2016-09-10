package zoom.test;

public class DupCnt {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] a = { 0, 0, 0, 0 };
        System.out.println(solution.solution(a));
    }

}

class Solution3 {
    public int solution(int[] A) {
        int pairsCnt = 0;
        StringBuilder intSb = new StringBuilder();
        String intStr = null;
        for (int i = 0; i < A.length; i++) {
            intSb.append(A[i]);
            intSb.append(",");
        }
        intStr = intSb.toString();
        for (int i = 0; i < A.length; i++) {
            String targetStr = Integer.toString(A[i]) + ",";
            intStr = intStr.replaceFirst(targetStr, "");
            int pairIdx = -1;
            boolean loopFlag = true;
            do {
                pairIdx = intStr.indexOf(targetStr, pairIdx + 1);
                if ((pairIdx > -1)) {
                    pairsCnt++;
                } else {
                    loopFlag = false;
                }
            } while (loopFlag);
        }
        return pairsCnt;
    }
}