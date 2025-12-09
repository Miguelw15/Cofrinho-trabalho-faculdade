package cofrinho;

import java.util.ArrayList;

public class Cofrinho {
    private final ArrayList<Moeda> cofrinho = new ArrayList<>();

    public void adicionarMoeda(Moeda moeda){
        cofrinho.add(moeda);
    }

    public void removerMoeda(Moeda moeda){
        cofrinho.remove(moeda);
    }

    public void listarMoedas(){
        System.out.println("============= LISTA DE MOEDAS ===============");
        for(Moeda m : cofrinho){
            m.info();
        }
    }

    public void totalEmReal() {
        double total = 0;
        for (Moeda m: cofrinho) {
            total += m.converter();
        }

        System.out.println("Total: R$"+total);

    }
    
        

}