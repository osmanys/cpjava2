/**
 *    author:  tourist
**/
#include <bits/stdc++.h>

using namespace std;

constexpr int md = (int) 1e9 + 7;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int tt;
  cin >> tt;
  for (int qq = 1; qq <= tt; qq++) {
    cout << "Case #" << qq << ": ";
    int n, k;
    cin >> n >> k;
    string s;
    cin >> s;
    int mn = 0;
    int cur = 0;
    int ans = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s[i] == 'A') {
        --cur;
      } else {
        if (cur + 1 - mn > k) {
          --cur;
          ans = (ans + 1) % md;
        } else {
          ++cur;
        }
      }
      mn = min(mn, cur);
      ans = (ans * 2) % md;
    }
    cout << ans << '\n';
  }
  return 0;
}
