
# A =  [3, 8, 10, 2, 15, 17, 9, 7, 6] and K = 3
# A -> [9, 7, 6, 3, 8, 10, 2, 15, 17].

def solution(A, K):

	N = len(A);

	if N <= 1 or N == K:
		return A

	if N < K:
		K = K % N;

	# print N
	R = [];

	for i in xrange(N-K, N):
		# print i,
		R.append(A[i]);
	
	for i in xrange(0, N-K):
		# print i,
		R.append(A[i]);

	print 'Rotated by: ', K
	print A
	print R
	print ''

	return R

solution([], 0)
solution([], 1)
solution([1], 1)
solution([1], 5)

solution([1,2], 5)
solution([1,2], 6)

solution([1,2,3,4], 5)
solution([1,2,3,4], 6)

solution([3, 8, 10, 2, 15, 17, 9, 7, 6], 0)
solution([3, 8, 10, 2, 15, 17, 9, 7, 6], 1)
solution([3, 8, 10, 2, 15, 17, 9, 7, 6], 2)
solution([3, 8, 10, 2, 15, 17, 9, 7, 6], 3)
solution([3, 8, 10, 2, 15, 17, 9, 7, 6], 6)
solution([3, 8, 10, 2, 15, 17, 9, 7, 6], len([3, 8, 10, 2, 15, 17, 9, 7, 6]))
