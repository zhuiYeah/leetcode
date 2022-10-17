package 蒸蒸简单;

import java.util.ArrayList;

public class 有效时间的数目 {
    public int countTime(String time) {
        int a = 1, b = 1, c = 1, d = 1;
        if (time.charAt(0) == '?' && time.charAt(1) != '?') {
            if (time.charAt(1) >= '4') {
                a = 2;
            } else {
                a = 3;
            }
        } else if (time.charAt(0) != '?' && time.charAt(1) == '?') {
            if (time.charAt(0) == '0' || time.charAt(0) == '1') {
                b = 10;
            } else if (time.charAt(0) == '2') {
                b = 4;
            }
        } else if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            b = 24;
        }

        char m1 = time.charAt(3), m2 = time.charAt(4);
        if (m1 == '?' && m2 == '?') {
            d = 60;
        } else if (m1 == '?' && m2 != '?') {
            c = 6;
        } else if (m1 != '?' && m2 == '?') {
            d = 10;
        }
        return a * b * c * d;
    }

//    public boolean isValid(String time) {
//        int hour = Integer.parseInt(time.substring(0, 2));
//        int minute = Integer.parseInt(time.substring(3));
//        if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) return true;
//        return false;
//    }
}
