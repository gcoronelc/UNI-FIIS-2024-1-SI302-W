
select * from Cuenta;
go


declare @cuenta varchar(8);
set @cuenta = '00200003';
select * from Cuenta where chr_cuencodigo=@cuenta;
select * from Movimiento where chr_cuencodigo=@cuenta order by 2 desc;
go

select * from cliente