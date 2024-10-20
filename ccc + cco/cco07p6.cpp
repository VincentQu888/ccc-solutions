#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

const int MM = 1005;
vector<int> adj[MM];
bool vis[MM], processed[MM];
int num[MM], low[MM];
stack<int> stk;
int cnt = 0;
unordered_map<int, vector<int>> scc;
vector<int> leaves;

void tarjan(int prev, int cur){
    stk.push(cur);
    num[cur] = low[cur] = cnt;
    ++cnt;

    for(int next : adj[cur]){
        if(next == prev) continue;
        if(!vis[next]){
            vis[next] = true;
            tarjan(cur, next);

            low[cur] = min(low[cur], low[next]);
        }else if(!processed[next]){
            low[cur] = min(low[cur], low[next]);
        }
    }

    processed[cur] = true;
    if(low[cur] == num[cur]){
        while(stk.top() != cur){
            scc[cur].push_back(stk.top());
            stk.pop();
        }
        stk.pop();
    }
}

void dfs(int prev, int cur){
    if(low[cur] == num[cur] && !scc[cur].empty()){
        bool leaf = true;
        for(int next : adj[cur]){
            if(next == prev) continue;
            if(low[next] != num[cur] || prev == cur) leaf = false;
            if(!vis[next] && low[next] != num[cur]){
                vis[next] = true;
                dfs(cur, next);
            }
        }
        if(leaf) leaves.push_back(cur);
    }else{
        if(adj[cur].size() == 1) leaves.push_back(cur);
        for(int next : adj[cur]){
            if(!vis[next]){
                vis[next] = true;
                dfs(cur, next);
            }
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, R;
    cin >> N >> R;

    for(int i = 0; i < R; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }


    for(int i = 0; i < N; ++i){
        if(!vis[i]){
            vis[i] = true;
            tarjan(i, i);
        }
    }

    for(auto& component : scc){
        for(int i = 0; i < component.second.size(); ++i){
            for(int next : adj[component.second[i]]){
                adj[component.first].push_back(next);
            }
        }
    }

    fill(vis, vis+MM, false);
    vis[0] = true;
    dfs(0, 0);
    
    cout << (leaves.size()+1)/2 << "\n"; 
}