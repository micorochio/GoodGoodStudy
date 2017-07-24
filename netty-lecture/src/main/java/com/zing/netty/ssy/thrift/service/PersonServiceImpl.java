package com.zing.netty.ssy.thrift.service;

import com.zing.netty.ssy.thrift.entity.DataException;
import com.zing.netty.ssy.thrift.entity.Person;
import com.zing.netty.ssy.thrift.entity.PersonService;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPerson(String userName) throws DataException, org.apache.thrift.TException {
        System.out.println("name is" + userName);
        Person person = new Person();
        person.setAddress("adfkhas");
        person.setDate("20170722");
        person.setName(userName);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, org.apache.thrift.TException {
        System.out.println("name is "+person.name);
        System.out.println("address is "+person.address);
        System.out.println("date is "+person.date);
    }
}
