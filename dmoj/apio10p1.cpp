#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf LONG_LONG_MAX
const int MM = 1e6+5;
int psa[MM]; ll dp[MM];
int n, a, b, c;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> n >> a >> b >> c;
    fill(dp, dp+MM, -inf); psa[0] = 0;
    for(int i = 0, x; i < n; ++i){
        cin >> x;
        psa[i+1] = psa[i] + x;
    }
    for(int i = 1, last = 0; i <= n; ++i){
        for(int j = last; j < i; ++j){
            ll val = dp[j] + (ll)a*(psa[i]-psa[j])*(psa[i]-psa[j]) + (ll)b*(psa[i]-psa[j]) + c;
            if(dp[j] == -inf) val = (ll)a*(psa[i]-psa[j])*(psa[i]-psa[j]) + (ll)b*(psa[i]-psa[j]) + c;
            if(val > dp[i]){
                dp[i] = val;
                last = j;
            }
        }
    }
    cout << dp[n] << "\n";
}