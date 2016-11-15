from math import *;

hash_length = {
'1': 'one','2': 'two','3': 'three','4': 'four','5': 'five','6': 'six','7': 'seven','8': 'eight','9': 'nine',
'10': 'ten','11': 'eleven','12': 'twelve','13': 'thirteen','14': 'fourteen','15': 'fifteen','16': 'sixteen','17': 'seventeen','18': 'eighteen','19': 'nineteen',
'20': 'twenty','30': 'thirty','40': 'forty','50': 'fifty','60': 'sixty','70': 'seventy','80': 'eighty','90': 'ninety',
};

hash_length = dict(map(lambda (k,y): (k,len(y)), hash_length.iteritems()));

sum = 0;

# from 1 to 9
for i in xrange(1,10):
	k = str(i)
	# print k
	# 1 to 1000 = one-nine appears 90 times as: one, twenty 'one', ninety 'one'
	# 1 to 1000 = one-nine appears 100 times as: 'one' hundred and twelve, 'one' hundred and twenty three
	sum += hash_length[k] * (90 + 100); 

# from 10 to 19
for i in xrange(10,20):
	k = str(i)
	# print k
	sum += hash_length[k] * 10; # 1 to 1000 = eleven-nineteen appears 1*10 times

# from 20 to 90 (step of 10)
for i in xrange(20,100,10):
	k = str(i)
	# print k
	sum += hash_length[k] * 100; # 1 to 1000 = twenty-ninety appears 100 times

# 'hundred' words
sum += len('hundred') * 900; # 1 to 1000 = hundred appears 100*9 - 1 times (minus one from 'one thousand')

# 'and' words
sum += len('and') * (99*9); # 1 to 1000 = and appears 99*9 times

# one thousand
sum += len('onethousand');

print sum