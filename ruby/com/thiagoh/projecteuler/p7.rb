def prime?(n)
    return true if n == 2 || n == 3
    return false if n % 2 == 0 || n % 3 == 0
 
    i = 5
    while i*i <= n do
        return false if (n % i == 0 || n % (i + 2) == 0)
        i += 6
    end
    return true
end

def get_10001st_prime
	order = 0
	n = 2
	while true
		if prime? n
			order += 1
			return n if order == 10001
		end
		n += 1
	end
end