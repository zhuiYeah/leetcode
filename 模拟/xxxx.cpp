//
// Created by 爽 on 2023/4/26.
//

#include <bits/stdc++.h>
using namespace std;

struct DlinkedNode {
    int key;
    DlinkedNode *prev;
    DlinkedNode *next;
    DlinkedNode() : key(), prev(nullptr), next(nullptr) {}

    DlinkedNode(int _key) : key(_key), prev(nullptr), next(nullptr) {}
};
int mian(){
    int l,r;
    cin >> l >> r;
    int M ;
    cin >> M;
    unordered_map<int,DlinkedNode*> cache;
    DlinkedNode* tail = new DlinkedNode();
    DlinkedNode* head = new DlinkedNode();
    int size = 0;
    head->next=tail;
    tail->prev=head;
    for (int k = l ;k<=r;k++){
        DlinkedNode* node = new DlinkedNode(k);
        cache[k] = node;
        tail->prev->next = node;
        node->prev = tail->prev;
        tail->prev = node;
        node->next = tail;
        size++;
    }
    for (int i = 1;i<=M;i++){
        int type;
        cin>>type;
        if (type == 1){
            int nums ; cin>>nums;
            if (nums>size) continue;
            for (int j = 1;j<=nums;j++){
                cache.erase(head->next->key);
                head->next->next->prev = head;
                head->next=head->next->next;
                size--;
            }
        }else if (type == 2){
            int id;
            cin>>id;
            if (id < l || id >r || !cache.count(id)) continue;
            DlinkedNode* node = cache[id];
            cache.erase(id);
            node->prev->next = node->next;
            node->next->prev=node->prev;
            size--;
        } else if (type == 3){
            int id;
            cin>>id;
            if (id < l || id >r || !cache.count(id)) continue;
            DlinkedNode* node = new DlinkedNode(id);
            tail->prev->next = node;
            node->prev = tail->prev;
            tail->prev = node;
            node->next=tail;
            size++;
            cache[id] =node;
        }
    }
    cout<<head->next->key<<endl;
    return 0;
}



SELECT s.name , s.sid  SUM(sc.score) AS sum_score
From student s
INNER JOIN score sc ON s.sid = sc.sid
WHERE s.class = 'A'
GROUP BY s.sid
ORDER BY sum_score DESC
LIMIT 10