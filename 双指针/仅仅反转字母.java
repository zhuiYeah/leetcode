package 双指针;



import static java.lang.Character.isLetter;

public class 仅仅反转字母 {
    public String reverseOnlyLetters(String s) {
        byte[] b = s.getBytes();
        int left = 0, right = b.length - 1;
        while (left < right) {
            while (left < right && !isLetter(b[left])) left++;
            while (left < right && !isLetter(b[right])) right--;
            if (left < right) {
                byte tmp = b[left];
                b[left] = b[right];
                b[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(b);
    }
}
