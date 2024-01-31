#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, W, D;
    cin >> N >> W >> D;

    vector<int> adj[N];
    int stations[N]; int train[N]; ll walk[N];

    for(int i = 0; i < W; ++i){
        int a, b;
        cin >> a >> b;
        --a; --b;

        adj[b].push_back(a);
    }

    for(int i = 0; i < N; ++i){
        int s; 
        cin >> s;
        --s;

        stations[i] = s;
        train[s] = i;
    }


    queue<int> queue;
    fill(walk, walk+N, inf);
    walk[N-1] = 0; queue.emplace(N-1);

    while(!queue.empty()){
        int cur = queue.front();
        queue.pop();

        for(int next : adj[cur]){
            if(walk[cur]+1 < walk[next]){
                walk[next] = walk[cur]+1;
                queue.emplace(next);
            }
        }
    }

    set<ll> dist; unordered_map<int, int> occurences;
    for(int i = 0; i < N; ++i){
        dist.emplace(train[i] + walk[i]);
        ++occurences[train[i] + walk[i]];
    }

    for(int i = 0; i < D; ++i){
        int x, y;
        cin >> x >> y;
        --x; --y;

        int s1 = stations[x], s2 = stations[y];
        swap(stations[x], stations[y]);

        --occurences[train[s1] + walk[s1]];
        --occurences[train[s2] + walk[s2]];
        if(occurences[train[s1] + walk[s1]] == 0) dist.erase(train[s1] + walk[s1]);
        if(occurences[train[s2] + walk[s2]] == 0) dist.erase(train[s2] + walk[s2]);

        swap(train[s1], train[s2]);
        dist.emplace(train[s1] + walk[s1]);
        dist.emplace(train[s2] + walk[s2]);
        ++occurences[train[s1] + walk[s1]];
        ++occurences[train[s2] + walk[s2]];

        cout << *dist.begin() << "\n";
    }
}