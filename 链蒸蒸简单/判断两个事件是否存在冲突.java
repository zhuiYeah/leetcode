package 链蒸蒸简单;

//316场周赛
public class 判断两个事件是否存在冲突 {
    public boolean haveConflict(String[] event1, String[] event2) {
        String start1;
        String start2;
        String end1;
        String end2;
        if (bijiao(event1[0], event2[0])){
            start1 = event1[0];
            end1 = event1[1];
            start2 = event2[0];
            end2 = event2[1];
        }else{
            start1 = event2[0];
            end1 = event2[1];
            start2 = event1[0];
            end2 = event1[1];
        }
        return !bijiao(end1, start2);
    }

    //time1是否是较小的时间(严格小于)
    public boolean bijiao(String time1, String time2) {
        var h1 = Integer.parseInt(time1.substring(0, 2));
        var h2 = Integer.parseInt(time2.substring(0, 2));
        var min1 = Integer.parseInt(time1.substring(3));
        var min2 = Integer.parseInt(time2.substring(3));
        if (h1 < h2){
            return true;
        }else if (h1 > h2){
            return false;
        }else{
            if (min1 < min2){
                return true;
            }else if (min1>min2){
                return false;
            }else{
                return false;
            }
        }
    }
}
