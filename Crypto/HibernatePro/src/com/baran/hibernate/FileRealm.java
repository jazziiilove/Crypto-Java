/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                   							 *
 * WorkspaceName: Crypto					 							 *
 * Project Name: HibernatePro          									 *
 * Package name: com.baran.hibernate									 *
 * File name: FileRealm.java               							  	 *
 *                                          							 *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

package com.baran.hibernate;

// POJO class
public class FileRealm {
	private int id;
	private String inputFileName;
	private String inputFilePath;
	private String outputFileName;
	private String outputFilePath;
	private String hashInput;
	private String hashOutput;
	private String trivia;	

	public FileRealm(){}
	public FileRealm(String inputFileName, String inputFilePath, String outputFileName, String outputFilePath, String hashInput, String hashOutput, String trivia)
	{
		this.inputFileName = inputFileName;
		this.inputFilePath = inputFilePath;
		this.outputFileName = outputFileName;
		this.outputFilePath = outputFilePath;
		this.hashInput  = hashInput;
		this.hashOutput = hashOutput;
		this.trivia = trivia;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInputFileName() {
		return inputFileName;
	}
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	public String getInputFilePath() {
		return inputFilePath;
	}
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	public String getOutputFileName() {
		return outputFileName;
	}
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	public String getOutputFilePath() {
		return outputFilePath;
	}
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}
	public String getHashInput() {
		return hashInput;
	}
	public void setHashInput(String hashInput) {
		this.hashInput = hashInput;
	}
	public String getHashOutput() {
		return hashOutput;
	}
	public void setHashOutput(String hashOutput) {
		this.hashOutput = hashOutput;
	}
	public String getTrivia() {
		return trivia;
	}
	public void setTrivia(String trivia) {
		this.trivia = trivia;
	}
}
