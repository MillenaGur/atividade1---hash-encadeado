package listas;

import java.util.Random;

public class HashEncadeado {
    // A tabela deve ser um array de 'No' (referências para as listas ligadas)
    No[] tabela = new No[1000];
    

    // Classe interna para representar um nó da lista
    class No {
        int chave;
        //int dado; // Valor armazenado no nó
        No proximo; // Referência para o próximo nó

        // Construtor do nó
        No(int chave) {
            this.chave = chave;
            //this.dado = elemento;
            this.proximo = null;
        }
    }

    // Método para inserir um elemento na tabela hash encadeada
    public void insereElemento(int chave) {
        int hash = funcaohash(chave);
        No novoNo = new No(chave);

        // se a posição estiver vazia o nó é adicionado
        if (tabela[hash] == null) {
            tabela[hash] = novoNo;
        } else {
         // Se já houver colissão percorre no encademanto ate achar um poximo vazio
        No atual = tabela[hash];
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        // Insere o novo nó 
        atual.proximo = novoNo;
    }
    }

    public int funcaohash(int chave) { //função hash
        return chave % 1000;
    }



    // Método para exibir os elementos da lista (para teste)
   public void exibeLista() {
    No maiorNo = null;
    int cont = 0;

    No[] tres = new No[3];
    int tresc = 0;

    System.out.print("Lista: ");
    
    // percorre toda tabela
    for (int i = 0; i < tabela.length; i++) {
        
        // verificar se possue valor na possisao x da tabela
        if (tabela[i] != null) {
            No atual = tabela[i];
            
            //percorre a lista encadeada da possisao x da tabela
            int c = 0;
            while (atual != null) {
                c += 1; //contador para a lista encadeada

                //System.out.print(atual.chave + " ");  //imprimir a lista toda

                atual = atual.proximo; // move para o próximo nó

                if (tresc == 0){ //guardar os 3 valores do encadeamento numa lista
                    tres[0] = atual;
                    tresc += 1;
                }

                else if( tresc == 1){
                    tres[1] = atual;
                    tresc += 1;
                }
                else{
                    tres[2] = atual;
                    tresc = 0;
                }
            }

            if (c > cont){ //ve qual maior lista encadeada
                maiorNo = tabela[i];
                cont = c;
            }
        }
    }
    System.out.println();
    System.out.println(maiorNo.chave + cont);
    System.out.println();
    System.out.println("tres ultimos encadeado: " + tres[0] + " " + tres[1] + " " + tres[2]);
}

    

    public static void main(String[] args) {
    HashEncadeado hash1 = new HashEncadeado(); 


    Random random = new Random(1090); 

    for (int i = 0; i < 1000; i++) { //adicionar os 1000 elementos

        int numeroInt = random.nextInt(10000); 
        hash1.insereElemento(numeroInt); 
    }

    // Exibindo os elementos da lista/tabela
    hash1.exibeLista();
}
}