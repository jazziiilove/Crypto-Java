/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                   							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: JAX-WSRPCPro          		 							 *
 * Package name: com.crypto.client		     							 *
 * File name: CryptoPublisher.java              						 *
 *                                           							 *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

package com.crypto.endpoint.publisher;

import javax.xml.ws.Endpoint;
import com.crypto.endpoint.ws.CryptoImpl;

public class CryptoPublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Gate between server and client
		Endpoint.publish("http://localhost:9999/ws/crypto", new CryptoImpl());
	}
}
