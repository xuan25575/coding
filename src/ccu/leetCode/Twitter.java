package ccu.leetCode;

import java.util.*;

/**
 * @Author huang_2
 * @Date 2020/4/13 2:03 下午
 * @Description leetcode 355
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，
 * 能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
 * 推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 *
 */
public class Twitter {

    // 用户 id 和推文（单链表）的对应关系
    private Map<Integer,Tweet> tweetMap;

    //  用户 id 和他关注的用户列表的对应关系
    private Map<Integer, Set<Integer>> follows;

    //全局使用的时间戳字段，用户每发布一条推文之前 + 1
    private static int timestamp = 0;

    // 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
    private static PriorityQueue<Tweet> maxHeap;




    /** Initialize your data structure here. */
    public Twitter() {
        tweetMap = new HashMap<>();
        follows = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1,o2)->o2.timeStamp-o1.timeStamp);

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if(tweetMap.containsKey(userId)){
            Tweet oldHead = tweetMap.get(userId);
            Tweet newHead = new Tweet(tweetId,timestamp);
            newHead.next = oldHead;
            tweetMap.put(userId,newHead);
        }else{
            tweetMap.put(userId,new Tweet(tweetId,timestamp));
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // 由于是全局使用的，使用之前需要清kong
        maxHeap.clear();

      // 如果自己发了推文也要算上
        if(tweetMap.containsKey(userId)){
            maxHeap.offer(tweetMap.get(userId));
        }

        // 关注列表
        Set<Integer> followerList = follows.get(userId);
        if(followerList!= null && followerList.size()>0){
            for (Integer followerId : followerList) {
                Tweet tweet = tweetMap.get(followerId);
                if(tweet != null){
                    maxHeap.offer(tweet);
                }
            }
        }
        // 返回结果
        List<Integer> list = new ArrayList<>(10);
        int count =0;
        while(!maxHeap.isEmpty() && count < 10){
            Tweet head = maxHeap.poll();
            list.add(head.id);
            if(head.next != null){
                maxHeap.offer(head.next);
            }
            count++;
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

       if(followeeId == followerId){
          return;
        }
        Set<Integer> set = follows.get(followerId);
        if(set == null){
            set = new HashSet<>();
            set.add(followeeId);
            follows.put(followerId,set);
        }else{
            if(set.contains(followeeId)) return;
            set.add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId == followerId){
            return;
        }
        Set<Integer> set = follows.get(followerId);
        if(set == null){
            return;
        }
        set.remove(followeeId);
    }

    class Tweet{

        // 推特id
        private int id;

        private int timeStamp;

        private Tweet next;

        public Tweet(int id, int timeStamp) {
            this.id = id;
            this.timeStamp = timeStamp;
        }
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);
    }
}


