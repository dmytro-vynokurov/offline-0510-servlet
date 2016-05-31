package ua.goit.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopicService {
    private static List<String> topics = Collections.synchronizedList(new ArrayList<String>());

    public List<String> addTopic(String topic) {
        topics.add(topic);
        return topics;
    }

    public List<String> getTopics() {
        return topics;
    }
}
