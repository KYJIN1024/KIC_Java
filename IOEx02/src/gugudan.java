import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class gugudan {

	public static void main(String[] args) {
		
		int startDan, endDan;
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);


			System.out.print("구구단 시작단수를 입력하세요:");
			startDan = Integer.parseInt(br.readLine());
			
			System.out.print("구구단 끝단수를 입력하세요:");
			endDan = Integer.parseInt(br.readLine());
			
			printGugudan(startDan, endDan);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( br != null) try { br.close();} catch(IOException e) {};
		}
		}
		

	private static void printGugudan(int startDan, int endDan) {
		// TODO Auto-generated method stub
		
	}

}
