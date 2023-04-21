import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjcetInputStreamEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream( new FileInputStream("./object2.dat"));
			
			Person p = (Person)ois.readObject();
			
			System.out.println(p.getName());
			System.out.println(p.getPhone());
			System.out.println(p.getAge());
			System.out.println(p.getAddress());
			
			System.out.println("입력완료 ");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(ois != null) try {ois.close();} catch(IOException e) {};
		}
	}

}
