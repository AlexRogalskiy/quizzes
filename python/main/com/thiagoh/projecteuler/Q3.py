
from math import *;

# http://math.stackexchange.com/questions/389675/largest-prime-factor-of-600851475143

n = 600851475143;
n = 600851475143123147;
div = 3;
largest_div = 0;
while n > 2 and largest_div < n:
	if (n % div == 0):
		largest_div = div
		n /= div
		# print '\n\n===================================> n: ' + str(n) + '\n\n'
	else:
		div += 2;
		if (str(div)[-1] == '5'):
			div += 2;
		# print str(div) + ',',

print 'The largest divisor if '+str(n)+' is: ' + str(largest_div)