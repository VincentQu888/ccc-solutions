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
string L, R;
int sum(string x){int ans = 0; for(char nxt : x){ans += nxt - '0';} return ans;}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> L >> R;
    int low = min(L[0] - '0' + 1, sum(L));
    if(R.size() > L.size()) low = 1;
    int high = max((int)(R.size()-1)*9 + R[0]-'0'-1, sum(R));
    cout << high-low+1 << "\n";
}