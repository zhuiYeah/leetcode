package 贪心;

//这题真把我写傻了
public class _____构造字典序最大的合并字符串 {
    public String largestMerge(String word1, String word2) {
        int m = word1.length(), n = word2.length(), start1 = 0, start2 = 0;
        var res = new StringBuilder();
        int i = 0, j = 0;
        //boolean flag = false;
        while (i < m || j < n) {
            while (i < m && j < n && word1.charAt(i) == word2.charAt(j)) {
                //flag = false;
//                if (i != m - 1 && j != n - 1) {
//                    if (word1.charAt(i) >word1.charAt(i+1) && word2.charAt(j) >word2.charAt(j+1)) {
//                        res.append(word1, start1, i+1);
//                        start1 = ++i;
//                        res.append(word2, start2, j+1);
//                        start2= ++j;
//                        flag = true;
//                        break;
//                    }
//                }
                i++;
                j++;
            }
            //if (flag) continue;
            if (i == m && j == n) {
                res.append(word1.substring(start1));
                res.append(word2.substring(start2));
                break;
            }
            if (i == m) {
                while (j < n && word2.charAt(j) == word1.charAt(i - 1)) {
                    j++;
                }
                if (j == n) {
                    res.append(word1.substring(start1));
                    res.append(word2.substring(start2));
                    break;
                }
                if (word2.charAt(j) < word1.charAt(i - 1)) {
                    res.append(word1.substring(start1));
                    res.append(word2.substring(start2));
                    break;
                }
                if (word2.charAt(j) > word1.charAt(i - 1)) {
                    res.append(word2, start2, j + 1);
                    j++;
                    start2 = j;
                    i = start1;
                    continue;
                }
            }
            if (j == n) {
                while (i < m && word1.charAt(i) == word2.charAt(j - 1)) {
                    i++;
                }
                if (i == m) {
                    res.append(word1.substring(start1));
                    res.append(word2.substring(start2));
                    break;
                }
                if (word1.charAt(i) < word2.charAt(j - 1)) {
                    res.append(word2.substring(start2));
                    res.append(word1.substring(start1));
                    break;
                }
                if (word1.charAt(i) > word2.charAt(j - 1)) {
                    res.append(word1, start1, i + 1);
                    i++;
                    start1 = i;
                    j = start2;
                    continue;
                }
            }

            if (word2.charAt(j) > word1.charAt(i)) {
                j++;
                res.append(word2, start2, j);
                start2 = j;
                i = start1;
                continue;
            }
            if (word1.charAt(i) > word2.charAt(j)) {
                i++;
                res.append(word1, start1, i);
                start1 = i;
                j = start2;
            }
        }
        return res.toString();
    }
}

class test {
    public static void main(String[] args) {
        new Solution().largestMerge("cabaa", "bcaaa");
    }
}


class dewdwedew {
    public String largestMerge(String word1, String word2) {
        var res = new StringBuilder();
        while (true) {
            if (word1.length() == 0 || word2.length() == 0) break;
            if (word1.charAt(0) > word2.charAt(0)) {
                res.append(word1.charAt(0));
                word1 = word1.substring(1);
                continue;
            }
            if (word2.charAt(0) > word1.charAt(0)) {
                res.append(word2.charAt(0));
                word2 = word2.substring(1);
                continue;
            }
            int c = word1.charAt(0);
            int i = 0, j = 0;
            while (i < word1.length() && j < word2.length() && word1.charAt(i) == c && word2.charAt(j) == c) {
                i++;
                j++;
            }
            if (i == word1.length() && j == word2.length()) {
                res.append(word1);
                res.append(word2);
                word1 = "";
                word2 = "";
                break;
            }
            if (i == word1.length()) {
                while (j < word2.length() && word2.charAt(j) == c) j++;
                if (j == word2.length()) {
                    res.append(word1);
                    res.append(word2);
                    word1 = "";
                    word2 = "";
                    break;
                }
                if (word2.charAt(j) > c) {
                    res.append(word2.substring(0, j + 1));
                    word2 = word2.substring(j + 1);
                    continue;
                }
                if (word2.charAt(j) < c) {
                    res.append(word1);
                    res.append(word2);
                    word1 = "";
                    word2 = "";
                    break;
                }
            }
            if (j == word2.length()) {
                while (i < word1.length() && word1.charAt(i) == c) i++;
                if (i == word1.length()) {
                    res.append(word1);
                    res.append(word2);
                    word1 = "";
                    word2 = "";
                    break;
                }
                if (word1.charAt(i) > c) {
                    res.append(word1.substring(0, i + 1));
                    word1 = word1.substring(i + 1);
                    continue;
                }
                if (word1.charAt(i) < c) {
                    res.append(word1);
                    res.append(word2);
                    word1 = "";
                    word2 = "";
                    break;
                }
            }
            if (word1.charAt(i) > c &&word1.charAt(i)>word2.charAt(j)) {
                res.append(word1.substring(0,i+1));
                word1 = word1.substring(i+1);
                continue;
            }
            if (word2.charAt(j) > c &&word2.charAt(j)>word1.charAt(i)) {
                res.append(word2.substring(0,j+1));
                word2 = word2.substring(j+1);
                continue;
            }
            res.append(word1.substring(0, i));
            res.append(word2.substring(0, j));
            word1 = word1.substring(i);
            word2 = word2.substring(j);
        }

        if (word1.length() == 0)  res.append(word2);
        if (word2.length() == 0)  res.append(word1);

        return res.toString();
    }
}



//以上全是错的 ，写傻了 ，写了一个多小时的时间全错

class Solution {
    public String largestMerge(String word1, String word2) {
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        int n1 = chars1.length, n2 = chars2.length, idx1 = 0, idx2 = 0;
        StringBuilder sb = new StringBuilder();
        String temp1 = null, temp2 = null;
        while(idx1 < n1 && idx2 < n2) {
            temp1 = word1.substring(idx1, n1);
            temp2 = word2.substring(idx2, n2);
            // 比较字母序
            if(temp1.compareTo(temp2) > 0) {
                sb.append(chars1[idx1++]);
            }else {
                sb.append(chars2[idx2++]);
            }
        }
        while(idx1 < n1) {
            sb.append(chars1[idx1++]);
        }
        while(idx2 < n2) {
            sb.append(chars2[idx2++]);
        }
        return sb.toString();
    }
}
