#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define int long long
#define pii pair<int, int>
#define inf 9e18
const int MM = 1e5+5;
int arr[MM], seg[4*MM], lazy[4*MM], type[4*MM]; 

void build(int l, int r, int idx){
    if(l > r) return;
    if(l == r){
        seg[idx] = arr[l];
        return;  
    } 
    build(l, (l+r)/2, 2*idx); build((l+r)/2+1, r, 2*idx+1);

    seg[idx] = min(seg[2*idx], seg[2*idx+1]);
    lazy[idx] = 0; type[idx] = 0;
}

void increment(int i, int j, int l, int r, int val, int idx){
    if(lazy[idx] != 0){
        if(type[idx] == 0){
            seg[idx] += lazy[idx];
            if(l != r){
                lazy[2*idx] += lazy[idx]; 
                lazy[2*idx+1] += lazy[idx];
            }
            lazy[idx] = 0;
        }else{
            seg[idx] = lazy[idx];
            if(l != r){
                lazy[2*idx] = lazy[idx]; lazy[2*idx+1] = lazy[idx];
                type[2*idx] = 1; type[2*idx+1] = 1;
            }
            lazy[idx] = 0;
            type[idx] = 0;
        }
    }

    if(r < i || l > j || l > r) return;
    if(i <= l && r <= j){
        seg[idx] += val;
        if(l != r){
            lazy[2*idx] += val; 
            lazy[2*idx+1] += val; 
        }
        return;
    }

    increment(i, j, l, (l+r)/2, val, 2*idx); increment(i, j, (l+r)/2+1, r, val, 2*idx+1);
    seg[idx] = min(seg[2*idx], seg[2*idx+1]); 
}

void sset(int i, int j, int l, int r, int val, int idx){
    if(lazy[idx] != 0){
        if(type[idx] == 0){
            seg[idx] += lazy[idx];
            if(l != r){
                lazy[2*idx] += lazy[idx]; 
                lazy[2*idx+1] += lazy[idx];
            }
            lazy[idx] = 0;
        }else{
            seg[idx] = lazy[idx];
            if(l != r){
                lazy[2*idx] = lazy[idx]; lazy[2*idx+1] = lazy[idx];
                type[2*idx] = 1; type[2*idx+1] = 1;
            }
            lazy[idx] = 0;
            type[idx] = 0;
        }
    }

    if(r < i || l > j || l > r) return;
    if(i <= l && r <= j){
        seg[idx] = val;
        if(l != r){
            lazy[2*idx] = val; lazy[2*idx+1] = val; 
            type[2*idx] = 1; type[2*idx+1] = 1;
        }
        return; 
    }

    sset(i, j, l, (l+r)/2, val, 2*idx); sset(i, j, (l+r)/2+1, r, val, 2*idx+1);
    seg[idx] = min(seg[2*idx], seg[2*idx+1]); 
}

ll query(int i, int j, int l, int r, int idx){
    if(l > r || l > j || r < i) return inf;

    if(lazy[idx] != 0){
        if(type[idx] == 0){
            seg[idx] += lazy[idx];
            if(l != r){
                lazy[2*idx] += lazy[idx]; 
                lazy[2*idx+1] += lazy[idx];
            }
            lazy[idx] = 0;
        }else{
            seg[idx] = lazy[idx];
            if(l != r){
                lazy[2*idx] = lazy[idx]; lazy[2*idx+1] = lazy[idx];
                type[2*idx] = 1; type[2*idx+1] = 1;
            }
            lazy[idx] = 0;
            type[idx] = 0;
        }
    }

    if(i <= l && r <= j) return seg[idx];
	return min(query(i, j, l, (l+r)/2, 2*idx), query(i, j, (l+r)/2+1, r, 2*idx+1));
}

signed main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, Q;
    cin >> N >> Q;

    for(int i = 0; i < N; ++i) cin >> arr[i];
    build(0, N-1, 1);

    for(int i = 0; i < Q; ++i){
        int cmd, l, r, v;
        cin >> cmd >> l >> r;
        --l; --r;

        if(cmd == 1){
            cin >> v;
            increment(l, r, 0, N-1, v, 1);
        }else if(cmd == 2){
            cin >> v;
            sset(l, r, 0, N-1, v, 1);
        }else{
            cout << query(l, r, 0, N-1, 1) << "\n";
        }
    }
}