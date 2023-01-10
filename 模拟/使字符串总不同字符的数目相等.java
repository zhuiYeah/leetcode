package 模拟;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**两个字符串，仅互相交换一个字符后，两个字符串的所包含的字母种类数量相等
 * 例如 aaaaa == a == b
 * abcd == fjkhhhh = fjkh = zxcv = okmn
 * **/

//周赛第三题，分类谈论的情况比较复杂

//模拟 + 分类讨论
public class 使字符串总不同字符的数目相等 {
    public boolean isItPossible(String word1, String word2) {
        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < word1.length(); i++)
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        for (int i = 0; i < word2.length(); i++)
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);

        if (map1.size() == map2.size()) {
            //两个字符串字符有交集，那么 true
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                var c = entry.getKey();
                if (map2.containsKey(c)) return true;
            }
            //现在两个字符串没有重叠字符了
            //如果一个字符串不包含数量为1的字符，而另一个的字符数量全部为1，那么false
            return check(map1, map2);
        }
        if (Math.abs(map2.size() - map1.size()) >= 3) return false;

        Map<Character, Integer> more1;
        Map<Character, Integer> less1;
        if (map1.size() > map2.size()) {
            more1 = map1;
            less1 = map2;
        } else {
            more1 = map2;
            less1 = map1;
        }

        if (more1.size() - less1.size() == 1) return check2(more1, less1);
        if (more1.size() - less1.size() == 2) {
            var moreArr = new int[26];
            var lessArr = new int[26];
            for (Map.Entry<Character, Integer> entry : less1.entrySet())
                lessArr[entry.getKey() - 'a'] = entry.getValue();

            for (Map.Entry<Character, Integer> entry : more1.entrySet())
                moreArr[entry.getKey() - 'a'] = entry.getValue();

            for (int i = 0; i < 26; i++) {
                if (moreArr[i] == 1 && lessArr[i] == 0) {
                    moreArr[i]--;
                    lessArr[i]++;
                    for (int j = 0; j < 26; j++) {
                        if (lessArr[j] >= 2 && moreArr[j] != 0) return true;
                    }
                    moreArr[i]++;
                    lessArr[i]--;
                }
            }
        }

        return false;


    }

    //仅在 map1size == map2size 时调用
    private boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        boolean map1All1 = true;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (entry.getValue() != 1) {
                map1All1 = false;
                break;
            }
        }

        boolean map2All1 = true;
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (entry.getValue() != 1) {
                map2All1 = false;
                break;
            }
        }

        boolean map1NoContain1 = true;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1) {
                map1NoContain1 = false;
                break;
            }
        }

        boolean map2NoContain1 = true;
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == 1) {
                map2NoContain1 = false;
                break;
            }
        }

        if (map1NoContain1 && map2All1) return false;
        if (map2NoContain1 && map1All1) return false;
        return true;
    }


    private boolean check2(Map<Character, Integer> more, Map<Character, Integer> less) {
        boolean moreContainLessNoAndContain2 = false; //more和less 的未重叠部分，more 拥有两个及以上
        for (Map.Entry<Character, Integer> entry : more.entrySet()) {
            if (!less.containsKey(entry.getKey())) {
                if (entry.getValue() >= 2) {
                    moreContainLessNoAndContain2 = true;
                    break;
                }
            }
        }
        boolean lessContainMoreHaveAndContain2 = false; //more 和 less 的重叠部分，less拥有两个及以上
        for (Map.Entry<Character, Integer> entry : less.entrySet()) {
            if (more.containsKey(entry.getKey())) {
                if (entry.getValue() >= 2) {
                    lessContainMoreHaveAndContain2 = true;
                    break;
                }
            }
        }
        if (moreContainLessNoAndContain2 && lessContainMoreHaveAndContain2) return true;

//        boolean n1 = false; //more和less有重叠 且 重叠部分 more 仅包含一个
//        for (Map.Entry<Character, Integer> entry : more.entrySet()) {
//            if (less.containsKey(entry.getKey())) {
//                if (entry.getValue() == 1) {
//                    n1 = true;
//                    break;
//                }
//            }
//        }
//
//        boolean n2 = false; //more和less有重叠 且 重叠部分 less 包含2个及以上
//        for (Map.Entry<Character, Integer> entry : less.entrySet()) {
//            if (more.containsKey(entry.getKey())) {
//                if (entry.getValue() >= 2) {
//                    n2 = true;
//                    break;
//                }
//            }
//        }
//
//        if (n1 && n2) return true;
        var moreArr = new int[26];
        var lessArr = new int[26];
        for (Map.Entry<Character, Integer> entry : less.entrySet())
            lessArr[entry.getKey() - 'a'] = entry.getValue();

        for (Map.Entry<Character, Integer> entry : more.entrySet())
            moreArr[entry.getKey() - 'a'] = entry.getValue();
        for (int i = 0; i < moreArr.length; i++) {
            if (moreArr[i] == 1) {
                moreArr[i]--;
                if (lessArr[i] == 0) {
                    lessArr[i]++;
                    for (int j = 0; j < 26; j++) {
                        if (lessArr[j] == 1 && moreArr[j] != 0) return true;
                    }
                } else {
                    lessArr[i]++;
                    for (int j = 0; j < 26; j++) {
                        if (lessArr[j] >= 2 && moreArr[j] != 0) return true;
                    }
                }
                moreArr[i]++;
                lessArr[i]--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        var s1 = "wilfuzpxqserkdcvbgajtyhon";
        var c1 = s1.toCharArray();
        Arrays.sort(c1);
        System.out.println(c1);
        var s2 = "rlmyvwvucqxsjodbelmgjkabnxegihuwats";
        var c2 = s2.toCharArray();
        Arrays.sort(c2);
        System.out.println(c2);
    }
}



