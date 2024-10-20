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
const int MM = 505, mod = 1e9+7;
int N, K, dp[2][MM][MM], psa[2][MM][MM];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    memset(dp, 0, sizeof(dp)); memset(psa, 0, sizeof(psa)); 
    dp[0][1][0] = 1; dp[0][0][0] = 1;
    for(int j = 0; j <= N; ++j){
        for(int k = 0; k <= K; ++k) psa[0][j][k+1] = psa[0][j][k] + dp[0][j][k];
    }
    for(int i = 1; i < N; ++i){
        for(int j = 0; j <= N; ++j){
            for(int k = 0; k <= K; ++k){
                dp[1][j][k] = dp[0][j][k];
                if(j >= 1) dp[1][j][k] = (dp[1][j][k] + dp[0][j-1][k]) % mod;
                dp[1][j][k] = ((dp[1][j][k] + psa[0][j+1][k+1] - psa[0][j+1][max(k-j, 0)]) % mod + mod) % mod;
                psa[1][j][k+1] = (psa[1][j][k] + dp[1][j][k]) % mod;
            }
        }
        for(int j = 0; j < MM; ++j){
            for(int k = 0; k < MM; ++k){
                dp[0][j][k] = dp[1][j][k];
                psa[0][j][k] = psa[1][j][k];
                psa[1][j][k] = 0;
            }
        }
    }
    cout << dp[0][0][K] << endl;
}