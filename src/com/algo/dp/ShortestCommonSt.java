package com.algo.dp;

import java.io.IOException;

import javax.net.ssl.SSLServerSocket;

public class ShortestCommonSt {
	
	/*
	 * private int getShortestCommonSt(String []s,int index) {
	 * 
	 * 
	 * 
	 * }
	 */
	
	public static void main(String args[]) throws ClassNotFoundException, IOException {
		/*
		 * String []s= {"abcd", "cdef", "fgh", "de"};
		 * 
		 * String a= "abcd"; String b = "c";
		 * 
		 * if(a.contains(b)) { System.out.println(b); }
		 */
		
		SSLServerSocket socket = new SSLServerSocket() {
			
			@Override
			public void setWantClientAuth(boolean want) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setUseClientMode(boolean mode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setNeedClientAuth(boolean need) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setEnabledProtocols(String[] protocols) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setEnabledCipherSuites(String[] suites) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setEnableSessionCreation(boolean flag) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean getWantClientAuth() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean getUseClientMode() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String[] getSupportedProtocols() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] getSupportedCipherSuites() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean getNeedClientAuth() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String[] getEnabledProtocols() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] getEnabledCipherSuites() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean getEnableSessionCreation() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		Class clz = Class.forName("SSLServerSocket");
	    System.out.println(clz.cast(socket));
	    
	}

}
