package com.ljelectrar.demospringmongodb.repository;

import com.ljelectrar.demospringmongodb.domain.Post;
import com.ljelectrar.demospringmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
