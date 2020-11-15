import java.util.Random;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Cuadrilatero{
     Luchador l1=null, l2=null;
    private static final int Max_Luch = 2;
    private final Semaphore entrar = new Semaphore(Max_Luch, true);

    public void addParticipante(Luchador luchador) throws InterruptedException{
        luchador.ring.entrar.acquire();
        System.out.println("Soy "+luchador.getName()+", preparado para luchar");
        if(l1 == null){
            l1=luchador;
            if(l2!=null) luchar();
        }else{
            l2=luchador;
            if(l1!=null) luchar();
        }

    }
    public void eliminarParticipante(Luchador luchador) {
        if(l1==luchador){
            l1=null;
        }else{
            l2=null;
        }
        luchador.ring.entrar.release();
    }

    public void luchar() throws InterruptedException{

        System.out.println(" ----------------------~o~-----------------------");
        if(l1!=null && l2!=null) {
            Random r = new Random();
            Luchador ganador, perdedor;
            System.out.println("| Pelea: " + l1.getName() + " vs. " + l2.getName()+"               |");
            sleep(5000);
            if (r.nextBoolean()) {
                ganador=l1;
                perdedor=l2;
            } else {
                ganador=l2;
                perdedor=l1;
            }
            System.out.println("| "+perdedor.getName() + " está K.O. " + ganador.getName() + " es el ganador."+" |");
            System.out.println(" ----------------------~o~-----------------------\n");
            eliminarParticipante(perdedor);
        }
    }
}
