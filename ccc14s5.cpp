#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N;

    vector<array<int, 3>> points; 
    int x[N+1], y[N+1], dist[N+1], temp[N+1], dp[N+1];
    fill(x, x+N+1, 0); fill(y, y+N+1, 0); fill(dist, dist+N+1, 0); fill(temp, temp+N+1, 0); fill(dp, dp+N+1, 0); 

    for(int i = 1; i <= N; ++i) cin >> x[i] >> y[i];
    for(int i = 0; i <= N; ++i){
        for(int j = i+1; j <= N; ++j){
            points.push_back({(x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]), i, j});
        }
    }
    sort(points.begin(), points.end());

    for(const auto& point : points){
        int d = point[0], i = point[1], j = point[2];

        if(d > dist[i]){
            dist[i] = d; 
            temp[i] = dp[i];
        }
        if(d > dist[j]){
            dist[j] = d;
            temp[j] = dp[j];
        }
        if(i != 0) dp[j] = max(dp[j], temp[i]+1);
        dp[i] = max(dp[i], temp[j]+1);
    }

    cout << dp[0] << "\n";
}