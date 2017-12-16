package com.mitrai.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mitrai.pojo.Application;
import com.mitrai.soap.client.ApplicationAdminClient;

import wso2.applicationadmin.wsdl.ListAllApplicationsResponse;

@Service
public class ApplicationRepositoryWSO2ESB implements ApplicationRepository {

	@Override
	public Iterable<Application> getAllApplications() throws Exception {

		List<Application> applications = new ArrayList<>();
		ApplicationAdminClient client = new ApplicationAdminClient();

		ListAllApplicationsResponse response = client.listAllApplications();

		List<String> appList = response.getReturn();

		for (String appName : appList) {
			applications.add(new Application(appName));
		}

		return applications;
	}

}
