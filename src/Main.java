public class Main {
    public static void main(String[] args) {
        Cuadrilatero ring = new Cuadrilatero();
        for (int i=0; i<10; i++){
            Luchador t = new Luchador(ring);
            t.setName("Luchador "+i);
            t.start();
        }
    }
}
