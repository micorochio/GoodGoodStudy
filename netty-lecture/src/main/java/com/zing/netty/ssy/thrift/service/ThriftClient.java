package com.zing.netty.ssy.thrift.service;

import com.alibaba.fastjson.JSONObject;
import com.zing.netty.ssy.thrift.entity.DataException;
import com.zing.netty.ssy.thrift.entity.Person;
import com.zing.netty.ssy.thrift.entity.PersonService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost" ,8899),600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);
        try {
            transport.open();
            Person p = client.getPerson("haha");
            System.out.println(JSONObject.toJSONString(p));

            Person pp = new Person();
            pp.setName("sb");
            pp.setAddress("jhasdgkjhds");
            pp.setDate("19910606");

            client.savePerson(pp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transport.close();
        }
    }
}
