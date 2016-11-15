__author__ = 'thiago'

def unique(s):
    if s == None or len(s) <= 1: return True;
    b = [False] * 100;
    aV = ord('a');
    for i in range(0, len(s)):
        c = ord(s[i]) - aV;
        if b[c] :
            return False;
        b[c] = True;
    return True;