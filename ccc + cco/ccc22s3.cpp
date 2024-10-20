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

    ll N, M, K;
    cin >> N >> M >> K;
    
    ll samples = N; vector<int> ans; ans.push_back(1);
    if(N*M >= K || N > K){
        ll length = floor(sqrt((K-samples)*2))+1;
        if(length*(length+1)/2 - length > K-samples) --length; 
        for(int i = 1; i <= min(length, M); ++i) ans.push_back(i);
        samples += min(length, M)*(min(length, M)+1)/2 - min(length, M); 

        while(samples < K){
            length = K-samples+1;
            ans.push_back(ans[ans.size() - min(length, M)]);
            samples += min(length, M)-1;
            if(min(length, M)-1 == 0) break;
        }
    } 

    if(ans.size() > N+1 || N*M < K || N > K) cout << -1 << "\n";
    else{
        for(int i = 1; i < ans.size(); ++i) cout << ans[i] << " ";
        for(int i = max((int)ans.size(), 1); i <= N; ++i) cout << ans[ans.size()-1] << " ";
    } 
}