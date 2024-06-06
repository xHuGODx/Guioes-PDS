public class Retangulo implements Figura{
    private double c;
    private double a;

    public Retangulo(double c, double a) {
        this.c = c;
        this.a = a;
    }

    public double getC() {
        return c;
    }

    public double getA() {
        return a;
    }

    public void setC(double c) {            
        this.c = c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public String toString() {
		return "Retangulo [comprimento=" + c + ", altura=" + a + ", Area=" + Area() + ", Perimetro=" + Perimetro() + "]";
	}

    public double Area() {
		return (a * c);
	}
	
	public double Perimetro() {
		return (2*a + 2*c);
	}

    public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }	
		if (obj == null) {
            return false;
        }	
		if (getClass() != obj.getClass()) {
            return false;
        }
		
		Retangulo other = (Retangulo) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a)) {
            return false;
        }
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c)) {
            return false;
        }
		return true;
    }
}
