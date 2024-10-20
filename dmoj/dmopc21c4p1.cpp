#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

const int MM = 3e3+5;
ll triangles[MM][6];

int query(ll triangle[], ll x, ll y){
    ll ta = (ll)abs(triangle[0]*triangle[3] - triangle[1]*triangle[2] + triangle[2]*triangle[5] - triangle[3]*triangle[4] + triangle[4]*triangle[1] - triangle[5]*triangle[0]);
    
    ll oa = 0;
    for(int i = 0, j = 2; j < 6; i += 2, j += 2){
        oa += (ll)abs(x*triangle[i+1] - y*triangle[i] + triangle[i]*triangle[j+1] - triangle[i+1]*triangle[j] + triangle[j]*y - triangle[j+1]*x);
    }
    int i = 4, j = 0;
    oa += (ll)abs(x*triangle[i+1] - y*triangle[i] + triangle[i]*triangle[j+1] - triangle[i+1]*triangle[j] + triangle[j]*y - triangle[j+1]*x); 

    if(ta == oa) return 1;
    else return 0;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, Q;
    cin >> N >> Q;
    
    for(int i = 0; i < N; ++i){
        cin >> triangles[i][0] >> triangles[i][1] >> triangles[i][2] >> triangles[i][3] >> triangles[i][4] >> triangles[i][5];
    }

    for(int i = 0; i < Q; ++i){
        ll x, y, ans = 0;
        cin >> x >> y;

        for(int j = 0; j < N; ++j){
            ans += query(triangles[j], x, y);
        }
        cout << ans << "\n";
    }
}