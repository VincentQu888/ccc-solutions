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
#define int long long
const int MM = 50+5;
int n, c, p, d[MM];
int cost(int ppl){
    int ret = 0;
    for(int i = 0; i < n; ++i){
        ret += c*ppl;
        ret += max(d[i]-ppl, (ll)0)*p;
    }
    return ret;
}
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n >> c >> p;
    for(int i = 0; i < n; ++i) cin >> d[i];
    int lo = 0, hi = 1e9, mid;
    while(lo <= hi){
        mid = (lo+hi)/2;
        int c1 = cost(mid), c2 = cost(mid+1), c3 = cost(mid-1);
        if(c1 < c2 && c1 < c3){cout << c1 << endl; return 0;} 
        else if(c2 < c1) lo = mid+1;
        else hi = mid-1;
    }
    cout << cost(mid);
}