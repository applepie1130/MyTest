package zoom.test;

public class MainTest {

    public static void main(String[] args) {
        Solution1 a = new Solution1();
        System.out.println(a.solution(51712));
    }

}
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
    public int solution(int N) {
        int maxZeroLength = 0;
        String binaryString = Integer.toBinaryString(N);
        String replaceStr = binaryString.replaceAll("^[10+]", "").replaceAll("10*$", "");
        System.out.println(replaceStr);
        String[] zeroStr = replaceStr.split("1");
        for (String a : zeroStr) {
            int zeroLength = a.length();
            if (zeroLength > maxZeroLength){
                maxZeroLength = zeroLength;
            }
        }
        return maxZeroLength;
    }
}