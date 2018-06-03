package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "SpringFrameWork","SpringFrameTutorials" ),
			new Topic("Python", "Django","DjangoTutorials" ),
			new Topic("python", "Flask","shivg7706" )
			
			));
	
	public List<Topic> getAllTopics() {
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
	
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
	

}
