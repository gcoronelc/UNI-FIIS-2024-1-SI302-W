
select * from MATRICULA where alu_id=3;
go

SELECT * FROM CURSO;
go

SELECT 
	M.cur_id AS codigo_curso, C.cur_nombre AS nombre_curso, 
	CASE WHEN C.cur_profesor IS NULL THEN 'NO DISPONIBLE' 
	WHEN LEN(C.cur_profesor) = 0 THEN 'NO DISPONIBLE' 
	ELSE C.cur_profesor END  AS profesor, 
	M.mat_tipo AS tipo, M.mat_precio AS precio, 
	M.mat_nota AS nota,
	CASE WHEN M.mat_nota IS NULL THEN 'None'
	WHEN M.mat_nota < 12 THEN 'Desaprobado'
	ELSE 'Aprobado' END Condicion 
FROM MATRICULA M 
JOIN CURSO C ON M.cur_id = C.cur_id 
--WHERE M.alu_id = ? 
ORDER BY 1;
go