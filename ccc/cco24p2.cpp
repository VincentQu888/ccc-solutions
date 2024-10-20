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
int N, a[MM], b[MM], c[MM], d[MM], freqa[MM], freqb[MM], cnt = 0;
stack<int> nxt[MM];
map<int, int> stk;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i = 0; i < N; ++i){cin >> a[i]; freqa[a[i]] += 1;}
    for(int i = 0; i < N; ++i){cin >> b[i]; freqb[b[i]] += 1; nxt[b[i]].push(i);}
    for(int i = 0; i < N; ++i){
        if(freqa[i] != freqb[i]){cout << -1 << "\n"; return 0;}
    }
    for(int i = 0; i < N; ++i){
        auto it = stk.upper_bound(nxt[a[i]].top());
        if(it != stk.end()){
            c[i] = it->second;
            d[nxt[a[i]].top()] = it->second;
            stk[nxt[a[i]].top()] = it->second;
            stk.erase(it);
        }else{
            int idx = stk.size()+1;
            c[i] = idx;
            d[nxt[a[i]].top()] = idx;
            stk[nxt[a[i]].top()] = idx;
        }
        nxt[a[i]].pop();
    }
    cout << stk.size() << "\n";
    for(int i = 0; i < N; ++i) cout << c[i] << " ";
    cout << "\n";
    for(int i = 0; i < N; ++i) cout << d[i] << " ";
}