#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

const int MM = 3e7;
struct node {ll l, r, s, m;} seg[MM];
ll cnt = 1;

void update(ll pos, ll val, ll l, ll r, ll idx){
    if(l == r){
        seg[idx].s = seg[idx].m = val; 
        return; 
    }
    ll mid = (l + r)/2;

    if(pos <= mid){
        if(seg[idx].l == 0) seg[idx].l = ++cnt;
        update(pos, val, l, mid, seg[idx].l);
    }else{
        if(seg[idx].r == 0) seg[idx].r = ++cnt;
        update(pos, val, mid+1, r, seg[idx].r);
    } 

    seg[idx].s = seg[seg[idx].l].s + seg[seg[idx].r].s;
    seg[idx].m = max(seg[seg[idx].l].m, seg[seg[idx].r].m);
}

ll querysum(ll i, ll j, ll l, ll r, ll idx){
    if(l == i && r == j) return seg[idx].s;

    ll mid = (l + r)/2;
    if(j <= mid) return querysum(i, j, l, mid, seg[idx].l);
    if(i > mid) return querysum(i, j, mid+1, r, seg[idx].r);

    return querysum(i, mid, l, mid, seg[idx].l) + querysum(mid+1, j, mid+1, r, seg[idx].r);
}

ll querymax(ll i, ll j, ll l, ll r, ll idx){
    if(l == i && r == j) return seg[idx].m;

    ll mid = (l + r)/2;
    if(j <= mid) return querymax(i, j, l, mid, seg[idx].l);
    if(i > mid) return querymax(i, j, mid+1, r, seg[idx].r);

    return max(querymax(i, mid, l, mid, seg[idx].l), querymax(mid+1, j, mid+1, r, seg[idx].r));
}

int main(){
    ios::sync_with_stdio(0); 
    cin.tie(0);

    ll N, Q;
    cin >> N >> Q;

    ll prev = 0;
    for(int i = 0; i < Q; ++i) {
        char cmd; ll x, y;
        cin >> cmd >> x >> y;
        x = x^prev; y = y^prev;
        --x;

        if(cmd == 'C') update(x, y, 0, N-1, 1);
        if(cmd == 'S'){
            --y;
            prev = querysum(x, y, 0, N-1, 1);
            cout << prev << "\n";
        } 
        if(cmd == 'M'){
            --y;
            prev = querymax(x, y, 0, N-1, 1);
            cout << prev << "\n";
        } 
    }
}