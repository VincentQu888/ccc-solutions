#include <iostream>
#include <algorithm>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")

int bit1[3005][3005];
int bit2[3005][3005];

void update1(int r, int c, int val) {
	for(int i = r+1; i <= 3005; i += i & -i)
		for(int j = c+1; j <= 3005; j += j & -j)
			bit1[i][j] += val;
}

int query1(int r, int c) {
	int ans = 0;
	for(int i = r+1; i > 0; i -= i & -i)
		for(int j = c+1; j > 0; j -= j & -j)
			ans += bit1[i][j];
	return ans;
}

void update2(int r, int c, int val) {
	for(int i = r+1; i <= 3005; i += i & -i)
		for(int j = c+1; j <= 3005; j += j & -j)
			bit2[i][j] += val;
}

int query2(int r, int c) {
	int ans = 0;
	for(int i = r+1; i > 0; i -= i & -i)
		for(int j = c+1; j > 0; j -= j & -j)
			ans += bit2[i][j];
	return ans;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;
    cin >> N >> M;
    
    int cmd; cin >> cmd;
    while(cmd != 0){
        if(cmd == 1){
            int r, c, x;
            cin >> r >> c >> x;
            --r; --c;

            if((r%2 == 0 && c%2 == 0) || (r%2 == 1 && c%2 == 1)){
                int old = query1(r, c) - query1(r, c-1) - query1(r-1, c) + query1(r-1, c-1);
                update1(r, c, x-old);
            }else{
                int old = query2(r, c) - query2(r, c-1) - query2(r-1, c) + query2(r-1, c-1);
                update2(r, c, x-old);
            }
        }else{
            int r1, c1, r2, c2;
            cin >> r1 >> c1 >> r2 >> c2; 
            --r1; --c1; --r2; --c2;

            if((r1%2 == 0 && c1%2 == 0) || (r1%2 == 1 && c1%2 == 1)){
                cout << (query1(r2, c2) - query1(r2, c1-1) - query1(r1-1, c2) + query1(r1-1, c1-1)) - (query2(r2, c2) - query2(r2, c1-1) - query2(r1-1, c2) + query2(r1-1, c1-1)) << "\n";
            }else{
                cout << (query2(r2, c2) - query2(r2, c1-1) - query2(r1-1, c2) + query2(r1-1, c1-1)) - (query1(r2, c2) - query1(r2, c1-1) - query1(r1-1, c2) + query1(r1-1, c1-1)) << "\n";
            }
        }

        cin >> cmd;
    }
}