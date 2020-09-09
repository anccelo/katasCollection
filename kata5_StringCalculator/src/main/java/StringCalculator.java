import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int add(String input) throws IllegalArgumentException {

        if ("".equals(input))
            return 0;

        String[] splitString =input.split(",|\n");
        if(splitString.length == 0)
            return Integer.parseInt(input);
        Integer sum = 0;
        List negatives = new ArrayList<>();
        if(splitString[0].length() > 2 && splitString[0].substring(0,2).equals("//")){
            String[] SecondSplitString = splitString[1].split(splitString[0].substring(2));

            for (String n: SecondSplitString) {

                if(Integer.parseInt(n)<0)
                    negatives.add(n);

                sum += Integer.parseInt(n);
            }
            if(negatives.size()!=0)
                throw new IllegalArgumentException("negatives not allowed, but follows numbers is present: "+ negatives.toString());
            return sum;
        }
        for (String n: splitString) {
            if(Integer.parseInt(n)<0)
                negatives.add(n);
            sum += Integer.parseInt(n);
        }
        if(negatives.size()!=0)
            throw new IllegalArgumentException("negatives not allowed, but follows numbers is present: "+ negatives.toString());
        return sum;
    }
}
