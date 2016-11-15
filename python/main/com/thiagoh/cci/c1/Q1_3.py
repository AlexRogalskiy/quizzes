__author__ = 'thiago'


def removeDuplicates(a):
    if (a == None or len(a) <= 1): return a;
    a = list(a);
    p = 1;
    n = 1;
    while n < len(a):
        b = False;
        for i in range(0, p):
            if a[n] == a[i]:
                b = True;
                break;
        if not b:
            a[p] = a[n];
            p += 1;
        n += 1;
    while p < len(a): a[p] = '\0'; p += 1;
    return ''.join(a);
