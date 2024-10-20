#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF LONG_LONG_MAX
const int MM = 2e4+5;
int N, K, arr[MM], psa[MM], dp[2][MM], best[2][MM];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    fill(dp[0], dp[0]+MM, -INF); 
    fill(best[0], best[0]+MM, -INF); 
    dp[0][0] = 0; best[0][0] = 0; psa[0] = 0;
    for(int i = 0; i < N; ++i){
        cin >> arr[i];
        psa[i+1] = psa[i] + arr[i];
    }
    for(int i = 1; i <= N; ++i){
        best[1][0] = max(best[1][0], -psa[i]);
        for(int j = 1; j <= K; ++j){
            dp[1][j] = max(dp[0][j], best[0][j-1] + psa[i]);
            best[1][j] = max(best[0][j], dp[1][j] - psa[i]);
        }
        for(int j = 0; j < MM; ++j){
            dp[0][j] = dp[1][j];
            best[0][j] = best[1][j];
        }
    }
    cout << dp[0][K] << endl;
}