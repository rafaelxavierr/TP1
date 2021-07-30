import java.util.Scanner;

public class Loja {
	static int op;
	static Clientes cliente = new Clientes();
	static Produtos produto = new Produtos();
	static String clientes[]= {"Cliente1", "Cliente2","Cliente3", "Cliente4","Cliente5","Cliente6","Cliente7","Cliente8","Cliente9","Cliente10"};
	static String endereços[]= {"Endereço1", "Endereço2","Endereço3", "Endereço4","Endereço5","Endereço6","Endereço7","Endereço8","Endereço9","Endereço10"};
	static String telefones[]= {"Telefone1", "Telefone2","Telefone3","Telefone4","Telefone5","Telefone6","Telefone7","Telefone8","Telefone9","Telefone10"};
	static String produtos[]= {"Produto1", "Produto2","Produto3", "Produto4","Produto5","Produto6","Produto7","Produto8","Produto9","Produto10"};
	static String descs[]= {"Desc1", "Desc2","Desc3", "Desc4","Desc5","Desc6","Desc7","Desc8","Desc9","Desc10"};
	static Float preços[]= {3.4f,1.3f,9.6f,8.7f,6.43f,6.7f,1.9f,7.5f,8.3f,4.6f};
	static Float lucros[]= {8.6f,3.4f,40.5f,90.7f,1.2f,6.4f,30.2f,4.44f,33.33f,55.55f};
	static int quants[]= {29,38,56,47,28,47,56,19,38,57};
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int op = 0;
		for (int i = 0; i < clientes.length; i++) {
			cliente.lnome.add(clientes[i]);
			cliente.lendereço.add(endereços[i]);
			cliente.ltelefone.add(telefones[i]);
			produto.lproduto.add(produtos[i]);
			produto.ldesc.add(descs[i]);
			produto.lpreço.add(preços[i]);
			produto.llucro.add(lucros[i]);
			produto.lestoq.add(quants[i]);
		}
		try {
			do {
				System.out.println("------MENU-----\n"
						+ "1- Cadastrar novo cliente\n"
						+ "2- Buscar cliente\n"
						+ "3- Cadastrar novo produto\n"
						+ "4- Buscar produto\n"
						+ "5- Cadastrar venda\n"
						+ "6- Mostrar estoque de produto\n"
						+ "7- Sair ");
				op = ler.nextInt();
				switch(op) {
				case 1:
					cliente.CadastrarCliente();
					break;
				case 2:
					cliente.PesquisarCliente();
					break;
				case 3:
					produto.CadastrarProduto();
					break;
				case 4:
					produto.PesquisarProduto();
					break;
				case 5:
					CadastrarVenda();
					break;
				case 6:
					produto.MostrarEstoque();
					break;
				case 7:
					System.out.println("Tchau!");
					break;
				default:
					System.out.println("Operação inválida.");
						
				}
			}while(op !=7 );		
			
			}catch(java.util.InputMismatchException exception) {
				System.out.println("Erro! Por favor digite um valor válido.");
			} finally {
				
			}
	}
	
	public static void CadastrarVenda() {
		Scanner ler = new Scanner(System.in); 
		int p , valor, f = 1, quant=0;
		boolean erro = false;
		
		cliente.TodosClientes();		
			try {
				System.out.println("Informe o n° do cliente:");
				op = ler.nextInt();
				op = op - 1;
				do {
					produto.TodosProdutos();
					System.out.println("Informe o n° do produto:");
					p = ler.nextInt();
					p = p - 1;
					do {
						System.out.println("Informe a quantidade vendida:");
						quant = ler.nextInt();
						if(quant > produto.lestoq.get(p)) {
							System.out.println("Essa quantidade excede o nosso estoque. Por favor, digite outro valor.\n");
									
						}
					}while(quant > produto.lestoq.get(p));
					valor =  produto.lestoq.get(p) - quant;
					produto.lestoq.set(p,valor);
					erro = true;
					System.out.println("Deseja continuar? 1 p/ sim ou 0 p/ não");
					f = ler.nextInt();
				}while(f != 0);
			}catch(java.util.InputMismatchException exception) {
				System.out.println("Núemro inválido.");
				erro = false;
			}
	}
}
