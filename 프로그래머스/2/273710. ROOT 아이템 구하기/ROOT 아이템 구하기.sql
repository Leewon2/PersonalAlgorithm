-- 코드를 작성해주세요
SELECT I.ITEM_ID, I.ITEM_NAME
FROM ITEM_INFO AS I JOIN ITEM_TREE AS IT ON I.ITEM_ID=IT.ITEM_ID
WHERE IT.PARENT_ITEM_ID IS NULL
ORDER BY I.ITEM_ID