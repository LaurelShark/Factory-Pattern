package task1;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractChooser{

    public List<Option> options = new ArrayList();

    public AbstractChooser(List<Option> options){
        this.options = options;
    }

    public List<Option> getOptions(){
        return this.options;
    }

    public abstract Option chooseOption();

    public abstract int getIndex();

    @Override
    public String toString(){
        return "Created an AbstractChooser with options: " + options;
    }





}

