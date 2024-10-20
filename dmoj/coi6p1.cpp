#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>
#define inf 0x7fffffff
struct group{int x, l, r;};
const int MM = 5e5+5;
int N; ll ans = 0;
deque<group> stk;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N;
    for(int i = 0, x; i < N; ++i){
        cin >> x;
        while(stk.size() > 0 && x > stk.front().x){
            ans += stk.front().r - stk.front().l + 1;
            stk.pop_front();
        }
        if(stk.size() > 0 && x == stk.front().x){
            group val = {x, stk.front().l, stk.front().r+1};
            stk.pop_front(); stk.push_front(val);
            if(stk.size() > 1) ans += stk.front().r - stk.front().l + 1;
            else ans += stk.front().r - stk.front().l;
        }
        else if(stk.size() > 0 && x < stk.front().x){
            stk.push_front({x, 0, 0});
            ++ans;
        }
        else stk.push_front({x, 0, 0});
    }
    cout << ans << "\n";
}