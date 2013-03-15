/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                   							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: CyrptoPro           		 							 *
 * Package name: com.baran.crypto			 							 *
 * File name: CryptoDES.java                 							 *
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
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.FileUtils;

// Important Note:
// The file in question must have UTF-8 encoding, careful about BOM character.

public class CryptoDES {

	// encrypt the file content via trivia password
	public byte[] encrypt(File file, String trivia) throws Exception
	{
		final MessageDigest md = MessageDigest.getInstance("md5");
		// digest the trivia password in UTF-8
		final byte[] digestTrivia = md.digest(trivia.getBytes("utf-8"));

		// truncating digest
		final byte[] keyBytes = Arrays.copyOf(digestTrivia, 24);
		for(int j = 0, k = 16; j < 8;)
		{
			keyBytes[k++] = keyBytes[j++];
		}
		// DESede setting
		final SecretKey key = new SecretKeySpec(keyBytes, "DESede");

		// CBC IV setting
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);

		final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		String allInOne = FileUtils.readFileToString(file, "utf-8");

		final byte[] plainTextBytes = allInOne.getBytes("utf-8");
		final byte[] cipherText = cipher.doFinal(plainTextBytes);

		return cipherText;
	}

	// decrypt the message via trivia password
	public byte[] decrypt(byte[] message, String trivia) throws Exception
	{
		final MessageDigest md = MessageDigest.getInstance("md5");
		final byte[] digestTrivia = md.digest(trivia.getBytes("utf-8"));

		final byte[] keyBytes = Arrays.copyOf(digestTrivia, 24);

		for(int j = 0, k = 16; j < 8;)
		{
			keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		decipher.init(Cipher.DECRYPT_MODE, key, iv);

		final byte[] plainText = decipher.doFinal(message);

		return plainText;		
	}
}
