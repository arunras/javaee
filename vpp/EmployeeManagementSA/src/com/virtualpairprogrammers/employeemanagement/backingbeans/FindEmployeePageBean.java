package com.virtualpairprogrammers.employeemanagement.backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.virtualpairprogrammers.employeemanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.employeemanagement.dataaccess.EmployeeNotFoundException;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@ManagedBean(name="findEmployeePageBean")
public class FindEmployeePageBean {
  @EJB 
  private EmployeeManagementServiceLocal service;

  private String employeeId;

  public String getEmployeeId() {
    return this.employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public Employee getSelectedEmployeeVersion1() {

    // JSF verison 1 way of retrieving a parameter from URL

    String employeeId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("employeeId");
    int id = Integer.parseInt(employeeId);

    try {
    		return service.getById(id);
    } catch(EmployeeNotFoundException e) {
      return null;
    }
  }

  public Employee getSelectedEmployee() {
    int id = Integer.parseInt(employeeId);
    try {
    		return service.getById(id);
    } catch(EmployeeNotFoundException e) {
      return null;
    }
  }
}
