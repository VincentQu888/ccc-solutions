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
const int MM = 305;
int N, M, ans[MM*MM];
void f(int lo, int hi){
    if(lo == hi) return;
    int mid = (lo+hi)/2;
    cout << "? " << mid - lo + 1 << " " << hi - mid << "\n"; cout << flush;
    for(int i = lo; i <= mid; ++i) cout << i << " \n"[i == mid]; cout << flush;
    for(int i = mid + 1; i <= hi; ++i) cout << i << " \n"[i == hi]; cout << flush;
    int R; cin >> R;
    for(int i = 0, r; i < R; ++i){
        cin >> r;
        ans[r] = 1;
    }
    f(lo, mid); f(mid+1, hi);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0); 
    cin >> N >> M;
    for(int i = 0, a, b; i < M; ++i) cin >> a >> b;
    memset(ans, 0, sizeof(ans));
    f(1, N);
    cout << "! ";
    for(int i = 1; i <= M; ++i) cout << ans[i];
    cout << endl;
}