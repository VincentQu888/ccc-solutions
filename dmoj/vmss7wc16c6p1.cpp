#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N; ll ans = 0;
    cin >> N;
    

    pii prev; pii origin;
    cin >> prev.first >> prev.second;
    origin = prev;
    for(int i = 1; i < N; ++i){
        int x, y;
        cin >> x >> y;

        ans += prev.first*y - prev.second*x;
        prev.first = x; prev.second = y;
    }
    ans += prev.first*origin.second - prev.second*origin.first;

    cout << (ll)ceil((double)abs(ans)/2) << "\n";
}