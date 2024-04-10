import java.util.Scanner;

public class Exeption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner text  = new Scanner(System.in);
		Scanner number = new Scanner(System.in);
		
		System.out.println("ingresa el nombre");
		String name;
		
		name = text.nextLine();
		
	
		int entero = 0;
		
		
		try {
			System.out.println("ingresa un numero");
			entero = number.nextInt();
			EdadException oEdadEx = new EdadException();
			oEdadEx.validarEdad(entero);
		}catch(EdadException ex){
			
			ex.printStackTrace();
			System.out.println("entre al cath");
			System.out.println(ex.getMessage());
		}finally {
			
		}
		

	}

}
