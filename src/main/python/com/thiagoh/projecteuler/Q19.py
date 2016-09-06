from math import *;

# hint 
# formula (month_days + how_many_weekdays_from_the_first_day_of_month) mod 7 

# for example:
# http://www.timeanddate.com/calendar/?year=1906&country=27
# January is (31 + 1) mod 7 = z => z = 4 ... go on with the search
# February is (28 + z) mod 7 = x => x = 4 ... go on with the search
# March is (31 + x) mod 7 = y => y = 0 <=== this is a sunday on the first day of month!
# April is (30 + y) mod 7 = t => t = 2 ... go on with the search

months = [0,31,28,31,30,31,30,31,31,30,31,30,31];

def is_leap_year( year):
	return (year % 4 == 0 and year % 100 != 0) or year % 400 == 0;

def get_days_of_month(month, year):
	if month == 2 and is_leap_year(year): 
		return 29;
	return months[month];

def solve(distance_from_sunday_in_days, from_month, from_year, to_month, to_year):

	sunday_count = 0;

	if distance_from_sunday_in_days == 0:
		sunday_count += 1;

	while from_year < to_year or (from_year == to_year and from_month < to_month):

		days_of_month = get_days_of_month(from_month, from_year);
		distance_from_sunday_in_days = (days_of_month + distance_from_sunday_in_days) % 7;

		if (distance_from_sunday_in_days == 0):
			sunday_count += 1;

		from_month += 1;

		if from_month == 13:
			from_year += 1;
			from_month = 1;

		print 'from_year', from_year, 'from_month', from_month, 'distance_from_sunday_in_days', distance_from_sunday_in_days

	return sunday_count

print 'The number of Sundays is: ' + str(solve(2, 1, 1901, 12, 2000));