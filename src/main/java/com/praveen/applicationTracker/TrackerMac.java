package com.praveen.applicationTracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.jutils.jprocesses.JProcesses;
import org.jutils.jprocesses.model.ProcessInfo;

public class TrackerMac {
	List<String> elements= new ArrayList<String>();
	public static void main(String[] args) {
		String osName=System.getProperty("os.name");
		if (osName.contains("Mac") || osName.contains("mac")) {
			TrackerMac trackerMac= new TrackerMac();
			System.out.println(trackerMac.getRunningProcessMac());
		}
	}
	
	public List<Map<String,String>> getRunningProcessMac() {
		List<ProcessInfo> processesList = JProcesses.getProcessList();
		List<Map<String,String>> processResponse=new ArrayList<Map<String,String>>();
		for (final ProcessInfo processInfo : processesList) {
			if (processInfo.getCommand().contains("Applications")) {
				Map<String,String> result= new HashMap<String,String>();
				String[] commandArray=processInfo.getCommand().split("/");
				String[] appArray=commandArray[2].split("\\.");
				if (!elements.contains(appArray[0])) {
					result.put("duration", processInfo.getTime());
					result.put("user", processInfo.getUser());
					result.put("start_time", processInfo.getStartTime());
					result.put("application_name", appArray[0]);
					processResponse.add(result);
					elements.add(appArray[0]);
				}
			}
			
		}
		return processResponse;
	}
}
