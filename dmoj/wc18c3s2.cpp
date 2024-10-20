#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e5+5;
vector<int> adj[MM];
set<int> gyms, removed;
int step[MM];
int path = 0;

bool dfs(int cur){
    bool ans = gyms.count(cur);
    for(int next : adj[cur]){
        if(step[cur]+1 < step[next]){
            step[next] = step[cur]+1;
            if(dfs(next)){
                ans = true;
                path += 2;
            }
        }
    }

    if(!ans) removed.emplace(cur);
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, K, F;
    cin >> N >> K >> F;

    for(int i = 0; i < K; ++i){
        int gym; cin >> gym;
        gyms.emplace(gym-1);
    }

    for(int i = 0; i < N-1; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }


    fill(step, step+MM, inf); step[0] = 0; 
    dfs(0);
    
    int longest = 0;
    for(int i = 0; i < N; ++i) if(step[i] != inf && gyms.count(i)) longest = max(longest, step[i]);
    int dragoniteless = path - longest;

    removed.clear(); gyms.emplace(F-1); 
    fill(step, step+MM, inf); step[0] = 0; 
    dfs(0);

    cout << min(dragoniteless, (int)(N - removed.size() - 1)) << "\n";
}