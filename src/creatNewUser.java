import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class creatNewUser extends User{
    public creatNewUser(String name, String password, String email) {
        super(name, password, email);
    }

    public String creatUser()
    {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("E:\\Java t\\term project\\Users\\"+name+".txt", true));
            out.write(password);
            out.newLine();
            out.write(email);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
