#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")

static std::unordered_map<long, long long> bit;
int largest = 0;

class query{
    public:
    long l;
    long r;
    long k;
    long idx;

    query() : l(0), r(0), k(0), idx(0) {}
    query(long l, long r, long k, long idx) : l(l), r(r), k(k), idx(idx) {}
};

void update(int idx, int val){
    for(int i = idx+1; i < largest+5; i += i & -i) bit[i] += val;
}

long long sum(int idx){
    idx = min(idx, largest);
    long long ans = 0;

    for(int i = idx+1; i > 0; i -= i & -i){
        if(bit.find(i) != bit.end()) ans += bit[i];
    }
    return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N; cin >> N;
    int arr[N];

    for(int i = 0; i < N; ++i){
        int m; cin >> m;
        arr[i] = m;
        largest = max(largest, m);
    }

    int Q; cin >> Q;
    query queries[Q];
    long long lgtk[Q] = {0}; long long rgtk[Q] = {0};
    for(int i = 0; i < Q; ++i){
        int a, b, q;
        cin >> a >> b >> q;

        queries[i] = query(a, b, q, i);
    }


    sort(queries, queries+Q, [](query a, query b) {
        return a.l < b.l; 
    });
    int idx = 0;
    for(int i = 0; i < Q; ++i){
        while(idx < queries[i].l){
            update(largest-arr[idx], arr[idx]);
            ++idx;
        }
        
        lgtk[queries[i].idx] = sum(largest-queries[i].k);
    }

    sort(queries, queries+Q, [](query a, query b) {
        return a.r < b.r; 
    });
    bit.clear();
    idx = 0;
    for(int i = 0; i < Q; ++i){
        while(idx <= queries[i].r){
            update(largest-arr[idx], arr[idx]);
            ++idx;
        }
        
        rgtk[queries[i].idx] = sum(largest-queries[i].k);
    }


    for(long i = 0; i < Q; ++i) {
        cout << rgtk[i]-lgtk[i] << "\n";
    }
}