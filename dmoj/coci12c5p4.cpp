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
const int MM = 1e5+1005;
vector<int> adj[MM];
int step[MM], N, M, K;

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K >> M;  
    for(int i = 1; i <= M; ++i){
        for(int j = 0, x; j < K; ++j){
            cin >> x;
            adj[100000+i].push_back(x);
            adj[x].push_back(100000+i);
        }
    }

    queue<int> q; q.push(1); 
    fill(step, step+MM, INF); step[1] = 1;
    while(!q.empty()){
        int cur = q.front(); q.pop();
        for(int nxt : adj[cur]){
            if(step[cur]+1 < step[nxt]){
                step[nxt] = nxt > 100000 ? step[cur] : step[cur]+1;
                q.push(nxt);
            }
        }
    }

    if(step[N] != INF) cout << step[N] << "\n";
    else cout << -1 << "\n";    
}