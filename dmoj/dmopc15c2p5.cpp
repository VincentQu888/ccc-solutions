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
int N, Q;
vector<pii> S, M, queries;
unordered_map<int, int> ans;
deque<int> q;
double slope(int k, int j){
    return (double)(S[M[k].second].first-S[M[j].second].first) / (M[j].first-M[k].first);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> Q;
    for(int i = 0, x, y; i < N; ++i){
        cin >> x >> y;
        S.push_back({x, i}); M.push_back({y, i});
    }
    for(int i = 0, x; i < Q; ++i){
        cin >> x;
        queries.push_back({x, i});
    }
    sort(M.begin(), M.end(), [](pii a, pii b){
        return a.first < b.first;
    });
    sort(queries.begin(), queries.end(), [](pii a, pii b){
        return a.first < b.first;
    });
    for(int i = 0; i < N; ++i){
        while(q.size() >= 2 && slope(q[q.size()-2], q.back()) > slope(q.back(), i)) q.pop_back();
        q.push_back(i);
    }
    for(int i = 0; i < Q; ++i){
        while(q.size() >= 2 && (queries[i].first > slope(q[0], q[1]) || (queries[i].first == slope(q[0], q[1]) && M[q[1]].second < M[q[0]].second))) q.pop_front();
        ans[queries[i].second] = M[q[0]].second;
    }
    for(int i = 0; i < Q; ++i) cout << ans[i] << endl;
}

//S[k] + M[k]*x = S[j] + M[j]*x
//S[k] - S[j] = M[j]*x - M[k]*x
//S[k] - S[j] = x*(M[j] - M[k])
//(S[k] - S[j]) / (M[j] - M[k]) = x