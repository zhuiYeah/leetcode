package 模拟;

//给定一个非常长的只包含0，1的arr ， 能否将这个arr分成三个相同的二进制数字（可以包含前导0），给出分割方法

//二进制数字也越界（java的二进制数应该是有长度限制的）
//long都不够存储的，不能使用长整数来记录三个数字了
//以下long越界了
public class 三等分 {
    public static int[] threeEqualParts(int[] arr) {
        int one = 0;
        for (int i : arr) {
            if (i == 1) one++;
        }
        if (one % 3 != 0) return new int[]{-1, -1};
        one /= 3;
        //one表示每一段中1必须出现的个数
        if (one == 0) return new int[]{0, 2};
        //count用来记录最后一段中1的个数,下面得到num3的值
        int count = 0;
        int j = 0;
        long num3 = 0;
        int wei = 0;
        for (j = arr.length - 1; j >= 0; j--) {
            if (arr[j] == 1) num3 += (long) Math.pow(2, wei);
            count += arr[j];
            wei++;
            if (count == one) break;
        }
        //得到第一段数字的值,count现在用来记录第一段中1的个数
        int i = 0;
        count = 0;
        long num1 = 0;
        for (; i < j; i++) {
            count += arr[i];
            num1 = num1 * 2 + (long) arr[i];
            if (count == one) break;

        }
        if (num1 > num3) {
            return new int[]{-1, -1};
        } else if (num1 < num3) {
            while (num1 < num3 && arr[i + 1] == 0 && i < j) {
                i++;
                num1 *= 2;
            }
        }
        if (num1 != num3) return new int[]{-1, -1};
        //得到第二段数字的值
        long num2 = 0;
        for (int k = i + 1; k < j; k++) {
            num2 = num2 * 2 + (long) arr[k];
            if (num2 == num3) {
                j = k + 1;
                break;
            }
            if (num2 > num3) return new int[]{-1, -1};
        }
        if (num2 != num3) return new int[]{-1, -1};
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0};
        threeEqualParts(nums);
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solutionxxx {
    public static int[] threeEqualParts(int[] arr) {
        int one = 0;
        for (int i : arr) {
            if (i == 1) one++;
        }
        if (one % 3 != 0) return new int[]{-1, -1};
        one /= 3;
        //one表示每一段中1的个数
        if (one == 0) return new int[]{0, 2};
        //count用来记录最后一段中1的个数，
        // 得到num3
        int count = 0;
        int j = 0;
        var num3SB = new StringBuilder();
        for (j = arr.length - 1; j >= 0; j--) {
            num3SB.insert(0, arr[j]);
            count += arr[j];
            if (count == one) break;
        }
        var num3 = num3SB.toString();
        //得到num1
        int i = 0;
        count = 0;
        var num1SB = new StringBuilder();
        for (; i < j; i++) {
            count += arr[i];
            num1SB.append(arr[i]);
            if (count == one) break;
        }
        var num1 = num1SB.toString();
        num1 = num1.replaceFirst("^0*", "");
        if (num1.length() > num3.length()) {
            return new int[]{-1, -1};
        } else {
            while (num1.length() < num3.length() && arr[i + 1] == 0 && i < j) {
                i++;
                num1 += arr[i];
            }
        }
        if (!num1.equals(num3)) return new int[]{-1, -1};
        //得到第二段数字的值
        String num2 = new String();
        boolean oneAppear = false;
        for (int k = i + 1; k < j; k++) {
            if (arr[k] == 0) {
                if (oneAppear) num2 += '0';
            } else {
                num2 += '1';
                oneAppear = true;
            }
            if (num2.equals(num3)) {
                j = k + 1;
                break;
            }
            if (num2.length() > num3.length()) return new int[]{-1, -1};
        }
        if (!num2.equals(num3)) return new int[]{-1, -1};
        return new int[]{i, j};
    }
}
