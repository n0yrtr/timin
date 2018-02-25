SELECT t.*, n.name
FROM task t
INNER JOIN task_name n
ON t.id = n.task_id
  AND n.data_in <= /* now */'2017-01-01 00:00:00'
  AND n.data_out >= /* now */'2017-01-01 00:00:00'
  AND n.data_from <= /* now */'2017-01-01 00:00:00'
  AND n.data_thru >= /* now */'2017-01-01 00:00:00'

INNER JOIN category_association ca
ON t.id = ca.task_id
  AND ca.data_in <= /* now */'2017-01-01 00:00:00'
  AND ca.data_out >= /* now */'2017-01-01 00:00:00'
  AND ca.data_from <= /* now */'2017-01-01 00:00:00'
  AND ca.data_thru >= /* now */'2017-01-01 00:00:00'

WHERE
  ca.category_id = /*categoryId */1
  AND t.data_in <= /* now */'2017-01-01 00:00:00'
  AND t.data_out >= /* now */'2017-01-01 00:00:00'
  AND t.data_thru >= /* now */'2017-01-01 00:00:00'
  AND t.data_from <= /* now */'2017-01-01 00:00:00'