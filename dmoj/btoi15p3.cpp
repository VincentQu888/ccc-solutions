#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

const int MM = 5e5+5;
vector<int> adj[MM];
vector<int> leaves;
int step[MM];

void dfs(int cur){
    if(adj[cur].size() == 1) leaves.push_back(cur);
    for(int next : adj[cur]){
        if(step[cur]+1 < step[next]){
            step[next] = step[cur]+1;
            dfs(next);
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N;

    for(int i = 0; i < N-1; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    fill(step, step+MM, inf);
    step[0] = 0;
    dfs(0);

    cout << (leaves.size()+1)/2 << "\n";
    for(int i = 0; i < leaves.size()/2; ++i){
        cout << leaves[i]+1 << " " << leaves[(leaves.size()+1)/2 + i]+1 << "\n";
    }
    if(leaves.size()%2 == 1) cout << leaves[leaves.size()/2]+1 << " " << leaves[0]+1 << "\n";
}