#include <bits/stdc++.h>
using namespace std;
#define ll long long

const ll MM = 2e5+5;
struct node {ll l, r, v;} seg[3*MM];
ll N, Q, arr[MM]; 

void build(ll l, ll r, ll idx){
    seg[idx].l = l; seg[idx].r = r;
    if(l == r){
        seg[idx].v = arr[l]; 
        return;  
    } 
    ll mid = (l+r)/2;
    build(l, mid, 2*idx); build(mid+1, r, 2*idx+1);

    seg[idx].v = seg[2*idx].v + seg[2*idx+1].v;
}

void update(ll pos, ll val, ll idx){
    if(seg[idx].l == seg[idx].r){
        seg[idx].v = val; 
        return; 
    }
    ll mid = (seg[idx].l + seg[idx].r)/2;

    pos <= mid ? update(pos, val, 2*idx) : update(pos, val, 2*idx+1);
    seg[idx].v = seg[2*idx].v + seg[2*idx+1].v;
}

ll query(ll l, ll r, ll idx){
    if(seg[idx].l == l && seg[idx].r == r) return seg[idx].v;

    ll mid = (seg[idx].l + seg[idx].r)/2;
    if(r <= mid) return query(l, r, 2*idx);
    if(l > mid) return query(l, r, 2*idx+1);

    return query(l, mid, 2*idx) + query(mid+1, r, 2*idx+1);
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> N >> Q;
    for(ll i = 0; i < N; ++i) cin >> arr[i];
    build(0, N-1, 1);

    for(ll i = 0; i < Q; ++i) {
        char cmd; ll x, y;
        cin >> cmd >> x >> y;

        if(cmd == 'U') update(x-1, y, 1);
        else cout << query(x-1, y-1, 1) << "\n";
    }
}