#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>

unordered_map<int, int> bit;
struct point{int x, y, path;};
int largest = 0;

void update(int idx, int val){
    for(int i = idx+1; i < largest+5; i += i & -i) bit[i] += val;
}

int query(int idx){
    int ans = 0;

    for(int i = idx+1; i > 0; i -= i & -i){
        if(bit.find(i) != bit.end()) ans += bit[i];
    }
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M; 
    cin >> N >> M;

    point points[N+M];
    pii input[N+M];
    for(int i = 0; i < N+M; ++i){
        int x, y;
        cin >> x >> y;

        input[i] = make_pair(x, y);
        largest = max(largest, y);
    }
    for(int i = 0; i < N; ++i){
        int x = input[i].first, y = input[i].second;
        
        points[i] = {x, y, 1};
        update(y, 1);
    }
    for(int i = N; i < N+M; ++i){
        int x = input[i].first, y = input[i].second;
        points[i] = {x, y, 0};
    }


    sort(points, points+N+M, [](point a, point b) {
        return a.x != b.x ? a.x < b.x : a.path < b.path; 
    });

    ll ans = 0;
    for(int i = 0; i < N+M; ++i){
        if(points[i].path == 0){
            ans += query(points[i].y);
        }else{
            update(points[i].y, -1);
        }
    }
    cout << ans << "\n";
}