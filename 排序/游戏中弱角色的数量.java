package 排序;

import java.util.ArrayList;
import java.util.Arrays;

//java手写多级排序
public class 游戏中弱角色的数量 {
    int res = 0;
    int maximum_defense = 0;

    public int numberOfWeakCharacters(int[][] properties) {
        mergeSort(properties, 0, properties.length - 1);
        for (int i = 0; i < properties.length; i++) {
            maximum_defense = Math.max(maximum_defense, properties[i][1]);
            if (properties[i][1] < maximum_defense) {
                res++;
            }

        }
        return res;
    }

    public void mergeSort(int[][] properties, int start, int end) {//按照攻击力降序排序,攻击力相同的情况下按照防御力升序排序
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(properties, start, mid);
        mergeSort(properties, mid + 1, end);
        int i = start;
        int j = mid + 1;
        ArrayList<int[]> tmp = new ArrayList<>();
        while (i <= mid && j <= end) {
            if (properties[i][0] > properties[j][0]) {
                tmp.add(properties[i]);
                i++;
            } else if (properties[i][0] < properties[j][0]) {
                tmp.add(properties[j]);
                j++;
            } else {
                if (properties[i][1] < properties[j][1]) {
                    tmp.add(properties[i]);
                    i++;
                } else {
                    tmp.add(properties[j]);
                    j++;
                }
            }
        }
        if (i <= mid) {
            mergeSort(properties, i, mid);
            while (i <= mid) {
                tmp.add(properties[i]);
                i++;
            }
        }
        if (j <= end) {
            mergeSort(properties, j, end);
            while (j <= end) {
                tmp.add(properties[j]);
                j++;
            }
        }
        for (int k = start; k <= end; k++) {
            properties[k] = tmp.get(k - start);
        }
    }

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//利用库函数多级排序
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            //攻击力相同的按照守备力升序排序
            //攻击力不同的按照攻击力降序排序
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        });
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }
}