package cofrinho;

public class Euro extends Moeda{
    private final double cotacao = 6.32;
    
    
    public Euro(double valor){
        super(valor);
    }

    @Override
    public void info(){
        System.out.println("Euro: "+valor); 
    }

    @Override
    public double converter(){
        double conversao = valor*cotacao;
        return conversao;
    }
}
