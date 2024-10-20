#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e6+5;
struct light{int p, r, g;};
light lights[MM];

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, D;
    cin >> N >> D;

    lights[0] = {0, 0, 0};
    for(int i = 1; i <= N; ++i){
        cin >> lights[i].p >> lights[i].r >> lights[i].g;
    }

    ll ans = 0;
    for(int i = 1; i <= N; ++i){
        ans += lights[i].p - lights[i-1].p;
        if(ans%(lights[i].r + lights[i].g) <= lights[i].r) ans += lights[i].r - ans%(lights[i].r + lights[i].g);   
    }
    cout << ans + (D - lights[N].p) << "\n";
}