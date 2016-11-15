(function() {

	/*
	 * Mergesort
	 * Pros
	 * O(n logn) in average case
	 * Cons
	 * Use extra space O(n)
	 */

	var mergesort = function mergesort(arr, start, end) {

		return _mergesort(arr, start, end, []);
	};

	function _mergesort(arr, start, end, out) {

		var middle = Math.floor((start + end) / 2);

		if (start < end) {

			_mergesort(arr, start, middle, out);
			_mergesort(arr, middle + 1, end, out);
			_merge(arr, start, middle, end, out);
		}

		return out;
	}

	function _merge(arr, start, middle, end, out) {

		var outIx = start,
			lo = start,
			hi = end,
			mid = middle + 1;

		while (lo <= middle && mid <= end) {

			if (arr[lo] <= arr[mid]) {
				out[outIx++] = arr[lo++];
			} else {
				out[outIx++] = arr[mid++];
			}
		}

		while (lo <= middle) {
			out[outIx++] = arr[lo++];
		}

		while (mid <= end) {
			out[outIx++] = arr[mid++];
		}

		for (var i = start; i <= end; i++) {
			arr[i] = out[i];
		}

		return arr;
	}

	module.exports = mergesort;

	var a = [5, 1, 6, 3, 4, 5, 6, 7, 2, 4, 1, 9, 8, 3, 5, 1, 9, 2, 5, 7];
	console.log(mergesort(a, 0, a.length - 1));

	var b = [];
	for (var i = 0; i < 400; i++) {
		b.push(parseInt(Math.random() * 1000, 10));
	}
	console.log(mergesort(b, 0, b.length - 1));

}());