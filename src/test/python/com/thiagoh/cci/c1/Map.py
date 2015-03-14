__author__ = 'thiago'

import unittest

from src.main.python.com.thiagoh.cci import Map;


class MapTest(unittest.TestCase):
    def test_map(self):
        m = Map.Map();
        m.put("a", 123);
        m.put("b", 123);
        m.put("c", 123);

        self.assertEqual(m.get("a"), 123);
        self.assertEqual(m.get("b"), 123);
        self.assertEqual(m.get("c"), 123);
        self.assertEqual(m.get("a"), m.get("b"));
        self.assertEqual(m.get("b"), m.get("c"));

        o = object();

        m.put("d", o);
        m.put("e", o);
        self.assertEqual(m.get("d"), m.get("e"));

        m.put("d", None);
        self.assertEqual(m.get("d"), None);
        self.assertNotEqual(m.get("d"), m.get("e"));

        m.put(None, None);


if __name__ == '__main__':
    unittest.main()
