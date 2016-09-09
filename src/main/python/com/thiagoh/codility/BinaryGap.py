

def solution(N):
	s = bin(N)[2:]
	print N, ' in binary is ', s,
	max_seq = 0;
	cur_seq = 0;
	for i in xrange(0, len(s)):
		if s[i] == '1':
			if cur_seq > max_seq:
				max_seq = cur_seq;
			cur_seq = 0;
		else:
			cur_seq += 1;
	print ': ', max_seq;
	return max_seq;


solution(0)
solution(1)
solution(2)
solution(3)
solution(5)
solution(6)
solution(7)
solution(10)
solution(11)
solution(100)
solution(101)
solution(144)
solution(288)
solution(1056)
solution(2147483647)