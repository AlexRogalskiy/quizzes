
from math import *;

def formula(a,b):
	return (a*a) + (b*b) - pow(a + b - 1000, 2)

def find_a_b():

	for a in xrange(1,999):
		for b in xrange(1,999):
			v = formula(a,b)
			if (v > -100 and v < 100):
				print '{0},{1} => {2}'.format(a,b,v)
			if (v == 0):
				return [a,b]

	return -1

(a,b) = find_a_b()
c = 1000 - a - b;

print 'The values are a: {0} b: {1} and c: {2} and their product is {3}'.format(a,b,c, (a*b*c))