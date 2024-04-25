
select * from cuenta where chr_cuencodigo='00100001';
select * from movimiento where chr_cuencodigo='00100001';
go

select m.int_movinumero id,
CONVERT(varchar(30),m.dtt_movifecha,105) fecha,
t.vch_tipodescripcion tipo, 
m.dec_moviimporte importe 
from Movimiento m join TipoMovimiento t 
on m.chr_tipocodigo = t.chr_tipocodigo 
where m.chr_cuencodigo = '00100005' 
order by 1;
go



select count(1) cont from Cuenta where chr_cuencodigo='00100000';
go






