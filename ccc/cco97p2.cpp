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
int t;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> t;
    for(int cases = 0, n; cases < t; ++cases){
        cin >> n; set<int> s;
        for(int i = 0, x; i < n; ++i){
            cin >> x;
            if(s.lower_bound(x) != s.end()){s.erase(s.lower_bound(x)); s.emplace(x);}
            else s.emplace(x);
        }
        cout << s.size() << "\n";
    }
}