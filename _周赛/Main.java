package _周赛;


import java.io.*;
import java.util.*;

public class Main {
//    public static void main(String args[]) throws Exception {
//        Scanner cin = new Scanner(System.in);
//        int a = cin.nextInt(), b = cin.nextInt();
//        System.out.println(a + b);
////
////        int a[] = new int[10];
////        int count = 0;
////        Scanner input = new Scanner(System.in);
////        for (int i = 0; i < 10; i++) {
////            a[i] = input.nextInt();
////        }
////        int b = input.nextInt();
////        for (int x : a) {
////            if (x <= (b + 30)) {
////                count++;
////            }
////        }
////        System.out.println(count);
////
//    }



}


class A {
    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int a = input.nextInt(), b = input.nextInt();
            if (b > 0) b = 1;
            else if (b < 0) b = -1;
            System.out.println(b * Math.abs(a));
        }
    }


}

class B {
    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt(), m = input.nextInt();
            int[] nums1 = new int[n], nums2 = new int[m];
            for (int i = 0; i < nums1.length; i++) nums1[i] = input.nextInt();
            for (int i = 0; i < nums2.length; i++) nums2[i] = input.nextInt();
            int ptr1 = n - 1, ptr2 = m - 1;
            int add = 2;
            int carry = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (ptr1 >= 0 || ptr2 >= 0) {
                if (ptr1 >= 0) carry += nums1[ptr1];
                if (ptr2 >= 0) carry += nums2[ptr2];
                list.add(0, carry % add);
                carry /= add;
                add++;
                ptr1--;
                ptr2--;
            }

            for (Integer integer : list) System.out.print(integer + " ");

        }
    }
}

class D {
    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt(), m = input.nextInt();
            m %= n;
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) nums[i] = input.nextInt();
            Arrays.sort(nums);
            int max = nums[nums.length - 1], min = nums[0];
            int res = max - min;

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (m > 0) {
                if (res == 0) break;
                //min -> max
                int a = res, b = res;
                Integer newmin = null, newmax = null;
                if (m >= map.get(min)) {
                    newmin = map.higherKey(min);
                    if (newmin == null) {
                        res = 0;
                        break;
                    }
                    a = max - newmin;
                }
                if (m >= map.get(max)) {
                    newmax = map.lowerKey(max);
                    if (newmax == null) {
                        res = 0;
                        break;
                    }
                    b = newmax - min;
                }
                if (a == res && b == res) break;

                if (m < map.get(min) && m < map.get(max)) break;
                if (a < b) {
                    map.put(max, map.get(max) + map.get(min));
                    m -= map.get(min);
                    map.remove(min);
                    min = newmin;
                    res = a;
                } else {
                    map.put(min, map.get(min) + map.get(max));
                    m -= map.get(max);
                    map.remove(max);
                    max = newmax;
                    res = b;
                }
            }

            System.out.println(res);

        }
    }
}