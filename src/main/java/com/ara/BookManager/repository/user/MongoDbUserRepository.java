package com.ara.BookManager.repository.user;

import com.ara.BookManager.model.UserEntity;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


@Repository
@RequiredArgsConstructor
public class MongoDbUserRepository implements UserRepository {
    private final MongoClient mongoClient;
    private MongoCollection<UserEntity> userCollection;


    @PostConstruct
    public void init(){
        userCollection=mongoClient.getDatabase("bookStore").getCollection("users", UserEntity.class);
    }


    @Override
    public UserEntity save(UserEntity user) {
        user.setId(new ObjectId());
        userCollection.insertOne(user);
        return user;
    }

    @Override
    public List<UserEntity> findAll() {
        return userCollection.find().into(new ArrayList<>());
    }

    @Override
    public UserEntity findById(String id) {
        return userCollection.find(eq("_id",new ObjectId(id))).first();
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userCollection.find(eq("email",new ObjectId(email))).first();
    }

    @Override
    public UserEntity update(UserEntity user) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions()
                .returnDocument(ReturnDocument.AFTER);
        return userCollection.findOneAndReplace(eq("_id",user.getId()),user,options);
    }

    @Override
    public long delete(String id) {
        return userCollection.deleteOne(eq("_id",new ObjectId(id))).getDeletedCount();
    }
}
