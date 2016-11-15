
from math import *;

# http://math.stackexchange.com/questions/389675/largest-prime-factor-of-600851475143

def is_prime(n):

	if (str(n)[-1] == '2'):
		return False;

	top = int(floor(sqrt(n)))
	div = 3
	while div <= top:

		if (n % div == 0):
			return False

		div += 2;

		if (str(div)[-1] == '5'):
			div += 2;

	return True

primes = [2,3,5,7];
n = 2*1000*1000;
n = 2*1000*1000;
i = 11;

while i < n:

	if (is_prime(i)):
		primes.append(i);

	i += 2; 

	if (str(i)[-1] == '5'):
			i += 2;

print 'The sum of primes under {0} is {1}: {2}'.format(n, sum(primes), primes)