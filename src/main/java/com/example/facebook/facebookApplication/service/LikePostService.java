package com.example.facebook.facebookApplication.service;

import com.aerospike.client.AerospikeException;
import com.example.facebook.facebookApplication.repository.AerospikeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class LikePostService {

    public AerospikeRepository aerospikeRepository = AerospikeRepository.getAerospikeRepository();

    public void addLike(String userId, String postId){
        try {
            aerospikeRepository.addDataToList("userId", postId, userId);
            aerospikeRepository.addDataToList("postId", userId, postId);
        } catch (AerospikeException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getAllLikesPost(String postId) {
        try{

            Map<String,Object> result = aerospikeRepository.getAllLikesPost("userId", postId);
            return (ArrayList<String>) result.get("userId");
        } catch (AerospikeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Object getAllLikesUser(String userId) {
        try{
            Map<String,Object> result = aerospikeRepository.getAllLikesUser("postId", userId);
            return (ArrayList<String>) result.get("postId");
        } catch (AerospikeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
