#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll unsigned long long


class edge{
    public:
    ll u;
    ll v;
    ll weight;

    edge(ll u, ll v, ll weight) : u(u), v(v), weight(weight) {}
    bool operator<(const edge& other) const {
        return weight < other.weight;
    }
};

vector<edge> adj[100005];
vector<ll> euler;
ll depth[100005];
ll dist[100005];
ll in[100005];
ll day[2][1000000];
pair<ll, ll> sparse[2*100000+5][21];
    
void dfs(edge cur){
    euler.push_back(cur.v);
    if(in[cur.v] == -1) in[cur.v] = euler.size()-1;

    for(edge next : adj[cur.v]){
        if(euler[euler.size()-1] != cur.v) euler.push_back(cur.v);
        if(depth[cur.v] + 1 < depth[next.v]){
            depth[next.v] = depth[cur.v] + 1;
            if(in[next.v] == -1) in[next.v] = euler.size();
            dfs(next);
            euler.push_back(next.v);
        }
    }
}

ll query(ll L, ll R){
    if(L > R) swap(L, R);
    ll j = (ll)log2(R - L + 1);
 
    if (sparse[L][j].first <= sparse[R - (1 << j) + 1][j].first) return sparse[L][j].second;
    else return sparse[R - (1 << j) + 1][j].second;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    ll N, D;
    cin >> N >> D;

    for(ll i = 0; i < N-1; ++i){
        ll a, b, c;
        cin >> a >> b >> c;
        --a; --b;
        adj[a].push_back(edge(a, b, c));
        adj[b].push_back(edge(b, a, c));
    }


    fill(depth, depth+N, LONG_LONG_MAX);
    fill(in, in+N, -1);
    depth[0] = 0;
    dfs(edge(0, 0, 0));

    for(ll i = 0; i < (ll)euler.size(); ++i) 
        sparse[i][0] = make_pair(depth[euler[i]], euler[i]);
    for(ll j = 1; j <= (ll)log2(euler.size()); ++j) {
        for(ll i = 1; i + (1 << j) - 1 <= (ll)euler.size(); i++) {
            if (sparse[i][j - 1].first < sparse[i + (1 << (j - 1))][j - 1].first) sparse[i][j] = sparse[i][j - 1];
            else sparse[i][j] = sparse[i + (1 << (j - 1))][j - 1];
        }
    }


    fill(dist, dist+N, LONG_LONG_MAX);
    priority_queue<edge> pq;
    pq.push(edge(0, 0, 0));
    dist[0] = 0;
    while(!pq.empty()){
        edge cur = pq.top();
        pq.pop();
        
        for(edge next : adj[cur.v]){
            if(dist[cur.v] + next.weight < dist[next.v]){
                dist[next.v] = dist[cur.v] + next.weight;
                pq.push(next);
            }
        }
    }


    for(ll i = 0; i < D; ++i){
        ll x, y;
        cin >> x >> y;
        --x; --y;

        day[0][i] = x;
        day[1][i] = y;
    }

    ll dp[D][2];
    dp[0][0] = dist[day[1][0]] + dist[day[0][0]]+dist[day[1][0]]-2*dist[query(in[day[0][0]], in[day[1][0]])];
    dp[0][1] = dist[day[0][0]] + dist[day[0][0]]+dist[day[1][0]]-2*dist[query(in[day[0][0]], in[day[1][0]])]; 

    for(int i = 1; i < D; ++i){
        dp[i][0] = min(
            dp[i-1][0] + dist[day[0][i-1]]+dist[day[1][i]]-2*dist[query(in[day[0][i-1]], in[day[1][i]])], 
            dp[i-1][1] + dist[day[1][i-1]]+dist[day[1][i]]-2*dist[query(in[day[1][i-1]], in[day[1][i]])]
        ) + dist[day[0][i]] + dist[day[1][i]] - 2*dist[query(in[day[0][i]], in[day[1][i]])];

        dp[i][1] = min(
            dp[i-1][0] + dist[day[0][i-1]]+dist[day[0][i]]-2*dist[query(in[day[0][i-1]], in[day[0][i]])], 
            dp[i-1][1] + dist[day[1][i-1]]+dist[day[0][i]]-2*dist[query(in[day[1][i-1]], in[day[0][i]])]
        ) + dist[day[0][i]] + dist[day[1][i]] - 2*dist[query(in[day[0][i]], in[day[1][i]])];
    }

    std::cout << min(dp[D-1][0], dp[D-1][1]) << "\n";
}