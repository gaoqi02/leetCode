package com.leet.code.字符串;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 中心扩展算法为啥有2n-1个中心是要考虑奇偶两种情况，也就是这个回文可能是以一个字符为中心，也可能这个回文以两个字符为中心，如abba，它就是以bb为中心，下面代码的原因就是把两种情况都进行一次判断，为啥，还是以abba为情况，当i处于第一个b的下标时候，也就是以这个b为中心，len1结果为1，当执行len2那行代码时候就是以bb为中心了(你看参数i跟i+1)，此时len2长度就为4，答案就出来了
 *
 * @author gaoqi
 * @date 2019/5/31.
 */
public class 回文子字符串 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        String s = "ahsjfkfjsqq";
        System.out.println(longestPalindrome(s));
    }
}
