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
const int MM = 1e5+5;
int N, L, a[MM], psa[MM], bit[2*MM], ans;
void update(int pos, int val){
    for(int i = pos+1; i < 2*MM; i += i & -i) bit[i] += val;
}
int sum(int pos) {
    int ans = 0;
    for(int i = pos+1; i > 0; i -= i & -i) ans += bit[i];
    return ans;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> L;
    for(int i = 0; i < N; ++i){
        cin >> a[i];
        a[i] = a[i] >= L ? 1 : -1;
    }
    psa[0] = 0;
    for(int i = 1; i <= N; ++i) psa[i] = psa[i-1] + a[i-1];
    for(int i = 0; i <= N; ++i){
        ans += sum(psa[i]+MM);
        update(psa[i]+MM, 1);
    }
    cout << ans << endl;
}