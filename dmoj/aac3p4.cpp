#include <iostream>
#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
unordered_map<int, int> freq;
int N, M, ans = 0;
int main() {
    cin.tie(NULL); ios_base::sync_with_stdio(false);
	cin >> N >> M;
	for(int i = 1, x; i <= N; ++i){
		cin >> x;
		if(x != -1) freq[x-i] += 1;
	}
	for(int i = 1, x; i <= M; ++i){
		cin >> x;
		if(x != -1) {
			if(freq[x-i] > 0){
				++ans;
				freq[x-i] -= 1;
			}
		}
	}
	cout << ans << "\n";
}