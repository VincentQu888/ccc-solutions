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
int R, C;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> R >> C;
    for(int i = 0; i < C; ++i){
        if(0 == R-2 && i == C-1) cout << "E";
        else cout << "."; 
    }
    cout << endl;
    int idx = C-2;
    for(int i = 1; i < R; ++i){
        for(int j = 0; j < C; ++j){
            if(i == R-1 && j == 0) cout << "S";
            else if(i == R-2 && j == C-1) cout << "E";
            else if(j == idx && idx >= 1 && idx == R-1-i){cout << "#"; --idx;}
            else cout << ".";
        }
        cout << endl;
    }
}