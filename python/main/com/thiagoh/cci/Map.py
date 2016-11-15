__author__ = 'thiago'


class Map:
    def __init__(self):
        self.map = [];

    class Entry:
        def __init__(self, k, v):
            self.key = k;
            self.value = v;

    def __getEntries__(self, id):
        if id == None: return None;
        h = hash(id);
        for i in range(0, len(self.map)):
            if h == self.map[i][0]: return self.map[i][1];
        return None;

    def get(self, key):
        if key == None: return None;
        h = hash(key);
        entries = self.__getEntries__(key);
        if entries == None: return None;
        p = 0;
        for i in range(0, len(entries)):
            if entries[i] != None and entries[i].key == key:
                return entries[i].value;
        return None;

    def put(self, key, value):
        if key == None: return;
        entries = self.__getEntries__(key);
        if entries == None:
            entries = [];
            self.map.append([hash(key), entries]);
        p = -1;
        for i in range(0, len(entries)):
            if entries[i] != None and entries[i].key == key:
                p = i;
                break;
        if p == -1:
            entries.append(Map.Entry(key, value));
        else:
            entries[p] = Map.Entry(key, value);