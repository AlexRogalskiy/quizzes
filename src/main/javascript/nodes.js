module.exports = function() {

	var Node = function Node(label) {
		this.label = label;
		this.nodes = [];
	};

	var A = new Node('A');

	var B = new Node('B');
	var C = new Node('C');
	var D = new Node('D');

	A.nodes = [B, C, D];

	var E = new Node('E');
	var F = new Node('F');
	var G = new Node('G');

	B.nodes = [E, F, G];

	var H = new Node('H');
	var I = new Node('I');

	C.nodes = [H, I];

	var J = new Node('J');

	D.nodes = [J];

	var L = new Node('L');
	var M = new Node('M');
	var N = new Node('N');

	H.nodes = [L, M, N];

	var O = new Node('O');
	var P = new Node('P');

	L.nodes = [O, P];

	return A;
}