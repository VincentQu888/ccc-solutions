#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
#define int long long
const int MM = 262144+5;
int N, a[MM], seen[MM], val; pii seg[4*MM], segs[4*MM];;
pii f(int l, int r, int idx){
    if(l == r) return seg[idx] = {0, a[l]};
    int mid = (l+r)/2;
    pii left = f(l, mid, 2*idx), right = f(mid+1, r, 2*idx+1);
    pii ret = {left.first+right.first + (left.second-right.second)*(left.second-right.second), max(left.second, right.second)};
    seg[idx] = ret;
    return ret;
}
pii h(int l, int r, int idx){
    if(l == r && l == 0) return segs[idx] = {0, 0};
    if(l == r) return segs[idx] = {0, a[l-1]};
    int mid = (l+r)/2;
    pii left = h(l, mid, 2*idx), right = h(mid+1, r, 2*idx+1);
    pii ret = {left.first+right.first + (left.second-right.second)*(left.second-right.second), max(left.second, right.second)};
    segs[idx] = ret;
    return ret;
}
pii g(int l, int r, int i, int idx){
    if(l == r) return {0, val};
    int mid = (l+r)/2;
    pii left, right;
    if(i <= mid){left = g(l, mid, i, 2*idx); right = segs[2*idx+1];}
    else{left = seg[2*idx]; right = g(mid+1, r, i, 2*idx+1);}
    return {left.first+right.first + (left.second-right.second)*(left.second-right.second), max(left.second, right.second)};
}
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i = 0; i < N-1; ++i){
        cin >> a[i];
        seen[a[i]] = 1;
    }
    for(int i = 1; i <= N; ++i){
        if(!seen[i]){
            val = i;
            break;
        }
    }
    f(0, N-1, 1); h(0, N-1, 1);
    g(0, N-1, 3, 1);
    for(int i = 0; i < N; ++i) cout << g(0, N-1, i, 1).first << " ";
}