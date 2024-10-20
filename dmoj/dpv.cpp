#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e5+5;
vector<int> adj[MM][3]; //0 adjlist, 1 prefix mult, 2 suffix mult, 1 & 2 r 1-indexed
int dpo[MM], dp[MM], M;
bool vis[MM];

int add(int a, int b){
    return (a+b) % M;
}

int mul(int a, int b){
    return (ll) a*b % M;
}

int filldpo(int prev, int cur){
    if(dpo[cur] != 0) return dpo[cur];
    if(adj[cur][0].size() == 1 && cur != 0) return dpo[cur] = 1;

    int ans = 1;
    adj[cur][1].push_back(1); adj[cur][2].push_back(1);
    for(int i = 0; i < adj[cur][0].size(); ++i){
        int next = adj[cur][0][i];
        if(next != prev){
            ans = mul(ans, filldpo(cur, next)+1);
            adj[cur][1].push_back(mul(adj[cur][1][i], dpo[next]+1));
        }else{
            adj[cur][1].push_back(adj[cur][1][i]);
        }
    }
    for(int i = adj[cur][0].size()-1; i >= 0; --i){
        int next = adj[cur][0][i];
        if(next != prev){
            adj[cur][2].push_back(mul(adj[cur][2][adj[cur][2].size()-1], (dpo[next]+1)));
        }else{
            adj[cur][2].push_back(adj[cur][2][adj[cur][2].size()-1]);
        }
    }
    reverse(adj[cur][2].begin(), adj[cur][2].end());
    
    return dpo[cur] = ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N >> M;

    if(N == 1){cout << "1\n"; return 0;}
    for(int i = 0; i < N-1; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u][0].push_back(v);
        adj[v][0].push_back(u);
    }


    fill(dp, dp+MM, 0); fill(dpo, dpo+MM, 0);
    vis[0] = true;
    filldpo(0, 0); dp[0] = dpo[0];
    
    fill(vis, vis+MM, false); vis[0] = true;
    queue<int> queue;
    queue.push(0);
    while(!queue.empty()){
        int cur = queue.front();
        queue.pop();

        for(int i = 0; i < adj[cur][0].size(); ++i){
            int next = adj[cur][0][i];
            if(!vis[next]){
                vis[next] = true;
                dp[next] = mul(adj[cur][1][i], adj[cur][2][i+1]) + 1;


                if(adj[next][1].size() > 1){
                    int idx = 0;
                    for(int j = 0; j < adj[next][0].size(); ++j){
                        if(adj[next][0][j] == cur){
                            idx = j;
                            break;
                        }
                    }

                    adj[next][1][idx+1] = mul(adj[next][1][idx], mul(adj[cur][1][i], adj[cur][2][i+1]) + 1);
                    adj[next][2][idx] = mul(adj[next][2][idx+1], mul(adj[cur][1][i], adj[cur][2][i+1]) + 1);

                    for(int j = idx+2; j < adj[next][1].size(); ++j){
                        adj[next][1][j] = mul(adj[next][1][j-1], (dpo[adj[next][0][j-1]]+1));
                    }
                    for(int j = idx-1; j >= 0; --j){
                        adj[next][2][j] = mul(adj[next][2][j+1], (dpo[adj[next][0][j]]+1));
                    }
                }


                for(int child : adj[next][0]){
                    if(!vis[child]){
                        dp[next] = mul(dp[next], dpo[child]+1);
                    }
                }
                queue.push(next);
            }
        }
    }

    for(int i = 0; i < N; ++i){
        cout << dp[i]%M << "\n";
    }
}