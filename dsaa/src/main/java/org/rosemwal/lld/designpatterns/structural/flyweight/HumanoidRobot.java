package org.rosemwal.lld.designpatterns.structural.flyweight;

public class HumanoidRobot implements IRobot {

    private String type;
    private Sprites body; // small 2D bitmap (graphic element).

    public HumanoidRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public void display(int x, int y) {

    }

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }
}
