package com.auth.using.nosql.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.auth.using.nosql.entity.User;

@Repository
public class MongoRep {
	private final MongoTemplate mongoTemplate;
	
	@Autowired
    public MongoRep(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	public User findOneByName(String name) {
		   Query query = new Query();
		   query.addCriteria(Criteria.where("username").is(name));
		   return mongoTemplate.findOne(query, User.class);
		}
	
}
