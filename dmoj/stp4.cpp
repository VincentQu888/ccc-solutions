#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 2e5+5;
struct query{int l, r, idx;};
int bit[MM], arr[MM], ans[MM], N, Q;
vector<query> queries;
unordered_map<int, vector<int>> duplicates;

void update(int pos, int val){
    for(int i = pos+1; i < MM; i += i & -i) {
        bit[i] += val;
    }
}

int sum(int pos) {
    ll ans = 0;

    for(int i = pos+1; i > 0; i -= i & -i) {
        ans += bit[i];
    }
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N >> Q;
    for(int i = 0; i < N; ++i){
        cin >> arr[i];
    }
    for(int i = 0, l, r; i < Q; ++i){
        cin >> l >> r;
        --l; --r;
        queries.push_back({l, r, i});
    }

    sort(queries.begin(), queries.end(), [](query a, query b){
        return a.r < b.r;
    });

    for(int i = 0; i <= queries[0].r; ++i){
        if(duplicates[arr[i]].size() == 0){
            update(i+1, 1);
            duplicates[arr[i]].push_back(i);
        }else if(duplicates[arr[i]].size() == 1){
            update(duplicates[arr[i]][0]+1, -2);
            update(i+1, 1);
            duplicates[arr[i]].push_back(i);
        }else if(duplicates[arr[i]].size() >= 2){
            update(duplicates[arr[i]][duplicates[arr[i]].size()-2]+1, 1);
            update(duplicates[arr[i]][duplicates[arr[i]].size()-1]+1, -2);
            update(i+1, 1);
            duplicates[arr[i]].push_back(i);
        }
    }
    ans[queries[0].idx] = sum(queries[0].r+1) - sum(queries[0].l);
    for(int j = 1; j < Q; ++j){
        query qry = queries[j];
        for(int i = queries[j-1].r+1; i <= qry.r; ++i){
            if(duplicates[arr[i]].size() == 0){
                update(i+1, 1);
                duplicates[arr[i]].push_back(i);
            }else if(duplicates[arr[i]].size() == 1){
                update(duplicates[arr[i]][0]+1, -2);
                update(i+1, 1);
                duplicates[arr[i]].push_back(i);
            }else if(duplicates[arr[i]].size() >= 2){
                update(duplicates[arr[i]][duplicates[arr[i]].size()-2]+1, 1);
                update(duplicates[arr[i]][duplicates[arr[i]].size()-1]+1, -2);
                update(i+1, 1);
                duplicates[arr[i]].push_back(i);
            }
        }

        ans[qry.idx] = sum(qry.r+1) - sum(qry.l);
    }

    for(int i = 0; i < Q; ++i) cout << ans[i] << "\n";
}