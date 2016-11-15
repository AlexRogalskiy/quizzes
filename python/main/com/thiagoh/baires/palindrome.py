from math import *;

def isAlmostPalindrome(word):

	length = len(word)
	middle = int(floor(length/2.0))

	palindrome = True
	count = 0
	for i in xrange(0, middle):
		if word[i] != word[length-1-i]:
			palindrome = False
			count += 1;

		if count > 1: return False

	if palindrome: return True;
	else: return count <= 1;

print isAlmostPalindrome('ababa');
print isAlmostPalindrome('abaaba');
print isAlmostPalindrome('abdcba');
print isAlmostPalindrome('abdcbd');