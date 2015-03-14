__author__ = 'thiago'

import unittest

from src.main.python.com.thiagoh.cci.c1.Q1_1 import *


class MyTestCase(unittest.TestCase):
    def test_something(self):
        self.assertTrue(unique(None));
        self.assertTrue(unique(""));
        self.assertTrue(unique("a"));
        self.assertTrue(unique("ab"));
        self.assertTrue(unique("abc"));
        self.assertTrue(unique("abcd"));

        s = "qwertyuiopasdfghjklzxcvbnm";
        self.assertTrue(unique(s));

        self.assertFalse(unique("abcda"));
        self.assertFalse(unique("abcdb"));
        self.assertFalse(unique("abcdc"));
        self.assertFalse(unique("abcdd"));
        self.assertFalse(unique("aa"));
        self.assertFalse(unique("aba"));
        self.assertFalse(unique("bb"));
        self.assertFalse(unique("cc"));
        self.assertFalse(unique("dd"));
        self.assertFalse(unique(s + s));

if __name__ == '__main__':
    unittest.main()
