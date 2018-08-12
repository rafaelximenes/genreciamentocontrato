delete from endereco where email_usuario not in ('fabiiolaellen@gmail.com', 'rafa.ximenes1@gmail.com');
delete from  usuario_alerta where email_usuario not in ('fabiiolaellen@gmail.com', 'rafa.ximenes1@gmail.com');
delete from   historico_alerta where email_usuario not in ('fabiiolaellen@gmail.com', 'rafa.ximenes1@gmail.com');
delete from link where id_historico in (select id_historico_alerta from historico_alerta where email_usuario not in ('fabiiolaellen@gmail.com', 'rafa.ximenes1@gmail.com'))
delete from historico_alerta where email_usuario not in ('fabiiolaellen@gmail.com', 'rafa.ximenes1@gmail.com')
delete from pagamento where email_usuario not in ('fabiiolaellen@gmail.com', 'rafa.ximenes1@gmail.com');
DELETE FROM public.usuario WHERE email not in ('fabiiolaellen@gmail.com', 'rafa.ximenes1@gmail.com');