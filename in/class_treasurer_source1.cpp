#include <iostream>
#include <stack>

#define MOD 1000000007

using namespace std;

void sol(int n, int k, string s){
    stack<int> st;

    int count = 0;

    for (int i = s.length() - 1; i >= 0; i--){
        if (s[i] == 'A') count--;
        else count++;

        if (count < 0) count = 0;
        else if (count > k){
            st.push(i+1);
            count -= 2;
            if (count < 0) count = 0;
        }
    }

    long long res = 0, i = 0, pos, pw = 1;

    while (!st.empty()){
        pos = st.top();
        st.pop();

        while (i < pos) {
            pw <<= 1;
            pw %= MOD;
            i++;
        }

        res += pw;
        res %= MOD;
    }

    cout << res << endl;
}

int main(){
    if (!freopen("class_treasurer.txt", "r", stdin)) {
        cout << "Could not open file";
        return 1;
    }
    
    ios::sync_with_stdio(false);
    cin.tie(0);
    int t;

    cin >> t;
    int n[t];
    int k[t];
    string s[t];
    
    for (int tt = 0; tt < t; tt++){
        cin >> n[tt] >> k[tt];
        cin >> s[tt];
    }

    for (int tt = 0; tt < t; tt++){
        cout << "Case #" << tt + 1 << ": ";

        sol(n[tt], k[tt], s[tt]);
    }
    return 0;
}
