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
#define int long long
unordered_set<int> a, divs;
int N, low = LINF, ans = 0, cnt = 0;

signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i = 0, x; i < N; ++i){
        cin >> x;
        a.emplace(x); low = min(low, x);
    }
    for(int x : a){
        vector<int> temp(a.begin(), a.end());
        for(int i = cnt+1; i < min(4, (signed)temp.size()); ++i){
            int diff = abs(x-temp[i]);
            for(int j = 1; j <= pow(diff, 0.5); ++j){
                if(diff%j == 0){divs.emplace(j); divs.emplace(diff/j);}
            }
        }
        ++cnt;
    }
    for(int L : divs){
        if(L > low/4) continue;
        unordered_set<int> mods; bool flag = true;
        for(int nxt : a){
            mods.emplace(nxt%L);
            if(mods.size() > 3){flag = false; continue;}
        }
        if(flag) ans += L;
    }
    if(a.size() <= 3) cout << (low/4)*(low/4+1)/2 << "\n";
    else cout << ans << "\n";
}