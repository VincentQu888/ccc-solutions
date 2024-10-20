#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>

ll exp(int a, int b){
    ll ans = 1;
    for(int i = 0; i < b; ++i) ans *= a;
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string column;
    cin >> column;

    ll ans = 0;
    for(int i = 0; i < column.length(); ++i){
        ans += (column.at(i)-'A'+1)*exp(26, column.length()-1-i);
    }

    cout << ans << "\n";
}