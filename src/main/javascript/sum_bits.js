// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function reverseBits(bits) {
	var reverse = '';
	// complement by 2 (reverse bits)
	for (var j = 0; j < bits.length; j++) {
		reverse += bits[j] === '1' ? '0' : '1';
	}
	return reverse;
}

function add1(bits) {
	var outBits = "";
	var goes = 1;
	for (var i = bits.length - 1; i >= 0; i--) {

		if (goes === 1) {

			if (bits[i] + '' === '0') {
				outBits = '1' + outBits;
				goes = 0;
			} else {
				outBits = '0' + outBits;
			}
		} else {
			outBits = bits[i] + outBits;
		}
	}

	outBits = '1' + outBits;

	return outBits;
}

function solution(A) {

	var sum = 0;
	var i = 0;

	for (; i < A.length; i++) {
		sum += A[i] * Math.pow(-2, i);
	}

	var remain = 0;
	var originalSum = sum;
	var bits = "";

	if (originalSum < 0) {
		sum = sum * -1;
	}

	do {

		remain = sum % 2;
		sum = sum / 2;
		bits = parseInt(remain) + bits;

	} while (sum >= 1);

	// console.log('bits', bits);
	
	// complement by 2 
	var outBits = add1(reverseBits(bits));

	// console.log(originalSum, 'stands for', bits);
	// console.log(originalSum, 'complement by two is', outBits);

	return outBits;
}

console.log(solution([1, 0, 0, 1, 1]));
console.log(solution([1, 0, 0, 1, 1, 1]));