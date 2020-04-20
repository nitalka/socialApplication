package com.example.facebook.facebookApplication.repository;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.Value;
import com.aerospike.client.cdt.ListOperation;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class AerospikeRepository {

    public final AerospikeClient client = getAerospikeClient();
    public final WritePolicy writePolicy = new WritePolicy();
    public final String SET_NAME = "mypost";
    public final String NAMESPACE = "test";
    public static AerospikeRepository aerospikeRepository;

    private AerospikeRepository() {

    }

    public static synchronized AerospikeRepository getAerospikeRepository() {
        if(aerospikeRepository == null) {
            aerospikeRepository = new AerospikeRepository();
        }
        return aerospikeRepository;
    }

    private AerospikeClient getAerospikeClient() {
        return new AerospikeClient("127.0.0.1", 3004);
    }

    public void addDataToList(String binName, String key, String valueToAppend) {

        Record record = client.operate(
                writePolicy,
                new Key(NAMESPACE, SET_NAME, key),
                ListOperation.append(binName, Value.get(valueToAppend))
                //ListOperation.getByIndex(binName, 0, 7)
               // ListOperation.getByIndexRange(binName, 0, 10, 7)
        );
    }

    public boolean isKeyExists(String key) {
        return client.exists(writePolicy, new Key(NAMESPACE, SET_NAME, key));
    }

    public Map<String, Object> getAllLikesPost(String binName, String postId) {
        return client.operate(
                writePolicy,
                new Key(NAMESPACE, SET_NAME, postId),
                ListOperation.getByIndexRange(binName, 0, Integer.MAX_VALUE, 7)
        ).bins;
    }

    public Map<String, Object> getAllLikesUser(String binName, String userId) {
        return client.operate(
                writePolicy,
                new Key(NAMESPACE, SET_NAME, userId),
                ListOperation.getByIndexRange(binName, 0, Integer.MAX_VALUE, 7)
        ).bins;
    }


    public boolean isValueExists(String binName, String key, String value) {

        Record record = client.operate(
                writePolicy,
                new Key(NAMESPACE, SET_NAME, key),
                ListOperation.getByValue(binName, Value.get(value), 7)
        );

        if(Objects.isNull(record)) {
            return false;
        }

        ArrayList<String> result = (ArrayList<String>) record.bins.get(binName);

        if(result.size() > 0) {
            return true;
        }
        return false;
    }

    public void deleteDataFromList(String binName, String key, String value) {
        client.operate(
                writePolicy,
                new Key(NAMESPACE, SET_NAME,key),
                ListOperation.removeByValue(binName, Value.get(value), 7)
        );

    }
}
