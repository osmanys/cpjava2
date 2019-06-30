#include <iostream>
#include <string>

const long M = 1000000007;

long pw(long y, long c){
    if(y == 1)
        return 1;

    long res = 1;

    while(c > 0){
        if(c & 1){
            res = (res*y);
            if(res > M)
                res %= M;
        }

        c >>= 1;
        y = (y*y);

        if(y > M)
            y%=M;
    }

    return res;
}

long sol(std::string votes, int N, int K) {
    long res = 0;
    int BsubA = 0;

    for (int i = N-1; i >= 0; --i) {
        BsubA += (votes[i] == 'B') ? 1 : -1;

        if(BsubA > K){
            res += pw(2,i+1);
            res %= M;

            BsubA -= 2;
        }

        BsubA = std::max(BsubA, 0);
    }

    return res;
}

int T;

void read(){
    std::cin >> T;
}

void write(){
    for (int i = 1; i <= T; ++i) {
        int N;
        int K;
        std::string votes;

        std::cin >> N >> K;
        std::cin >> votes;

        auto ans = sol(votes, N, K);

        std::cout << "Case #" << i << ": " << ans << std::endl;
    }
}

int main(){
  read();
  write();
}
