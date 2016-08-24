
from math import *;

# def formula(a,b):
# 	return pow(1000,4) - (pow(4000,2) * a * b) + (4 * pow(a,2) * pow(b,2)) - (pow(2000,2) * ( pow(a,2) + pow(b,2)))

# def formula(a,b):
# 	return pow(1000,2) - (2000 * sqrt( a*a + b*b )) - (2*a*b)

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