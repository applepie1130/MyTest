package zoom.test;

import java.util.ArrayList;
import java.util.List;

public class Time {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(1,2,3,4));

    }

}

class Solution2 {
    public String solution(int A, int B, int C, int D) {
        List<Integer> intSet = new ArrayList<>();
        intSet.add(A);
        intSet.add(B);
        intSet.add(C);
        intSet.add(D);
        int[] maxTime = { 2, 3, 5, 9 };
        StringBuilder maxTimeSb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int[] tempTimeInfo = { 0, 0, 0 };
            for (int j = 0; j < intSet.size(); j++) {
                int param = intSet.get(j).intValue();
                if (param <= maxTime[i]) {
                    if (param >= tempTimeInfo[1]) {
                        tempTimeInfo[0] = j;
                        tempTimeInfo[1] = param;
                        tempTimeInfo[2] = 1;
                    }
                }
            }
            if (tempTimeInfo[2] == 0) {
                return "NOT POSSIBLE";
            }
            maxTimeSb.append(Integer.toString(tempTimeInfo[1]));
            intSet.remove(tempTimeInfo[0]);
            if (i == 0 && tempTimeInfo[1] < 2) {
                maxTime[1] = 9;
            }
            if (i == 1) {
                maxTimeSb.append(":");
            }
        }
        return maxTimeSb.toString();
    }
}