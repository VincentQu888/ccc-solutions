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
int K, N;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> K >> N; --K;
    int cur = 0;
    for(int i = 0; i < N; ++i){
        int t; char z;
        cin >> t >> z;
        if(cur+t >= 3*60+30){cout << K+1 << "\n"; return 0;}
        if(z == 'T') K = (K+1)%8;
        cur += t;
    }
}