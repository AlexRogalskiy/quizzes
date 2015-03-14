__author__ = 'thiago'

import unittest

from src.main.python.com.thiagoh.cci.c1.Q1_3 import *


class MyTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(removeDuplicates(""), "");
        self.assertEqual(removeDuplicates(None), None);
        self.assertEqual(removeDuplicates("a"), "a");
        self.assertEqual(removeDuplicates("ab"), "ab");
        self.assertEqual(removeDuplicates("aab"), "ab\0");
        self.assertEqual(removeDuplicates("aaab"), "ab\0\0");

        s = "qwertyuiopasdfghjklzxcvbnm";
        sb = list();
        for i in range(0, len(s)): sb.append('\0');

        self.assertEqual(removeDuplicates(s), s);
        self.assertEqual(removeDuplicates(s + s), s + (''.join(sb)));

if __name__ == '__main__':
    unittest.main()
