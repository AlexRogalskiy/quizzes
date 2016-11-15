
fib_list = [1, 2, 3, 5, 8, 13, 21, 34, 55, 89];

def _fib(n):
	if (n == 0): return 0;
	if (n == 1): return 1;

	return _fib(n-1) + _fib(n-2);

print 'Fib of 1 is: ' + str(_fib(1));
print 'Fib of 2 is: ' + str(_fib(2));
print 'Fib of 3 is: ' + str(_fib(3));
print 'Fib of 4 is: ' + str(_fib(4));
print 'Fib of 5 is: ' + str(_fib(5));
print 'Fib of 6 is: ' + str(_fib(6));
print 'Fib of 7 is: ' + str(_fib(7));
print 'Fib of 8 is: ' + str(_fib(8));
print 'Fib of 9 is: ' + str(_fib(9));
print 'Fib of 10 is: ' + str(_fib(10));

even_ends = [0,2,4,6,8]
x = 4
n = 0
p2 = 1
p1 = 2
sum = p1
limit = 4*1000*1000;
# limit = 100;
while True:
	fib_number = p2 + p1
	if fib_number >= limit: break;
	if int(str(fib_number)[-1]) in even_ends: sum += fib_number;
	n = fib_number;
	p2 = p1;
	p1 = fib_number;
	print 'Current fib('+str(x)+') is ('+str(p1) + ',' + str(p2) +'): ' + str(fib_number)
	x += 1;

print 'The final sum is: ' + str(sum)