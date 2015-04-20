
def pal? n
	s = n.to_s
	h, t = 0, s.length - 1
	while h < t do
		return false if s[h] != s[t]
		h += 1
		t -= 1
	end
	return true
end

def max_pal 
	max = 0
	for d1 in 999.downto 100 do
		for d2 in 999.downto 100 do
			n = d1*d2
			if pal? n and n >= max
				puts d1.to_s + ' and ' + d2.to_s
				max = n
			end
		end
	end	
	return max
end