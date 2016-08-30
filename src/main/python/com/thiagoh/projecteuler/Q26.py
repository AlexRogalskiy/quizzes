from datetime import datetime;
import math;

t1 = datetime.now()
max_remainders = 0;
result = 0;

div = 999
while div > 7:
	remainders = [];
	remainder = 1 % div;
	if remainder > 0:
		while remainder not in remainders and remainder != 0:
			remainders.append(remainder)
			remainder = remainder * 10 % div;

		if len(remainders) > max_remainders:
			max_remainders = len(remainders);
			result = div;

	div -= 2;

t2 = datetime.now()

print 'Result: ', [max_remainders, result], ' in ', (t2-t1).microseconds/1000, 'ms'
