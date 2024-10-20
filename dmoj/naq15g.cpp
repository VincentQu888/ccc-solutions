#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
const int MM = 15+5;
int students[MM], dp[MM], N;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N;
    for(int i = 1; i <= N; ++i) cin >> students[i];
    sort(students+1, students+N+1);
    dp[1] = students[1]; dp[2] = students[2];
    for(int i = 3; i <= N; ++i) dp[i] = min(dp[i-1] + students[1] + students[i], dp[i-2] + students[1] + students[i] + students[2]*2);
    cout << dp[N] << "\n";
}