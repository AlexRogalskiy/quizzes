(function() {

	var Node = function Node(label) {
		this.label = label;
		this.next = undefined;
	};

	var A = new Node('A');
	var B = new Node('B');
	var C = new Node('C');
	var D = new Node('D');
	var E = new Node('E');
	var F = new Node('F');
	var G = new Node('G');
	var H = new Node('H');
	var I = new Node('I');
	var J = new Node('J');
	var L = new Node('L');

	A.next = B;
	B.next = C;
	C.next = D;
	D.next = E;
	E.next = F;
	F.next = G;

	H.next = I;
	I.next = J;
	J.next = L;
	L.next = D;

	function findConvergingPoint(list1, list2) {

		var length1 = 0;
		var length2 = 0;
		var current_node = list1;

		while (current_node !== undefined) {
			length1++;
			current_node = current_node.next;
		}

		current_node = list2;

		while (current_node !== undefined) {
			length2++;
			current_node = current_node.next;
		}

		var start_point = list1,
			other_point = list2;

		if (length1 > length2) {

			start_point = list1;
			other_point = list2;

		} else if (length1 < length2) {

			start_point = list2;
			other_point = list1;
		}

		for (var i = 0; i < Math.abs(length1 - length2); i++) {
			start_point = start_point.next;
		}

		while (start_point !== undefined) {
			if (start_point === other_point) {
				return start_point;
			} else {
				start_point = start_point.next;
				other_point = other_point.next;
			}
		}

		return undefined;
	}

	console.log(findConvergingPoint(A, H));

}());