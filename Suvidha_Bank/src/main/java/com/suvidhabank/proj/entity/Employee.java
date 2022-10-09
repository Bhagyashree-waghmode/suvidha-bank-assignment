package com.suvidhabank.proj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="bhagya_suvidha_Employee")

public class Employee {
	@Id
private String employeeId;
private String employeeName;
@JsonIgnore
@OneToOne(mappedBy = "employee")
private Loan loan;

}
