package com.Kambercan.repository;

import com.Kambercan.document.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile ,String> {
}
