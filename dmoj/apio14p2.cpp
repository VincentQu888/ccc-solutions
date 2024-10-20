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
const int MM = 1e5+5;
ll dp[2][MM]; 
int point[205][MM], a[MM], psa[MM], n, k;
stack<int> ans;

double slope(int k, int j){
    if(psa[j] == psa[k]) return 0;
    return (double)(dp[0][j] - (ll)psa[j]*psa[j] - dp[0][k] + (ll)psa[k]*psa[k]) / (psa[k] - psa[j]);
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n >> k; 
    psa[0] = 0;
    for(int i = 1; i <= n; ++i){
        cin >> a[i]; 
        psa[i] = a[i] + psa[i-1];
    }
    fill(dp[0], dp[0]+MM, 0);
    for(int i = 1; i <= k; ++i){
        deque<int> q; q.push_back(1);
        dp[0][1] = 0; dp[1][1] = 0;
        for(int j = 2; j <= n; ++j){
            while(q.size() >= 2 && psa[j] >= slope(q[0], q[1])) q.pop_front();
            dp[1][j] = dp[0][q.front()] + (ll)psa[q.front()]*(psa[j]-psa[q.front()]); 
            point[i][j] = q.front();
            while(q.size() >= 2 && slope(q[q.size()-2], q.back()) >= slope(q.back(), j)) q.pop_back();
            q.push_back(j);
        } 
        for(int j = 1; j <= n; ++j) dp[0][j] = dp[1][j];
    }
    for(int i = k, last = n; i >= 1; --i){
        last = point[i][last];
        ans.push(last);
    }
    cout << dp[0][n] << "\n";
    while(!ans.empty()){
        cout << ans.top() << " "; 
        ans.pop();
    }
}