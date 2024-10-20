#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
int N, M, K;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M >> K;
    int fielda[N][M+2], fieldb[N][M+2];
    memset(fielda, 0, sizeof(fielda)); memset(fieldb, 0, sizeof(fieldb));
    for(int i = 0; i < N; ++i){
        string row; cin >> row;
        for(int j = 1; j <= M; ++j){
            if(row[j-1] == 'A'){fielda[i][j] += 1; fielda[i][min(M+1, j+K+1)] -= 1;}
            if(row[j-1] == 'B'){fieldb[i][j] -= 1; fieldb[i][max(0, j-K)] += 1;}
        }
        for(int j = 1; j <= M; ++j) fielda[i][j] += fielda[i][j-1];
        for(int j = 1; j <= M; ++j) fieldb[i][j] += fieldb[i][j-1];
        for(int j = 1; j <= M; ++j){
            if(row[j-1] == 'A' && fieldb[i][j] > 0) cout << "N";
            else if(row[j-1] == 'B' && fielda[i][j] > 0) cout << "N";
            else if(row[j-1] == 'A') cout << "Y";
            else if(row[j-1] == 'B') cout << "Y";
            else cout << ".";
        }
        cout << "\n";
    }
}