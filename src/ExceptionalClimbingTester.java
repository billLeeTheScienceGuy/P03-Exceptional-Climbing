//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Climbing Tester
// Course:   CS 300 Fall 2021
//
// Author:   Bill Lee
// Email:    blee266@Wisc.edu
// Lecturer: Mouna Kacem
//
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////

import java.util.zip.DataFormatException;
public class ExceptionalClimbingTester {

	
	public static boolean testSendClimb() {
		String[] send = new String[0];
		
		String grade = "V4";
		//Valid input causes no exceptions
		try {
			ExceptionalClimbing.sendClimb(send, 5, grade);
		} catch (Exception e) {
			return false;
	    }
		//Invalid grade causes IllegalArgumentException
		grade = "12";
		try {
			ExceptionalClimbing.sendClimb(send, 2, grade);
		} catch (Exception e){
			if (!(grade+" is not a valid grade").equals(e.getMessage())) {
				return false;
			}
		}
			//Full array causes IllegalArgumentException
		send = new String[3];
			try {
				ExceptionalClimbing.sendClimb(send, 3, grade);
			} catch (Exception a){
				if (!("cannot add new value to full length "+3+" array").equals(a.getMessage())) {
					return false;
				}
			}
		//Array with null elements or invalid size causes DataFormatException
		try {
			ExceptionalClimbing.sendClimb(send, -1, grade);
		} catch (DataFormatException e){
			if (!("invalid oversize array").equals(e.getMessage())) {
				return false;
		}
		}
		return true;
	}

       public static boolean testFailClimb() {
    	   String[] fail = new String[0];
   		
   		String grade = "V4";
   		//Valid input causes no exceptions
   		try {
   			ExceptionalClimbing.failClimb(fail, 5, grade);
   		} catch (Exception e) {
   			return false;
   	    }
   	//Invalid grade causes IllegalArgumentException1
   		try {
			ExceptionalClimbing.failClimb(fail, 2, grade);
		} catch (Exception e){
			if (!(grade+" is not a valid grade").equals(e.getMessage())) {
				return false;
			}
		}
   	//Full array causes IllegalArgumentException
		try {
			ExceptionalClimbing.failClimb(fail, 3, grade);
		} catch (Exception a){
			if (!("cannot add new value to full length "+3+" array").equals(a.getMessage())) {
				return false;
			}
		}
		//Array with null elements or invalid size causes DataFormatException
		try {
			ExceptionalClimbing.failClimb(fail, -1, grade);
		} catch (DataFormatException e){
			if (!("invalid oversize array").equals(e.getMessage())) {
				return false;
			}
		}
		return true;
       }
	
       
		public static boolean testGetStats() {
			String[] sendAvg = new String[0];
			int send = 0;
			String[] failAvg = new String[0];
			int fail = 0;
			int historyLength =2;
			//Both arrays empty causes RuntimeException
			try {
				ExceptionalClimbing.getStats(sendAvg, send, failAvg, fail, historyLength);
			} catch (RuntimeException e){
				if (!("no climbs provided").equals(e.getMessage())) {
					return false;
				}
			} catch (Exception e) {
				return false;
		    }
			//Negative or 0 historyLength causes IllegalArgumentException
			historyLength =0;
			try {
				ExceptionalClimbing.getStats(sendAvg, send, failAvg, fail, historyLength);
			} catch (Exception e){
				if (!(historyLength+" is not a valid history length").equals(e.getMessage())) {
					return false;
				}
			} 
			//Valid input causes no exceptions
			return true;
	       }
		public static boolean testGetHistogram() {
			String[] send = new String[0];
			int numSend = 0;
			String[] fail = new String[0];
			int numFail = 0;
			//Both arrays empty causes RuntimeException
			try {
				ExceptionalClimbing.getHistogram(send, numSend, fail, numFail);
			} catch (RuntimeException e){
				if (!("no climbs provided").equals(e.getMessage())) {
					return false;
				}
			} catch (Exception e) {
				return false;
		    }
			return true;
		}
		public static boolean runAllTests() {
			if(testSendClimb() == true && testFailClimb() == true && testGetStats() == true && testGetHistogram() == true) {
				return true;
			}
			return false;
		}
		public static void main(String[] args) {
			System.out.println(runAllTests());

		}
	
		}
