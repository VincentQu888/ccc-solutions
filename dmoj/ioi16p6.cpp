#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define int long long
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const int MM = 1e5+5;
int n, m, k, cnt[MM], dp[MM], rm[MM];
deque<int> q;
vector<pii> segs, temp;
double slope(int k, int j){
    if(k == 0) return (double)(dp[j] - dp[k] - max((ll)0, segs[j-1].second-segs[j].first+1)*max((ll)0, segs[j-1].second-segs[j].first+1) - segs[k].first*segs[k].first + 2*segs[k].first + segs[j].first*segs[j].first - 2*segs[j].first) / (2*(segs[j].first - segs[k].first));
    return (double)(dp[j] - dp[k] - max((ll)0, segs[j-1].second-segs[j].first+1)*max((ll)0, segs[j-1].second-segs[j].first+1) + max((ll)0, segs[k-1].second-segs[k].first+1)*max((ll)0, segs[k-1].second-segs[k].first+1) - segs[k].first*segs[k].first + 2*segs[k].first + segs[j].first*segs[j].first - 2*segs[j].first) / (2*(segs[j].first - segs[k].first));
}
pair<int, int> cht(int C){
    q.clear();
    dp[0] = 0; cnt[0] = 0; q.push_back(0);
    for(int i = 1; i <= segs.size(); ++i){
        while(q.size() >= 2 && segs[i-1].second >= slope(q[0], q[1])) q.pop_front();
        int j = q[0]; 
        if(j > 0) dp[i] = dp[j] + (segs[i-1].second-segs[j].first+1)*(segs[i-1].second-segs[j].first+1) - max((ll)0, segs[j-1].second-segs[j].first+1)*max((ll)0, segs[j-1].second-segs[j].first+1) + C;
        else dp[i] = dp[j] + (segs[i-1].second-segs[j].first+1)*(segs[i-1].second-segs[j].first+1) + C;
        cnt[i] = cnt[j]+1;
        while(q.size() >= 2 && slope(q[q.size()-2], q.back()) >= slope(q.back(), i)) q.pop_back();
        q.push_back(i);
    }
    return {dp[segs.size()], cnt[segs.size()]};
}
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n >> m >> k;
    for(int i = 0, r, c; i < n; ++i){
        cin >> r >> c;
        temp.push_back({min(r, c), max(r, c)});
    }
    sort(temp.begin(), temp.end(), [](pii a, pii b){
        return a.first != b.first ? a.first < b.first : a.second > b.second;
    });
    rm[0] = 0; int last = 0;
    for(int i = 1; i < n; ++i){
        if(temp[i].second <= temp[last].second) rm[i] = 1;
        else{rm[i] = 0; last = i;}
    }
    for(int i = 0; i < n; ++i){
        if(!rm[i]) segs.push_back(temp[i]);
    }
    int lo = 0, hi = m*m+5, mid;
    while(lo <= hi){
        mid = (lo+hi)/2;
        pii ret1 = cht(mid), ret2 = cht(mid-1);
        if(ret1.second <= k && ret2.second >= k){
            if(ret1.second == ret2.second) cout << ret1.first - mid*k << endl;
            else{
                int y1 = ret1.first - ret1.second*mid;
                int y2 = ret2.first - ret2.second*(mid-1);
                cout << ((y1-y2) / (ret1.second-ret2.second)) * (k-ret1.second) + y1 << endl;
            }
            return 0;
        }
        else if(ret1.second > k) lo = mid+1;
        else hi = mid-1;
    }
    pii ret = cht(mid);
    cout << ret.first - mid*ret.second << endl;
}

// dp[k] + (segs[i-1].second-segs[k].first+1)^2 - max(0, segs[k-1].second-segs[k].first+1)^2 >= dp[j] + (segs[i-1].second-segs[j].first+1)^2 - max(0, segs[j-1].second-segs[j].first+1)^2
// (segs[i-1].second-segs[k].first+1)^2 - (segs[i-1].second-segs[j].first+1)^2 >= dp[j] - dp[k] - max(0, segs[j-1].second-segs[j].first+1)^2 + max(0, segs[k-1].second-segs[k].first+1)^2
// (r[i-1] - l[k] + 1)^2 - (r[i-1] - l[j] + 1)^2 >= dp[j] - dp[k] - max(0, segs[j-1].second-segs[j].first+1)^2 + max(0, segs[k-1].second-segs[k].first+1)^2
// r[i-1]^2 - 2*l[k]*r[i-1] + 2*r[i-1] + l[k]^2 - 2*l[k] + 1 - (r[i-1]^2 - 2*l[j]*r[i-1] + 2*r[i-1] + l[j]^2 - 2*l[j] + 1) >= dp[j] - dp[k] - max(0, segs[j-1].second-segs[j].first+1)^2 + max(0, segs[k-1].second-segs[k].first+1)^2
// r[i-1]^2 - 2*l[k]*r[i-1] + 2*r[i-1] + l[k]^2 - 2*l[k] + 1 - r[i-1]^2 + 2*l[j]*r[i-1] - 2*r[i-1] - l[j]^2 + 2*l[j] - 1 >= dp[j] - dp[k] - max(0, segs[j-1].second-segs[j].first+1)^2 + max(0, segs[k-1].second-segs[k].first+1)^2
// - 2*l[k]*r[i-1] + l[k]^2 - 2*l[k] + 2*l[j]*r[i-1] - l[j]^2 + 2*l[j] >= dp[j] - dp[k] - max(0, segs[j-1].second-segs[j].first+1)^2 + max(0, segs[k-1].second-segs[k].first+1)^2
// - 2*l[k]*r[i-1] + 2*l[j]*r[i-1] >= dp[j] - dp[k] - max(0, segs[j-1].second-segs[j].first+1)^2 + max(0, segs[k-1].second-segs[k].first+1)^2 - l[k]^2 + 2*l[k] + l[j]^2 - 2*l[j]
// - 2*r[i-1]*(l[j]-l[k]) >= dp[j] - dp[k] - max(0, segs[j-1].second-segs[j].first+1)^2 + max(0, segs[k-1].second-segs[k].first+1)^2 - l[k]^2 + 2*l[k] + l[j]^2 - 2*l[j]
// r[i-1] >= (dp[j] - dp[k] - max(0, segs[j-1].second-segs[j].first+1)^2 + max(0, segs[k-1].second-segs[k].first+1)^2 - l[k]^2 + 2*l[k] + l[j]^2 - 2*l[j]) / (2*(l[j] - l[k]))