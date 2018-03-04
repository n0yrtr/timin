SELECT
  t.*, n.name
FROM task t
INNER JOIN task_name n
ON t.id = n.task_id
  AND n.data_in <= /* now */'2017-01-01 00:00:00'
  AND n.data_out >= /* now */'2017-01-01 00:00:00'
  AND n.data_from <= /* now */'2017-01-01 00:00:00'
  AND n.data_thru >= /* now */'2017-01-01 00:00:00'
INNER JOIN active a
ON t.id = a.task_id
  AND a.data_in <= /* now */'2017-01-01 00:00:00'
  AND a.data_out >= /* now */'2017-01-01 00:00:00'
  AND a.data_thru >= /* now */'2017-01-01 00:00:00'
  AND a.data_from <= /* now */'2017-01-01 00:00:00'
WHERE
t.data_in <= /* now */'2017-01-01 00:00:00'
  AND t.data_out >= /* now */'2017-01-01 00:00:00'
  AND t.data_thru >= /* now */'2017-01-01 00:00:00'
  AND t.data_from <= /* now */'2017-01-01 00:00:00'