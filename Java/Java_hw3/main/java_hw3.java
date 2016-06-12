/*
*	ProjectName	: 2015-1 ��ü�������α׷��� ���� Homework 03
*	Corder 		: ������ / 201021395
*	Organiz.	: Catholic Univ. of Korea
*	Major		: Computer Science (Minor : Information System Eng)
*	DateTime	: 2015.06.10 22:40
*	Develop OS	: Microsoft Windows 8.1 Embedded Industy Pro (x64)
*	PorgramLang	: Java (Java1.8.0_45)
*	IDE			: Eclipse Luna
*	Compiler	: Javac 1.8
*/

package main;

import category.social.SocialNetworkService;	//import Super Class
import category.social.subs.Facebook;	//import Sub Class

public class java_hw3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocialNetworkService blogServ = new SocialNetworkService("Blog", "uyu423@gmail.com", "1q2w3e4r", "Yu Yongwoo");
		blogServ.showServiceInfo();	//������ ���� ǥ��
		System.out.println();
		blogServ.serviceLogout();	//�α׾ƿ� -> �α��� ���� �ʾ����Ƿ� ����
		blogServ.serviceLogin("uyu423@gmail.com", "1q2w3e4r");	//�α��� -> ����
		blogServ.serviceLogout();	//�α׾ƿ� -> �α��� �����Ƿ� ����
		System.out.println();
		
		Facebook fbServ = new Facebook("qkrrhdms@gmail.com", "qqqq", "Park Goeun", "010-4617-****", "Earth");
		fbServ.showFacebookInfo();	//������ ���� ǥ��
		System.out.println();
		fbServ.serviceLogin("qkrrhdms@gmail.com", "1q2w3e4r");	//�α��� -> ���й�ȣ Ʋ���� ����
		fbServ.writePost("Hello World !");	//������ -> �α��� ���� �ʾ����Ƿ� ����
		fbServ.serviceLogin("qkrrhdms@gmail.com", "qqqq");	//�α��� -> ����
		fbServ.writePost("Hello World !");	//������ -> ����
		System.out.println();
		fbServ.showFacebookInfo();	//������ ���� ǥ�� -> ������ ���� ���� �� ������
		System.out.println();
		fbServ.writePost();	//������ -> ����
		System.out.println();
		fbServ.showFacebookInfo(); //������ ���� ǥ�� -> ������ ���� ���� �� ������
		System.out.println();
		fbServ.serviceLogout(); //�α׾ƿ� -> ����
	}

}
