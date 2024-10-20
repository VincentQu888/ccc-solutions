#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

const int MM = 1e5+2, LOG = log2(MM)+2;
int stmin[MM][20], stmax[MM][20]; pii strit[MM][20];

int querymax(int L, int R){
    if(L > R) swap(L, R);
    int j = (int)log2(R - L + 1);
 
    if(stmax[L][j] >= stmax[R - (1 << j) + 1][j]) return stmax[L][j];
    else return stmax[R - (1 << j) + 1][j];
}

int querymin(int L, int R){
    if(L > R) swap(L, R);
    int j = (int)log2(R - L + 1);
 
    if(stmin[L][j] <= stmin[R - (1 << j) + 1][j]) return stmin[L][j];
    else return stmin[R - (1 << j) + 1][j];
}

pii queryrit(int L, int R){
    if(L > R) swap(L, R);
    int j = (int)log2(R - L + 1);
 
    if(strit[L][j].second - strit[L][j].first >= strit[R - (1 << j) + 1][j].second - strit[R - (1 << j) + 1][j].first) return strit[L][j];
    else return strit[R - (1 << j) + 1][j];
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, K;
    cin >> N >> K;
    
    int lights[N];
    for(int i = 0; i < N; ++i){
        cin >> lights[i];
    }


    for(int i = 0; i < N; ++i) {
        stmin[i][0] = lights[i];
        stmax[i][0] = lights[i];
    }
    for(int j = 1; j <= log2(N); ++j) {
        for(int i = 0; i + (1 << j) - 1 <= N; i++) {
            if(stmin[i][j - 1] < stmin[i + (1 << (j - 1))][j - 1]) stmin[i][j] = stmin[i][j - 1];
            else stmin[i][j] = stmin[i + (1 << (j - 1))][j - 1];

            if(stmax[i][j - 1] > stmax[i + (1 << (j - 1))][j - 1]) stmax[i][j] = stmax[i][j - 1];
            else stmax[i][j] = stmax[i + (1 << (j - 1))][j - 1];
        }
    }

    int lft[N], rit[N];
    for(int l = 0, r = 0; l < N;){
        if(r < N && querymax(l, r) - querymin(l, r) <= K) ++r;
        else{
            lft[l] = r-1;
            ++l;
        }
    }
    for(int l = N-1, r = N-1; r >= 0;){
        if(l >= 0 && querymax(l, r) - querymin(l, r) <= K) --l;
        else{
            rit[r] = l+1;
            --r;
        }
    }


    for(int i = 0; i < N; ++i) {
        strit[i][0] = make_pair(rit[i], i);
    }
    for(int j = 1; j <= log2(N); ++j) {
        for(int i = 0; i + (1 << j) - 1 <= N; i++) {
            if(strit[i][j - 1].second - strit[i][j - 1].first >= strit[i + (1 << (j - 1))][j - 1].second - strit[i + (1 << (j - 1))][j - 1].first) strit[i][j] = strit[i][j - 1];
            else strit[i][j] = strit[i + (1 << (j - 1))][j - 1];
        }
    }


    int Q; cin >> Q;
    for(int i = 0; i < Q; ++i){
        int l, r; pii ans;
        cin >> l >> r;
        --l; --r;

        ans = queryrit(min(lft[l]+1, r), r);
        ans.first = max(ans.first, l);
        ans = ans.second-ans.first > min(lft[l], r)-l ? ans : make_pair(l, min(lft[l], r));

        cout << ans.first+1 << " " << ans.second+1 << "\n";
    }
}