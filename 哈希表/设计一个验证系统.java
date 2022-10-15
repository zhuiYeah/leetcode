package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class 设计一个验证系统 {

}

class AuthenticationManager {
    int timeToLive;
    Map<String, Integer> map = new HashMap<String, Integer>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        int oldTime = map.getOrDefault(tokenId, 0);
        if (oldTime == 0) return;
        if (currentTime - oldTime >= timeToLive) {
            map.remove(tokenId);
            return;
        }
        map.put(tokenId, currentTime);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (currentTime - entry.getValue() < timeToLive) count++;
        }
        return count;
    }
}
