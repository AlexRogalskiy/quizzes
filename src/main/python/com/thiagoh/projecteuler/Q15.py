from math import *;

class Node:
	def __init__(self):
		self.counter = 0;

	def add_paths(self, many):
		self.counter += many;

	def __str__(self):
		return 'Node (' + str(self.counter) + ')';

def calculate_paths(size):

	a = [[Node() for i in range(size)] for i in range(size)];
	a[0][0].counter = 1;

	for i in xrange(0, len(a)):
		for j in xrange(0, len(a[i])):
			node = a[i][j];

			if (j + 1 < len(a[i])):
				right_node = a[i][j+1];
				right_node.add_paths(node.counter);

			if (i + 1 < len(a)):
				bottom_node = a[i+1][j];
				bottom_node.add_paths(node.counter);

	return a[size-1][size-1];

print 'The possible paths for a Grid 20x20 are {0} '.format(calculate_paths(21));