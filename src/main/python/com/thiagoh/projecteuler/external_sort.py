from audioop import reverse

__author__ = 'thiago'

import sys
import bisect
import random
import math


arr1 = [random.randint(1, 160) for x in range(1, random.randint(15, 300))];
arr2 = [random.randint(50, 260) for x in range(1, random.randint(10, 252))];
arr3 = [random.randint(13, 90) for x in range(1, random.randint(15, 251))];

arrs = [];
ixs = [0, 0, 0];
arrs.append(arr1);
arrs.append(arr2);
arrs.append(arr3);

for i in arrs: print(i)
for i in arrs: i.sort()
print()
for i in arrs: print(i)

output = [];

def goon():
    for i, ix in enumerate(ixs):
        if ix < len(arrs[i]):
            return True;
    return False;

while goon():

    i = 0;
    min = None;
    minIx = 0;

    while i < len(arrs):

        if (ixs[i] >= len(arrs[i])):
            i += 1;
            continue;

        v = arrs[i][ixs[i]];

        if min == None or v < min:
            min = v;
            minIx = i;

        i += 1;

    ixs[minIx] += 1;
    output.append(min)

print('\nresult', output)








