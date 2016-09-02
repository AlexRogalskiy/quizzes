from math import *;

def dist(p1, p2):
	return sqrt( pow(p2[0] - p1[0], 2) + pow(p2[1] - p1[1], 2) )

def avg(p1, p2, p3):

	d1 = dist(p1,p2)
	d2 = dist(p2,p3)
	d3 = dist(p1,p3)
	return (d1 + d2 + d3) / 3

print avg([0,0],[20,20],[10,0]);