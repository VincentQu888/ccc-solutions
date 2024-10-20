#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, ll> pl;

const int MM = 1e5+2;
struct node {int l, r, v;} seg[4*MM];
ll arr[MM]; 

void build(int l, int r, int idx){
    seg[idx].l = l; seg[idx].r = r;
    if(l == r){
        seg[idx].v = arr[l]; 
        return;  
    } 
    int mid = (l+r)/2;
    build(l, mid, 2*idx); build(mid+1, r, 2*idx+1);

    seg[idx].v = seg[2*idx].v & seg[2*idx+1].v;
}

void update(int pos, int val, int idx){
    if(seg[idx].l == seg[idx].r){
        seg[idx].v = val; 
        return; 
    }
    int mid = (seg[idx].l + seg[idx].r)/2;

    pos <= mid ? update(pos, val, 2*idx) : update(pos, val, 2*idx+1);
    seg[idx].v = seg[2*idx].v & seg[2*idx+1].v;
}

ll query(int l, int r, int idx){
    if(seg[idx].l == l && seg[idx].r == r) return seg[idx].v;

    int mid = (seg[idx].l + seg[idx].r)/2;
    if(r <= mid) return query(l, r, 2*idx);
    if(l > mid) return query(l, r, 2*idx+1);

    return query(l, mid, 2*idx) & query(mid+1, r, 2*idx+1);
}

int main(){
    ios::sync_with_stdio(0); 
    cin.tie(0);
    
    int N, Q;
    cin >> N >> Q;

    for(int i = 0; i < N; i++) cin >> arr[i];
    build(0, N-1, 1);

    for(int i = 0; i < Q; ++i) {
        char cmd; ll x, y, z;
        cin >> cmd >> x >> y;

        if(cmd == 'U') update(x-1, y, 1);
        else{
            cin >> z;
            cout << (z&query(x-1, y-1, 1)) << "\n";
        } 
    }
}