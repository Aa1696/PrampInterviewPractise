package Hard;
import java.util.*;
public class Difference_Between_Two_Strings {
    static String[] diffBetweenTwoStrings(String source, String target) {
        // your code goes here
        int n = source.length();
        int m = target.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i][m] = n - i;
        }
        for (int j = 0; j <= m; ++j) {
            dp[n][j] = m - j;
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (source.charAt(i) == target.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        LinkedList<String> result = new LinkedList<>();
        int startI = 0;
        int startJ = 0;
        while (result.size() != dp[0][0]) {
            if (startI >= n) {
                result.addLast("+" + target.charAt(startJ));
                startJ++;
                continue;
            }
            if (startJ >= m) {
                result.addLast("-" + source.charAt(startI));
                startI++;
                continue;
            }
            if (source.charAt(startI) == target.charAt(startJ)) {
                result.addLast(Character.toString(source.charAt(startI)));
                startI++;
                startJ++;
            } else if (dp[startI + 1][startJ] <= dp[startI][startJ + 1]) {
                result.addLast("-" + source.charAt(startI));
                startI++;
            } else {
                result.addLast("+" + target.charAt(startJ));
                startJ++;
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
