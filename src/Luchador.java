public class Luchador extends Thread{

    Cuadrilatero ring;

    public Luchador(Cuadrilatero cuadrilatero){
        this.ring=cuadrilatero;
    }

    @Override
    public void run() {
        try {
            ring.addParticipante(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
