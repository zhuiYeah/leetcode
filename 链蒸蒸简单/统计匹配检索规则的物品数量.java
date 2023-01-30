package 链蒸蒸简单;

import java.util.List;

public class 统计匹配检索规则的物品数量 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int j = -1;
        if (ruleKey.equals("type")) {
            j = 0;
        } else if (ruleKey.equals("color")) {
            j = 1;
        } else {
            j = 2;
        }
        int count = 0;
        for (List<String> item : items) {
            if (item.get(j).equals(ruleValue)) count++;
        }
        return count;
    }

}
