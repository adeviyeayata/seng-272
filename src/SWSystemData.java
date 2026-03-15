import java.util.ArrayList;
import java.util.HashMap;

public class SWSystemData {
    public static HashMap<String, ArrayList<SWSystem>> getAllSystems() {
        HashMap<String, ArrayList<SWSystem>> map = new HashMap<>();

        ArrayList<SWSystem> webList = new ArrayList<>();
        webList.add(createECommercePlatform());
        webList.add(createBankingPortal());
        map.put("Web", webList);

        ArrayList<SWSystem> mobileList = new ArrayList<>();
        mobileList.add(createHealthApp());
        map.put("Mobile", mobileList);

        return map;
    }

    private static SWSystem createECommercePlatform() {
        SWSystem s = new SWSystem("ShopSphere", "Web", "3.2.1");

        QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 25);
        funcSuit.addCriterion(new Criterion("Functional Completeness Ratio", 50, "higher", 0, 100, "%"));
        funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));
        s.addDimension(funcSuit);

        QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 25);
        reliability.addCriterion(new Criterion("Availability Ratio", 50, "higher", 95, 100, "%"));
        reliability.addCriterion(new Criterion("Defect Density", 50, "lower", 0, 20, "defect/KLOC"));
        s.addDimension(reliability);

        QualityDimension perfEff = new QualityDimension("Performance Efficiency", "QC.PE", 25);
        perfEff.addCriterion(new Criterion("Response Time", 50, "lower", 100, 500, "ms"));
        perfEff.addCriterion(new Criterion("CPU Utilisation", 50, "lower", 0, 100, "%"));
        s.addDimension(perfEff);

        QualityDimension maintainability = new QualityDimension("Maintainability", "QC.MA", 25);
        maintainability.addCriterion(new Criterion("Test Coverage Ratio", 50, "higher", 0, 100, "%"));
        maintainability.addCriterion(new Criterion("Cyclomatic Complexity", 50, "lower", 1, 15, "score"));
        s.addDimension(maintainability);

        return s;
    }

    private static SWSystem createBankingPortal() {
        return new SWSystem("SecureBank", "Web", "1.0.0");
    }

    private static SWSystem createHealthApp() {
        return new SWSystem("FitLife", "Mobile", "2.1.4");
    }
}