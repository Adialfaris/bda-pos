module com.bdajaya.database {
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires com.bdajaya.model;
    requires java.naming;
    requires java.sql;
    
    exports com.bdajaya.database;
}