package com.crud;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/meeting")
public class MeetingController {

	@Autowired
	MeetingCrud meetingCrud;
	
	@PostMapping("/save")
	public Meeting saveMeeting(@RequestBody Meeting meeting) {
		meetingCrud.save(meeting);
		return null;
	}
	
	@GetMapping("/get/{starttime}/{endtime}")
	public Meeting getMeeting(@PathVariable LocalDateTime starttime, @PathVariable LocalDateTime endtime) {
		
		
		return null;
	}
	
	@GetMapping("/gettime/{starttime}")
	public List<Meeting> getMeeting(@PathVariable String starttime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(starttime, formatter);
		List<Meeting> list=meetingCrud.findByStartTime(dateTime);
		return list;
	}
	
	
	@GetMapping("/gettimeduration/{startTime}/{endTime}")
	public List<Meeting> getMeetingByDuration(@PathVariable String startTime,@PathVariable String endTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime startDuration = LocalDateTime.parse(startTime, formatter);
		LocalDateTime endDuration = LocalDateTime.parse(endTime, formatter);
		List<Meeting> list=meetingCrud.findByStartTimeAndEndTime(startDuration,endDuration);
		return list;
	}
}
