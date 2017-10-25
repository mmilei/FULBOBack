grant select,insert on sigo.tbugs_new to sigoweb
/
grant select,insert on sigo.trenbugs_new to sigoweb
/
grant select on sigo.ttipos_inci to sigoweb
/
grant select on sigo.vcli to sigoweb
/
grant select on sigo.tclisigo to sigoweb
/
grant select on sigo.estados_new to sigoweb
/
grant select on condor.tcodvalo to sigoweb
/
create table tbugs_archivo (id_ticket number(6),
                            id_renglon number(3),
                            nombre varchar2(50),
                            extension varchar2(10),
                            datos blob,
                            primary key (id_ticket,id_renglon)
                            )
                            tablespace cdr_dat
/
grant select,update,delete,insert on sigo.tbugs_archivo to sigoweb
/
ALTER TABLE sigo.tbugs_new ADD email_contacto VARCHAR2(100)
/                    
INSERT INTO sigo.tcodprof (emp,codprof,nombre,nomabre,tiparea,estado,email)
VALUES (1,999,'Sigo Web','WEB',8,1,'helpdesk@opensolutions.com.ar')
/
insert into sigo.estados_new (estado,nombre)
values (5,'Ingresado')
/
Insert into SIGO.TRELUSR (EMP, CODPROF, USERNAME, MARCA)
Values (1, '999', 'SIGO', 'N')
/

                               
