-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO AS FI JOIN FISH_NAME_INFO AS FN ON FI.FISH_TYPE=FN.FISH_TYPE
WHERE FN.FISH_NAME='BASS' OR FN.FISH_NAME='SNAPPER'
