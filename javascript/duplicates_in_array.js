var arr1 = [12, 0, 2, 17, 32, 9, 15, 5, 6, 7, 1, 13, 4, 33, 47, 100];
var arr2 = [19, 13, 3, 11, 0, 4, 100];
arr1.sort(function(o1, o2) {
	return o1 - o2;
});
arr2.sort(function(o1, o2) {
	return o1 - o2;
});

// console.log(arr1);
// console.log(arr2);

var i = 0,
	j = 0,
	dup = [];

while (i < arr1.length && j < arr2.length) {

	console.log(i, j, arr1[i], arr2[j]);

	if (arr1[i] === arr2[j] && typeof arr1[i] !== 'undefined') {

		dup.push(arr1[i]);
		i++;
		j++;
	} else {

		if (arr1[i] < arr2[j]) {
			i++;
		} else {
			j++;
		}
	}
}

console.log(dup);