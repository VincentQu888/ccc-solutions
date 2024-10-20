#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

const int MM = 1e5+2;
int sl[3*MM], sr[3*MM], smin[3*MM], sgcd[3*MM], freq[3*MM];
int arr[MM]; 

void build(int l, int r, int idx){
    sl[idx] = l; sr[idx] = r;
    if(l == r){
        smin[idx] = arr[l]; 
        sgcd[idx] = arr[l]; 
        freq[idx] = 1;
        return;  
    } 
    int mid = (l+r)/2;
    build(l, mid, 2*idx); build(mid+1, r, 2*idx+1);

    smin[idx] = min(smin[2*idx], smin[2*idx+1]);
    sgcd[idx] = gcd(sgcd[2*idx], sgcd[2*idx+1]);
    
    for(int i = l; i <= r; ++i) if(arr[i] == sgcd[idx]) ++freq[idx];
}

void update(int pos, int val, int oldVal, int idx){
    if(sl[idx] == sr[idx]){
        smin[idx] = val;
        sgcd[idx] = val; 
        return; 
    }
    int mid = (sl[idx] + sr[idx])/2;
    int oldGCD = sgcd[idx];

    pos <= mid ? update(pos, val, oldVal, 2*idx) : update(pos, val, oldVal, 2*idx+1);
    smin[idx] = min(smin[2*idx], smin[2*idx+1]);
    sgcd[idx] = gcd(sgcd[2*idx], sgcd[2*idx+1]);

    if(oldGCD != sgcd[idx]){
        freq[idx] = 0;
        for(int i = sl[idx]; i <= sr[idx]; ++i) if(arr[i] == sgcd[idx]) ++freq[idx];
    }
    else if(val == sgcd[idx] && oldVal != val) ++freq[idx];
    else if(val != sgcd[idx] && oldVal == sgcd[idx]) --freq[idx];
}

int queryMin(int l, int r, int idx){
    if(sl[idx] == l && sr[idx] == r) return smin[idx];

    int mid = (sl[idx] + sr[idx])/2;
    if(r <= mid) return queryMin(l, r, 2*idx);
    if(l > mid) return queryMin(l, r, 2*idx+1);

    return min(queryMin(l, mid, 2*idx), queryMin(mid+1, r, 2*idx+1));
}

int queryGCD(int l, int r, int idx){
    if(sl[idx] == l && sr[idx] == r) return sgcd[idx];

    int mid = (sl[idx] + sr[idx])/2;
    if(r <= mid) return queryGCD(l, r, 2*idx);
    if(l > mid) return queryGCD(l, r, 2*idx+1);

    return gcd(queryGCD(l, mid, 2*idx), queryGCD(mid+1, r, 2*idx+1));
}

int queryFreq(int l, int r, int val, int idx){
    if(sl[idx] == l && sr[idx] == r) return sgcd[idx] == val ? freq[idx] : 0;

    int mid = (sl[idx] + sr[idx])/2;
    if(r <= mid) return queryFreq(l, r, val, 2*idx);
    if(l > mid) return queryFreq(l, r, val, 2*idx+1);

    return queryFreq(l, mid, val, 2*idx) + queryFreq(mid+1, r, val, 2*idx+1);
}

int main(){
    ios::sync_with_stdio(0); 
    cin.tie(0);

    int N, M;
    cin >> N >> M;

    for(int i = 0; i < N; ++i) cin >> arr[i];
    build(0, N-1, 1);

    for(int i = 0; i < M; ++i) {
        char cmd; int l, r;
        cin >> cmd >> l >> r;
        --l; --r;

        if(cmd == 'C'){
            ++r;
            int old = arr[l];
            arr[l] = r;
            update(l, r, old, 1);
        }else if(cmd == 'M'){
            cout << queryMin(l, r, 1) << "\n";
        }else if(cmd == 'G'){
            cout << queryGCD(l, r, 1) << "\n";
        }else{
            int gcd = queryGCD(l, r, 1);
            cout << queryFreq(l, r, gcd, 1) << "\n";
        }
    }
}