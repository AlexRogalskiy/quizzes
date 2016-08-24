
from math import *;

# http://math.stackexchange.com/questions/389675/largest-prime-factor-of-600851475143

primes = [2,3,5,7];
n = 2*1000*1000;
n = 2*1000;
i = 11;

while i < n:

	if (is_prime(i)):
		primes.append(i);

	i += 2; 

	if (str(i)[-1] == '5'):
			i += 2;

print 'The sum of primes under {n} is {sum(primes)}'