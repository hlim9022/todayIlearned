public class Transportation {
    private int num; // 대중교통 고유번호
    private int gas;
    private final int INIT_SPEED = 0; // 처음속도
    private int changeSpeed; // 변경된 속도
    private int passenger; // 탑승자 수
    private int maxPassenger; // 최대 탑승자 수
    private String status;

    public Transportation(int num) {
        this.num = num;
        this.gas = 100;
        this.passenger = 0;
        this.status = "운행중";
    }

    public void start() {
        this.setStatus("운행중");
    }

    public void finish() {
        this.setStatus("차고지행");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void takeGas(int gas) { // setGas
        this.gas += gas;
    }


    public int checkGas() { // getGas
        return this.gas;
    }

    public void setChangeSpeed(int speed) {
        this.changeSpeed += speed;
    }

    public int getCurrentSpeed() {
        return this.changeSpeed;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public void changeStatus() {
        if(this.status.equals("운행중")) this.status = "차고지행";
        else this.status = "운행중";
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getStatus() {
        return this.status;
    }

    public void takePax(int passenger) {
        setPassenger(passenger);

        if (getPassenger() >= this.getMaxPassenger()) {
            System.out.println("'최대 승객 수 초과'");
        } else {
            int space = this.getMaxPassenger() - getPassenger();
            System.out.println("탑승 승객 수 = " + getPassenger() +
                    "\n잔여 승객 수 = " + space);
        }
    }
}


