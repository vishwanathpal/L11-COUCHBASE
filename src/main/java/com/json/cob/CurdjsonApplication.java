package com.json.cob;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import java.io.Serializable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CurdjsonApplication {

  public static void main(String[] args) {

    SpringApplication.run(CurdjsonApplication.class, args);

    Cluster cluster = CouchbaseCluster.create("couchbase://127.0.0.1");
    Bucket bucket = cluster.openBucket("customer", "admin123");
    JsonObject personeJsonObject = JsonObject.create();
    JsonArray socialJsonArray = JsonArray.create();

    personeJsonObject.put("id", "4");
    personeJsonObject.put("firstname", "nickol");
    personeJsonObject.put("lastname", "paul");
    socialJsonArray.add(JsonObject.create().put("tittle", "twitter").put("link", "www.twitter.com/nick"));
    socialJsonArray.add(JsonObject.create().put("tittle", "github").put("link", "www.github.com/nick"));
    personeJsonObject.put("social", socialJsonArray);

    JsonDocument personeJsonDocument = JsonDocument.create("5", personeJsonObject);
    bucket.upsert(personeJsonDocument);
    System.out.println(bucket.get("5").content());




  }
  @GetMapping("/customer")
  public String getAllPerson(){
    Cluster cluster = CouchbaseCluster.create("couchbase://127.0.0.1");
    Bucket bucket = cluster.openBucket("customer", "admin123");
    String query = "SELECT * FROM customer";
    bucket.bucketManager().createN1qlPrimaryIndex(true, false);
    N1qlQueryResult result = bucket.query(N1qlQuery.simple(query));
    System.out.println("result::::"+result.allRows());
    //JsonObject personeJsonObject = JsonObject.create();
    //personeJsonObject.put("result", result.allRows().toString());
   // return personeJsonObject.put("re", ).create();
    return result.allRows().toString();
  }

  @PostMapping(value = "/customer")
  public String addPerson(@RequestBody PersonPojo personPojo){

    Cluster cluster = CouchbaseCluster.create("couchbase://127.0.0.1");
    Bucket bucket = cluster.openBucket("customer", "admin123");
    JsonObject personeJsonObject = JsonObject.create();
    JsonArray socialJsonArray = JsonArray.create();

    personeJsonObject.put("id", Integer.toString(personPojo.getId()));
//    personeJsonObject.put(Integer.toString), "4");
    personeJsonObject.put("firstname", "nickol");
    personeJsonObject.put("lastname", "paul");
    socialJsonArray.add(JsonObject.create().put("tittle", "twitter").put("link", "www.twitter.com/nick"));
    socialJsonArray.add(JsonObject.create().put("tittle", "github").put("link", "www.github.com/nick"));
    personeJsonObject.put("social", socialJsonArray);



    String query = "INSERT INTO `customer` (KEY,VALUE) ";
    return null;
  }
}
//reference: https://www.youtube.com/watch?v=SbNaryRodEE
//reference: https://www.baeldung.com/n1ql-couchbase
