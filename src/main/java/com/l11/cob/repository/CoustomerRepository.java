package com.l11.cob.repository;

import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.SimpleN1qlQuery;
import com.l11.cob.model.Customer;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "customer", viewName = "all")
//@N1qlPrimaryIndexed
//@ViewIndexed(designDoc = "customer")
@Repository
//@ViewIndexed(designDoc = "customer")
public interface CoustomerRepository extends CouchbaseRepository<Customer, Integer> {


   // @Query("#{#n1ql.name} where #{#n1ql.name} = Ryan within #{#n1ql.customer}")
    //@Query("#{#n1ql.selectEntity} where #{#n1ql.filter} and name = Ryan and within #{#n1ql.customer}")
    //@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND name like Ryan")
   // @Query("#{#n1ql.selectEntity} where #{#n1ql.filter} and name = searchText within #{#n1ql.bucket}")
   // @Query("select *, META().id AS _ID, META().cas AS _CAS FROM `customer` WHERE name = 'searchText'")

   ////@Query("select *, META().id AS _ID, META().cas AS _CAS FROM `customer` WHERE name = $searchText")
   //@Query("select META().id AS _ID, from customer where _class = 'com.l11.cob.model.Customer' and name = $searchText")
 // @N1QL("SELECT * FROM customer WHERE name = $searchText")
   @Query("select name, address, META().id AS _ID, META().cas AS _CAS FROM `customer` where name = 'Jose'")
   //@Query("select *, META().id AS _ID, META().cas AS _CAS FROM `customer` WHERE name = $searchText")
  public List<Customer> FindCustomerByName(String searchText);

  @Query("SELECT *, META().id AS _ID, META().cas AS _CAS FROM `customer`")
  public List<Customer> findCustomerAllCustomer();


    //Building findByCompanyAndAreaId(String companyId, String areaId);
    //public List<Customer> FindCustomerByName(@Param("searchText") String searchText);



}
