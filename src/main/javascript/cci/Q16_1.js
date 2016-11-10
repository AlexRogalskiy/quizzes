function swap(a, b) {

	console.log('in  a,b', a, b);

	a = a - b;
	b = a + b;
	a = b - a;

	console.log('out a,b', a, b);
	console.log('--------------');
}

swap(0, 1);
swap(1, 2);
swap(10, 12);
swap(12, 12);
swap(-2, -1);
swap(-1, -2);