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
const int MM = 1e5, mod = 1e9+7;
string K; ll dp[MM][2][2][2][2];
ll f(int pos, bool hi, bool first, bool second, bool third){
    if(pos == K.size()){
        if(first && second && !third) return 1;
        return 0;
    }
    ll& cnt = dp[pos][hi][first][second][third];
    if(cnt != -1) return cnt;
    int hv = hi ? K[pos] - '0' : 9;
    cnt = 0;
    for(int x = 0; x <= hv; ++x) cnt = (cnt + f(pos+1, hi && x == K[pos] - '0', first || x == 1, second || (first && x == 0), third || (first && second && x == 0)))%mod;
    return cnt;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    memset(dp, -1, sizeof(dp));
    cin >> K;
    cout << (f(0, 1, 0, 0, 0)%mod+mod)%mod << endl;
} 