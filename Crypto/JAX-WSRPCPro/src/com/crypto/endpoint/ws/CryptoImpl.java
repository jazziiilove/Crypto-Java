/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                   							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: JAX-WSRPCPro          		 							 *
 * Package name: com.crypto.client		     							 *
 * File name: CryptoImpl.java              								 *
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
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.jws.WebMethod;
import javax.jws.WebService;
import com.baran.crc.CheckSum;
import com.baran.crypto.CryptoDES;
import com.baran.file.FileOperator;
import com.baran.hibernate.HibernateOp;

@WebService(endpointInterface="com.crypto.endpoint.ws.Crypto")
public class CryptoImpl implements Crypto{

	@Override
	@WebMethod
	public String encrypt(File fileToSend, String trivia) {
		// TODO Auto-generated method stub
		CheckSum cs = new CheckSum();

		CryptoDES cryptoDes = new CryptoDES();
		try {

			// file sent by client is encrypted
			byte[] crypted = cryptoDes.encrypt(fileToSend, trivia);
			long checksumIn = cs.checkSum(fileToSend);

			String outputFilePath = FileOperator.storeBinaryContent(crypted, fileToSend.getName());

			// server debug, client
			System.out.println("outputfilepath" + outputFilePath);
			Path path = Paths.get(outputFilePath);
			String outputFileName = path.getName(path.getNameCount() - 1).toString();

			long checksumOut = cs.checkSum(new File(outputFilePath));

			// ORM
			HibernateOp.addFileRealm(fileToSend.getName(), fileToSend.getCanonicalPath(), outputFileName, outputFilePath, String.valueOf(checksumIn), String.valueOf(checksumOut), trivia);

			// debug, hidden from client
			System.out.println("Success");

			// return the generated file path to client
			return outputFilePath;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		}
	}

	@Override
	@WebMethod
	public String decrypt(String filePath, String trivia) {
		// TODO Auto-generated method stub
		System.out.println("CryptoImpl: " + filePath);
		CryptoDES cryptoDes = new CryptoDES();
		try {
			byte[] read = FileOperator.readFileToBinaryArray(new File(filePath));
			byte[] decrypted = cryptoDes.decrypt(read, trivia);

			// ORM
			HibernateOp.listFiles();			

			// return the decrypted file content to client
			String s = new String(decrypted, "utf-8");						

			return s;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
}
