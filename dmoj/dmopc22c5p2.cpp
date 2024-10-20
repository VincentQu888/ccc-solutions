#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 2e5+5;
int N; ll pprev = 0, nprev = 0;
vector<int> signs;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N;
    if(N%2 == 0){
        for(int i = 0; i < N; ++i){
            if(i%4 == 0) cout << 0 << " ";
            if(i%4 == 1){cout << -(pprev+1) << " "; nprev = pprev+1;}
            if(i%4 == 2) cout << -1 << " ";
            if(i%4 == 3){cout << nprev+2 << " "; pprev = nprev+2;}
        }
    }else{
        for(int i = 0; i < N; ++i){
            if(i%4 == 0) {cout << nprev+2 << " "; pprev = nprev+2;}
            if(i%4 == 1) cout << 0 << " ";
            if(i%4 == 2) {cout << -(pprev+1) << " "; nprev = pprev+1;}
            if(i%4 == 3) cout << -1 << " ";
        }
    }
}

