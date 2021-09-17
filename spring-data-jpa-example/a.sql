select employee0_.id as id1_0_, employee0_.name as name2_0_, employee0_.username as username3_0_ 
from employee employee0_ left outer join task ownedtasks1_ on employee0_.id=ownedtasks1_.owner_id 
where ownedtasks1_.id=5


select employee0_.id as id1_0_, employee0_.name as name2_0_, employee0_.username as username3_0_ 
from employee employee0_ left outer join task assignedta1_ on employee0_.id=assignedta1_.assignee_id 
where assignedta1_.id=4