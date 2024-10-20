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
int T;
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int cases = 0, N, K; cases < T; ++cases){
        cin >> N >> K;
        int dp[32+1][K+1], ans = -1; memset(dp, 0, sizeof(dp));
        for(int i = 1; i <= 32; ++i){
            dp[i][1] = i;
            if(dp[i][1] >= N){ans = i; goto end;}
            for(int j = 2; j <= K; ++j){
                for(int x = i-1; x > 0; --x) dp[i][j] += dp[x][j-1]+1;
                ++dp[i][j];
                if(dp[i][j] >= N){ans = i; goto end;}
            }
        }
        end:
        if(ans != -1) cout << ans << endl;
        else cout << "Impossible" << endl;
    }
}