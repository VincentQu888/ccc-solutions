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
const int MM = 2e5+5;
ll dp[MM], C;
int h[MM], N;
deque<int> q;

double slope(int k, int j){
    return (double)((dp[j] + (ll)h[j]*h[j]) - (dp[k] + (ll)h[k]*h[k])) / (2*(h[j] - h[k])); 
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> C;
    fill(dp, dp+MM, LINF); dp[1] = 0; 
    cin >> h[1]; q.push_back(1); 
    for(int i = 2; i <= N; ++i){
        cin >> h[i];
        while(q.size() >= 2 && h[i] >= slope(q[0], q[1])) q.pop_front();
        dp[i] = dp[q.front()] + C + (ll)(h[i]-h[q.front()])*(h[i]-h[q.front()]);
        while(q.size() >= 2 && slope(q[q.size()-2], q.back()) >= slope(q.back(), i)) q.pop_back();
        q.push_back(i); 
    }
    cout << dp[N] << "\n";
}