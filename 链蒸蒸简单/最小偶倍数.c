
int gcd(int x, int y);

int smallestEvenMultiple(int n) {
    //return n % 2 == 0 ? n : 2 * n;
    return 2 * n / gcd(2, n);
}

int gcd(int a, int b) {
    while (b != 0) {
        int tmp = b;
        b = a % b;
        a = tmp;
    }
    return a;
}