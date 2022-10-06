package 模拟;

import java.util.HashSet;

public class 快乐数 {
    public boolean isHappy(int n) {
        var seen = new HashSet<>();
        seen.add(n);
        int num = 0;
        while(true){
             num = 0;
            while(n>0){
                num += (n%10)*(n%10);
                n/=10;
            }
            if (num == 1) return true;
            if (seen.contains(num)){
                return false;
            }else{
                seen.add(num);
            }
            n=num;
        }
    }
}
