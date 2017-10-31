package com.pratikjarandeprojects.bowling.providers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.pratikjarandeprojects.bowling.exceptions.ServicesNotFoundException;
import com.pratikjarandeprojects.bowling.services.BowlingService;

public class BowlingServiceProvider {
	public static BowlingService BowlingServProvider() throws ServicesNotFoundException{
		try {
			Properties properties=new Properties();
			properties.load(new FileInputStream(".\\resources\\bowlingprojectresources.properties"));
			@SuppressWarnings("rawtypes")
			Class c =Class.forName(properties.getProperty("BowlingService"));
			return (BowlingService)c.newInstance();
		} catch (FileNotFoundException e) {
			throw new ServicesNotFoundException("service not available",e);
		} catch (ClassNotFoundException e) {
			throw new ServicesNotFoundException("service not available",e);
		} catch (InstantiationException e) {
			throw new ServicesNotFoundException("service not available",e);
		} catch (IllegalAccessException e) {
			throw new ServicesNotFoundException("service not available",e);
		} catch (IOException e) {
			throw new ServicesNotFoundException("service not available",e);
		}
	}
}
