package mybatis.service.domain;

import java.io.Serializable;

import java.sql.Date;

/*
 * FileName : User.java  
 * �� User �� ������ ���� Value Object (�����ΰ�ü,�����Ͻ���ü)
 * �� USERS TABLE �� 1���� ROW �� ������ ���´�.  
*/ 
public class User implements Serializable {

	///Field
    private String userId; 			// ȸ�� ID 
    private String userName;		// ȸ�� �̸� 
    private String password;     // ��й�ȣ 
    private String role;    			// ���� :: Integer wrapper class ��� :: ���� �뵵 Ȯ��  
    private String ssn;    				// ��� :: int primitive ��� :: :: ���� �뵵 Ȯ�� 
    private String phone;    				// ��� :: int primitive ��� :: :: ���� �뵵 Ȯ�� 
    private String addr;    				// ��� :: int primitive ��� :: :: ���� �뵵 Ȯ�� 
    private String email;    				// ��� :: int primitive ��� :: :: ���� �뵵 Ȯ�� 
    private Date regDate; // �������� 
    //private Timestamp regDate	= new Timestamp(new Date().getTime()); // ��������
    private boolean active; 
    
    ///Constructor
    public User() {
	}
    public User (	String userId, String userName,String password,String role, 
    		String ssn,String phone,String addr,String email,Date regDate) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.ssn = ssn;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
		this.regDate = regDate;
	}    

	///Method (getter/setter)

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", ssn=" + ssn + ", phone=" + phone + ", addr=" + addr + ", email=" + email + ", regDate=" + regDate
				+ ", active=" + active + "]";
	}
	
}//end of class