#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, pos;
    cin >> N >> pos; --pos;

    pii line[N];
    for(int i = 0; i < N; ++i){
        cin >> line[i].first >> line[i].second;
    }

    int pwr = 1, dir = 1, counter = 0, ans = 0;
    while(0 <= pos && pos < N && counter < 1e6){
        if(line[pos].first == 0){
            pwr += line[pos].second;
            dir = -dir;
        } 
        else if(line[pos].first == 1 && pwr >= line[pos].second){
            ++ans;
            line[pos].first = -1;
        }

        if(dir == 1) pos += pwr;
        else pos -= pwr;
        ++counter;
    }

    cout << ans << "\n";
}