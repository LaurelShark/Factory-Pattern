package task1;

public class Option {
    private String name;
    private double utility;

    public Option(String name, int utility){
        if (name != null || utility >= 0){
            this.name=name;
            this.utility=utility;
        }else throw new IllegalArgumentException();
    }

    @Override
    public String toString(){
        return "\nOptions: name - " + name + ", utility - " + utility ;
    }


    public String getName() {
        return this.name;
    }

    public double getUtility() {
        return this.utility;
    }

    public void setUtility(double utility){
        this.utility = utility;
    }
}

