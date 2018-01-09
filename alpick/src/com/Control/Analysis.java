package com.Control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Analysis {
	
	StringBuffer cmd = null;
	StringBuffer output = null;
	String url = "python C:";
	String filename = "selectData.py";
	
	public StringBuffer analysis(String id, String user_type) {
		
		cmd = new StringBuffer();
		output = new StringBuffer();
		
		cmd.append(url);
		cmd.append("\\");
		cmd.append(filename);
		cmd.append(" ");
		cmd.append(id);
		cmd.append(" ");
		cmd.append(user_type);
		
		try {
			
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(cmd.toString());
			
			int resultSign = -1;
			
			try {
				resultSign = p.waitFor();
			} catch(Exception e) {
				System.out.println(e);
			}
			
			if(resultSign == 0) {
				
				BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				String line = "";
				while((line = bfr.readLine()) != null) {
					output.append(line);
					output.append("\n");
				}
				
				bfr.close();
				
			} else {
				System.out.println(resultSign);
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return output;
		
	}

}
