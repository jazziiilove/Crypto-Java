/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                  							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: CyrptoPro           									 *
 * Package name: com.baran.crypto										 *
 * File name: CryptoEx.java                  							 *
 *                                           							 *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

package com.baran.crypto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//Important Note:
//The file in question must have UTF-8 encoding, careful about BOM character.

public class CryptoEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		CryptoDES cryptoDES = new CryptoDES();
		byte [] encBytes = cryptoDES.encrypt(new File("loremipsum_inp.txt"), "1234-4567-8910-2345");
		FileOutputStream fos = new FileOutputStream("loremipsum_enc.enc");
		fos.write(encBytes);
		fos.flush();
		fos.close();

		// passwords must match
		byte[] decBytes = cryptoDES.decrypt(encBytes, "1234-4567-8910-2345");

		String encoded = new String(decBytes, "utf-8");
		fos = new FileOutputStream("loremipsum_dec.dec");
		PrintWriter writer = new PrintWriter(fos);

		writer.write(encoded);
		writer.flush();
		writer.close();
		fos.flush();
		fos.close();

	}
}
