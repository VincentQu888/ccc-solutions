#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const int MM = 1e5+5;
int n, last[MM], ans[MM];
unordered_map<int, int> diff, psa;
set<int> temp;
vector<int> coords;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    for(int i = 0, s, t; i < n; ++i){
        cin >> s >> t;
        diff[s] += 1; diff[t] -= 1;
        temp.emplace(s); temp.emplace(t);
    }
    temp.emplace(0);
    for(int nxt : temp) coords.push_back(nxt);
    psa[0] = 0;
    for(int i = 1; i < coords.size(); ++i) psa[coords[i]] = diff[coords[i]] + psa[coords[i-1]];
    memset(last, 0, sizeof(last)); memset(ans, 0, sizeof(ans));
    int cnt = 0;
    for(int i = 1; i < coords.size(); ++i){
        if(cnt < psa[coords[i]]){
            ++cnt;
            for(; cnt < psa[coords[i]]; ++cnt) last[cnt] = coords[i];
            last[cnt] = coords[i];
        }else{
            for(; cnt > psa[coords[i]]; --cnt) ans[cnt] = max(ans[cnt], coords[i] - last[cnt]);
        }
    }
    for(int i = 1; i <= n; ++i) cout << ans[i] << " ";
}