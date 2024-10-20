#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
#include <ctime>

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;
    cin >> N >> M;

    vector<int> adj[N];
    int step[N][3]; 
    vector<pii> ans;
    for(int i = 0; i < N; ++i){
        step[i][0] = inf; step[i][1] = inf; step[i][2] = inf;
    }

    for(int i = 0; i < M; ++i){
        int u, v;
        cin >> u >> v;
        --u; --v;

        adj[u].push_back(v);
        adj[v].push_back(u);
        ans.push_back(make_pair(u, v));
    }

    int a, b, c, d;
    cin >> a >> b >> c >> d;
    --a; --b; --c; --d;

    step[a][0] = 0; step[a][1] = 0; step[a][2] = 0;
    queue<int> queue;
    queue.push(a);
    while(queue.size() > 0){
        int cur = queue.front();
        queue.pop();

        for(int next : adj[cur]){
            if(step[cur][0]+1 < step[next][0] && next != c && next != d){
                step[next][0] = step[cur][0]+1;
                queue.push(next);
            }
        }
    }

    queue.push(a);
    while(queue.size() > 0){
        int cur = queue.front();
        queue.pop();

        for(int next : adj[cur]){
            if(step[cur][1]+1 < step[next][1] && next != d){
                step[next][1] = step[cur][1]+1;
                queue.push(next);
            }
        }
    }

    queue.push(a);
    while(queue.size() > 0){
        int cur = queue.front();
        queue.pop();

        for(int next : adj[cur]){
            if(step[cur][2]+1 < step[next][2] && next != c){
                step[next][2] = step[cur][2]+1;
                queue.push(next);
            }
        }
    }


    bool adjacent = false;
    for(int next : adj[c]){
        if(next == d){
            adjacent = true;
            break;
        }
    }

    if((step[b][0] == inf && step[b][1] == inf && step[b][2] == inf) || adjacent){
        cout << -1 << "\n";
    }else{
        cout << 2 << "\n";
        
        if(step[b][1] < step[b][2]){
            for(pii next : ans){
                if(next.first == d or next.second == d) cout << 2 << "\n";
                else cout << 1 << "\n";
            }
        }
        else{
            for(pii next : ans){
                if(next.first == c or next.second == c) cout << 2 << "\n";
                else cout << 1 << "\n";
            }
        }
    }
}