package 数组;

import java.util.ArrayList;
import java.util.List;

public class 设计有序流 {
}

class OrderedStream {
    String[] stream;
    int ptr;
    public OrderedStream(int n) {
        stream = new String[n+1];
        ptr = 1;
    }
    public List<String> insert(int idKey, String value) {//类的方法
        List<String> res =new ArrayList<String>();
        stream[idKey] = value;
        while(ptr<stream.length && stream[ptr]!=null) {
            res.add(stream[ptr]);
            ptr++;
        }
        return res;
    }
}