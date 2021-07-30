import java.util.Scanner;
import java.util.ArrayList;

public class Produtos {
	Scanner ler = new Scanner(System.in);
	String produto, desc;
	int estoq,q,i;
	float pre�o, lucro ;
	ArrayList<String> lproduto = new ArrayList<String>();
	ArrayList<String> ldesc = new ArrayList<String>();
	ArrayList<Integer> lestoq = new ArrayList<Integer>();
	ArrayList<Float> lpre�o = new ArrayList<Float>();
	ArrayList<Float> llucro = new ArrayList<Float>();
	
	public void MostrarEstoque() {
		
		for(int i=0; i < lproduto.size(); i++) {
			System.out.println(lproduto.get(i)+"- "+lestoq.get(i)+" unidades.");
		}
	}
	
	public void TodosProdutos() {
		for(int i = 0; i<lproduto.size(); i++){
			System.out.println((i+1)+"- "+lproduto.get(i));
		}
	}
	
	public int QuantProdutos() {
		return lproduto.size();
	}	
	
	public int CadastrarProduto() {
		System.out.println("Por favor, informe quantos produtos ser�o cadastrados: ");
		q = ler.nextInt();
		for(i=0; i < q; i++) {
			ler.nextLine();
			System.out.println("Informe o nome do produto: ");
			produto = ler.nextLine();
			lproduto.add(produto);
			ler.nextLine();
			
			System.out.println("Informe a descri��o do produto: ");
			desc = ler.nextLine();
			ldesc.add(desc);
			ler.nextLine();
			
			System.out.println("Informe o pre�o do produto: ");
			pre�o = ler.nextFloat();
			lpre�o.add(pre�o);
			
			System.out.println("Informe a porcentagem de lucro: ");
			lucro = ler.nextFloat();
			llucro.add(lucro);
				
			System.out.println("Informe a quantidade no estoque: ");
			estoq = ler.nextInt();
			lestoq.add(estoq);
			}
		return lproduto.size();
		}
	
	public void PesquisarProduto() {
		String nome;
		int size = lproduto.size(),alt, i=0;
		boolean aux = false;
		System.out.println("Informe o nome do produto: ");
		nome = ler.next();
		
		do {
			if(lproduto.get(i).equals(nome)) {
				aux = true;
				System.out.println("Produto: "+lproduto.get(i));
				System.out.println("Descri��o: "+ldesc.get(i));
				System.out.println("Pre�o: R$: "+lpre�o.get(i));
				System.out.println("Porcentagem de lucro: "+llucro.get(i));
				System.out.println("Quantidade no estoque: "+lestoq.get(i)+"\n");
				do {
					System.out.println("Deseja alterar algum dado?\n "
							+"\n"
							+ "Digite 0 se n�o deseja\n"
							+ "1 para alterar o nome\n"
							+ "2 para alterar a descri��o\n"
							+ "3 para alterar o pre�o\n"
							+ "4 para alterar a porcentagem de lucro\n"
							+ "5 para alterar a quantidade no estoque");
					alt = ler.nextInt();
					switch(alt) {
					case 0:
						System.out.println("-----Nenhuma altera��o foi realizada-----");
						break;
					case 1:
						System.out.println("Digite o nome do produto: ");
						produto = ler.next();
						lproduto.set(i, produto);
						break;
					case 2:
						System.out.println("Informe a descri��o do produto: ");
						desc = ler.next();
						ldesc.set(i, desc);
						break;
					case 3:
						System.out.println("Informe o pre�o do produto: ");
						pre�o = ler.nextFloat();
						lpre�o.set(i, pre�o);
						break;						
					case 4:
						System.out.println("Informe a porcentagem do lucro do produto: ");
						lucro = ler.nextFloat();
						llucro.set(i, lucro);
						break;
					case 5:
						System.out.println("Informe a quantidade no estoque do produto: ");
						estoq = ler.nextInt();
						lestoq.set(i, estoq);
						break;
					default:
						System.out.println("Op��o inv�lida!");
					}
				}while(alt != 0);
			}else {
				i = i + 1;
			}
		}while(aux == false && i<=size);
		
		if(aux == false) {
			System.out.println("Produto inexistente.");
		}
	}
}
