package 回溯;

import java.util.ArrayList;
import java.util.List;

//超暴力回溯
public class 模糊坐标 {
    List<String> res = new ArrayList<String>();
    StringBuilder S;
    boolean hasdouhao;
    int restdian;

    public List<String> ambiguousCoordinates(String s) {
        S = new StringBuilder(s.substring(1, s.length() - 1));
        hasdouhao = true;
        restdian = 2;
        backtracking(1);
        return res;
    }


    public void backtracking(int index) {
        //剪枝
        if (restdian == 0 && hasdouhao) return;
        if (index == S.length()) {
            String[] xx = S.toString().split(",");
            if (xx.length == 1) return;
            if (isValid(xx[0]) && isValid(xx[1])) {
                res.add(new String('(' + xx[0] + ", " + xx[1] + ')'));
            }
            return;
        }

        //不插入逗号且不放点
        backtracking(index + 1);
        //插入逗号
        if (hasdouhao) {
            hasdouhao = false;
            S.insert(index, ',');
            backtracking(index + 2);
            S.deleteCharAt(index);
            hasdouhao = true;
        }
        //放点
        if (restdian != 0) {
            restdian--;
            S.insert(index, '.');
            backtracking(index + 2);
            S.deleteCharAt(index);
            restdian++;
        }
    }

    //判断一个数字字符串是否有效
    public boolean isValid(String s) {
        String[] xx = s.split("\\.");
        if (xx.length == 3) return false;
        if (xx.length == 1) {
            if (xx[0].length() == 1) {
                return true;
            } else {
                return xx[0].charAt(0) != '0';
            }
        }
        if (xx[0].length() != 1 && xx[0].charAt(0) == '0') return false;
        return xx[1].charAt(xx[1].length() - 1) != '0';
    }

    public static void main(String[] args) {
        //ambiguousCoordinates("(0123)");
    }
}

