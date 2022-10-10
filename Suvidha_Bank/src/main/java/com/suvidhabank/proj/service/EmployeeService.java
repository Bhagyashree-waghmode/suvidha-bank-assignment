package com.suvidhabank.proj.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvidhabank.proj.entity.Customer;
import com.suvidhabank.proj.entity.Employee;
import com.suvidhabank.proj.entity.Loan;
import com.suvidhabank.proj.repository.EmployeeRepository;
import com.suvidhabank.proj.repository.LoanRepository;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;
@Autowired
private LoanRepository loanRepository;
public boolean searchEmployeeById(String employeeId) {
	
	if(!this.employeeRepository.existsById(employeeId))
	return true;
	return false;
	}
	public boolean addEmployee(Employee employee) {
		if(!this.employeeRepository.existsById(employee.getEmployeeId())) {
			this.employeeRepository.save(employee);
			return true;
		}
		return false;
	}
	public void approveLoan(String empId) throws Exception {
		
		try {
				
				List<Loan> loans=this.loanRepository.findByEmployeeEmployeeId(empId);
		}
		catch(Exception e) {
			System.out.println("error");
		}
				
				
		
		if (this.searchEmployeeById(empId)) 
		{			
			
			List<Loan> loans=this.loanRepository.findByEmployeeEmployeeId(empId);
			System.out.println(loans);
			if(loans.size()>0) {
				for(Loan loan:loans) {
					Customer customer=loan.getCustomer();
					if(loan.getLoanAmount() > (10 * customer.getAnnualIncome())) {
						loan.setRemarks("Loan amount cannot be 10 times of annual income");
						loan.setApproved(false);
						this.loanRepository.save(loan);
						
					}
					
					else if(!customer.isIncomeTaxReturnAttached()) {
						loan.setRemarks( "Income proof not attached");
						loan.setApproved(false);
						this.loanRepository.save(loan);
						
					}
					else if(customer.getCustomerIdentity() == null) {
						loan.setRemarks( "Identity document not submitted");
						loan.setApproved(false);
						this.loanRepository.save(loan);
						
					}
					else if(loan.getCollateral() == null || loan.getCollateral().size() == 0) {
						loan.setRemarks( "No collateral submitted");
					   loan.setApproved(false);
						this.loanRepository.save(loan);
						
					}
					else
					{
						loan.setRemarks( "Approved");
						loan.setApproved(true);
						
						this.loanRepository.save(loan);
						
					}
					System.out.println(loans);
				}
			}
			else {
				throw new Exception("No loan proposals against this employee id");
			}
		}
		else
			throw new EntityNotFoundException("Employee does not exist");
				}
	
	
}

