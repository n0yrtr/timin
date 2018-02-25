SELECT c.*
FROM category c
WHERE c.data_in <= /* now */'2017-01-01 00:00:00'
  AND c.data_out >= /* now */'2017-01-01 00:00:00'
  AND c.data_thru >= /* now */'2017-01-01 00:00:00'
  AND c.data_from <= /* now */'2017-01-01 00:00:00'


