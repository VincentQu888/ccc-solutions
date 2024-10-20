#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 2e5+5;
vector<int> adj[MM];
int col[MM], b[MM], w[MM];
bool vis[MM];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    ll N; string colours;
    cin >> N >> colours;

    for(int i = 0; i < N; ++i){
        col[i] = colours[i];
    }
    for(int i = 0; i < N-1; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }


    ll bad = 0;
    fill(b, b+MM, 0); fill(w, w+MM, 0);
    for(int i = 0; i < N; ++i){
        for(int next : adj[i]){
            if(col[next] == 'B') ++b[i];
            else ++w[i];
        }
        
        if(adj[i].size() >= 2){
            if(col[i] == 'B') bad += b[i] * w[i] + w[i]*(w[i]-1)/2;
            else bad += b[i] * w[i] + b[i]*(b[i]-1)/2;
        }
    }

    for(int u = 0; u < N; ++u){
        if(adj[u].size() <= 1) continue;
        vis[u] = true;

        for(int v : adj[u]){
            if(vis[v]) continue;
            if(adj[v].size() <= 1) continue;
            int bsum = col[u] == 'B' ? 1 : 0, wsum = col[u] == 'W' ? 1 : 0;

            bsum = col[v] == 'B' ? bsum+1 : bsum;
            wsum = col[v] == 'W' ? wsum+1 : wsum;

            bsum += b[u] - (col[v] == 'B' ? 1 : 0);
            wsum += w[u] - (col[v] == 'W' ? 1 : 0);
            bsum += b[v] - (col[u] == 'B' ? 1 : 0);
            wsum += w[v] - (col[u] == 'W' ? 1 : 0);
            if(!(bsum >= 3 || wsum >= 3)) ++bad;
        }
    }

    cout << N*(N-1)/2 - (N-1) - bad << "\n";
}