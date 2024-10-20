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
const int MM = 3e5+5;
int N, a[MM], b[MM];
vector<pii> sl, sr;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i = 0; i < N; ++i) cin >> a[i];
    for(int i = 0; i < N; ++i) cin >> b[i];
    int i = 0, j = 0;
    while(i < N && j < N){
        if(a[i] == b[j]){
            if(i < j) sr.push_back({j, i});
            else if(i > j) sl.push_back({j, i});
            ++j;
        }else ++i;
    }
    if(i > j) cout << "NO" << "\n";
    else{
        cout << "YES\n" << sl.size() + sr.size() << "\n";
        for(int k = sr.size()-1; k >= 0; --k) cout << "R " << sr[k].second << " " << sr[k].first << "\n";
        for(int k = 0; k < sl.size(); ++k) cout << "L " << sl[k].first << " " << sl[k].second << "\n";
    }
}