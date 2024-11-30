import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    private String result = "Мимо";
    private String name;

    public void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                this.result = "Потопил(а)";
                System.out.println("Ой, вы потопили" + name + " : ( ");
            } else {
                this.result = "Попал(а)";
            }
        }
        return this.result;
    }
}
