#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 2e5+5; int M;
ll arr[MM], seg[4*MM], lazy[4*MM]; 

void build(int l, int r, int idx){
    if(l > r) return;
    if(l == r){
        seg[idx] = arr[l]; seg[idx] %= M;
        return;  
    } 
    build(l, (l+r)/2, 2*idx); build((l+r)/2+1, r, 2*idx+1);

    seg[idx] = seg[2*idx]%M + seg[2*idx+1]%M; seg[idx] %= M;
    lazy[idx] = 0;
}

void update(int i, int j, int l, int r, int val, int idx){
    if(lazy[idx] != 0){
        seg[idx] += lazy[idx]%M*(r-l+1)%M; seg[idx] %= M;
        if(l != r){
            lazy[2*idx] += lazy[idx]%M; lazy[2*idx+1] += lazy[idx]%M;
            lazy[2*idx] %= M; lazy[2*idx+1] %= M;
        }
        lazy[idx] = 0;
    }

    if(r < i || l > j || l > r) return;
    if(i <= l && r <= j){
        seg[idx] += val%M*(r-l+1)%M; seg[idx] %= M;
        if(l != r){
            lazy[2*idx] += val%M; lazy[2*idx+1] += val%M; 
            lazy[2*idx] %= M; lazy[2*idx+1] %= M;
        }
        return;
    }

    update(i, j, l, (l+r)/2, val, 2*idx); update(i, j, (l+r)/2+1, r, val, 2*idx+1);
    seg[idx] = seg[2*idx]%M + seg[2*idx+1]%M; seg[idx] %= M;
}

ll query(int i, int j, int l, int r, int idx){
    if(l > r || l > j || r < i) return 0;

    if(lazy[idx] != 0){
        seg[idx] += lazy[idx]%M*(r-l+1)%M; seg[idx] %= M;
        if(l != r){
            lazy[2*idx] += lazy[idx]%M; lazy[2*idx+1] += lazy[idx]%M; 
            lazy[2*idx] %= M; lazy[2*idx+1] %= M;
        }
        lazy[idx] = 0;
    }

    if(i <= l && r <= j) return seg[idx];
	return query(i, j, l, (l+r)/2, 2*idx) + query(i, j, (l+r)/2+1, r, 2*idx+1);
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, Q;
    cin >> M >> N >> Q;

    for(int i = 0; i < N; ++i) cin >> arr[i];
    build(0, N-1, 1);

    for(int i = 0; i < Q; ++i){
        int cmd, l, r, x;
        cin >> cmd >> l >> r;
        --l; --r;

        if(cmd == 2) cout << query(l, r, 0, N-1, 1)%M << "\n";
        else{
            cin >> x;
            update(l, r, 0, N-1, x, 1);
        }
    }
}