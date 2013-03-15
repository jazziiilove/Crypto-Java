/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                   							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: JAX-WSRPCPro          		 							 *
 * Package name: com.crypto.client		     							 *
 * File name: Crypto.java              									 *
 *                                           							 *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

package com.crypto.endpoint.ws;

import java.io.File;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface Crypto {

	@WebMethod
	public String encrypt(File fileToSend, String trivia);

	@WebMethod
	public String decrypt(String filePath, String trivia);

}
