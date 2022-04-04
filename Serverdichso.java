package thien_61134397;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket;

public class Serverdichso {
	 
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) throws IOException{

	// TODO code application logic here



	    DataOutputStream dos = null;

	    DataInputStream dis=null;

	    try {

	        serverSocket = new ServerSocket(1234);

	        System.out.print("Server đã được mở \n" );

	        Socket clientSocket = null;

	        clientSocket = serverSocket.accept();

	        dos=new DataOutputStream(clientSocket.getOutputStream());

	        dis=new DataInputStream(clientSocket.getInputStream());

	        String inline="";

	        while(true)

	        {

	            inline = dis.readUTF();

	            char ch[]=inline.toCharArray();

	            if(Character.isDigit(ch[0]))

	                {

	                int i=Integer.parseInt(inline);

	                switch(i)

	                {

	                    case 0:inline="zero";break;

	                    case 1:inline="one";break;

	                    case 2:inline="two";break;

	                    case 3:inline="three";break;

	                    case 4:inline="four";break;

	                    case 5:inline="five";break;

	                    case 6:inline="six";break;

	                    case 7:inline="seven";break;

	                    case 8:inline="eight";break;

	                    case 9:inline="nine";break;

	                }

	                dos.writeUTF(inline);

	            }

	            else

	                dos.writeUTF("Không phải số nguyên");

	        }

	    }

	    catch(Exception e) {

	        dos.close();

	        serverSocket.close();

	        dis.close();

	        System.out.print(e.getMessage());

	    }

	}

} 

