#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e5+5;
vector<unordered_map<int, int>> freq[MM];
vector<pii> adj[MM];
bool removed[MM];
int subtree_size[MM];
int N; ll ans = 0;

int get_size(int cur, int prev){
    subtree_size[cur] = 1;
    for(pii next : adj[cur]){
        if(next.first != prev && !removed[next.first]){
            subtree_size[cur] += get_size(next.first, cur);
        }
    }
    return subtree_size[cur];
}

int get_centroid(int cur, int prev, int tree_size){
    for(pii next : adj[cur]){
        if(next.first != prev && !removed[next.first] && subtree_size[next.first]*2 > tree_size){
            return get_centroid(next.first, cur, tree_size);
        }
    }
    return cur;
}

void ff(int cur, int prev, int sum, int centroid, int idx){
    freq[centroid][idx][sum] += 1;
    for(pii next : adj[cur]){
        if(!removed[next.first] && next.first != prev){
            ff(next.first, cur, sum+next.second, centroid, idx);
        }
    }
}

void build(int cur){ 
    int centroid = get_centroid(cur, -1, get_size(cur, -1));
    removed[centroid] = true;

    for(pii next : adj[centroid]){
        if(!removed[next.first]){
            freq[centroid].push_back(unordered_map<int, int>());
            ff(next.first, centroid, next.second, centroid, freq[centroid].size()-1);
            build(next.first);
            --ans;
        }
    }

    unordered_map<int, int> cfreq;
    for(unordered_map<int, int> nxt : freq[centroid]){
        for(auto& it : nxt){
            cfreq[it.first] += it.second;
        }
    }
    ans += cfreq[1];
    ans += cfreq[-1];

    for(unordered_map<int, int> nxt : freq[centroid]){
        int low = 0, high = 0;
        for(auto& it : nxt){
            cfreq[it.first] -= it.second;
            low = min(low, it.first);
            high = max(high, it.first);
        }
        for(int i = low; i <= high; ++i){
            ans += nxt[i]*cfreq[-i+1];
            ans += nxt[i]*cfreq[-i-1]; 
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N;
    for(int i = 0, a, b; i < N-1; ++i){
        char c;
        cin >> a >> b >> c;
        --a; --b;
        adj[a].push_back({b, c == 'r' ? 1 : -1});
        adj[b].push_back({a, c == 'r' ? 1 : -1});
    }

    build(0);
    cout << ans << "\n";
}