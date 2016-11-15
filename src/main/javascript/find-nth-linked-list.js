(function() {

	var Node = function Node(label) {
		this.label = label;
		this.next = undefined;
	};

	var findNthOnLinkedList = function findNthOnLinkedList(head, n) {

		var nBackNode = head;
		var node = head;
		var counter = n;

		while (typeof node !== 'undefined') {
			if (counter-- <= 0) {
				nBackNode = nBackNode.next;
			}

			node = node.next;
		}

		return nBackNode;
	};

	module.exports = findNthOnLinkedList;

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

	console.log(findNthOnLinkedList(head, 3).label);
	console.log(findNthOnLinkedList(head, 5).label);
	console.log(findNthOnLinkedList(head, 10).label);
	console.log(findNthOnLinkedList(head, 12).label);
	console.log(findNthOnLinkedList(head, 15).label);

}());