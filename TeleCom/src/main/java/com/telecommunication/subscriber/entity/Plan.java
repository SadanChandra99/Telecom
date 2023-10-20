package com.telecommunication.subscriber.entity;

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
public class Plan {

	@MongoId
	private String planName; // plan name 

	private String planType; // PREPAID or POSTPAID
	private String dataLimit; // unlimited or limited as 1.5GB 2GB
	private String voiceLimit; // time limit subscribed to talk
	
	private String smsLimit; // sms limit subscribed to send sms
	private Double price;   // plan price
}
