select s.user_id, round(ifnull(avg(t.action = 'confirmed'),0),2) as confirmation_rate from Signups s
left join Confirmations t
on s.user_id = t.user_id
group by s.user_id;