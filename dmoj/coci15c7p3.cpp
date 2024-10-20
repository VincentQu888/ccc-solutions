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
const int MM = 1e5+5;
int K, Q, x[MM], psa[MM];
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> K; 
    int val = 0; psa[0] = 0;
    for(int i = 0; i < K; ++i){
        cin >> x[i];
        psa[i+1] = psa[i] ^ x[i];
        val ^= x[i];
    }
    x[K] = val; psa[K+1] = psa[K] ^ x[K];
    cin >> Q;
    for(int i = 0, l, r, L, R; i < Q; ++i){
        cin >> l >> r;
        if(l%(K+1) == 0) L = K;
        else L = l%(K+1)-1;
        R = r%(K+1);
        if((l-r+1 - (K+1-L) - R) / (K+1) %2 == 0) cout << ((psa[K+1]^psa[L]) ^ psa[R]) << endl;
        else cout << (psa[K+1] ^ (psa[K+1]^psa[L]) ^ psa[R]) << endl;
    }
}