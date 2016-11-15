__author__ = 'thiago'

import unittest

from src.main.python.com.thiagoh.cci.c1.Q1_2 import *;


class MyTestCase(unittest.TestCase):
    def test_something(self):
        s1 = "aaaaabbbbb";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));

        s1 = "qwertyuiopasdfghjklzxcvbnm";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));

        s1 = "jp4o fjwpojg wpoejgwpeog jwpoe jgpwoje gpwoejg powej gpowjegpoj3p2o3jg232j309g2j3 0g92j3 g0923j g0239gj2 03g9j23 0g92j3 g0293jg 0239gj203 9gj230 g92j 30g29j32093j2039gj2 30g92j3 g092j3g";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));

        s1 = None;
        self.assertEqual(None, creverse(s1));

        s1 = "a";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));

        s1 = "";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));

        s1 = "aaa";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));

        s1 = "aba";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));

        s1 = "abc";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));

        s1 = "abcd";
        self.assertEqual(''.join(reversed(s1)) + '\0', creverse(s1 + '\0'));


if __name__ == '__main__':
    unittest.main()
