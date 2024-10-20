#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long

class kid{
    public:
    int idx;
    ll num;
    ll den;

    kid() : idx(0), num(0), den(0) {}
    kid(int index, ll numerator, ll denominator) : idx(index), num(numerator), den(denominator) {}
};

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N;
    
    kid kids[N];
    for(int i = 0; i < N; ++i){
        int x, y;
        cin >> x >> y;

        kids[i] = kid(i+1, x, x+y);
    }

    sort(kids, kids+N, [](kid a, kid b) {
        if(a.num*b.den != a.den*b.num) return a.num*b.den > a.den*b.num; 
        else return a.idx < b.idx;
    });

    for(int i = 0; i < N; ++i){
        cout << kids[i].idx << " ";
    }
}