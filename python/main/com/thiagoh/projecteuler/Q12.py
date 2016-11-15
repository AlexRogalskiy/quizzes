from math import *;

def count_divisors(n):
	# all numbers are divided by itselves and by 1 (one)
	divisors = 2; 
	current_divisor = 2;
	limit = int(ceil(n / 2));
	while current_divisor < limit:
		if (n % current_divisor == 0):
			limit = int(n / current_divisor);
			# print current_divisor, limit;
			divisors += 1;
			# avoid count twice those kind of 6*6 = 36, or 5*5 = 25 product
			if (current_divisor < limit):
				divisors += 1;
		current_divisor += 1;
	return divisors;

print 'The divisors for {0} count {1}'.format(28, count_divisors(28));
print 'The divisors for {0} count {1}'.format(36, count_divisors(36));
print 'The divisors for {0} count {1}'.format(55, count_divisors(55));
print 'The divisors for {0} count {1}'.format(100, count_divisors(100));

def calc_triangle_number(n):
	v = 0;
	for i in xrange(1, n+1):
		v += i;
	return v;
	
print 'The 7th triangle number is {0}'.format(calc_triangle_number(7));
print 'The 8th triangle number is {0}'.format(calc_triangle_number(8));
print 'The 10th triangle number is {0}'.format(calc_triangle_number(10));
print 'The 100th triangle number is {0}'.format(calc_triangle_number(100));

cur_triangle_index = 7;
n = calc_triangle_number(cur_triangle_index);
divisors = count_divisors(n);
while divisors <= 500:
	divisors = count_divisors(n);
	print str(cur_triangle_index) + ' => ' + str(n) + ' has ' + str(divisors) + ' divisors'
	cur_triangle_index += 1;
	n = calc_triangle_number(cur_triangle_index);
