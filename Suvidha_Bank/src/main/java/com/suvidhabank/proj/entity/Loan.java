package com.suvidhabank.proj.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="bhagya_suvidha_loan")

public class Loan {
	@Id
private String loanId;
private String loanType;
private double loanAmount;
private double interestRate;
private double period;
private boolean isApproved;
private String remarks;
@JsonIgnore
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="customer_id")
private Customer customer;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="employee_id")
private Employee employee;
@Embedded
private List<Collateral>collateral;
}
