package com.telecommunication.subscriber.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

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
public class Subscriber {
	
	
	@MongoId
	private String subscriberID;
	private String name;
	private String email;
	private Long mobile;
	private String planType;
	private String planName;
	private Plan plan;
	private Location location;
	private List<CallHistory> callHistory;
	private List<Text> text;
	private List<DataUsage> dataUsage;

}
