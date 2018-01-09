const swap = (A, p, q) => {
  const n = q - p + 1;
  let OutputA = Array.prototype.slice.call(A, 0); // to make this function pure
  if (n < 2) {
    return OutputA;
  }

  if (OutputA[p] > OutputA[p + 1]) {
    v = OutputA[p];
    OutputA[p] = OutputA[p + 1];
    OutputA[p + 1] = v;
  }

  return OutputA;
};

// A => the Array
// L => left position of the array to start merging
// R => right position of the array to start merging
// S => size of the array
// n => merging factor (will merge 2 elemeents of two arrays when n=2; will merge 4 elements of two arrays when n=4 and so on.)
const merge = (A, L, R, S, n) => {
  let l = L;
  let r = R;
  let k = L;
  let OutputA = Array.prototype.slice.call(A, 0); // to make this function pure

  // Explanation of l < Math.min(R, S)
  // l must be < R if R < S otherwise l must be < S; that's why => l < Math.min(R, S)
  // Textual explanation:
  // Sometimes R > S; you can see that in the following for instance
  // L = 8
  // R = 12
  // S = 10
  // n = 4
  // then we want to merge 4 elements (since n=4) of A from L=8 up to four elements and from R=12 up to four elements
  // however, the array size is S=10 so l < S (l must be lower than S because S < R)
  while (l < Math.min(R, S) && r < S) {
    if (A[l] > A[r]) {
      OutputA[k++] = A[r++];
    } else {
      OutputA[k++] = A[l++];
    }
  }

  while (l < Math.min(R, S)) {
    OutputA[k++] = A[l++];
  }

  while (r < S) {
    OutputA[k++] = A[r++];
  }

  return OutputA;
};

const iterativeMergeSort = (A, p, q) => {
  const S = q - p + 1;
  let OutputA = Array.prototype.slice.call(A, 0); // to make this function pure
  if (S < 2) {
    return OutputA;
  }
  for (let j = 0; j < S; j += 2) {
    OutputA = swap(OutputA, j, j + 1);
  }

  if (S === 2) {
    return OutputA;
  }

  let n = 2;
  let L = 0;
  let R = n + L;
  let i = 0;
  while (n < S) {
    while (L < S) {
      OutputA = merge(OutputA, L, R, Math.min(n + R, S), n);
      i++;
      L = i * n * 2;
      R = L + n;
    }
    n *= 2;
    L = 0;
    R = L + n;
    i = 0;
  }

  return OutputA;
};

module.exports = iterativeMergeSort;
