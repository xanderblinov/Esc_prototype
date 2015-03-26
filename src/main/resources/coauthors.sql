--helper script for fetching co-authors


SELECT
  co._id        AS co_id,
  co.year       AS co_year,
  co.article_id AS co_artid,
  co.author     AS co_aid,
  a_a.name      AS aname,
  co.coauthor   AS co_coaid,
  a_coa.name    AS coaname,
  a_a.click     AS aclick,
  a_coa.click   AS acoaclick
FROM co_authorship AS co
  JOIN author AS a_a ON (a_a._id = co.author)
  JOIN author AS a_coa ON (a_coa._id = co.coauthor);
