from math import *;
import os;

triangle_arr = [];
f = open(os.path.dirname(os.path.realpath(__file__)) + os.sep + 'triangles.txt', 'r')
for line in f:
    triangle_arr.append([int(x) for x in line.split(' ')])

def solve(from_arr):

	tmp_arr = [[]] * len(from_arr);
	for i, value in enumerate(tmp_arr):
		tmp_arr[i] = from_arr[i][:]

	for l in reversed(xrange(1, len(tmp_arr))):
		for i in xrange(0, len(tmp_arr[l]) - 1):
			greater = max(tmp_arr[l][i], tmp_arr[l][i+1]);
			tmp_arr[l-1][i] += greater;

	return tmp_arr[0][0]

print 'The maximum total from top to bottom is: ' + str(solve(triangle_arr));