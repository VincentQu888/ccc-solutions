//set all ints to ll cxause too lazy to fix all cases of ll for one of them
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<ll, ll>
#define inf 0x7fffffff

struct event{ll x, y1, y2, type;}; //0 for x plane start, 1 for y plane, 2 for x plane end
const ll MM = 1e6+5;
ll bit[MM];

void update(ll idx, ll val){
    for(ll i = idx+1; i < MM; i += i & -i) bit[i] += val;
}

ll query(ll idx){
    ll ans = 0;

    for(ll i = idx+1; i > 0; i -= i & -i){
        ans += bit[i];
    }
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    ll T; cin >> T;
    for(ll cases = 0; cases < T; ++cases){
        vector<event> events;
        ll S; cin >> S;
        ll ans = 0;

        for(ll players = 0; players < 2; ++players){
            ll x, y, N; 
            cin >> x >> y >> N;
            x += 2; y += 2;
            ans -= N-1;

            for(ll i = 0; i < N; ++i){
                char D; ll L;
                cin >> D >> L;
                
                switch(D){
                    case 'R':
                        events.push_back(event{x, y, y, 0}); 
                        x += L;
                        events.push_back(event{x, y, y, 2});
                        break;
                    case 'L':
                        events.push_back(event{x, y, y, 2});
                        x -= L;
                        events.push_back(event{x, y, y, 0});
                        break;
                    case 'U':
                        events.push_back(event{x, y, y+L, 1});
                        y += L;
                        break;
                    case 'D':
                        events.push_back(event{x, y-L, y, 1});
                        y -= L;
                        break;
                    default:
                        break;
                }
            }
        }
        
        sort(events.begin(), events.end(), [](event a, event b) {
            return a.x != b.x ? a.x < b.x : a.type < b.type; 
        });
        for(event next : events){
            if(next.type == 0) update(next.y1, 1);
            else if(next.type == 1) ans += query(next.y2) - query(next.y1-1);
            else update(next.y1, -1);
        }
        cout << ans << "\n";
    }
}