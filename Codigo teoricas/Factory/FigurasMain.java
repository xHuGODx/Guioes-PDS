public class FigurasMain {
    public static void main(String[] args) {
        Figura ret1 = FigurasFactory.createFigura("Retangulo");
        System.out.println(ret1.toString());
        Figura cir1 = FigurasFactory.createFigura("Circulo");
        System.out.println(cir1.toString());
        Figura tri1 = FigurasFactory.createFigura("Triangulo");
        System.out.println(tri1.toString());
    }

}
