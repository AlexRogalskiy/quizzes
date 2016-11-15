SELECT
	to_char(l.Date_Time, 'DD/MM/YYYY') as 'Date',
	u.Name as 'User Name',
	count(*) as 'Number of logins per day'
FROM
	Users u
	left join Logins_System l on
		u.idUser = l.idUser
WHERE
	extract(year from l.Date_Time) = extract(year from now())
GROUP BY
	to_char(l.Date_Time, 'DD/MM/YYYY')
