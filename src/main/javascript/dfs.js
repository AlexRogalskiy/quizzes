(function(argument) {

	function dfs(root, act) {

		var arr = [];
		arr.push(root);

		while (arr.length > 0) {

			var n = arr.pop();
			act.level(n);
			n.cix = typeof n.cix === 'undefined' ? 0 : n.cix;

			for (var i = n.nodes.length - 1; i >= 0; i--) {
				arr.push(n.nodes[i]);
			}
		}

		act.printResult();
	}
	var A = require('./nodes.js')();

	function act() {

		var s = '';

		this.level = function(node) {
			s += node.label + ',';
		}

		this.printResult = function() {
			console.log(s);
		}

		return this;
	}

	dfs(A, act());

})();