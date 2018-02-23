SELECT *
FROM work_time
WHERE
    task_id = /*taskId */1
      AND data_in <= /* now */'2017-01-01 00:00:00'
      AND data_out >= /* now */'2017-01-01 00:00:00'
      AND data_thru >= /* now */'2017-01-01 00:00:00'
      AND data_from <= /* now */'2017-01-01 00:00:00'