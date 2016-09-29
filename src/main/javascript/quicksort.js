(function() {

	/*
	 * Quicksearch
	 * Pros
	 * Does not use extra space
	 * Cons
	 * O(n^2) in average case
	*/
	var quicksort = function quicksort(arr, lo, hi) {

		if (hi > lo) {
			var pivot = partition(arr, lo, hi);
			quicksort(arr, lo, pivot - 1);
			quicksort(arr, pivot, hi);
		}

		return arr;
	}


	function swap(arr, i, j) {
		var t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
		return arr;
	}

	function partition(arr, lo, hi) {

		var pivot = Math.floor((hi + lo) / 2.0);

		while (lo <= hi) {

			while (arr[lo] < arr[pivot]) lo++;
			while (arr[pivot] < arr[hi]) hi--;

			if (lo <= hi) {
				swap(arr, lo, hi);
				lo++;
				hi--;
			}
		}

		return lo;
	}

	module.exports = quicksort;

	// var a = [5, 1, 6, 3, 4, 5, 6, 7, 2, 4, 1, 9, 8, 3, 5, 1, 9, 2, 5, 7];
	// console.log(quicksort(a, 0, a.length - 1));
	// var b = [];
	// for (var i = 0; i < 400; i++) {
	// 	b.push(parseInt(Math.random() * 1000, 10));
	// }
	// console.log(quicksort(b, 0, b.length - 1));

}());