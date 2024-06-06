public class FigurasFactory {
    public static Figura createFigura(String type){
        switch(type) {
            case "Circulo":
                Ponto centro = new Ponto(0, 0); 
                return new Circulo(centro, 7);
            case "Retangulo":
                return new Retangulo(20,10);
            case "Triangulo":
                return new Triangulo(1, 1, 1);
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}