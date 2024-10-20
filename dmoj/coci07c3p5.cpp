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
string L, R; int l[20], r[20], s; ll dp[20][2][2][9*18+5], mi = LINF;
ll f(int pos, bool lo, bool hi, int sum, ll num){
    if(pos == R.size()){
        if(sum == s){mi = min(mi, num); return 1;}
        return 0;
    }
    ll& cnt = dp[pos][lo][hi][sum];
    if(cnt != -1) return cnt;   
    int lv = lo ?  l[pos] : 0, hv = hi ? r[pos] : 9;
    cnt = 0;
    for(int x = lv; x <= hv; ++x) cnt += f(pos+1, lo && x == l[pos], hi && x == r[pos], sum+x, num*10+x);
    return cnt;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    memset(dp, -1, sizeof(dp));
    cin >> L >> R >> s;
    for(int i = 0; i < R.size(); ++i) r[i] = R[i] - '0';
    for(int i = 0; i < L.size(); ++i) l[R.size()-1-i] = L[L.size()-1-i] - '0';
    cout << f(0, 1, 1, 0, 0) << endl;
    cout << mi << endl;
}