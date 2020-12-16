package com.mybank.service

import org.reactivestreams.Publisher
import com.mongodb.client.result.InsertOneResult
import com.mongodb.reactivestreams.client.MongoClients
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoCollection
import com.mongodb.reactivestreams.client.MongoDatabase
import java.util.Arrays
import org.bson.Document
import javax.inject.Inject
import javax.inject.Singleton

class test {


    //MongoClient mongoClient = MongoClients.create();
    var mongoClient: MongoClient = MongoClients.create("mongodb://root:q@localhost:27017")
    var database: MongoDatabase = mongoClient.getDatabase("mydb")
    var collection: MongoCollection<Document> = database.getCollection("mycollection")

    var doc: Document = Document("name", "MongoDB")
            .append("type", "database")
            .append("count", 1)
            .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
            .append("info", Document("x", 203).append("y", 102))


    fun publisher(document: Document): Publisher<InsertOneResult> {
      val publisher = collection.insertOne(document)

      return publisher
    }


}