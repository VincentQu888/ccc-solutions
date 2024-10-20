#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e5+5;
vector<pii> adj[MM]; unordered_map<int, int> total[MM];
vector<int> euler;
pii sparse[20][2*MM];
int depth[MM], in[MM], out[MM];
int N, K, M = 1e9+7;

long long modExp(long long base, long long exp, long long mod) { //chatgpt generated function lmfao
    long long result = 1; // Initialize result
    base = base % mod; // Update base if it is more than or equal to mod

    while (exp > 0) {
        // If exp is odd, multiply base with the result
        if (exp % 2 == 1) {
            result = (result * base) % mod;
        }
        
        // Now exp must be even, so we divide it by 2
        exp = exp >> 1; // exp = exp / 2
        base = (base * base) % mod; // Change base to base^2
    }
    return result;
}

void dfs(int cur){
    euler.push_back(cur);
    if(in[cur] == -1) in[cur] = euler.size()-1;
    out[cur] = euler.size()-1;

    for(pii next : adj[cur]){
        if(depth[cur] + 1 < depth[next.first]){
            depth[next.first] = depth[cur] + 1;
            dfs(next.first);
            euler.push_back(cur);
            out[cur] = euler.size()-1;
        }
    }
}

pii query(int L, int R){
    if(L > R) swap(L, R);
    int j = log2(R - L + 1);
 
    if(depth[sparse[j][L].first] <= depth[sparse[j][R - (1 << j) + 1].first]) return sparse[j][L];
    else return sparse[j][R - (1 << j) + 1];
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N;
    for(int i = 0, a, b, x; i < N-1; ++i){
        cin >> a >> b >> x;
        --a; --b;
        adj[a].push_back({b, 0});
        adj[b].push_back({a, x});
    }

    fill(depth, depth+N, inf); fill(in, in+N, -1);
    depth[0] = 0; dfs(0);

    for(int i = 0; i < euler.size(); ++i) 
        sparse[0][i] = {euler[i], i};
    for(int j = 1; j <= log2(euler.size()); ++j) {
        for(int i = 1; i + (1 << j) - 1 <= euler.size(); i++) {
            if(depth[sparse[j - 1][i].first] < depth[sparse[j - 1][i + (1 << (j - 1))].first]) sparse[j][i] = sparse[j - 1][i];
            else sparse[j][i] = sparse[j - 1][i + (1 << (j - 1))];
        }
    }

    cin >> K;
    int prev = 0; int down[euler.size()+1], up[euler.size()+1], psad[euler.size()+1], psau[euler.size()+1];
    fill(down, down+euler.size()+1, 0); fill(up, up+euler.size()+1, 0); fill(psad, psad+euler.size()+1, 0); fill(psau, psau+euler.size()+1, 0);
    for(int i = 0, s; i < K; ++i){
        cin >> s; --s;
        pii lca = query(in[prev], in[s]);

        down[out[prev]+1] += 1; down[out[lca.first]+1] -= 1;
        up[out[s]+1] += 1; up[out[lca.first]+1] -= 1;
        prev = s;
    }

    for(int i = 1; i < euler.size()+1; ++i){
        psad[i] = psad[i-1] + down[i-1];
        psau[i] = psau[i-1] + up[i-1];
    }

    for(int i = 1; i < euler.size(); ++i){
        int a = euler[i-1], b = euler[i];
        for(pii next : adj[a]){
            if(next.first == b && next.second == 1){
                if(depth[a] > depth[b]) total[a][b] = psad[out[a]+2] - psad[in[a]+1];
                else total[a][b] = psau[out[b]+2] - psau[in[b]+1];
                break;
            }
        }
    }

    ll ans = 0;
    for(int a = 0; a < N; ++a){
        for(auto& b : total[a]){
            ans = (ans + modExp(2, b.second, M)-1)%M;
        }
    }
    cout << ans%M << "\n";
}



