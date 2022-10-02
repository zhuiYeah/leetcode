package 太简单了没意思;

//88场双周赛 秒杀
public class 最长上传前缀 {

}

class LUPrefix {
    boolean[] videoLoad;
    int ptr = 0;

    public LUPrefix(int n) {
        videoLoad = new boolean[n + 1];
    }

    public void upload(int video) {
        videoLoad[video] = true;
        while (ptr + 1 < videoLoad.length && videoLoad[ptr + 1]) {
            ptr++;
        }
    }

    public int longest() {
        return ptr;
    }
}
