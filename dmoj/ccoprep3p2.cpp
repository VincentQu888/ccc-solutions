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
const int MM = 2e6+5; 
ll N, L, psa[MM], dp[MM];
deque<ll> q;

double slope(int k, int j){
    return (double)((dp[j] + (psa[j]+L)*(psa[j]+L)) - (dp[k] + (psa[k]+L)*(psa[k]+L))) / (2*(psa[j]-psa[k]));
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> L; ++L;
    for(int i = 1; i <= N; ++i){
        cin >> psa[i];
        psa[i] += psa[i-1]+1;
    }
    fill(dp, dp+MM, LINF); dp[0] = 0; q.push_back(0);
    for(int i = 1; i <= N; ++i){
        while(q.size() >= 2 && psa[i] >= slope(q[0], q[1])) q.pop_front();
        dp[i] = dp[q.front()] + (psa[i]-psa[q.front()]-L)*(psa[i]-psa[q.front()]-L);
        while(q.size() >= 2 && slope(q[q.size()-2], q.back()) >= slope(q.back(), i)) q.pop_back();
        q.push_back(i);
    }
    cout << dp[N] << "\n";
}