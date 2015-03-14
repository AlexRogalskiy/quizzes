__author__ = 'thiago'

import bisect

arr = [x for x in range(20, 30)]
print(arr)
n = 24
b = bisect.bisect_right(arr, n)
arr[b] = -1
print(b)
print(arr)