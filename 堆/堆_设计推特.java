package 堆;

import java.util.*;

//在高铁上设计twitter ，乐了
//要充分考虑空指针异常即哈希表get不到的情况
//getOrDefault
public class 堆_设计推特 {
    class Twitter {
        //映射 用户ID -》 用户发布的所有twitterId
        Map<Integer, ArrayList<Integer>> userTwitter = new HashMap<Integer, ArrayList<Integer>>();
        //映射twitterId -》 该条twitter的发送时间
        Map<Integer, Integer> twitterPriority = new HashMap<Integer, Integer>();
        //映射 用户id -》该用户关注的所有用户id
        Map<Integer, ArrayList<Integer>> followed = new HashMap<Integer, ArrayList<Integer>>();
        int time;

        public Twitter() {
        }

        public void postTweet(int userId, int tweetId) {
            var myTwitter = this.userTwitter.getOrDefault(userId, new ArrayList<Integer>());
            myTwitter.add(tweetId);
            userTwitter.put(userId, myTwitter);
            twitterPriority.put(tweetId, time);
            time++;
        }

        public List<Integer> getNewsFeed(int userId) {
            //获得前10个最新发送（time最大） 的twitter， 小顶堆
            var pq = new PriorityQueue<Integer>((a, b) -> {
                return twitterPriority.get(a) - twitterPriority.get(b);
            });
            var myTwitter = userTwitter.getOrDefault(userId, new ArrayList<>());
            for (int i = 0; i < myTwitter.size(); i++) {
                int tid = myTwitter.get(i);
                if (pq.size() < 10) {
                    pq.add(tid);
                } else {
                    if (twitterPriority.get(tid) > twitterPriority.get(pq.peek())) {
                        pq.poll();
                        pq.add(tid);
                    }
                }
            }

            var myFollowed = followed.getOrDefault(userId, new ArrayList<>());
            for (int i = 0; i < myFollowed.size(); i++) {
                int uid = myFollowed.get(i);
                var hisTwitter = userTwitter.getOrDefault(uid, new ArrayList<>());
                for (int j = 0; j < hisTwitter.size(); j++) {
                    int tid = hisTwitter.get(j);
                    if (pq.size() < 10) {
                        pq.add(tid);
                    } else {
                        if (twitterPriority.get(tid) > twitterPriority.get(pq.peek())) {
                            pq.poll();
                            pq.add(tid);
                        }
                    }
                }
            }
            List<Integer> res = new ArrayList<Integer>();
            while (!pq.isEmpty()) {
                res.add(0, pq.poll());
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            var user = followed.getOrDefault(followerId, new ArrayList<>());
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i) == followeeId) {
                    return;
                }
            }
            user.add(followeeId);
            followed.put(followerId, user);
        }

        public void unfollow(int followerId, int followeeId) {
            var user = followed.getOrDefault(followerId, new ArrayList<>());
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i) == followeeId) {
                    user.remove(i);
                    break;
                }
            }
            followed.put(followerId, user);
        }
    }
}
