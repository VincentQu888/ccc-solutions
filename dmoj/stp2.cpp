#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, ll> pl;

const int MM = 2e5+2;
struct node{int l, r, v, idx;} seg[3*MM];
int N, M, arr[MM]; 

void build(int l, int r, int idx){
    seg[idx].l = l; seg[idx].r = r;
    if(l == r){
        seg[idx].v = arr[l]; 
        seg[idx].idx = l; 
        return;  
    } 
    int mid = (l+r)/2;
    build(l, mid, 2*idx); build(mid+1, r, 2*idx+1);

    if(seg[2*idx].v <= seg[2*idx+1].v){
        seg[idx].v = seg[2*idx].v;
        seg[idx].idx = seg[2*idx].idx;
    }else{
        seg[idx].v = seg[2*idx+1].v;
        seg[idx].idx = seg[2*idx+1].idx;
    }
}

void update(int pos, int val, int idx){
    if(seg[idx].l == seg[idx].r){
        seg[idx].v = val; 
        seg[idx].idx = seg[idx].l; 
        return; 
    }
    int mid = (seg[idx].l + seg[idx].r)/2;

    pos <= mid ? update(pos, val, 2*idx) : update(pos, val, 2*idx+1);
    if(seg[2*idx].v <= seg[2*idx+1].v){
        seg[idx].v = seg[2*idx].v;
        seg[idx].idx = seg[2*idx].idx;
    }else{
        seg[idx].v = seg[2*idx+1].v;
        seg[idx].idx = seg[2*idx+1].idx;
    }
}

node query(int l, int r, int idx){
    if(seg[idx].l == l && seg[idx].r == r) return seg[idx];

    int mid = (seg[idx].l + seg[idx].r)/2;
    if(r <= mid) return query(l, r, 2*idx);
    if(l > mid) return query(l, r, 2*idx+1);

    if(query(l, mid, 2*idx).v <= query(mid+1, r, 2*idx+1).v) return query(l, mid, 2*idx);
    else return query(mid+1, r, 2*idx+1);
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i = 0; i < N; ++i) cin >> arr[i];
    build(0, N-1, 1);

    for(int i = 0; i < M; ++i) {
        char cmd; int x, y;
        cin >> cmd >> x >> y;

        if(cmd == 'U') update(x-1, y, 1);
        else cout << query(x-1, y-1, 1).v << " " << query(x-1, y-1, 1).idx+1 << "\n";
    }
}