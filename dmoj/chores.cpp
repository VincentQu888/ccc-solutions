#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define int long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 1e5+5;
int N; int M = 1e9+7;
pii arr[MM];

int add(int a, int b){
    return (a+b)%M;
}

int mul(int a, int b){
    return (ll)a*b%M;
}

int divi(int a, int b){
    return mul(a, pow(b, M-2));
}

signed main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N;
    for(int i = 0, a, b; i < N; ++i){
        cin >> a >> b;
        arr[i] = {a, b};
    }

    sort(arr, arr+N, [](pii a, pii b){
        return a.first < b.first;
    });

    int ans = 0, t = 0;
    for(int i = 0; i < N; ++i){
        ans = (ans + arr[i].second*t%M + (arr[i].second*(arr[i].second+1) >> 1)%M * arr[i].first%M)%M;
        t = add(t, mul(arr[i].first, arr[i].second));
    }
    cout << ans%M << "\n";
}