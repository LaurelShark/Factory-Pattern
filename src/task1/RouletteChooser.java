package task1;

import java.util.List;
import java.util.Random;

public class RouletteChooser extends AbstractChooser{
    public RouletteChooser(List<Option> options){
        super(options);
    }

    @Override
    public Option chooseOption() {
        return options.get(getIndex());
    }


    //Roulette algorithm
    @Override
    public int getIndex() {
        // Finding the sum of utilities. The function
        //return the utility value for member i**
        double sumUtilities = 0;
        for(Option option2 : options) {
            sumUtilities += option2.getUtility();
        }
            // Get a double number in the interval 0.0 ... sumUtilities
            Random random = new Random();
            double[] values = new double[options.size()];
            for (int i = 0; i < values.length; i++){
                values[i] = random.nextInt(10) * (options.get(i).getUtility()/sumUtilities);
            }
            int biggestIndex = 0;
            for (int i = 0; i < values.length; ++i){
                if (values[biggestIndex] <= values[i])
                    biggestIndex = i;
            }
        return biggestIndex;
    }
}
