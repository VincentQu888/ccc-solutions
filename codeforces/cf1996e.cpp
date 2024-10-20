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
const int mod = 1e9+7;
int t;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> t;
    for(int cases = 0; cases < t; ++cases){
        string s; cin >> s;
        int psa[s.size()+5], ans = 0; psa[0] = 0;
        unordered_map<int, int> freq;
        for(int i = 0; i < s.size(); ++i){
            ans = (ans + freq[(s[i] == '0' ? -1 : 1) + psa[i]] * (s.size()-i) % mod) % mod;
            psa[i+1] = (s[i] == '0' ? -1 : 1) + psa[i];
            if(psa[i+1] == 0) ans = (ans + s.size()-i) % mod;
            freq[psa[i+1]] = (freq[psa[i+1]] + i+2) % mod;
        }
        cout << ans << endl;
    }
}