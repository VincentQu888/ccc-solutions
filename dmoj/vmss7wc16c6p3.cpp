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
bool vis[MM];
int num[MM], low[MM];
int cnt = 0;
bool ap[MM];

int tarjan(int prev, int cur){
    int children = 0;
    num[cur] = low[cur] = cnt;
    ++cnt;

    for(int next : adj[cur]){
        if(next == prev) continue;
        if(!vis[next]){
            ++children;
            vis[next] = true;
            tarjan(cur, next);
 
            if(num[cur] <= low[next]) ap[cur] = true;
            low[cur] = min(low[cur], low[next]);
        }else{
            low[cur] = min(low[cur], num[next]);
        }
    }

    return children;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;
    cin >> N >> M;

    for(int i = 0; i < M; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }


    for(int i = 0; i < N; ++i){
        if(!vis[i]){
            vis[i] = true;
            ap[i] = tarjan(i, i) > 1;
        }
    }


    int ans = 0;
    for(int next : ap) ans = next ? ans+1 : ans;

    cout << ans << "\n";
    for(int i = 0; i < MM; ++i){
        if(ap[i]) cout << i+1 << "\n";
    }
}