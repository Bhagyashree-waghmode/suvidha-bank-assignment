package com.suvidhabank.proj;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.suvidhabank.proj.entity.Collateral;
import com.suvidhabank.proj.entity.Customer;
import com.suvidhabank.proj.entity.Employee;
import com.suvidhabank.proj.entity.Loan;
import com.suvidhabank.proj.repository.LoanRepository;
import com.suvidhabank.proj.service.EmployeeService;

@SpringBootApplication
public class SuvidhaBankApplication {
	@Autowired
	LoanRepository loanRepository;
	@Autowired
	EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(SuvidhaBankApplication.class, args);
	}
	
	//@Bean
	public void initialize() {
		Customer c1=new Customer();
		c1.setCustomerIdentity("101");
		c1.setCustomerName("Bhagyashree");
		c1.setCustomerAddress("Mumbai");
		c1.setEmailId("waghbhagya@9167");
		c1.setAnnualIncome(2000000.0);
		c1.setIncomeTaxReturnAttached(true);
		
		Loan l1=new Loan();
		l1.setLoanId("01");
		l1.setLoanType("Buying Land");
		l1.setLoanAmount(2000000.0);
		l1.setInterestRate(8000.0);
		l1.setPeriod(5.0);
		l1.setRemarks("Well Cooperated");
		l1.setCustomer(c1);
		
		
		
		
		for(int i=110;i<120;i++) {
			Employee e=new Employee();
			e.setEmployeeId(""+i);
			e.setEmployeeName("Employee"+(i-100));
			this.employeeService.addEmployee(e);
		}
		
		Collateral co=new Collateral();
		co.setCollaterlId("1004");
		co.setCollaterlId("Vehicle");
//		co.setLoan(l1);
		
		Collateral co1=new Collateral();
		co1.setCollaterlId("1005");
		co1.setCollaterlId("Fixed Deposit");
//		co1.setLoan(l1;
		
		List<Collateral> list=Arrays.asList(co,co1);
		
//		l1.setCollaterals(list);
//     	l1.setEmployee(e);
     	
     	this.loanRepository.save(l1);
	}

}
