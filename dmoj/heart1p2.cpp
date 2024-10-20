#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f

// Function to perform prime factorization
vector<int> primeFactorize(int n) {
    vector<int> factors;  // Vector to store prime factors

    // Check for number of 2s that divide n
    if (n % 2 == 0) {
        factors.push_back(2);
        while (n % 2 == 0) {
            n /= 2;
        }
    }

    // n must be odd at this point, so a skip of 2 (i += 2) can be used
    for (int i = 3; i <= sqrt(n); i += 2) {
        if (n % i == 0) {
            factors.push_back(i);
            while (n % i == 0) {
                n /= i;
            }
        }
    }

    // This condition is to handle the case when n is a prime number
    // greater than 2
    if (n > 2) {
        factors.push_back(n);
    }

    return factors;
}

int main() {
    int n;
    cin >> n;

    vector<int> factors = primeFactorize(n);
    if(factors.size() > 1) cout << "NO" << "\n";
    else cout << "YES" << "\n";
}