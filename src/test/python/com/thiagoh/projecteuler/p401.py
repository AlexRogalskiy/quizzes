import math

class Sol401(object):

	m = {}
	d = {}
	tenSix = 10**6

	@staticmethod
	def make_cache(n):
		for i in range(1, n):
			Sol401.m[i] = Sol401.sigma2(i)

	@staticmethod
	def divisors(n):
		a = []
		for i in range(1, math.ceil(math.sqrt(n)) + 1):
			if n % i == 0:
				a.append(i)
				a.append(n/i)
		return list(set(a))

	@staticmethod
	def sigma2(n):
		if n in Sol401.m:
			return Sol401.m[n]
		if n < Sol401.tenSix:
			if n in Sol401.d:
				a = Sol401.d[n]  
			else: 
				a = Sol401.divisors(n)
				Sol401.d[n] = a
		else:
			a = Sol401.divisors(n)
		sum = 0
		for i in a:
			sum += i**2
		if n < Sol401.tenSix:
			Sol401.m[n] = sum
		return sum

	@staticmethod
#	def bigsigma2(n, acc=1):
#		if n == 1:
#			return acc
#		v = Sol401.bigsigma2(n - 1, Sol401.sigma2(n) + acc)
#		return v

	def bigsigma2_recursive(n):
		if (n == 1):
			return Sol401.sigma2(1)
		return Sol401.sigma2(n) + Sol401.bigsigma2(n - 1)

	def bigsigma2(n, acc=0):
		while n > 1:
			(n, acc) = (n - 1, Sol401.sigma2(n) + acc)
		return acc + Sol401.sigma2(1)

print("Making cache up to 10**10")
Sol401.make_cache(10**10)
print("Cache up to 10*10 is done")
print("Making cache up to 10**15")
Sol401.make_cache(10**15)
print("Cache up to 10*15 is done")

print('Sol401.sigma2(10**10)' + str(Sol401.sigma2(10**10)))
print('Sol401.sigma2(10**15)' + str(Sol401.sigma2(10**15)))
print('Sol401.bigsigma2(1)' + str(Sol401.bigsigma2(1)))
print('Sol401.bigsigma2(2)' + str(Sol401.bigsigma2(2)))
print('Sol401.bigsigma2(3)' + str(Sol401.bigsigma2(3)))
print('Sol401.bigsigma2(4)' + str(Sol401.bigsigma2(4)))
print('Sol401.bigsigma2(5)' + str(Sol401.bigsigma2(5)))
print('Sol401.bigsigma2(6)' + str(Sol401.bigsigma2(6)))
print('Sol401.bigsigma2(10**1)' + str(Sol401.bigsigma2(10**1)))
print('Sol401.bigsigma2(10**2)' + str(Sol401.bigsigma2(10**2)))
print('Sol401.bigsigma2(10**3)' + str(Sol401.bigsigma2(10**3)))
print('Sol401.bigsigma2(10**4)' + str(Sol401.bigsigma2(10**4)))
print('Sol401.bigsigma2(10**5)' + str(Sol401.bigsigma2(10**5)))
print('Sol401.bigsigma2(10**6)' + str(Sol401.bigsigma2(10**6)))
print('Sol401.bigsigma2(10**15) % (10**9)' + str(Sol401.bigsigma2(10**15) % (10**9)))
