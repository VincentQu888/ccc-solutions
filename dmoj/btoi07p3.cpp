#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e6+5;
int n, m, c; 
deque<pii> high, low;
vector<int> ans;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> n >> m >> c;
    for(int i = 0, a; i < n; ++i){
        cin >> a;

        if(high.size() > 0 && i - high.front().second >= m) high.pop_front();
        while(high.size() > 0 && high.back().first <= a){
            high.pop_back();
        }
        high.push_back({a, i});

        if(low.size() > 0 && i - low.front().second >= m) low.pop_front();
        while(low.size() > 0 && low.back().first >= a){
            low.pop_back();
        }
        low.push_back({a, i});

        if(i >= m-1 && high.front().first - low.front().first <= c) ans.push_back(i+1-(m-1)); 
    }

    if(ans.empty()) cout << "NONE" << "\n";
    else for(int next : ans) cout << next << "\n";
}