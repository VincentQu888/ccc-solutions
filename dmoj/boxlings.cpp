#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>

const int MM = 300000;

int bit[MM+5];
struct box{int x1, y1, x2, y2;};
struct line{int x, y1, y2, type;};

void update(int idx, int val){
    for(int i = idx+1; i < MM+5; i += i & -i) bit[i] += val;
}

int query(int idx){
    int ans = 0;

    for(int i = idx+1; i > 0; i -= i & -i){
        ans += bit[i];
    }
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M; 
    cin >> N >> M;

    vector<line> boxes;
    vector<int> coords;
    unordered_map<int, int> compressed;
    box input[N+M];
    for(int i = 0; i < N; ++i){
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        y1 += 1e8, y2 += 1e8;

        input[i] = box{x1, y1, x2, y2};
        coords.push_back(y1); 
        coords.push_back(y2);
    }
    for(int i = N; i < N+M; ++i){
        int x, y;
        cin >> x >> y;
        y += 1e8;

        input[i] = box{x, y, 0, 0};
        coords.push_back(y); 
    }
    for(int i = 0; i < N; ++i){
        int x1 = input[i].x1, y1 = input[i].y1, x2 = input[i].x2, y2 = input[i].y2; 
        boxes.push_back(line{x1, y1, y2, 2}); //0 = removal, 1 = boxling, 2 = addition
        boxes.push_back(line{x2, y1, y2, 0});
    }
    for(int i = N; i < N+M; ++i){
        int x = input[i].x1, y = input[i].y1;
        boxes.push_back(line{x, y, y, 1});
    }


    sort(boxes.begin(), boxes.end(), [](line a, line b) {
        return a.x != b.x ? a.x < b.x : a.type > b.type; 
    });
    sort(coords.begin(), coords.end());
    for(int i = 0; i < coords.size(); ++i) compressed[coords[i]] = i;


    int ans = 0;
    for(line next : boxes){
        if(next.type == 0){
            update(compressed[next.y1], -1);
            update(compressed[next.y2]+1, 1);
        }else if(next.type == 2){
            update(compressed[next.y1], 1);
            update(compressed[next.y2]+1, -1);
        }else{
            ans += query(compressed[next.y1]) > 0 ? 1 : 0;
        }
    }
    cout << ans << "\n";
}