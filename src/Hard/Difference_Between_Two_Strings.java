package Hard;
import java.util.*;
/*
Given two strings of uppercase letters source and target, list (in string form) a sequence of edits to convert from source to target that uses the least edits possible.

For example, with strings source = "ABCDEFG", and target = "ABDFFGH" we might return: ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"

More formally, for each character C in source, we will either write the token C, which does not count as an edit; or write the token -C, which counts as an edit.

Additionally, between any token that we write, we may write +D where D is any letter, which counts as an edit.

At the end, when reading the tokens from left to right, and not including tokens prefixed with a minus-sign, the letters should spell out target (when ignoring plus-signs.)

In the example, the answer of A B -C D -E F +F G +H has total number of edits 4 (the minimum possible), and ignoring subtraction-tokens, spells out A, B, D, F, +F, G, +H which represents the string target.

If there are multiple answers, use the answer that favors removing from the source first.

Constraints:

[time limit] 5000ms
[input] string source
2 ≤ source.length ≤ 12
[input] string target
2 ≤ target.length ≤ 12
[output] array.string
 */
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
