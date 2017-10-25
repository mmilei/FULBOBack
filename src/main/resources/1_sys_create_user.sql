CREATE USER sigoweb IDENTIFIED BY "sigobackend!"
/
grant create session to sigoweb
/
grant CREATE TABLE to sigoweb
/
grant CREATE VIEW to sigoweb
/
ALTER USER sigoweb QUOTA 100M ON cdr_dat
/
grant execute on dbms_crypto to sigoweb
/
grant execute on dbms_crypto to sigo
/
grant select on condor.tcodvalo to sigoweb
/
