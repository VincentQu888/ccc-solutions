#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#define ll long long
#define pii pair<int, int>

const int MM = 4e6;
int bit[MM+5];
struct in{ll x1, y1, x2, y2;};
struct point{ll x, y1, y2, type;}; //horizontal start, vertical, horizontal end

void update(int idx, int val){
    for(int i = idx+1; i < MM+5; i += i & -i) bit[i] += val;
}

int query(int idx){
    int ans = 0;

    for(int i = idx+1; i > 0; i -= i & -i){
        ans += bit[i];
    }
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N; 
    cin >> N;

    unordered_map<ll, int> compressed;
    vector<ll> coords;
    vector<point> events;
    in input[N];
    for(int i = 0; i < N; ++i){
        ll x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        y1 += 1e9+5; y2 += 1e9+5;

        input[i] = in{x1, y1, x2, y2};
        coords.push_back(y1); coords.push_back(y2);
    }

    sort(coords.begin(), coords.end());
    for(int i = 0; i < coords.size(); ++i) compressed[coords[i]] = i;
    for(in next : input){
        int x1 = next.x1, y1 = compressed[next.y1], x2 = next.x2, y2 = compressed[next.y2];

        if(x1 == x2) events.push_back(point{x1, y1, y2, 1}); 
        else{
            events.push_back(point{x1, y1, y1, 0}); 
            events.push_back(point{x2, y1, y1, 2}); 
        }
    }


    sort(events.begin(), events.end(), [](point a, point b) {
        return a.x != b.x ? a.x < b.x : a.type < b.type; 
    });

    ll ans = 0;
    for(point next : events){
        if(next.type == 0){
            update(next.y1, 1);
        }else if(next.type == 1){
            ans += query(next.y2)-query(next.y1-1);
        }else{
            update(next.y1, -1);
        }
    }
    cout << ans << "\n";
}