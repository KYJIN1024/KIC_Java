import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader br = null;
		
		try {
			br = new FileReader("./test1.txt ");
			
			int data = 0;
			while((data = br.read()) !=-1) {
				System.out.println((char)data);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try { br.close();} catch(IOException e) {};
		}
		
	}

