__author__ = 'thiago'


def creverse(s):
    if s == None: return None;
    if len(s) <= 2: return s;
    sarr = list(s);
    p1 = 0;
    p2 = len(sarr) - 2;
    t = 0;
    while (p1 < p2):
        t = sarr[p1];
        sarr[p1] = sarr[p2];
        sarr[p2] = t;
        p1 += 1;
        p2 -= 1;
    return ''.join(sarr);
