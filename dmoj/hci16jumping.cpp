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
const int MM = 2005;
int N, C, a[MM][MM];
ll dp[MM][MM];

double slope(int k, int j, int col){
    return (double)(dp[j][col-1] + j*j - (dp[k][col-1] + k*k)) / (2*(j-k));
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> C;
    for(int i = 0; i < C; ++i){
        string input; cin >> input;
        for(int j = 0; j < N; ++j){
            a[i][j] = (int)input[j] - '0';
        }
    }
    for(int i = 0; i < C; ++i) dp[i][0] = 0;
    for(int j = 1; j < N; ++j){
        deque<int> q;
        for(int i = 0; i < C; ++i){
            if(a[i][j-1] == 1){
                while(q.size() >= 2 && slope(q[q.size()-2], q.back(), j) >= slope(q.back(), i, j)) q.pop_back();
                q.push_back(i);
            } 
        }
        for(int i = 0; i < C; ++i){
            if(a[i][j] == 0){dp[i][j] = LINF; continue;}
            while(q.size() >= 2 && dp[q[0]][j-1] + (i-q[0])*(i-q[0]) >= dp[q[1]][j-1] + (i-q[1])*(i-q[1])) q.pop_front();
            dp[i][j] = dp[q[0]][j-1] + (i-q[0])*(i-q[0]);
        }
    }
    ll ans = LINF;
    for(int i = 0; i < C; ++i) ans = min(ans, dp[i][N-1]);
    cout << ans << "\n";
}