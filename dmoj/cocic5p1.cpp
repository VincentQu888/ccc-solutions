#include <iostream>
#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define INF 0x7fffffff
#define LINF LONG_LONG_MAX
int n;

bool areValuesEqual(unordered_map<char, int> map1, unordered_map<char, int> map2) {
    // Check if the sizes of the maps are different
    if (map1.size() != map2.size()) {
        return false;
    }

    // Iterate through the first map and compare values with the second map
    for (const auto& pair : map1) {
        auto it = map2.find(pair.first);
        if (it == map2.end() || it->second != pair.second) {
            return false;
        }
    }

    return true;
}

void printUnorderedMap(unordered_map<char, int> map) {
    for (const auto& pair : map) {
        std::cout << "Key: " << pair.first << ", Value: " << pair.second << std::endl;
    }
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    for(int i = 0; i < n; ++i){
        string rxn; cin >> rxn;
        rxn = '+' + rxn;
        unordered_map<char, int> cnt1, cnt2;
        bool flag = false; int coef = 1;
        for(int j = 1; j < rxn.length(); ++j){
            if(!flag){
                if(rxn[j] == '-') flag = true;
                else if(rxn[j] == '+') coef = 1;
                else if(2 <= (int)rxn[j] - '0' && (int)rxn[j] - '0' <= 9 && rxn[j-1] == '+') coef = (int)rxn[j] - '0';
                else if(2 <= (int)rxn[j] - '0' && (int)rxn[j] - '0' <= 9) cnt1[rxn[j-1]] += coef*((int)rxn[j] - '0' - 1);
                else cnt1[rxn[j]] += coef;
            }else{
                if(rxn[j] == '>' || rxn[j] == '+') coef = 1;
                else if(2 <= (int)rxn[j] - '0' && (int)rxn[j] - '0' <= 9 && (rxn[j-1] == '+' || rxn[j-1] == '>')) coef = (int)rxn[j] - '0';
                else if(2 <= (int)rxn[j] - '0' && (int)rxn[j] - '0' <= 9) cnt2[rxn[j-1]] += coef*((int)rxn[j] - '0' - 1);
                else cnt2[rxn[j]] += coef;
            }   
        }
        if(areValuesEqual(cnt1, cnt2)) cout << "DA" << "\n";
        else cout << "NE" << "\n";
    }
}