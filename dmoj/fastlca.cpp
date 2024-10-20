#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 6e6+5;
int parent[MM];
int N, Q;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N >> Q;
    for(int i = 1; i < N; ++i){
        cin >> parent[i]; --parent[i];
    }

    for(int i = 0, x, y; i < Q; ++i){
        cin >> x >> y;
        --x; --y;
        while(x != y){
            if(x < y) y = parent[y];
            else x = parent[x];
        }
        cout << x+1 << "\n";
    }
}