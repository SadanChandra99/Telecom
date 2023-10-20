package com.telecommunication.subscriber.entity;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

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
public class Text {
	
	private int textCount; // number of texts subscriber has subscribed
	private int completedText;
	private int remainingText;
	
	@DateTimeFormat(pattern = "DD-MM-YYYY")
	private LocalDate textUsagedate;
	

}
