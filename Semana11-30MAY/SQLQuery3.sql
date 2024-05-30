
select * from Sucursal where chr_sucucodigo='001';
select * from Cuenta where chr_sucucodigo='001';
go


select * from Asignado;
go


select count(1) cont from Asignado 
where chr_emplcodigo='0003' and dtt_asigfechabaja is null;
go


update sucursal 
set int_sucucontcuenta = int_sucucontcuenta + 1 
where chr_sucucodigo = ?
go

select int_sucucontcuenta from Sucursal where chr_sucucodigo = ?
go


select * from cuenta;
select * from Movimiento;

select * from TipoMovimiento;







