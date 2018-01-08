const recursiveInsertionSort = (A, p, r) => {
  const n = r - p + 1;
  let OutputA = Array.prototype.slice.call(A, 0); // to make this function pure
  if (n <= 1) {
    return OutputA;
  }
  const key = A[r];

  if (n > 2) {
    OutputA = recursiveInsertionSort(OutputA, p, r - 1);
    let i = r - 1;
    while (i >= p && OutputA[i] > key) {
      OutputA[i + 1] = OutputA[i];
      i--;
    }
    OutputA[i + 1] = key;
  } else {
    if (OutputA[p] > key) {
      // swap
      OutputA[p + 1] = OutputA[p];
      OutputA[p] = key;
    }
  }

  return OutputA;
};

module.exports = recursiveInsertionSort;
