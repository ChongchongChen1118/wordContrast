package com.word.luoji.tiqu;

public class Duibixiangsidu {

    /**
     * 余弦相似度
     * @param str1
     * @param str2
     * @return
     */

    public static double cosineSimilarity(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[len1][len2];
        double similarity = (double) lcs / Math.max(len1, len2);
        return similarity;
    }
    }
