#include <iostream>
#include <vector>

using namespace std;


int getPrimeSum(int n)
{
	vector<bool> primes(n + 1);
	int sum = 0;
	
	for (int i = 0; i <= n; i++)
		primes[i] = false;

	for (int i = 2; i <= n; i++)
	{
		if (primes[i] == false)
		{
			cout << i << " ";
			sum += i;
		}

		for (int j = i + i; j <= n; j += i)
		{
			primes[j] = true;
		}

	}

	return sum;
}

int main()
{
	int n = 0;
	int ans = 0;

	cin >> n;
	if (n < 2 || n > 10000000)
		return -1;

	ans = getPrimeSum(n);
	cout << endl;
	cout << ans << endl;

	return 0;
}