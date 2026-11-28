select contest_id, (count(*)/(select count(*) from Users)*100) as percentage from Register
group by contest_id
order by percentage desc, contest_id asc;