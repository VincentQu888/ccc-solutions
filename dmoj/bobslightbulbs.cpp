#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
const int MM = 2*10e4+5;
int bit[MM];

void update(int idx, int val){
    for(int i = idx+1; i < MM+5; i += i & -i) bit[i] += val;
}

long long query(int idx){
    idx = min(idx, MM);
    long long ans = 0;

    for(int i = idx+1; i > 0; i -= i & -i) ans += bit[i];
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, Q;
    cin >> N >> Q;

    for(int i = 0; i < Q; ++i){
        string cmd; int x, y;
        cin >> cmd >> x;
        --x; 

        if(cmd == "TOGGLE") {
            int cur = query(x) - query(x-1);
            if(cur == 0) update(x, 1);
            else update(x, -1);
        }else if(cmd == "ON"){
            cin >> y; --y;
            cout << query(y) - query(x-1) << "\n";
        }else{
            cin >> y; --y;
            cout << (y-x+1) - (query(y)-query(x-1)) << "\n";
        }
    }
}