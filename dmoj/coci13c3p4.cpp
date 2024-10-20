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
int N, a[MM], b[MM], sum = 0;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i = 0; i < N; ++i){
        cin >> a[i] >> b[i];
        sum += b[i];
    }
    for(int i = 1; i < N; ++i){
        if((a[i-1] > a[i] && b[i-1] > b[i]) || (a[i-1] < a[i] && b[i-1] < b[i])){cout << -1 << "\n"; return 0;}
    }
    int it = 0;
    double lo = 0, hi = 1e7, mid;
    while(lo <= hi){
        ++it;
        if(it > 100){break;}
        mid = (lo+hi)/2;
        bool ans = true;
        for(int i = 1; i < N; ++i){
            if(a[i-1] + mid*((double)b[i-1]/sum) >= a[i] + mid*((double)b[i]/sum)) continue;
            else if(a[i-1] < a[i]){lo = mid+0.00000000000001; ans = false; break;}
            else{hi = mid-0.00000000000001; ans = false; break;}
        }
        if(ans){cout << setprecision(12) << mid << "\n"; return 0;}
    }
    cout << -1 << "\n";
}