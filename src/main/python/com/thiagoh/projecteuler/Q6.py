
from math import *;

limit = 100

sum1 = 0;
sum2 = 0;

for x in xrange(1, limit + 1):
	sum1 += x;

value1 = sum1*sum1;

for x in xrange(1, limit + 1):
	sum2 += x*x;

value2 = sum2

final_value = value1-value2

print 'sum1 ' + str(sum1)
print 'value1 ' + str(value1)

print 'sum2 ' + str(sum2)
print 'value2 ' + str(value2)

print 'The values are value1: {0} value2: {1} and the difference is: {2}'.format(value1, value2, final_value)