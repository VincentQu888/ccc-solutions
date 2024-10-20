#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<ll, ll>
#define inf LLONG_MAX

const ll MM = 1e5+5, mod = 1e9+7;
ll a[100]; ll dp[100][MM];
int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    ll N, K;
    cin >> N >> K;

    for(ll i = 0; i < N; ++i){
        cin >> a[i];
        fill(dp[i], dp[i]+MM, 0);
    }


    for(ll i = 0; i < MM; ++i){
        if(a[N-1] >= i) dp[N-1][i] = 1;
    }
    for(ll i = N-2; i >= 0; --i){
        dp[i][0] = 1;
        for(ll j = 1; j <= K; ++j){
            if(j > a[i]) dp[i][j] = (dp[i][j-1]%mod + dp[i+1][j]%mod - dp[i+1][j-1-a[i]]%mod)%mod;
            else dp[i][j] = (dp[i][j-1]%mod + dp[i+1][j]%mod)%mod;
        }
    }
    cout << (dp[0][K]%mod + mod)%mod << "\n";
}