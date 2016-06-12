package category.social;

import java.security.MessageDigest;

public class SocialNetworkService {
	/* �ʼ� ���� �ʵ� */
	protected String serviceName;	//������ �̸�
	protected boolean serviceLogin;	//������ �α��� ����
	private String userEmail;	//���� �̸���
	private String userPasswd;	//���� ���й�ȣ
	private String userName;	//������ �̸�
	/* �߰� ���� �ʵ� */
	private String userPhone;	//������ ����ó
	private String userAddress;	//������ �ּ�
	
	/* Constructor */
	//Constructor Overloading
	public SocialNetworkService(String serviceName, String userEmail, String userPasswd, String userName) {
		this(serviceName, userEmail, userPasswd, userName, null, null);
	}

	public SocialNetworkService(String serviceName, String userEmail, String userPasswd, String userName, String userPhone, String userAddress) {
		this.serviceName = serviceName;
		this.userEmail = userEmail;
		this.setUserPasswd(userPasswd);
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.serviceLogin = false;	//�⺻ �α��� ������ false
	}

	/* Getter  && Setter */
	public String getUserEmail() { return userEmail; }
	public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
	public String getUserPasswd() { return userPasswd; }
	public void setUserPasswd(String userPasswd) { this.userPasswd = sha(userPasswd); }	//���й�ȣ ��ȣȭ�� sha��
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	public String getUserPhone() { return userPhone; }
	public void setUserPhone(String userPhone) { this.userPhone = userPhone; }
	public String getUserAddress() { return userAddress; }
	public void setUserAddress(String userAddress) { this.userAddress = userAddress; }
	
	/* Methods */
	public void showServiceInfo() {
		System.out.println("Service Name : " + this.serviceName);
		this.showUserInfo();
	}
	public void showUserInfo() {
		System.out.println("User Email : " + this.userEmail);
		System.out.println("User Password : " + this.userPasswd);
		System.out.println("User Name : " + this.userName);
		System.out.println("User Phone : " + this.userPhone);
		System.out.println("User Address : " + this.userAddress);
	}
	
	/* �α��� �޼��� */
	public void serviceLogin(String userEmail, String userPasswd) {
		if(this.serviceLogin == true) {
			System.out.println("Login Failed : Already Login");
			return;
		}
		else if(userEmail != this.userEmail) {
			System.out.println("Login Failed : Different Email");
			return;
		}
		else if(this.userPasswd.equals(sha(userPasswd)) == false) {
			System.out.println("Login Failed : Different Password");
			return;
		}
		else {
			System.out.println(this.serviceName + " Service Login Success");
			this.serviceLogin = true;	//�α��� ����
			return;
		}
	}
	
	/* �α׾ƿ� �޼��� */
	public void serviceLogout() {
		if(this.serviceLogin == false) {
			System.out.println("Logout Failed : You Not Login");
		}
		else {
			System.out.println(this.serviceName + " Service Logout Success");
			this.serviceLogin = false;	//�α׾ƿ� ����
			return;
		}
	}
	
	/* User Password SHA-256 Encrypt Method */
	protected String sha(String userPasswd) {
		String SHA = ""; 
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(userPasswd.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
			
		}catch(Exception e){
			e.printStackTrace(); 
			SHA = null; 
		}
		return SHA;
	}
}