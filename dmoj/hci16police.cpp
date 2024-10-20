#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf LONG_LONG_MAX
const int MM = 1e5+5;
int N, H, pos[MM]; ll dp[MM];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N >> H;

    fill(dp, dp+MM, inf); dp[0] = 0;
    for(int i = 1, last = 0; i <= N; ++i){
        cin >> pos[i];
        for(int j = last; j < i; ++j){
            ll val = dp[j] + H + (ll)(pos[i] - pos[j+1])*(pos[i] - pos[j+1]);
            if(val < dp[i]){
                dp[i] = val;
                last = j;
            }
        }
    }

    cout << dp[N];
}