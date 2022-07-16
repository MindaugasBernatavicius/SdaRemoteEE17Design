package cf.mindaugas._03_patterns._01_Creational;

// 0. Setters
class LunchOrder {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrder() {}

    public String getBread() {
        return bread;
    }
    public String getCondiments() {
        return condiments;
    }
    public String getDressing() { return dressing; }
    public String getMeat() {
        return meat;
    }
    public void setBread(String bread) {
        this.bread = bread;
    }
    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }
    public void setDressing(String dressing) {
        this.dressing = dressing;
    }
    public void setMeat(String meat) {
        this.meat = meat;
    }

    @Override
    public String toString() {
        return "LunchOrder{" +
                "bread='" + bread + '\'' +
                ", condiments='" + condiments + '\'' +
                ", dressing='" + dressing + '\'' +
                ", meat='" + meat + '\'' +
                '}';
    }
}

// 1. Telescoping constructors - 4! = 24 for all combinations of ingredients
class LunchOrderTelescoping {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    // What if I'm eating paleo and I don't want meat?
    // This is immutable, but we need different constructors for everything

    public LunchOrderTelescoping(String bread) {
        this.bread = bread;
    }

    public LunchOrderTelescoping(String bread, String condiments) {
        this(bread);
        this.condiments = condiments;
    }

    public LunchOrderTelescoping(String bread, String condiments, String dressing) {
        this(bread, condiments);
        this.dressing = dressing;
    }

    public LunchOrderTelescoping(String bread, String condiments, String dressing, String meat) {
        this(bread, condiments, dressing);
        this.meat = meat;
    }

    @Override
    public String toString() {
        return "LunchOrder{" +
                "bread='" + bread + '\'' +
                ", condiments='" + condiments + '\'' +
                ", dressing='" + dressing + '\'' +
                ", meat='" + meat + '\'' +
                '}';
    }
}

// 2. Builder pattern - both immutable and provides all the combinations
class LunchOrderWithPattern {
    public static class Builder {
        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        public Builder() {}

        public LunchOrderWithPattern build() {
            return new LunchOrderWithPattern(this);
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }
    }

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    private LunchOrderWithPattern(Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    @Override
    public String toString() {
        return "LunchOrder{" +
                "bread='" + bread + '\'' +
                ", condiments='" + condiments + '\'' +
                ", dressing='" + dressing + '\'' +
                ", meat='" + meat + '\'' +
                '}';
    }
}

public class _03_Builder {
    public static void main(String[] args) {
//        LunchOrder lunchOrder = new LunchOrder();
//
//        // no immutability, no contract of what is a valid lunchOrder (things can be commented out)
//        lunchOrder.setBread("Wheat");
//        lunchOrder.setCondiments("Lettuce");
//        lunchOrder.setDressing("Mustard");
//        lunchOrder.setMeat("Ham");
//
//        System.out.println(lunchOrder);


//        LunchOrderTelescoping lunchOrderTele = new LunchOrderTelescoping(
//                "Wheat", "Lettuce", "Mustard", "Ham");
//
//        System.out.println(lunchOrderTele);

        // we could populate this from a CSV file, where some properties do not exist
        LunchOrderWithPattern lunchOrder = new LunchOrderWithPattern.Builder()
                                                            .bread("Wheat")
                                                            .dressing("Mayo")
                                                            .meat("Turkey")
                                                            .build();

        System.out.println(lunchOrder);


        // The warning is because we are using a small string
        // ... with small strings using a String object is more readable
        StringBuilder str = new StringBuilder();
        str.append("Hello ");
        str.append("my ");
        str.append("world ");
        System.out.println(str.toString()); // equivalent build();
    }
}
