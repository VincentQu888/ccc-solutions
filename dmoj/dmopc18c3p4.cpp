#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 2e5+5;
vector<pii> adj[MM];
int cnt[MM], sz[MM];
ll ans = 0;

void getsz(int cur, int prev){
    sz[cur] = cnt[cur];
    for(pii nxt : adj[cur]){
        if(nxt.first != prev){
            getsz(nxt.first, cur);
            sz[cur] += sz[nxt.first];
        }
    }
}

int getcentroid(int cur, int prev, int tot){
    for(pii nxt : adj[cur]){
        if(nxt.first != prev && sz[nxt.first]*2 > tot) return getcentroid(nxt.first, cur, tot);
    }
    return cur;
}

void dfs(int cur, int prev, int dist){
    ans += (ll) cnt[cur]*dist;
    for(pii nxt : adj[cur]){
        if(nxt.first != prev) dfs(nxt.first, cur, dist+nxt.second);
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int K, N;
    cin >> K >> N;

    for(int i = 0, z; i < K; ++i){
        cin >> z; ++cnt[z];
    }

    for(int i = 0, u, v, w; i < N-1; ++i){
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }

    getsz(1, -1);
    int centroid = getcentroid(1, -1, K);
    dfs(centroid, -1, 0);
    cout << ans << "\n";
}