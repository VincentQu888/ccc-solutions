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

    int t; 
    cin >> t;

    for(int cases = 0; cases < t; ++cases){
        int N;
        cin >> N;

        int cows[N]; set<int> ans;
        for(int i = 0; i < N; ++i){
            cin >> cows[i];
        }

        for(int i = 0; i < N-2; ++i){
            unordered_map<int, int> preferences;
            
            for(int j = i; j < i+3; ++j){
                ++preferences[cows[j]];
                if(preferences[cows[j]] == 2) ans.insert(cows[j]);
            }
        }

        if(ans.empty()){
            if(cows[0] == cows[1]) cout << cows[0] << "\n";
            else cout << -1 << "\n";
        } 
        else{
            int counter = 1;
            for(int const& next : ans){
                if(counter < ans.size()) cout << next << ' ';
                else cout << next;
                ++counter;
            }
            cout << "\n";
        }
    }
}