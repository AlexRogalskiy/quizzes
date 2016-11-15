
# Nice solution proposed by https://www.martinkysel.com/codility-oddoccurrencesinarray-solution/
# def solution(A):
#     missing_int = 0
#     for value in A:
#         missing_int ^= value
#     return missing_int

def solution(A):
	counter = {};

	for i in xrange(0, len(A)):
		counter[A[i]] = (counter[A[i]] if A[i] in counter else 0) + 1;

	for k,v in counter.iteritems():
		if v % 2 == 1:
			return k;

	return -1

print solution([9,3,9,3,9,7,9])
print solution([9,3,2,6,6,6,6,2,9,3,9,7,9,1,1,2,3,3,2])