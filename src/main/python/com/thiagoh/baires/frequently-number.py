from math import *;

def frequently(numbers, length):
	arr = [0] * 5001;

	for i in xrange(0, length):
		arr[numbers[i]] += 1;

	most_frequent = 0;
	index = 0;
	for i in xrange(0, len(arr)):
		if (most_frequent < arr[i]):
			most_frequent = arr[i];
			index = i
		elif (most_frequent == arr[i] and i < index):
			index = i

	return index

print frequently([1,2,4,1,2,1,0,0,2], 9);
# print frequently([1,2,4,1,2,1,0,0,0], 9);