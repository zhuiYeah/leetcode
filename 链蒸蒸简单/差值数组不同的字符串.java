package 链蒸蒸简单;

public class 差值数组不同的字符串 {
    public String oddString(String[] words) {
        var arr1 = toarr(words[0]);
        var arr2 = toarr(words[1]);
        var arr3 = toarr(words[2]);
        int[] me = arr1;
        if (isEqual(arr1, arr2) && isEqual(arr1, arr3)) {
            me = arr1;
        } else if (isEqual(arr1, arr2) && !isEqual(arr1, arr3)) {
            return words[2];
        } else if (isEqual(arr1, arr3) && !isEqual(arr1, arr2)) {
            return words[1];
        } else if (isEqual(arr2, arr3) && !isEqual(arr2, arr1)) {
            return words[0];
        }
        for (int i = 3; i < words.length; i++) {
            var now = toarr(words[i]);
            if (!isEqual(now, me)) return words[i];
        }
        return "";
    }

    public boolean isEqual(int[] nums1, int[] nums2) {
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) return false;
        }
        return true;
    }

    public int[] toarr(String s) {
        int n = s.length();
        int[] arr = new int[n - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i + 1) - s.charAt(i);
        }
        return arr;
    }
}
