#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const int MM = 1e6+5;
int N, M, a[MM], b[MM], cnt = 0; ll psa[MM];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i = 0; i < N; ++i) cin >> a[i];
    for(int i = 0; i < N; ++i) cin >> b[i];
    for(int i = 0; i < N; ++i){
        int prev = cnt;
        cnt += b[i];
        psa[prev] += a[i];
        psa[min(cnt, M)] -= a[i];
        if(cnt >= M){
            cnt = cnt%M;
            psa[0] += a[i];
            psa[cnt] -= a[i];
        }
    }
    cout << psa[0] << " ";
    for(int i = 1; i < M; ++i){
        psa[i] += psa[i-1];
        cout << psa[i] << " ";
    }
}