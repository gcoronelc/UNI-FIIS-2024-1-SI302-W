sp_help movimiento


select chr_cliecodigo codigo, vch_cliepaterno paterno,  
vch_cliematerno materno, vch_clienombre nombre,   
chr_cliedni dni, vch_clieciudad ciudad,
vch_cliedireccion direccion, vch_clietelefono telefono,
vch_clieemail email 
from cliente where chr_cliecodigo = '00003';
go


