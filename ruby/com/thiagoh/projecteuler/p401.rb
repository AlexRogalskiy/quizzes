class Sol401

	@@m = {}
	@@d = {}
	@@s = {}

	@@f = File.new("bigsigma2", "w")
	
	def self.f
		@@f
	end

	def self.divisors n 
		a = []
		v = (n**0.5).ceil
		for i in 1..v do
			if n % i == 0
				a.push(i)
				a.push(n/i)
			end
		end
		a = a.uniq
		@@d[n] = a
		a
	end

	def self.sigma2 n
		a = @@d.has_key?(n) ? @@d[n] : divisors(n)
		sum = 0
		for i in a do
			sum += i**2
		end
		@@m[n] = sum
		sum
	end

#	def self.bigsigma2 n
#		last = @@s.max_by{|k,v| k}
#		lastkey = last.nil? ? 1 : last[0] + 1
#		sum = last.nil? ? 0 : last[1]
#		puts "looking for n #{n} found: " + last.inspect + " and lastkey is #{lastkey}"
#		for i in lastkey..n do
#			sum += @@m.has_key?(i) ? @@m[i] : sigma2(i)
#			#puts "i is #{i} with value of "
#		end
#		@@s[n] = sum
#		@@f.write("#{n}=#{sum}\n")
#		sum
#	end

	def self.bigsigma2 n, acc=1

		if n == 1
			return acc
		end

		v = bigsigma2(n - 1, sigma2(n) + acc)
		@@f.write("#{n}=#{v}\n")

		return v
	end

end

##
## SIGMA2(2) = sigma2(1) + sigma2(2)
## SIGMA2(3) = sigma2(1) + sigma2(2) + sigma2(3) = SIGMA2(2) + sigma2(3)
## SIGMA2(3) = sigma2(1) + sigma2(2) + sigma2(3)
## SIGMA2(4) = sigma2(1) + sigma2(2) + sigma2(3) + sigma2(4)
## SIGMA2(5) = sigma2(1) + sigma2(2) + sigma2(3) + sigma2(4) + sigma2(5)
##

puts 'Sol401.bigsigma2(1)' + Sol401.bigsigma2(1).to_s
puts 'Sol401.bigsigma2(2)' + Sol401.bigsigma2(2).to_s
puts 'Sol401.bigsigma2(3)' + Sol401.bigsigma2(3).to_s
puts 'Sol401.bigsigma2(4)' + Sol401.bigsigma2(4).to_s
puts 'Sol401.bigsigma2(5)' + Sol401.bigsigma2(5).to_s
puts 'Sol401.bigsigma2(6)' + Sol401.bigsigma2(6).to_s
puts 'Sol401.bigsigma2(10**1)' + Sol401.bigsigma2(10**1).to_s
puts 'Sol401.bigsigma2(10**2)' + Sol401.bigsigma2(10**2).to_s
puts 'Sol401.bigsigma2(10**3)' + Sol401.bigsigma2(10**3).to_s
puts 'Sol401.bigsigma2(10**4)' + Sol401.bigsigma2(10**4).to_s
#puts 'Sol401.bigsigma2(10**5)' + Sol401.bigsigma2(10**5).to_s
#puts 'Sol401.bigsigma2(10**6)' + Sol401.bigsigma2(10**6).to_s
#puts 'Sol401.bigsigma2(10**15)' + Sol401.bigsigma2(10**15).to_s

Sol401.f.close