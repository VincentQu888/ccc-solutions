#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 2e3+5;
char grid[MM][MM];
int N, M, S;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> M >> N >> S;
    for(int i = 0; i < M; ++i){
        string row; cin >> row;
        for(int j = 0; j < N; ++j) grid[i][j] = row[j];
    }

    ll count = 0;
    for(int i = 0; i < M; ++i){
        for(int j = 0; j < N; ++j){
            if(grid[i][j] == '.') continue;
            count += min(min(i, min(M-S, M-1-i))+1, S) * min(min(j, min(N-S, N-1-j))+1, S);
        }
    }

    cout << setprecision(8) << count / ((double)(M-S+1)*(N-S+1)) << "\n";
}