package com.example.facebook.facebookApplication.service;

import com.aerospike.client.AerospikeException;
import com.example.facebook.facebookApplication.models.GenericResponse;
import com.example.facebook.facebookApplication.repository.AerospikeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class LikePostService {

    public AerospikeRepository aerospikeRepository = AerospikeRepository.getAerospikeRepository();

    public GenericResponse addLike(String userId, String postId){
        try {
//            if(!(aerospikeRepository.isKeyExists(userId) && aerospikeRepository.isKeyExists(postId))) {
//                return GenericResponse.builder()
//                        .code("401")
//                        .message("UserId/postId does not exist")
//                        .build();
//            }

            if(aerospikeRepository.isValueExists("postId", userId, postId)) {
                // delete from this
                aerospikeRepository.deleteDataFromList("postId", userId, postId);
                aerospikeRepository.deleteDataFromList("userId", postId, userId);
                return GenericResponse.builder()
                        .message("Unliked Post")
                        .build();
            }

            aerospikeRepository.addDataToList("userId", postId, userId);
            aerospikeRepository.addDataToList("postId", userId, postId);
            return GenericResponse.builder()
                    .code("200")
                    .message("added likes")
                    .build();

        } catch (AerospikeException e) {
            System.out.println(e.getMessage());
            return GenericResponse.builder()
                    .code("500")
                    .message("Aerospike error occured..")
                    .build();
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
