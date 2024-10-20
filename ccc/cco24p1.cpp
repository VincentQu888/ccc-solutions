#include <iostream>
#include <bits/stdc++.h>
#include <queue>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const int MM = 1e6+5;
int N, M, v[MM], ans[MM];
vector<pii> adj[MM];
priority_queue<pii, vector<pii>, decltype([](pii a, pii b){
	return a.second < b.second;
})> pq; //node, ans[prev]-cost
int main(){
	ios_base::sync_with_stdio(0); cin.tie(0);
	fill(ans, ans+MM, -INF);
	cin >> N >> M;
	for(int i = 1; i <= N; ++i){
		cin >> v[i]; 
		pq.push({i, v[i]});
		ans[i] = v[i];
	}
	for(int i = 0, a, b, c; i < M; ++i){
		cin >> a >> b >> c;
		adj[a].push_back({b, c});
		adj[b].push_back({a, c});
	}	
	while(!pq.empty()){
		pii cur = pq.top();
		pq.pop();
		for(pii nxt : adj[cur.first]){
			if(ans[cur.first]-nxt.second > ans[nxt.first]){
				ans[nxt.first] = ans[cur.first]-nxt.second;
				pq.push({nxt.first, ans[nxt.first]});
			}
		}
	}
	for(int i = 1; i <= N; ++i) cout << ans[i] << "\n";
}