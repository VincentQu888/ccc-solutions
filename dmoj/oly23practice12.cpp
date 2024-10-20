#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x7fffffff
#define LINF LONG_LONG_MAX
const int MM = 1e5+5;
int N, M, K, idx[MM], vis[MM], cnt = 1;
vector<int> adj[MM];
stack<int> stk;
bool ans = true;
void cycle(int u){
    for(int v : adj[u]){
        if(vis[v]){
            ans = false;
            return;
        }else{
            vis[v] = 1;
            cycle(v);
        }
    }
    vis[u] = 0;
}
void dfs(int u){
    for(int v : adj[u]){
        if(!vis[v]){
            vis[v] = 1;
            dfs(v);
        }
    }
    stk.push(u);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M >> K;
    memset(vis, 0, sizeof(vis)); memset(idx, -1, sizeof(idx));
    for(int i = 0, a, b; i < M; ++i){
        cin >> a >> b;
        adj[a].push_back(b);
    }
    for(int i = 1; i <= N; ++i){
        vis[i] = 1; 
        cycle(i);
    }
    for(int i = 1; i <= N; ++i){
        vis[i] = 1; 
        dfs(i);
    }
    if(ans){
        cnt = 0;
        while(!stk.empty()){
            idx[stk.top()] = cnt;
            ++cnt;
            stk.pop();
        } 
        for(int i = 0, a, b; i < K; ++i){
            cin >> a >> b;
            if(idx[a] > idx[b]) cout << b << " " << a << endl;
            else cout << a << " " << b << endl;
        }
    }else cout << -1 << endl;
}