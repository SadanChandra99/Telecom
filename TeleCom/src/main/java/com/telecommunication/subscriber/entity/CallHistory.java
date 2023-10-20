package com.telecommunication.subscriber.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
@Builder
public class CallHistory {

	private LocalTime callDuration;
//	@DateTimeFormat(pattern = "HH:mm:ss")
//	@JsonFormat
	private LocalTime callStartTime ;
	
//	@DateTimeFormat(pattern = "HH:mm:ss")
//	@JsonFormat
	private LocalTime callEndTime ;
	
	@DateTimeFormat(pattern = "DD-MM-YYYY")
	private LocalDate callUsagedate;
}
