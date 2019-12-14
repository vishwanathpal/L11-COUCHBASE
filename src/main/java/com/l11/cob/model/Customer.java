package com.l11.cob.model;

import com.couchbase.client.java.repository.annotation.Field;
import java.util.Arrays;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document
public class Customer {

    @Id
    private int id;
    @Field
    private String name;
    @Field
    private String[] address;

   /* public Customer(int id, String name, String[] address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + Arrays.toString(address) +
                '}';
    }
}