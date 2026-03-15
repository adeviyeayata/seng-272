import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<SWSystem>> allSystems = SWSystemData.getAllSystems();
        ArrayList<SWSystem> webSystems = allSystems.get("Web");

        SWSystem shopSphere = null;
        for (SWSystem s : webSystems) {
            if (s.getName().equals("ShopSphere")) {
                shopSphere = s;
                break;
            }
        }

        if (shopSphere != null) {
            for (QualityDimension qd : shopSphere.getDimensions()) {
                for (Criterion c : qd.getCriteria()) {
                    if (c.getName().equals("Functional Completeness Ratio")) c.setMeasuredValue(94);
                    else if (c.getName().equals("Functional Correctness Ratio")) c.setMeasuredValue(91);
                    else if (c.getName().equals("Availability Ratio")) c.setMeasuredValue(99.2);
                    else if (c.getName().equals("Defect Density")) c.setMeasuredValue(2.1);
                    else if (c.getName().equals("Response Time")) c.setMeasuredValue(220);
                    else if (c.getName().equals("CPU Utilisation")) c.setMeasuredValue(38);
                    else if (c.getName().equals("Test Coverage Ratio")) c.setMeasuredValue(72);
                    else if (c.getName().equals("Cyclomatic Complexity")) c.setMeasuredValue(8.5);
                }
            }
            shopSphere.printReport();
        }
    }
}