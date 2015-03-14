__author__ = 'thiago'

import random


def mergeSort(arr):
    tmp = [0 for x in arr];
    mergeSort0(arr, tmp, 0, len(arr))


def mergeSort0(arr, tmp, left, right):
    if right - left <= 1: return;
    middle = int((right + left) / 2);
    mergeSort0(arr, tmp, left, middle);
    mergeSort0(arr, tmp, middle, right);
    merge(arr, tmp, left, middle, right);


def merge(arr, tmp, leftStart, rightStart, end):
    k = left = leftStart;
    right = rightStart;
    while (left < rightStart and right < end):
        if (arr[left] <= arr[right]):
            tmp[k] = arr[left];
            left += 1;
        else:
            tmp[k] = arr[right];
            right += 1;
        k += 1;
    while (left < rightStart):
        tmp[k] = arr[left];
        left += 1;
        k += 1;
    while (right < end):
        tmp[k] = arr[right];
        right += 1;
        k += 1;
    for i in range(leftStart, end):
        arr[i] = tmp[i];


arr1 = [random.randrange(1, 100) for x in range(0, 30)];
# arr1 = [10, 1, 8, 2, 4, 7, 5, 1, 1, 4];
print("len ", len(arr1), arr1);
mergeSort(arr1);
print("len ", len(arr1), arr1);
