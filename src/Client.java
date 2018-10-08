import java.io.*;
import java.net.*;
class Client
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        int i = 0;
        while(i <= 9)
        {
            String sentence = inFromServer.readLine();
            System.out.println("From Server : "+sentence);
            i++;
        }
    }
}
