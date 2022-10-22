package 递归;

//超时
public class 第k个语法符号 {
    public int kthGrammar(int n, int k) {
        return f(n).toString().charAt(k - 1) - '0';
    }

    public static StringBuilder f(int n) {
        if (n == 1) return new StringBuilder("0");
        var s = f(n - 1);
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) == '0') {
                s.insert(i + 1, '1');
            } else {
                s.insert(i + 1, '0');
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(f(4).toString());
        System.out.println(f(5).toString());
        System.out.println(f(6).toString());
        System.out.println(f(7).toString());
    }
}


//超出内存限制
class dewd {
    public int kthGrammar(int n, int k) {
        return f(n).charAt(k - 1) - '0';
    }

    public String f(int n) {
        if (n == 1) return "0";
        var s = f(n - 1);
        return s + reverse(s);
    }

    public String reverse(String s) {
        var c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            c[i] = (char) ('1' - c[i] + '0');
        }
        return new String(c);
    }
}


//发现结果其实仅与k有关  数学
//将k移动到0～8之间
class dexsw {
    public static int kthGrammar(int n, int k) {
        String s = "01101001";


        int reverseCount = 0;
        while (k > 8) {
            for (n = 1; n <= 30; n++) {
                if (Math.pow(2, n) >= k) break;
            }
            int mid = (int) Math.pow(2, n - 1);
            k = k - mid;
            reverseCount++;
        }
        if (reverseCount % 2 == 0) return s.charAt(k - 1) - '0';
        return '1' - s.charAt(k - 1);
    }
    public static void main(String[] args) {
       var x=  kthGrammar(30,434991989);
       System.out.println(x);
    }
}
