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
const int MM = 1e6;
int N, K, a[MM]; 
unordered_map<int, int> dis;
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    for(int i = 0; i < N; ++i) cin >> a[i];
    int l = 0, r = 0, ans = 0;
    dis[a[0]] += 1;
    while(r < N){
        if(dis.size() >= K){
            if(dis[a[l]] > 1) dis[a[l]] -= 1;
            else dis.erase(a[l]);
            ans += (N-r);
            ++l;
        }else{
            ++r;
            dis[a[r]] += 1;
        }
    }
    cout << ans << endl;
}