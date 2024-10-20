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
int N; vector<int> vec;

signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    if(N >= 4){
        int ans = 0;
        for(int i = 1; i <= N/2; ++i){
            ans = max(ans, (N-2*i-1)*(N-2*i)/2 * i);
        }
        cout << ans << "\n";
    }
    else cout << 0 << "\n";
}