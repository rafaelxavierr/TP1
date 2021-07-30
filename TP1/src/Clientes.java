import java.util.Scanner;
import java.util.ArrayList;


public class Clientes {
	
	String nome,endereço,telefone;
	int quant,i;
	Scanner ler = new Scanner(System.in);
	ArrayList<String> lnome = new ArrayList<String>();
	ArrayList<String> lendereço = new ArrayList<String>();
	ArrayList<String> ltelefone = new ArrayList<String>();

	public int CadastrarCliente() {
		System.out.println("Por favor, informe quantos clientes serão cadastrados:");
		quant = ler.nextInt();
		for(i=0;i<quant;i++) {
			ler.nextLine();
			System.out.println("Informe o nome:");
			nome = ler.nextLine();
			ler.nextLine();
			lnome.add(nome);
			System.out.println("Informe o endereço:");
			endereço = ler.nextLine();
			ler.nextLine();
			lendereço.add(endereço);
			System.out.println("Informe o telefone:");
			telefone = ler.nextLine();
			ler.nextLine();
			ltelefone.add(telefone);
			}
		return lnome.size();
		}
	
	public void TodosClientes() {
		for(int i = 0; i < lnome.size(); i++){
			System.out.println((i+1)+"- "+ lnome.get(i));
		}
	}
	
	public int QuantClientes() {
		return lnome.size();
	}
	
	public void PesquisarCliente() {
		String nome;
		int size = lnome.size(),alt, i;
		boolean aux = false;
		System.out.println("Informe o nome do cliente:");
		nome = ler.nextLine();
		i = 0;
		do {
			if(nome.equals(lnome.get(i))) {
				aux = true;
				System.out.println("Nome: "+lnome.get(i));
				System.out.println("Endereço: "+lendereço.get(i));
				System.out.println("Telefone: "+ltelefone.get(i)+"\n");
				do {
					System.out.println("Deseja alterar algum dado?\n"
							+ "\n"
							+ "Digite 0 se não deseja\n"
							+ "1 para alterar o nome\n"
							+ "2 para alterar o endereço\n"
							+ "3 para alterar o telefone");
					alt = ler.nextInt();
					
					switch(alt) {
					case 0:
						System.out.println("-----Nenhuma alteração foi realizada-----");
						break;
					case 1:
						System.out.println("Informe o nome:");
						nome = ler.next();
						lnome.set(i, nome);
						break;
					case 2:
						System.out.println("Informe o endereço:");
						endereço = ler.next();
						lendereço.set(i, endereço);
						break;
					case 3:
						System.out.println("Informe o telefone:");
						telefone = ler.next();
						ltelefone.set(i, telefone);
						break;
					default:
						System.out.println("Opção inválida!");
					}
					
				} while(alt != 0);
			}else {
				i=i+1;
			}			
		
		}while(aux == false && i<=size);
		
		if(aux == false) {
			System.out.println("Cliente inexistente.");
		}
	}			
}			
			
			
			
			
		