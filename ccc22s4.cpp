#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>

ll nC2(int N){return (ll)N*(N-1)/2;}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, C;
    cin >> N >> C;

    int points[2*N]; int freq[C];
    fill(freq, freq+C, 0);
    for(int i = 0; i < N; ++i){
        cin >> points[i];
        ++freq[points[i]];
    }
    
    sort(points, points+N);
    for(int i = N; i < 2*N; ++i) points[i] = C + points[i-N];

    int l = 0, r = 0; ll ans = 0;
    while(l < N){
        if(points[r]-points[l] <= C/2) ++r;
        else{
            ans += nC2(r-l-1);  
            ++l;    
        }
    }

    if(C%2 == 0){
        for(int i = 0; i < C/2; ++i) ans -= freq[i] * nC2(freq[i+C/2]) + nC2(freq[i]) * freq[i+C/2];
    }

    ll nC3 = (ll)N*(N-1)*(N-2)/6;
    cout << nC3 - ans << "\n";
}