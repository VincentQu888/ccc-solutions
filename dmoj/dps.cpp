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
const int MM = 10005, mod = 1e9+7;
string K; int D, dp[MM][2][105];
int f(int pos, bool hi, int sum){
    if(pos == K.size()){
        if(sum%D == 0) return 1;
        return 0;
    }
    int& cnt = dp[pos][hi][sum%D];
    if(cnt != -1) return cnt;
    int hv = hi ? K[pos] - '0' : 9;
    cnt = 0;
    for(int x = 0; x <= hv; ++x) cnt = (cnt + f(pos+1, hi && x == K[pos] - '0', sum+x))%mod;
    return cnt;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> K >> D;
    memset(dp, -1, sizeof(dp));
    cout << (f(0, 1, 0)-1 + mod)%mod << "\n";
}