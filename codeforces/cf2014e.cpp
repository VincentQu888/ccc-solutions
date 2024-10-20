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
int t; ll step1[MM][2], step2[MM][2]; vector<pii> adj[MM]; bool H[MM];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> t;
    for(int cases = 0, n, m, h; cases < t; ++cases){
        cin >> n >> m >> h; ll ans = LINF;
        for(int i = 0; i <= n; ++i){H[i] = false; adj[i].clear();    step1[i][0] = LINF; step1[i][1] = LINF; step2[i][0] = LINF; step2[i][1] = LINF;}
        for(int i = 0, x; i < h; ++i){cin >> x; H[x] = true;}
        for(int i = 0, a, b, c; i < m; ++i){
            cin >> a >> b >> c;
            adj[a].push_back({b, c});
            adj[b].push_back({a, c});
        }
        priority_queue<array<ll, 3>, vector<array<ll, 3>>, greater<array<ll, 3>>> pq;
        step1[1][0] = 0; step2[n][0] = 0;
        pq.push({0, 1, 0}); if(H[1]){pq.push({0, 1, 1}); step1[1][1] = 0;}
        while(!pq.empty()){
            array<ll, 3> u = pq.top(); pq.pop();
            if(u[0] > step1[u[1]][u[2]]) continue;
            for(pii v : adj[u[1]]){
                if((u[2] ? u[0]+v.second/2 : u[0]+v.second) < step1[v.first][u[2]]){
                    step1[v.first][u[2]] = u[2] ? u[0]+v.second/2 : u[0]+v.second;
                    pq.push({step1[v.first][u[2]], v.first, u[2]});
                }
                if(H[v.first] && !u[2] && u[0]+v.second < step1[v.first][1]){
                    step1[v.first][1] = u[0]+v.second; 
                    pq.push({step1[v.first][1], v.first, 1});
                }
            }
        }
        pq.push({0, n, 0}); if(H[n]){pq.push({0, n, 1}); step2[n][1] = 0;}
        while(!pq.empty()){
            array<ll, 3> u = pq.top(); pq.pop();
            if(u[0] > step2[u[1]][u[2]]) continue;
            for(pii v : adj[u[1]]){
                if((u[2] ? u[0]+v.second/2 : u[0]+v.second) < step2[v.first][u[2]]){
                    step2[v.first][u[2]] = u[2] ? u[0]+v.second/2 : u[0]+v.second;
                    pq.push({step2[v.first][u[2]], v.first, u[2]});
                }
                if(H[v.first] && !u[2] && u[0]+v.second < step2[v.first][1]){
                    step2[v.first][1] = u[0]+v.second; 
                    pq.push({step2[v.first][1], v.first, 1});
                }
            }
        }
        for(int i = 1; i <= n; ++i) ans = min(ans, max(min(step1[i][0], step1[i][1]), min(step2[i][0], step2[i][1])));
        cout << (ans == LINF ? -1 : ans) << "\n";
    }
}