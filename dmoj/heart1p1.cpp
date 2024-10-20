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
const int MM = 2e5+5;
int N, K, a[MM], m[MM];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    for(int i = 0; i < N; ++i) cin >> a[i];
    for(int i = 0, x; i < K; ++i){cin >> x; m[x-1] = 1;}
    int cnt = 0;
    for(int i = 0; i < N; ++i){
        if(m[i]) ++cnt;
        else cout << a[i]-cnt << " ";
    }
}
