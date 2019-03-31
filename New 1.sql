create table classes(
 clss varchar2(200),
 synopsis varchar2(5000),
 id int
);
CREATE SEQUENCE classes_seq;
CREATE TRIGGER classes_bi
BEFORE INSERT ON classes
FOR EACH ROW
BEGIN
  SELECT classes.nextval
  INTO :new.id
  FROM dual;
END;