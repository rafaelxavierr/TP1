import java.util.Scanner;
import java.util.ArrayList;

public class Produtos {
	Scanner ler = new Scanner(System.in);
	String produto, desc;
	int estoq,q,i;
	float preço, lucro ;
	ArrayList<String> lproduto = new ArrayList<String>();
	ArrayList<String> ldesc = new ArrayList<String>();
	ArrayList<Integer> lestoq = new ArrayList<Integer>();
	ArrayList<Float> lpreço = new ArrayList<Float>();
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
		System.out.println("Por favor, informe quantos produtos serão cadastrados: ");
		q = ler.nextInt();
		for(i=0; i < q; i++) {
			ler.nextLine();
			System.out.println("Informe o nome do produto: ");
			produto = ler.nextLine();
			lproduto.add(produto);
			ler.nextLine();
			
			System.out.println("Informe a descrição do produto: ");
			desc = ler.nextLine();
			ldesc.add(desc);
			ler.nextLine();
			
			System.out.println("Informe o preço do produto: ");
			preço = ler.nextFloat();
			lpreço.add(preço);
			
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
				System.out.println("Descrição: "+ldesc.get(i));
				System.out.println("Preço: R$: "+lpreço.get(i));
				System.out.println("Porcentagem de lucro: "+llucro.get(i));
				System.out.println("Quantidade no estoque: "+lestoq.get(i)+"\n");
				do {
					System.out.println("Deseja alterar algum dado?\n "
							+"\n"
							+ "Digite 0 se não deseja\n"
							+ "1 para alterar o nome\n"
							+ "2 para alterar a descrição\n"
							+ "3 para alterar o preço\n"
							+ "4 para alterar a porcentagem de lucro\n"
							+ "5 para alterar a quantidade no estoque");
					alt = ler.nextInt();
					switch(alt) {
					case 0:
						System.out.println("-----Nenhuma alteração foi realizada-----");
						break;
					case 1:
						System.out.println("Digite o nome do produto: ");
						produto = ler.next();
						lproduto.set(i, produto);
						break;
					case 2:
						System.out.println("Informe a descrição do produto: ");
						desc = ler.next();
						ldesc.set(i, desc);
						break;
					case 3:
						System.out.println("Informe o preço do produto: ");
						preço = ler.nextFloat();
						lpreço.set(i, preço);
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
						System.out.println("Opção inválida!");
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
