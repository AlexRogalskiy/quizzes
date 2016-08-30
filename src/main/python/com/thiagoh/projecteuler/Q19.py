from math import *;

# hint 
# formula (month_days + how_many_weekdays_from_the_first_day_of_month) mod 7 

# for example:
# http://www.timeanddate.com/calendar/?year=1906&country=27
# January is (31 + 1) mod 7 = z => z = 4 ... go on with the search
# February is (28 + z) mod 7 = x => x = 4 ... go on with the search
# March is (31 + x) mod 7 = y => y = 0 <=== this is a sunday on the first day of month!
# April is (30 + y) mod 7 = t => t = 2 ... go on with the search

def solve(from, to):
	pass

print 'The maximum total from top to bottom is: ' + str(solve(triangle_arr));