// [-1, 3, -4, 5, 1, -6, 2, 1]
// [-1, +2, -2, +3, +4, -2, +0, +1]  = 1
// 
// -------------------------------------
// 
// [1, +3, +5, +02, +11]
// [+22, +11, +9, +4, 1]
// 
// -------------------------------------
// 
// [1, 2, 3, 100, 6]
// [1, 3, 6, 106, 112]
// 1 -> 111, 
// 3 -> 109
// 6 -> 106
// 106 -> 6 
// 
// 
// -------------------------------------
// -1  + 3 - 4 = -2 = 1 - 6 + 2 + 1
// 
// -1 + 3 - 4 = -2 = 1 - 6 + 2 + 1 (X)
// -1 + 3 - 4 + 5 = 3 = 1 - 6 + 2 + 1 + 5 (X)

function solution(a) {

	// console.log('################ SOLUTION ###############');
	// console.log('##### FOR: ', a);
	var na = [];
	var rightSide = 0;
	var leftSide = 0;
	var eqs = [];

	for (var i = a.length - 1; i >= 0; i--) {
		rightSide += a[i];
		na.push(rightSide);
	}

	// console.log('##### ACC: ', na);

	for (var i = 0; i < na.length; i++) {
		rightSide = na.length - 2 - i >= 0 ? na[na.length - 2 - i] : 0;
		// console.log('leftSide', leftSide, 'rightSide', rightSide);
		if (leftSide === rightSide) {
			return i;
		}
		leftSide += a[i];
	}

	return -1;
}

console.log(solution([1, 1, 1]));
console.log(solution([1, 1, 1, 1, 1]));
console.log(solution([1, 2, 3, 7, 6]));
console.log(solution([-1, 3, -4, 5, 1, -6, 2, 1]));
console.log(solution([4, 2, -12, 12, -6]));
console.log(solution([]));
console.log(solution([0]));
console.log(solution([0, 0, 0]));
console.log(solution([0]));
console.log(solution([1]));