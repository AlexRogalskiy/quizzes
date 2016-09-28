(function(argument) {

	function bfs(root, act) {

		var arr = [];
		arr.push(root);
		act.level(root);

		while (arr.length > 0) {

			var n = arr.shift();

			for (var i = 0; i < n.nodes.length; i++) {
				arr.push(n.nodes[i]);
				act.level(n.nodes[i]);
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

	bfs(A, act());

})();