SELECT t.*, n.name
FROM task t
INNER JOIN task_name n
ON t.id = n.task_id
  AND n.`in` <= /* now */'2017-01-01 00:00:00'
  AND n.out >= /* now */'2017-01-01 00:00:00'
  AND n.thru >= /* now */'2017-01-01 00:00:00'
WHERE t.out >= /* now */'2017-01-01 00:00:00'

