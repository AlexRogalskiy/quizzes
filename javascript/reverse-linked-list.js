(function() {

	var Node = function Node(label) {
		this.label = label;
		this.next;
	};

	var reverse = function reverse(head) {

		var last;
		var node = head;

		while (typeof node !== 'undefined') {

			var next = node.next;
			node.next = last;
			last = node;
			node = next;
		}

		// console.log(last);

		return last;
	};

	function print(head) {

		var s = '';
		var node = head;
		while (typeof node !== 'undefined') {
			s += node.label + ',';
			node = node.next;
		}

		console.log(s);
	}

	module.exports = reverse

	var head = new Node('A');
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
	var M = new Node('M');

	head.next = B;
	B.next = C;
	C.next = D;
	D.next = E;
	E.next = F;
	F.next = G;
	G.next = H;
	H.next = I;
	I.next = J;
	J.next = L;
	L.next = M;

	print(reverse(head));

}());