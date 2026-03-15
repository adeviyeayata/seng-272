import java.util.ArrayList;

public class QualityDimension {
    private String name;
    private String isoCode;
    private double weight;
    private ArrayList<Criterion> criteria;

    public QualityDimension(String name, String isoCode, double weight) {
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;
        this.criteria = new ArrayList<>();
    }

    public void addCriterion(Criterion criterion) {
        criteria.add(criterion);
    }

    public double calculateDimensionScore() {
        if (criteria.isEmpty()) return 0;
        double weightedSum = 0;
        double totalWeight = 0;
        for (Criterion c : criteria) {
            weightedSum += (c.calculateScore() * c.getWeight());
            totalWeight += c.getWeight();
        }
        return weightedSum / totalWeight;
    }

    public String getQualityLabel() {
        double score = calculateDimensionScore();
        if (score >= 4.5) return "Excellent Quality";
        if (score >= 3.5) return "Good Quality";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor Quality";
    }

    public double getQualityGap() {
        return 5.0 - calculateDimensionScore();
    }

    public String getName() { return name; }
    public String getIsoCode() { return isoCode; }
    public double getWeight() { return weight; }
    public ArrayList<Criterion> getCriteria() { return criteria; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("--- %s [%s] (Weight: %.0f) ---\n", name, isoCode, weight));
        for (Criterion c : criteria) {
            sb.append(c.toString()).append("\n");
        }
        sb.append(String.format(">> Dimension Score: %.1f/5 [%s]\n", calculateDimensionScore(), getQualityLabel()));
        return sb.toString();
    }
}