__author__ = 'thiago'

import random

a = [random.randrange(1,200) for x in range(0, 30)];
b = [random.randrange(1,300) for x in range(0, 12)];
a.sort();
b.sort();

for i in range(len(a), len(a) + len(b)):
    a.append(0);

print(a);
print(b);

for i in reversed(range(0, len(a))):
    a[i] = a[i-len(b)] if i >= len(b) else 0;

print(a);
print(b);

ia = len(b);
ib = 0;
ix = 0;
while(ia < len(a) and ib < len(b)):
    if (a[ia] <= b[ib]):
        a[ix] = a[ia];
        ia += 1;
    else:
        a[ix] = b[ib];
        ib += 1;
    ix += 1;

while(ia < len(a)):
    a[ix] = a[ia];
    ia += 1;
    ix += 1;
while(ib < len(b)):
    a[ix] = b[ib];
    ib += 1;
    ix += 1;

print("result", a);
c = a.copy();
c.sort();
print("result", c);
print("Success" if c == a else "You failed!");
