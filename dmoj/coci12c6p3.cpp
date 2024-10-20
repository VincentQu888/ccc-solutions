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
const int MM  = 5005;
int N, a[MM], ans = 0; 
unordered_set<int> seen;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i = 0; i < N; ++i) cin >> a[i];
    for(int i = 0; i < N; ++i){
        for(int j = i-1; j >= 0; --j){
            if(seen.count(a[i]-a[j])){++ans; break;}
        }
        for(int j = i; j >= 0; --j) seen.emplace(a[i]+a[j]);
    }
    cout << ans << "\n";
}