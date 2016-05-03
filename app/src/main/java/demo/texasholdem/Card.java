package demo.texasholdem;

class Card {
    /**
     * 红桃:H-Heart 桃心(象形),代表爱情.
     * 黑桃:S-Spade 橄榄叶(象形),代表和平.
     * 方块:D-Diamond 钻石(形同意合),代表财富.
     * 梅花:C-Club 三叶草(象形),代表幸运
     */
    enum Type {
        HEART,
        SPADE,
        DIAMOND,
        CLUB
    }

    String name = "";
    Type type = Type.HEART;
    boolean state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}