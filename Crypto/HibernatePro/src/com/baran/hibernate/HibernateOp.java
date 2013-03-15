/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Company: -								 							 *            
 * Assignment: Cyclic Redundancy Check + DES + Hibernate + JAX-WSRPC	 *
 * Deadline: -                           	 							 *
 * Programmer: Baran Topal                  							 *
 * WorkspaceName: Crypto												 *
 * Project Name: HibernatePro          									 *
 * Package name: com.baran.hibernate									 *
 * File name: HibernateOp.java             							     *
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

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateOp {

	public static void main(String [] args)
	{		
		// mock values:
		String inputFileName = "test1.txt";
		String inputFilePath = "C:\\test1";
		String outputFileName = "test2.txt";
		String outputFilePath = "C:\\test2";
		String hashInput = "hashin";
		String hashOutput = "hashout";
		String trivia = "trivia";		

		HibernateOp.addFileRealm(inputFileName, inputFilePath, outputFileName, outputFilePath, hashInput, hashOutput, trivia);		
	}

	public static Session prepare()
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration
				.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		Session session = sessionFactory.openSession();

		return session;        
	}

	public static Integer addFileRealm(String inputFileName, String inputFilePath, String outputFileName, String outputFilePath, String hashInput, String hashOutput, String trivia)
	{
		// create factory, deprecated
		// SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// Session session = factory.openSession();
		Session session= prepare();

		Transaction tx = null;
		Integer id =null;

		try
		{			
			// session starts
			tx = session.beginTransaction();

			// ORM
			FileRealm fr = new FileRealm(inputFileName, inputFilePath, outputFileName, outputFilePath, hashInput, hashOutput, trivia);
			id = (Integer)session.save(fr);
			tx.commit();

		}catch(Exception ex){ex.printStackTrace(); if(tx != null) tx.rollback(); }
		finally{ session.close(); }

		return id;		
	}

	public static void listFiles()
	{
		Session session= prepare();

		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			List<FileRealm> files = session.createQuery("FROM FileRealm").list();
			for(Iterator iterator = files.iterator(); iterator.hasNext();)
			{
				FileRealm fileRealm = (FileRealm)iterator.next();
				System.out.println("Input File Name: " + fileRealm.getInputFileName());
				System.out.println("Input File Path: " + fileRealm.getInputFilePath());
				System.out.println("Output File Name: " +  fileRealm.getOutputFileName());
				System.out.println("Output File Path: " + fileRealm.getOutputFilePath());
				System.out.println("Hash Input: " + fileRealm.getHashInput());
				System.out.println("Hash Output: " + fileRealm.getHashOutput());
			}
			tx.commit();			
		}catch(Exception ex)
		{
			if(tx != null)
				tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}
}
