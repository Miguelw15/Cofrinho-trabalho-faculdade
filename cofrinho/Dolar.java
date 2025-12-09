package cofrinho;

public class Dolar extends Moeda{
    private final double cotacao = 5.43;


    public Dolar(double valor){
        super(valor);
    }

    @Override
    public void info(){
        System.out.println("Dolar: "+valor); 
    }

    @Override
    public double converter(){
        double conversao = valor*cotacao;
        return conversao;
    }
}
