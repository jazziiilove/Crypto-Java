/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                   							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: JAX-WSRPCPro          		 							 *
 * Package name: com.crypto.client		     							 *
 * File name: CryptoClient.java              							 *
 *                                           							 *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

package com.crypto.client;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.crypto.endpoint.ws.Crypto;

public class CryptoClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = null;
		try 
		{
			// path to wsdl URL
			url = new URL("http://localhost:9999/ws/crypto?wsdl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// prepare
		QName qname = new QName("http://ws.endpoint.crypto.com/", "CryptoImplService");
		Service service = Service.create(url, qname);
		Crypto crypto = service.getPort(Crypto.class);

		// send the file to server via wsdl definition
		File file = new File("loremipsum_inp.txt");
		String encOuputPath = crypto.encrypt(file, "1234-4567-8910-2345");

		// let server decrypt the sent file
		String decryptedContent = crypto.decrypt(encOuputPath, "1234-4567-8910-2345");

		if(decryptedContent != null)
		{
			System.out.println("The file decrypted successfully!");
			System.out.println(decryptedContent);
		}
		else
			System.out.println("The file decryption failed!");
	}
}
