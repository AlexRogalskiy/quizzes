from datetime import datetime;
import math;

t1 = datetime.now()
results = []

div = 7;
while div < 1001:
	remainders = [];
	remainder = 1 % div;
	if remainder > 0:
		while not remainder in remainders:
			remainders.append(remainder)
			remainder = remainder * 10 % div;
		results.append([len(remainders), div])
	div += 1;

# print results

results.sort(lambda x,y: cmp(x[0], y[0]), reverse=False)
v = results[len(results)-1];

t2 = datetime.now()

# print 'Result: ', v, ' in ', dir((t2-t1).milliseconds), 'ms'
print 'Result: ', v, ' in ', (t2-t1).microseconds/1000, 'ms'
