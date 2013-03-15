/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Company: -								 							 *            
 * Assignment :Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                    							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: FileOperatorPro      		 							 *
 * Package name: com.baran.file				 							 *
 * File name: FileOperator.java              							 *
 *                                           							 *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

package com.baran.file;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class FileOperator {

	// store crypted content in a file generated
	public static String storeBinaryContent(byte[] crypted, String inputFile)
	{			
		String completePath = uniqueNameGenerator(inputFile);
		try {		
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(completePath));
			dos.write(crypted);		 
			dos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return completePath;
	}

	// unique name generator
	public static String uniqueNameGenerator(String inputFile)
	{
		// randomization
		SecureRandom random = new SecureRandom();
		BigInteger bi = new BigInteger(130, random);
		String uniqueEncFile = String.valueOf((BigInteger)bi);		

		// commons-io-2.4.jar
		String fileNameWithOutExt = FilenameUtils.removeExtension(inputFile);		

		String randomFileName = System.getProperty("user.dir") + "\\" + fileNameWithOutExt + "_" + uniqueEncFile + ".enc";

		return randomFileName;		
	}

	// read file content to a binary array
	public static byte[] readFileToBinaryArray(File file)
	{
		byte[] bin = null;
		try {			
			InputStream is = new FileInputStream(file);  

			// commons-io-2.4.jar
			bin = IOUtils.toByteArray(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bin;
	}	
}
