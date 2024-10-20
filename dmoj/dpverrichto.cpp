#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define any_black first
#define all_white second
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e5+5;
vector<int> adj[MM], children[MM]; 
vector<pii> ch[MM], pre[MM], suf[MM];
pii down[MM], up[MM];
int M;

void dfs1(int cur, int prev){
    down[cur] = {0, 1};

    for(int nxt : adj[cur]){
        if(nxt != prev){
            children[cur].push_back(nxt);
            dfs1(nxt, cur);
            down[cur].any_black = down[cur].any_black * (down[nxt].any_black + down[nxt].all_white) + (down[cur].all_white * down[nxt].any_black);
            down[cur].all_white *= down[nxt].all_white;
            ch[cur].push_back(down[nxt]);
        }
    }

    down[cur].any_black = down[cur].any_black + down[cur].all_white;
}

void dfs2(int cur, int prev){
    for(int i = 0; i < children[cur].size(); ++i){
        pii p{0, 1};
        if(i != 0){
            p.any_black = p.any_black * (pre[cur][i-1].any_black + pre[cur][i-1].all_white) + (p.all_white * pre[cur][i-1].any_black);
            p.all_white *= pre[cur][i-1].all_white;
        }
        if(i != ch[cur].size()-1){
            p.any_black = p.any_black * (suf[cur][i+1].any_black + suf[cur][i+1].all_white) + (p.all_white * suf[cur][i+1].any_black);
            p.all_white *= suf[cur][i+1].all_white;
        }
        if(cur != 0){
            p.any_black = p.any_black * (up[cur].any_black + up[cur].all_white) + (p.all_white * up[cur].any_black);
            p.all_white *= up[cur].all_white;
        }
        int nxt = children[cur][i];
        up[nxt].any_black = p.any_black + p.all_white;
        up[nxt].all_white = p.all_white;
        dfs2(nxt, cur);
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N >> M;

    if(N == 1) return 0;
    for(int i = 0; i < N-1; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs1(0, -1);
    for(int cur = 0; cur < N; ++cur){
        int k = ch[cur].size();
        pii p{0, 1};
        for(int i = 0; i < k; ++i){
            p.any_black = p.any_black * (ch[cur][i].any_black + ch[cur][i].all_white) + (p.all_white * ch[cur][i].any_black);
            p.all_white *= ch[cur][i].all_white;
            pre[cur].push_back(p);
        }

        p = {0, 1};
        for(int i = k-1; i >= 0; --i){
            p.any_black = p.any_black * (ch[cur][i].any_black + ch[cur][i].all_white) + (p.all_white * ch[cur][i].any_black);
            p.all_white *= ch[cur][i].all_white;
            suf[cur].push_back(p);
        }
        reverse(suf[cur].begin(), suf[cur].end());
    }

    dfs2(0, -1);
    for(int cur = 0; cur < N; ++cur){
        pii p{0, 1};
        if(cur != 0){
            p.any_black = p.any_black * (up[cur].any_black + up[cur].all_white) + (p.all_white * up[cur].any_black);
            p.all_white *= up[cur].all_white;
        }
        if(!children[cur].empty()){
            p.any_black = p.any_black * (pre[cur].back().any_black + pre[cur].back().all_white) + (p.all_white * pre[cur].back().any_black);
            p.all_white *= pre[cur].back().all_white;
        }
        
        cout << p.any_black + p.all_white << "\n";
    }
}