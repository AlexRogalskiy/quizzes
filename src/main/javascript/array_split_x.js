// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(X, A) {

	var left = 0;
	var right = A.length - 1;

	while (left < right) {

		if (A[left] !== X && A[right] !== X) {
			left++;
			right--;

		} else {

			if (A[left] === X) {
				left++;
			}

			if (A[right] === X) {
				right--;
			}
		}
		if (left >= right) {
			return right + 1;
		}
	}

	return;
}

var a = [5, 5, 1, 7, 2, 3, 5];
console.log('a', solution(5, a))

var b = [1, 3, 2, 3, 4, 1, 3, 2, 3, 7, 9, 7, 3, 3];
console.log('b', solution(3, b));

var c = [3, 3, 6, 3, 3, 1, 3, 2, 3, 4, 1, 3, 2, 3, 3, 3];
console.log('c', solution(3, c));

var d = [1, 3, 1];
console.log('d', solution(3, d));

var e = [1, 2, 4, 1, 2, 3, 4, 3, 1];
console.log('e', solution(3, e));

var f = [0, 0, 0, 0, 0, 0, 10, 0];
console.log('f', solution(10, f));

var g = [0, 0, 0, 0, 0, 0, 0, 0];
console.log('g', solution(0, g));

var h = [1, 3, 2, 3, 4, 1, 3, 2, 3, 9, 3, 3];
console.log('h', solution(3, h));