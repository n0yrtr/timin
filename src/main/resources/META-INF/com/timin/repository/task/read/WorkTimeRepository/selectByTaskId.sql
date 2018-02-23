SELECT *
FROM work_time
WHERE
    task_id = /*taskId */1
    AND `out` >= /*now*/'2017-01-01 00:00:00';