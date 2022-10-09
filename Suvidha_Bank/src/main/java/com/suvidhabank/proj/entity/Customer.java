package com.suvidhabank.proj.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="bhagya_suvidha_customer")

public class Customer {
	@Id
private String customerIdentity;
private String customerName;
private String customerAddress;
private String emailId;
private double annualIncome;
private boolean incomeTaxReturnAttached;
@OneToOne(mappedBy = "customer")
private Loan loan;
}
