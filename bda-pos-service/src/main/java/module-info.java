module com.bdajaya.service {
    requires com.bdajaya.model;
    requires com.bdajaya.database;
    requires java.persistence;
    requires org.hibernate.orm.core;

    exports com.bdajaya.service;
}