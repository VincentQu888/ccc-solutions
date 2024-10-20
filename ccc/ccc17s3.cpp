#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e6+5;
unordered_map<int, int> lengths;
int N;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N;
    for(int i = 0, L; i < N; ++i){
        cin >> L; 
        lengths[L] += 1;
    }

    int ans = 0, cnt = 0;
    for(int i = 0; i < 4000; ++i){
        int ways = 0;
        for(int l = 0, r = i; l < r; ++l, --r){
            ways += min(lengths[l], lengths[r]);
        }
        if(i%2 == 0) ways += lengths[i/2]/2;
        
        if(ways > ans){
            ans = ways;
            cnt = 1;
        }else if(ways == ans) ++cnt;
    }

    cout << ans << " " << cnt << "\n";
}