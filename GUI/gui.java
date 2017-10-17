import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

//import lejos.utility.Delay;

public class gui {
	private final String USER_AGENT = "Mozilla/5.0";
	String urlParameters = null;
	HttpURLConnection con = null;
	
	public static void main(String[] args) throws Exception {
		System.setProperty("http.protocols", "TLSv1.2");
		gui http = new gui();
		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();
	}
	
	private void sendPost() throws Exception {
		JFrame demo = new JFrame();
        demo.setSize(492, 410);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton upbutton = new JButton("upButton");
        JButton downbutton = new JButton("downButton");
        JButton leftbutton = new JButton("leftButton");
        JButton rightbutton = new JButton("rightButton");
		
		demo.getContentPane().add(BorderLayout.NORTH, upbutton);
        demo.getContentPane().add(BorderLayout.SOUTH, downbutton);
        demo.getContentPane().add(BorderLayout.WEST, leftbutton);
        demo.getContentPane().add(BorderLayout.EAST, rightbutton);
        
       
        final String url = "http://140.116.104.73:1880/gui";
        
        System.out.println("1");
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
        
		upbutton.addActionListener(new ActionListener() {
    	    	public void actionPerformed(ActionEvent e) {
        	    	urlParameters = "a=1";
        	    	try {
        				URL obj = new URL(url);
        				con = (HttpURLConnection) obj.openConnection();
        				con.setRequestMethod("POST");
        				con.setRequestProperty("User-Agent", USER_AGENT);
        			} catch (IOException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
        	    	con.setDoOutput(true);
        			DataOutputStream wr;
    				try {
    					wr = new DataOutputStream(con.getOutputStream());
    					wr.writeUTF(urlParameters);
    	    			wr.flush();
    	    			wr.close();
    	    			System.out.println("0");
    	    			int responseCode = con.getResponseCode();
    	    			System.out.println("Response Code : " + responseCode);
    	    			System.out.println("2");

    	    			BufferedReader in = new BufferedReader(
    	    			        new InputStreamReader(con.getInputStream()));
    	    			String inputLine;
    	    			StringBuffer response = new StringBuffer();
    	    			
    	    			System.out.println(response.toString());
    	    			while ((inputLine = in.readLine()) != null) {
    	    				response.append(inputLine);
    	    			}
    	    			in.close();
    				} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
        	    }
        	});

		downbutton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	urlParameters = "a=0";
    	    	try {
    				URL obj = new URL(url);
    				con = (HttpURLConnection) obj.openConnection();
    				con.setRequestMethod("POST");
    				con.setRequestProperty("User-Agent", USER_AGENT);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    	    	con.setDoOutput(true);
    			DataOutputStream wr;
				try {
					wr = new DataOutputStream(con.getOutputStream());
					wr.writeUTF(urlParameters);
	    			wr.flush();
	    			wr.close();
	    			System.out.println("0");
	    			int responseCode = con.getResponseCode();
	    			System.out.println("Response Code : " + responseCode);
	    			System.out.println("2");

	    			BufferedReader in = new BufferedReader(
	    			        new InputStreamReader(con.getInputStream()));
	    			String inputLine;
	    			StringBuffer response = new StringBuffer();
	    			
	    			System.out.println(response.toString());
	    			while ((inputLine = in.readLine()) != null) {
	    				response.append(inputLine);
	    			}
	    			in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	    }
    	});				
		
		leftbutton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	urlParameters = "a=3";
    	    	try {
    				URL obj = new URL(url);
    				con = (HttpURLConnection) obj.openConnection();
    				con.setRequestMethod("POST");
    				con.setRequestProperty("User-Agent", USER_AGENT);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    	    	con.setDoOutput(true);
    			DataOutputStream wr;
				try {
					wr = new DataOutputStream(con.getOutputStream());
					wr.writeUTF(urlParameters);
	    			wr.flush();
	    			wr.close();
	    			System.out.println("0");
	    			int responseCode = con.getResponseCode();
	    			System.out.println("Response Code : " + responseCode);
	    			System.out.println("2");

	    			BufferedReader in = new BufferedReader(
	    			        new InputStreamReader(con.getInputStream()));
	    			String inputLine;
	    			StringBuffer response = new StringBuffer();
	    			
	    			System.out.println(response.toString());
	    			while ((inputLine = in.readLine()) != null) {
	    				response.append(inputLine);
	    			}
	    			in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	    }
    	});				
		
		rightbutton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	urlParameters = "a=4";
    	    	try {
    				URL obj = new URL(url);
    				con = (HttpURLConnection) obj.openConnection();
    				con.setRequestMethod("POST");
    				con.setRequestProperty("User-Agent", USER_AGENT);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    	    	con.setDoOutput(true);
    			DataOutputStream wr;
				try {
					wr = new DataOutputStream(con.getOutputStream());
					wr.writeUTF(urlParameters);
	    			wr.flush();
	    			wr.close();
	    			System.out.println("0");
	    			int responseCode = con.getResponseCode();
	    			System.out.println("Response Code : " + responseCode);
	    			System.out.println("2");

	    			BufferedReader in = new BufferedReader(
	    			        new InputStreamReader(con.getInputStream()));
	    			String inputLine;
	    			StringBuffer response = new StringBuffer();
	    			
	    			System.out.println(response.toString());
	    			while ((inputLine = in.readLine()) != null) {
	    				response.append(inputLine);
	    			}
	    			in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	    }
    	});				
			
		demo.setVisible(true);
	}
}




