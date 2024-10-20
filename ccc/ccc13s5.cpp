#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff

const int MM = 5e6+2;
bool prime[MM]; int first[MM];

int cost(int N){
    if(N == 1) return 0;
    if(prime[N]) return cost(N-1) + N-1;
    return cost(N - N/first[N]) + first[N]-1;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N;

    memset(prime, true, sizeof(prime));
    for(int i = 2; i*i <= N; ++i){
        if(prime[i]){
            for(int j = i*i; j <= N; j += i){
                if(first[j] == 0) first[j] = i;
                prime[j] = false;
            } 
        }
    }
    cout << cost(N) << "\n";
}