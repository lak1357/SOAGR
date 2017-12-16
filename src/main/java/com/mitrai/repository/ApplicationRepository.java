package com.mitrai.repository;

import org.springframework.stereotype.Service;

import com.mitrai.pojo.Application;

@Service
public interface ApplicationRepository {

	public Iterable<Application> getAllApplications() throws Exception;

}
