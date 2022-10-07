package 蒸蒸简单;

import java.util.HashMap;
import java.util.Map;

public class 能否连接形成数组 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        var ptr = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        while (ptr < arr.length) {
            int index = map.getOrDefault(arr[ptr], -1);
            if (index == -1) return false;
            for (int i = 0; i < pieces[index].length; i++) {
                if (pieces[index][i] == arr[ptr]) {
                    ptr++;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    }
}

