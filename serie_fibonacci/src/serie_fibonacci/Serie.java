package serie_fibonacci;
import java.util.Scanner;

public class Serie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner pot = null;
		//creamos una variable para escaner lo ingresado por consola
		int resultado = 1;
		//creamos una nueva variable resultado la cual sera la encargada de realizar las operaciones
        // y se inicializa en 1 para obtener la base por la cual se ira multiplicando en cada iteracion
		int poten = 0;
		//creamos la variable de la potenica y se incializa en 0 ya que esta sera ingresada por el usuario
		int num1 = 0;
		//inicializamos una variable nueva la cual sera el numero que sera elevado a la potencia
		
		pot = new Scanner(System.in);
		
		System.out.print("ingresa el numero a elevar la potencia: ");
		num1 = pot.nextInt();
		//guardamos el valor del numero
		System.out.print("ingresa la potencia: ");
		poten = pot.nextInt();
		//guardamos el valor de la potencia
         
         
        
        for (int i = 0; i < poten; i++) {
        	//se realiza un ciclo for donde el numero de iteraciones debe ser menor que la potencia
        	//la cual sera el numero de veces por la cual el resultado sera multiplicado por la primera iteracion de resultado
            resultado *= num1;
            // en esta linea se le multiplicara y se le asignara a la variable resultado el numero obtenido de la multiplicacion
            // y esta sera multiplicada el numero de veces de la potencia 
        }
        
        System.out.println("El resultado de " + num1 + " elevado a la potencia " + poten + " es: " + resultado);
    

	}
	
	
	

}
