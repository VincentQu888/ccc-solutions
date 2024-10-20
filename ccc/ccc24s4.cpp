#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const int MM = 2e5+5;
int N, M, ans[MM], vis[MM];
vector<pii> adj[MM];
void dfs(int u, int prev){
    for(pii v : adj[u]){
        if(!vis[v.first]){
            ans[v.second] = !prev;
            vis[v.first] = 1;
            dfs(v.first, !prev);
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    fill(ans, ans+MM, -1); memset(vis, 0, sizeof(vis));
    for(int i = 0, a, b; i < M; ++i){
        cin >> a >> b;
        adj[a].push_back({b, i}); adj[b].push_back({a, i});
    }
    for(int i = 1; i <= N; ++i){
        if(!vis[i]){vis[i] = 1; dfs(i, 1);}
    }
    for(int i = 0; i < M; ++i){
        if(ans[i] == 0) cout << "R";
        else if(ans[i] == 1) cout << "B";
        else cout << "G";
    }
}