package com.hbn.main;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hbn.configuration.HibernateConfig;
import com.hbn.entity.Address;
import com.hbn.entity.Employee;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Address a1 = new Address();
        a1.setCity("Noida");
        a1.setState("UP");
        
        Address a2 = new Address();
        a2.setCity("Meerut");
        a2.setState("UP");

        Employee e1 = new Employee();
        e1.setName("Amar Goswami");
        e1.setGender("Male");
        e1.setSalary(250000);

        Employee e2 = new Employee();
        e2.setName("Ujjawal Goswami");
        e2.setGender("Male");
        e2.setSalary(300000);

        ArrayList<Address> list1 = new ArrayList<>();
        list1.add(a1);
        list1.add(a2);

        e1.setAddress(list1);

        ArrayList<Address> list2 = new ArrayList<>();
        list2.add(a1);

        e2.setAddress(list2);

        session.persist(e1);
        session.persist(e2);

        tx.commit();
        session.close();

        System.out.println("Many To Many Mapping Saved Successfully");
    }
}
