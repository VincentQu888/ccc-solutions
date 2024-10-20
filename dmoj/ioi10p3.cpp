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
const int MM = 4005; //3000 doesnt work LOL
int R, C, H, W, Q[MM][MM];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> R >> C >> H >> W;
    for(int i = 0; i < R; ++i){
        for(int j = 0; j < C; ++j) cin >> Q[i][j];
    }
    int lo = 1, hi = R*C, last = 1;
    while(lo <= hi){
        int mid = (lo+hi)/2, temp[MM][MM], psa[MM][MM];
        bool flag = false;
        memset(psa, 0, sizeof(psa));
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                temp[i][j] = Q[i][j] > mid ? 1 : -1;
                psa[i+1][j+1] = psa[i+1][j] + psa[i][j+1] + temp[i][j] - psa[i][j];
            }
        }
        for(int i = 1; i+H-1 <= R; ++i){
            for(int j = 1; j+W-1 <= C; ++j){
                if(psa[i+H-1][j+W-1] - psa[i-1][j+W-1] - psa[i+H-1][j-1] + psa[i-1][j-1] < 0){
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            hi = mid-1;
            last = mid;
        }else lo = mid+1;
    }
    cout << last << endl;
}