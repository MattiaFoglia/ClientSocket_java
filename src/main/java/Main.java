import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Socket mySocket;
            mySocket = new Socket("localhost", 4316); 
            String stringRed = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            do {
                System.out.println("Insert String : ");
                String outputString = sc.nextLine();
                out.writeBytes(outputString + '\n');
                stringRed = in.readLine();
                System.out.println("String received : " + stringRed);
            } while(!stringRed.equals("!"));
            mySocket.close();
            sc.close();
        } catch (UnknownHostException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}
