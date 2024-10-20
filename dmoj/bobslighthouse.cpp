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
int N, h[MM], l[MM], r[MM];
deque<int> q;
int slopel(int k, int j){
    int l = j, r = 1e9, ret = 1e9;
    while(l <= r){
        int mid = (l+r)/2;
        if(h[k] + sqrt(abs(mid-k)) < h[j] + sqrt(abs(mid-j))){
            ret = mid;
            r = mid-1;
        } 
        else l = mid+1;
    }
    return ret;
}
int sloper(int k, int j){
    int l = -1e9, r = j, ret = -1e9;
    while(l <= r){
        int mid = (l+r)/2;
        if(h[k] + sqrt(abs(mid-k)) < h[j] + sqrt(abs(mid-j))){
            ret = mid;
            l = mid+1;
        }
        else r = mid-1;
    }
    return ret;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    l[0] = 0; r[N-1] = 0;
    q.push_back(0);
    cin >> h[0];
    for(int i = 1; i < N; ++i){
        cin >> h[i];
        while(q.size() >= 2 && i >= slopel(q[0], q[1])) q.pop_front();
        int j = q.front(); 
        l[i] = ceil(h[j] + sqrt(abs(i-j)));
        if(h[i] > h[q.back()]){
            while(q.size() >= 2 && slopel(q[q.size()-2], q.back()) >= slopel(q.back(), i)) q.pop_back();
            q.push_back(i);
        }
    }
    q.clear(); q.push_back(N-1);
    for(int i = N-2; i >= 0; --i){
        while(q.size() >= 2 && i <= sloper(q[0], q[1])) q.pop_front();
        int j = q.front();
        r[i] = ceil(h[j] + sqrt(abs(i-j)));
        if(h[i] > h[q.back()]){
            while(q.size() >= 2 && sloper(q[q.size()-2], q.back()) <= sloper(q.back(), i)) q.pop_back();
            q.push_back(i);
        }
    }
    for(int i = 0; i < N; ++i) cout << max(max(l[i], r[i]) - h[i], 0) << "\n";
}
