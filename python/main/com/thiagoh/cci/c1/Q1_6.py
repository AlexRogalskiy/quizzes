__author__ = 'thiago'

import math

def rotateLeft(a):
    if (a == None or len(a) <= 1): return a;
    for D in range(0, math.floor(len(a)/2)):
        x = 0;
        W = len(a) - 1;
        while (x + D < W - D):
            l1 = a[D + x][D];
            l2 = a[W - D][x + D];
            l3 = a[W - x - D][W - D];
            l4 = a[D][W - x - D];
            a[D + x][D] = l2; # l1 <- l2
            a[W - D][x + D] = l3; # l2 <- l3
            a[W - x - D][W - D] = l4; # l3 <- l4
            a[D][W - x - D] = l1; # l4 <- l1
            x += 1;

def rotateRight(a):
    if (a == None or len(a) <= 1): return a;
    for D in range(0, math.floor(len(a)/2)):
        x = 0;
        W = len(a) - 1;
        while (x + D < W - D):
            l1 = a[D + x][D];
            l2 = a[W - D][x + D];
            l3 = a[W - x - D][W - D];
            l4 = a[D][W - x - D];
            a[D + x][D] = l4; #l1 <- l4
            a[W - D][x + D] = l1; # l2 <- l1
            a[W - x - D][W - D] = l2; # l3 <- l2
            a[D][W - x - D] = l3; # l4 <- l3
            x += 1;

def printArr(a):
    for line in a:
        print(line);
    print();

arr4x4 = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12],[13, 14, 15, 16]];
printArr(arr4x4);
rotateLeft(arr4x4);
printArr(arr4x4);

arr4x4 = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12],[13, 14, 15, 16]];
printArr(arr4x4);
rotateRight(arr4x4);
printArr(arr4x4);
