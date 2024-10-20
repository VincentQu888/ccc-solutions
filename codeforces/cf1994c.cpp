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
int t;

signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> t;
    for(int cases = 0, n, x; cases < t; ++cases){
        cin >> n >> x;
        int dp[n+5], a[n+5], psa[n+5], ans = 0;
        dp[n+1] = 0; dp[n+2] = 0; psa[0] = 0; psa[n+1] = LINF;
        for(int i = 1; i <= n; ++i){
            cin >> a[i];
            psa[i] = psa[i-1] + a[i];
        }
        for(int i = n; i > 0; --i){
            int l = i, r = n+1, mid = (l+r)/2;
            while(l < r){
                mid = (l+r)/2;
                if(psa[mid] - psa[i-1] > x) r = mid;
                else l = mid+1;
            }  
            mid = (l+r)/2;
            dp[i] = dp[mid+1] + mid-i;
            ans += dp[i];
        }
        cout << ans << "\n";
    }
}