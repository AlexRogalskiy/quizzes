
i3 = 3;
i5 = 5;

limit = 1000;
sum = 0;

while i3 < limit:
	sum += i3;
	if (i5 < limit and i5 % 3 != 0): sum += i5;
	i3 += 3;
	i5 += 5;

print 'Sum is: ' + str(sum);
