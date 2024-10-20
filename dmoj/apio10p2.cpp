#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e5+5;
struct edge{int v, weight;};
struct options{edge a, b;};
vector<edge> adj[MM];
int step[MM], parent[MM]; options dpo[MM]; options dp[MM];
int cnt = 0;

void dfs(edge cur){
    for(edge next : adj[cur.v]){
        if(step[cur.v]+1 < step[next.v]){
            step[next.v] = step[cur.v]+1;
            parent[next.v] = cur.v;
            dfs(next);
        }
    }
}

void diameter(int cur, int prev){
    if(adj[cur].size() == 1 && dpo[cur].a.weight != 0) return; 
    for(edge next : adj[cur]){
        if(next.v != prev){
            diameter(next.v, cur);
            if(dpo[next.v].a.weight + next.weight > dpo[cur].a.weight){ 
                dpo[cur].a.v = next.v;
                dpo[cur].a.weight = dpo[next.v].a.weight  + next.weight;
            } 
            else if(dpo[next.v].a.weight + next.weight > dpo[cur].b.weight){
                dpo[cur].b.v = next.v;
                dpo[cur].b.weight = dpo[next.v].a.weight + next.weight;
            } 
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, K;
    cin >> N >> K;

    for(int i = 0; i < N-1; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u].push_back(edge{v, 1});
        adj[v].push_back(edge{u, 1});
    }


    fill(step, step+MM, inf);
    step[0] = 0;
    dfs(edge{0, 0});

    int end1 = 0;
    for(int i = 0; i < N; ++i){
        if(step[i] > step[end1]) end1 = i;
    }
    

    fill(step, step+MM, inf);
    step[end1] = 0; parent[end1] = end1;
    cnt = 0;
    dfs(edge{end1, end1});

    int end2 = 0;
    for(int i = 0; i < N; ++i){
        if(step[i] > step[end2]) end2 = i;
    }


    int d1 = 0, d2 = 0, btnode = end2;
    while(parent[btnode] != btnode){
        ++d1;
        for(int j = 0; j < adj[btnode].size(); ++j){
            if(adj[btnode][j].v == parent[btnode]) adj[btnode][j].weight = -1;
        }
        for(int j = 0; j < adj[parent[btnode]].size(); ++j){
            if(adj[parent[btnode]][j].v == btnode) adj[parent[btnode]][j].weight = -1;
        }

        btnode = parent[btnode];
    }


    int start = 0;
    for(int i = 0; i < N; ++i){
        dpo[i].a = edge{i, 0}; dpo[i].b = edge{i, 0};
        dp[i].a = edge{i, 0}; dp[i].b = edge{i, 0};
    }
    for(int i = 0; i < N; ++i){
        if(adj[i].size() > 1){
            diameter(i, i);
            start = i;
            break;
        }
    } 
    dp[start] = dpo[start];


    queue<edge> queue;
    fill(step, step+MM, inf);
    step[start] = 0;
    queue.push(edge{start, 0});
    while(!queue.empty()){
        edge cur = queue.front();
        queue.pop();

        for(edge next : adj[cur.v]){
            if(step[cur.v]+1 < step[next.v]){
                step[next.v] = step[cur.v]+1;
                queue.push(next);


                if(next.v != dp[cur.v].a.v){
                    if(dp[cur.v].a.weight > dpo[next.v].a.weight){
                        dp[next.v].a.v = dp[cur.v].a.v;
                        dp[next.v].a.weight = dp[cur.v].a.weight + next.weight;
                        dp[next.v].b.v = dpo[next.v].a.v;
                        dp[next.v].b.weight = dpo[next.v].a.weight;
                    }else{
                        dp[next.v].b.v = dp[cur.v].a.v;
                        dp[next.v].b.weight = dp[cur.v].a.weight + next.weight;
                        dp[next.v].a.v = dpo[next.v].a.v;
                        dp[next.v].a.weight = dpo[next.v].a.weight;
                    }
                }else{
                    if(dp[cur.v].b.weight > dpo[next.v].a.weight){
                        dp[next.v].a.v = dp[cur.v].b.v;
                        dp[next.v].a.weight = dp[cur.v].b.weight + next.weight;
                        dp[next.v].b.v = dpo[next.v].a.v;
                        dp[next.v].b.weight = dpo[next.v].a.weight;
                    }else{
                        dp[next.v].b.v = dp[cur.v].b.v;
                        dp[next.v].b.weight = dp[cur.v].b.weight + next.weight;
                        dp[next.v].a.v = dpo[next.v].a.v;
                        dp[next.v].a.weight = dpo[next.v].a.weight;
                    }
                }
            }
        }

        d2 = max(d2, max(dp[cur.v].a.weight, 0) + max(dp[cur.v].b.weight, 0));
    }

    if(K == 1) cout << 2*(N-1) - d1 + 1 << "\n";
    else cout << 2*(N-1) - d1 + 1 - d2 + 1 << "\n";
}