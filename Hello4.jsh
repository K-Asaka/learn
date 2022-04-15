class Greets {
    String message;

    void setMessage(String m) {
        message = m;
    }

    public void Say() {
        System.out.println(message);
    }
}
Greets g = new Greets();
g.setMessage("Hello.");
g.Say();