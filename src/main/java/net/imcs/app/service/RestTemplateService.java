package net.imcs.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.imcs.app.beans.Address;

@Service
public class RestTemplateService {

	

	public List<Address> getData(String query) {
		List<Address> addressList = new ArrayList<>();
		// request url
		String url = "https://places-dsn.algolia.net/1/places/query";

		try {// create an instance of RestTemplate
			RestTemplate restTemplate = new RestTemplate();

			// create headers
			HttpHeaders headers = new HttpHeaders();

			// set `Content-Type` and `Accept` headers
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

			// example of custom header
			headers.set("Application-Id", "4FJTTQ4FW7");
			headers.set("API-Key", "b807118899d94f07f9aef80e28ac3e54");

			JSONObject body = new JSONObject();
			body.put("query", query);
			// build the request
			HttpEntity request = new HttpEntity(body.toString(), headers);

			// make an HTTP GET request with headers
			String resData = restTemplate.postForObject(url, request, String.class);
			System.out.println("Query:" + query);
			JSONObject response = new JSONObject(resData);

			System.out.println("Respose" + response.toString());

			JSONArray hits = response.getJSONArray("hits");

			Address addr = null;
			for (int i = 0; i < hits.length(); i++) {
				addr = new Address();
				JSONObject data = (JSONObject) hits.get(i);
				JSONObject country = data.getJSONObject("country");
				addr.setCountryName(country.getString("default"));
				//addr.setCountryCode(country.getString("country_code"));
				JSONArray states = data.getJSONArray("administrative");
				// System.out.println("states:"+states.toString());
				for (int j = 0; j < states.length(); j++) {
					if (j == 0) {
						addr.setStateName(states.getString(j));
					} else if (j == 1) {
						addr.setCityName(states.getString(j));
					}
				}
				addressList.add(addr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return addressList;
	}

}
