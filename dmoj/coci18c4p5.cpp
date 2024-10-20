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
int N, K, cnt[MM];
deque<int> q;
pair<double, int> dp[MM];
double slope(int k, int j){
    return (dp[j].first - dp[k].first - (double)j/dp[j].second + (double)k/dp[k].second) / (1.0/dp[k].second - 1.0/dp[j].second);
}
pair<double, int> cht(double C){
    q.clear();
    dp[0] = {0.0, N}; cnt[0] = 0; q.push_back(0);
    for(int i = 1; i <= N; ++i){
        while(q.size() >= 2 && i >= slope(q[0], q[1])) q.pop_front();
        int j = q[0]; 
        dp[i] = {dp[j].first + (double)(i-j)/dp[j].second - C, dp[j].second - (i-j)};
        cnt[i] = cnt[j]+1;
        while(q.size() >= 2 && slope(q[q.size()-2], q.back()) >= slope(q.back(), i)) q.pop_back();
        q.push_back(i);
    }
    return {dp[N].first, cnt[N]};
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    double lo = 0, hi = 1e9;
    while(lo <= hi){
        double mid = (lo+hi)/2;
        pair<double, int> ret = cht(mid);
        if(ret.second == K){
            cout << setprecision(9) << ret.first + mid*K << endl;
            break;
        }
        else if(ret.second > K) lo = mid + 0.000000000000001;
        else hi = mid - 0.000000000000001;
    }
}


// dp[k].first + (i-k)/dp[k].second <= dp[j].first + (i-j)/dp[j].second
// (i-k)/dp[k].second - (i-j)/dp[j].second <= dp[j].first - dp[k].first
// i/dp[k].second - k/dp[k].second - i/dp[j].second + j/dp[j].second <= dp[j].first - dp[k].first
// i/dp[k].second - i/dp[j].second <= dp[j].first - dp[k].first - j/dp[j].second + k/dp[k].second
// i*(1/dp[k].second - 1/dp[j].second) <= dp[j].first - dp[k].first - j/dp[j].second + k/dp[k].second
// i >= (dp[j].first - dp[k].first - j/dp[j].second + k/dp[k].second) / (1/dp[k].second - 1/dp[j].second)