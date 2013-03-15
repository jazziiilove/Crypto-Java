/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                   							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: CRCPro           			 							 *
 * Package name: com.baran.crc				 							 *
 * File name: CheckSum.java                  							 *
 *                                           							 *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

package com.baran.crc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CheckedInputStream;
import java.util.zip.CRC32;

// class for computing checksum
public class CheckSum {

	public long checkSum(File file){
		long checksum = 0L;
		try{

			CRC32 crc = new CRC32();
			long sizeOfFile = 0;
			// java-7 style
			try(FileInputStream fis = new FileInputStream(file); CheckedInputStream cis = new CheckedInputStream(fis, crc);){								
				sizeOfFile = file.length();

				byte[] buffer = new byte[4096];
				while(cis.read(buffer)>=0)
				{
					checksum = cis.getChecksum().getValue();				
				}
				System.out.println("The checksum of the file" + file + " is: " + checksum); 
				System.out.println("The file size is: " + sizeOfFile + " bytes");
			}
		}
		catch(IOException e){
			System.out.println("IO Exception thrown");
			e.printStackTrace();
			System.exit(1);
		}
		return checksum;
	}		 
}
