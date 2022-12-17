package com.crud;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingCrud extends JpaRepository<Meeting, Integer>{
	
	@Query(value="select id,start_time,end_time from Meeting where start_time>=?1",nativeQuery = true)
    List<Meeting> findByStartTime(LocalDateTime time);
	
	@Query(value="select id,start_time,end_time from Meeting where start_time>=?1 and end_time<=?2",nativeQuery = true)
    List<Meeting> findByStartTimeAndEndTime(LocalDateTime starttime,LocalDateTime endtime);
}
