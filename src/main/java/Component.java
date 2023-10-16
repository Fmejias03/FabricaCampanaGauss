class Component {
    private final String type;
    private final int id;

    public Component(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Component{" +
                "type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}