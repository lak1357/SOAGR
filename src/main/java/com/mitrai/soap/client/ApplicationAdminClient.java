package com.mitrai.soap.client;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import wso2.applicationadmin.wsdl.ListAllApplications;
import wso2.applicationadmin.wsdl.ListAllApplicationsResponse;


public class ApplicationAdminClient extends WebServiceGatewaySupport {
	
	

	public ListAllApplicationsResponse listAllApplications() throws Exception {

		ListAllApplications request = new ListAllApplications();

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		

		HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();

		messageSender.setCredentials(new UsernamePasswordCredentials("admin", "admin"));
		setMessageSender(messageSender);
		messageSender.afterPropertiesSet();

		marshaller.setContextPath("wso2.applicationadmin.wsdl");
		marshaller.afterPropertiesSet();
		setMarshaller(marshaller);
		setUnmarshaller(marshaller);

		ListAllApplicationsResponse response = (ListAllApplicationsResponse) getWebServiceTemplate()
				.marshalSendAndReceive("https://localhost:9443/services/ApplicationAdmin", request,
						new SoapActionCallback("urn:listAllApplications"));

		return response;

	}

}
