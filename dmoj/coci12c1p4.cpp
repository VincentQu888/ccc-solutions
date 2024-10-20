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
int N, M, arr[300005];
bool check(int envy){
    int tot = 0;
    for(int nxt : arr) tot += ceil((double)nxt/envy);
    if(tot > N) return false;
    return true;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i = 0; i < M; ++i) cin >> arr[i];
    int lo = 0, hi = 1e9, ans = 0;
    while(lo <= hi){
        int mid = (lo+hi)/2;
        if(check(mid)){ans = mid, hi = mid-1;}
        else lo = mid+1;
    }
    cout << ans;
}