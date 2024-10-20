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
const int MM = 1e5+5;
int n, l, s, a[MM];
bool f(int x){
    int rq = 1, sum = 0;
    for(int i = 1; i <= n; ++i){
        if(a[i] > x) return false;
        if((sum != 0 ? sum + a[i] + s : sum + a[i]) > x){sum = 0; ++rq; --i;}
        else sum += (sum != 0 ? a[i] + s : a[i]);
    }
    if(rq > l) return 0;
    return 1;
}
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n >> l >> s;
    a[0] = 0;
    for(int i = 1; i <= n; ++i) cin >> a[i];
    int lo = 0, hi = LINF, last = 0;
    while(lo <= hi){
        int mid = (lo+hi)/2;
        if(f(mid)){last = mid; hi = mid-1;}
        else lo = mid+1;
    }
    cout << last << endl;
}