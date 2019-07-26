

!--HELPFUL SQL COMMANDS:

!-- retrieve users with assigned roles:
select * from users as u
inner join authorities as ur on u.id = ur.user_id
inner join roles as r on r.id = ur.role_id
!-- specific user
where u.id = 2;