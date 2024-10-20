#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")

static std::unordered_map<long, long long> bit;
static long max;


class query{
    public:
    long l;
    long r;
    long k;
    long idx;

    query() : l(0), r(0), k(0), idx(0) {}
    query(long l, long r, long k, long idx) : l(l), r(r), k(k), idx(idx) {}
};


void update(long pos, long long val){
    for(long i = pos+1; i < max+5; i += i & -i) {
        bit[i] += val;
    }
}

long long sum(long pos) {
    if(pos > max) pos = max;
    long long ans = 0;

    for(long i = pos+1; i > 0; i -= i & -i) {
      if(bit.find(i) != bit.end()) ans += bit[i];
    }
    return ans;
}

int main()  {
    // TODO Auto-generated method stub
    std::cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);
    long N, Q;
    std::cin >> N >> Q;

    long lltk[200000] = {0}; long rltk[200000] = {0}; long psa[200005] = {0};
    query queries[Q];
    long A[N];
    max = 0;

    for(long i = 0; i < N; ++i) {
        long cur;
        std::cin >> cur;

        A[i] = cur;
        max = std::max(max, cur);
        psa[i+1] = psa[i] + cur;
    }

    for(long i = 0; i < Q; ++i) {
        long l, r, k;
        std::cin >> l >> r >> k;

        queries[i] = query(l-1, r-1, k, i);
    }


    std::sort(queries, queries + Q, [](query a, query b) {
        return a.l < b.l;  // Adjust for ascending order
    });
    bit.clear();
    long idx = 0;
    for(long i = 0; i < Q; ++i) {
        while(idx < queries[i].l) {
            update(A[idx], A[idx]);
            ++idx;
        }

        lltk[queries[i].idx] = sum(queries[i].k-1);
    }

  
    std::sort(queries, queries + Q, [](query a, query b) {
        return a.r < b.r;  // Adjust for ascending order
    });
    bit.clear();
    idx = 0;
    for(long i = 0; i < Q; ++i) {
        while(idx <= queries[i].r) {
            update(A[idx], A[idx]);
            ++idx;
        }

        rltk[queries[i].idx] = sum(queries[i].k-1);
    }


    std::sort(queries, queries + Q, [](query a, query b) {
        return a.idx < b.idx;  // Adjust for ascending order
    });
    for(long i = 0; i < Q; ++i) {
        std::cout << (psa[queries[i].r+1]-psa[queries[i].l]) - 2*(rltk[i]-lltk[i]) << "\n";
    }
}