package com.Nine.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Nine.json.Response;
import com.Nine.json.ResponseContainer;
import com.Nine.predicates.PredicateFilters;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class EpisodeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	@PostConstruct
	public void startMessage() {
		// eye catcher
		logger.info("*** Episode Service has started ***");
		logger.info("*** Episode Service has started ***");
		logger.info("*** Episode Service has started ***");
		logger.info("*** Episode Service has started ***");
	}
	
	public ResponseContainer doRequest(String json) throws JsonParseException, JsonMappingException, IOException {

		Map<String, ArrayList<Map<String,Object>>> map = new HashMap<String, ArrayList<Map<String,Object>>>();
			map = jacksonObjectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
			logger.info(map.toString()); 
			
			Function<Map<String,Object>, Map<String,Object>> recordFunction = record -> {return record;};			
			Predicate<Map<String,Object>> multipleConditions = joinedAndFilter(
					PredicateFilters.drmTrue,
					PredicateFilters.epCountGreaterThanZero
					);

			ResponseContainer responseContainer = new ResponseContainer();
			
			if  (map.get("payload") != null) {
				List<Map<String,Object>> matchingEpisodes = map.get("payload")
				.stream().filter(multipleConditions)
				.map(recordFunction)
				.collect(Collectors.toList());
	
				List<Response> responses = new ArrayList<Response>();
	
				for (Map<String,Object> matchingEpisodeMap: matchingEpisodes) {
					logger.debug(matchingEpisodeMap.get("title").toString());
					logger.debug(matchingEpisodeMap.get("slug").toString());
					logger.debug(matchingEpisodeMap.get("image").toString());
					logger.debug(((Map)(matchingEpisodeMap.get("image"))).get("showImage").toString());
					Response response = new Response();				
					response.setTitle((String)matchingEpisodeMap.get("title"));
					response.setImage((String)(((Map)(matchingEpisodeMap.get("image"))).get("showImage")));
					response.setSlug((String)matchingEpisodeMap.get("slug"));
					responses.add(response);
				}			
				responseContainer.setResponse(responses);
				jacksonObjectMapper.writeValue(new File("C:\\temp\\myTempJson.json"), responseContainer); // ELB won't store this....
			} else logger.error("Payload empty");
		return responseContainer;
	}
	
	@SafeVarargs
	private static <T> Predicate<T> joinedAndFilter(Predicate<T> first, Predicate<T>... next) {
	    if (next == null) {
	        return first;
	    }

	    Predicate<T> conjunctionPredicate = first;
	    for (Predicate<T> predicate : next) {
	        conjunctionPredicate = conjunctionPredicate.and(predicate);
	    }

	    return conjunctionPredicate;
	}


}
