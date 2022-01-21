package com.te.mail.mailinfo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Mail_Info {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String from_Id;
	private String to_Id;
	private String subject;
	private String message;
	private String status;

}
